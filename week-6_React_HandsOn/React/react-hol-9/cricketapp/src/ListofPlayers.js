function ListofPlayers(props) {

    return (

        <ul>

            {
                props.players.map((item, index) => (

                    <li key={index}>
                        Mr. {item.name} <span>{item.score}</span>
                    </li>

                ))
            }

        </ul>

    );

}

export default ListofPlayers;