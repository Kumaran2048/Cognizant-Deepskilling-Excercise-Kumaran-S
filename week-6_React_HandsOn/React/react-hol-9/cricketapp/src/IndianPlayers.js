const T20Players = [
    "First Player",
    "Second Player",
    "Third Player"
];

const RanjiTrophyPlayers = [
    "Fourth Player",
    "Fifth Player",
    "Sixth Player"
];

export const IndianPlayers = [
    ...T20Players,
    ...RanjiTrophyPlayers
];

export function OddPlayers(props) {

    const [first, , third, , fifth] = props.players;

    return (

        <ul>

            <li>First : {first}</li>
            <li>Third : {third}</li>
            <li>Fifth : {fifth}</li>

        </ul>

    );

}

export function EvenPlayers(props) {

    const [, second, , fourth, , sixth] = props.players;

    return (

        <ul>

            <li>Second : {second}</li>
            <li>Fourth : {fourth}</li>
            <li>Sixth : {sixth}</li>

        </ul>

    );

}

export function ListofIndianPlayers(props) {

    return (

        <ul>

            {
                props.IndianPlayers.map((player, index) => (

                    <li key={index}>
                        Mr. {player}
                    </li>

                ))
            }

        </ul>

    );

}