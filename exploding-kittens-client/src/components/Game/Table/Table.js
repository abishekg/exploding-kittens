import React from 'react';
import './Table.scss';
import Card from "../Player/Hand/Card/Card";
import WithdrawDeck from "./WithdrawDeck/WithdrawDeck";
import DiscardedDeck from "./DiscardedDeck/DiscardedDeck";
import Timer from "./Timer/Timer";

function Table({game, defuseTimer, initializeDefuseTimer}) {
    return (
        <div className='table'>
            <WithdrawDeck deck={game.deck}/>
            <DiscardedDeck deck={game.discardedCards}/>
            {defuseTimer ? <Timer defuseTimer={defuseTimer} initializeDefuseTimer={initializeDefuseTimer}/> : <div className='table__empty-timer'></div>}
        </div>
    );
}

export default Table;