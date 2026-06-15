-- Schema setup (for reference/testing)
-- CREATE TABLE Customers (
--     CustomerID NUMBER PRIMARY KEY,
--     Name VARCHAR2(100),
--     DOB DATE,
--     Balance NUMBER,
--     LastModified DATE
-- );

-- CREATE TABLE Loans (
--     LoanID NUMBER PRIMARY KEY,
--     CustomerID NUMBER,
--     LoanAmount NUMBER,
--     InterestRate NUMBER,
--     StartDate DATE,
--     EndDate DATE,
--     FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
-- );

-- ALTER TABLE Customers ADD IsVIP VARCHAR2(10) DEFAULT 'FALSE';


-- ==========================================
-- Scenario 1: Apply 1% discount to loan interest rates for customers above 60 years old.
-- ==========================================
DECLARE
    -- Cursor to find loans of customers who are older than 60 years
    CURSOR c_senior_loans IS
        SELECT l.LoanID, l.InterestRate, c.Name, c.DOB
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60;
        
    v_loan_id       Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_name          Customers.Name%TYPE;
    v_dob           Customers.DOB%TYPE;
BEGIN
    OPEN c_senior_loans;
    LOOP
        FETCH c_senior_loans INTO v_loan_id, v_interest_rate, v_name, v_dob;
        EXIT WHEN c_senior_loans%NOTFOUND;
        
        -- Apply 1% discount (reducing the interest rate by 1, e.g., 5% becomes 4%)
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = v_loan_id;
        
        DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || v_loan_id || ' for Customer: ' || v_name);
    END LOOP;
    CLOSE c_senior_loans;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in Scenario 1: ' || SQLERRM);
        ROLLBACK;
END;
/


-- ==========================================
-- Scenario 2: Promote customer to VIP status based on balance (> $10,000).
-- ==========================================
DECLARE
    -- Cursor to fetch all customers
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance
        FROM Customers;
        
    v_cust_id Customers.CustomerID%TYPE;
    v_name    Customers.Name%TYPE;
    v_balance Customers.Balance%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_cust_id, v_name, v_balance;
        EXIT WHEN c_customers%NOTFOUND;
        
        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE',
                LastModified = SYSDATE
            WHERE CustomerID = v_cust_id;
            DBMS_OUTPUT.PUT_LINE('Customer ' || v_name || ' (ID: ' || v_cust_id || ') promoted to VIP.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE',
                LastModified = SYSDATE
            WHERE CustomerID = v_cust_id;
        END IF;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in Scenario 2: ' || SQLERRM);
        ROLLBACK;
END;
/


-- ==========================================
-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
-- ==========================================
DECLARE
    -- Cursor to fetch loans due in the next 30 days
    CURSOR c_due_loans IS
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
        
    v_loan_id  Loans.LoanID%TYPE;
    v_cust_name Customers.Name%TYPE;
    v_end_date Loans.EndDate%TYPE;
BEGIN
    OPEN c_due_loans;
    LOOP
        FETCH c_due_loans INTO v_loan_id, v_cust_name, v_end_date;
        EXIT WHEN c_due_loans%NOTFOUND;
        
        -- Print reminder message
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || v_cust_name || ', your loan (ID: ' || v_loan_id || ') is due on ' || TO_CHAR(v_end_date, 'YYYY-MM-DD') || '. Please ensure payment is processed.');
    END LOOP;
    CLOSE c_due_loans;
END;
/
