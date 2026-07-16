import './App.css';
import React, { useState } from "react";

function GuestPage() {

  return (

    <div>

      <h2>Flight Details</h2>

      <table border="1" cellPadding="8">

        <thead>
          <tr>
            <th>Flight</th>
            <th>From</th>
            <th>To</th>
            <th>Time</th>
          </tr>
        </thead>

        <tbody>

          <tr>
            <td>AI101</td>
            <td>Chennai</td>
            <td>Delhi</td>
            <td>09:00 AM</td>
          </tr>

          <tr>
            <td>AI202</td>
            <td>Bangalore</td>
            <td>Mumbai</td>
            <td>02:30 PM</td>
          </tr>

        </tbody>

      </table>

      <p>Please login to book your ticket.</p>

    </div>

  );

}

function UserPage() {

  return (

    <div>

      <h2>Book Your Ticket</h2>

      <p>Welcome! You can now book your flight.</p>

      <button>Book Ticket</button>

    </div>

  );

}

function App() {

  const [loggedIn, setLoggedIn] = useState(false);

  return (

    <div style={{ margin: "30px" }}>

      <h1>Ticket Booking Application</h1>

      {
        loggedIn ?

          <button onClick={() => setLoggedIn(false)}>
            Logout
          </button>

          :

          <button onClick={() => setLoggedIn(true)}>
            Login
          </button>

      }

      <hr />

      {
        loggedIn ?

          <UserPage />

          :

          <GuestPage />

      }

    </div>

  );

}

export default App;