import './App.css';

import ListofPlayers from "./ListofPlayers";
import ScoreBelow70 from "./ScoreBelow70";
import {
  OddPlayers,
  EvenPlayers,
  ListofIndianPlayers,
  IndianPlayers
} from "./IndianPlayers";

function App() {

  const players = [

    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }

  ];

  const flag = false; // change to true when needed

  if (flag) {

    return (

      <div>

        <h1>List of Players</h1>

        <ListofPlayers players={players} />

        <hr />

        <h1>List of Players having Scores Less than 70</h1>

        <ScoreBelow70 players={players} />

      </div>

    );

  }

  else {

    const IndianTeam = [
      "Sachin",
      "Dhoni",
      "Virat",
      "Rohit",
      "Yuvraj",
      "Raina"
    ];

    return (

      <div>

        <h1>Indian Team</h1>

        <h2>Odd Players</h2>

        <OddPlayers players={IndianTeam} />

        <hr />

        <h2>Even Players</h2>

        <EvenPlayers players={IndianTeam} />

        <hr />

        <h2>List of Indian Players Merged</h2>

        <ListofIndianPlayers IndianPlayers={IndianPlayers} />

      </div>

    );

  }

}

export default App;