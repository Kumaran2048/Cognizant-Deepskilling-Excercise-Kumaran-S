import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {

    const Name = "John";
    const School = "ABC Public School";
    const Total = 450;
    const Goal = 5;

    const Average = Total / Goal;

    return (
        <div className="box">
            <h1>Student Details</h1>

            <p><b>Name:</b> {Name}</p>

            <p><b>School:</b> {School}</p>

            <p><b>Total:</b> {Total}</p>

            <p><b>Goal:</b> {Goal}</p>

            <h2>Average Score: {Average}</h2>
        </div>
    );
}

export default CalculateScore;