CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all savings accounts successfully.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in ProcessMonthlyInterest: ' || SQLERRM);
        ROLLBACK;
END ProcessMonthlyInterest;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN Employees.Department%TYPE,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    IF p_bonus_percentage < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Bonus percentage cannot be negative.');
    END IF;

    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;
    
    DBMS_OUTPUT.PUT_LINE('Salary updated with ' || p_bonus_percentage || '% bonus for department: ' || p_department);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in UpdateEmployeeBonus: ' || SQLERRM);
        ROLLBACK;
END UpdateEmployeeBonus;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN Accounts.AccountID%TYPE,
    p_dest_account_id   IN Accounts.AccountID%TYPE,
    p_amount            IN NUMBER
) AS
    v_source_balance Accounts.Balance%TYPE;
    v_dest_exists    NUMBER;
BEGIN
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transfer amount must be greater than zero.');
    END IF;

    IF p_source_account_id = p_dest_account_id THEN
        RAISE_APPLICATION_ERROR(-20003, 'Source and destination accounts must be different.');
    END IF;

    BEGIN
        SELECT Balance INTO v_source_balance
        FROM Accounts
        WHERE AccountID = p_source_account_id
        FOR UPDATE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20004, 'Source account does not exist.');
    END;

    SELECT COUNT(*) INTO v_dest_exists
    FROM Accounts
    WHERE AccountID = p_dest_account_id;

    IF v_dest_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Destination account does not exist.');
    END IF;

    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20006, 'Insufficient balance in source account. Available: ' || v_source_balance);
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_source_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_dest_account_id;

    DBMS_OUTPUT.PUT_LINE('Transferred $' || p_amount || ' from Account ' || p_source_account_id || ' to Account ' || p_dest_account_id || ' successfully.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/
