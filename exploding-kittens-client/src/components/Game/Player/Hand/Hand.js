import React, {useContext, useRef} from 'react';
import Card from "./Card/Card";
import './Hand.scss';
import {GameContext} from "../../../../Providers/GameProvider";

function Hand({hand, isPlayerTurn, player, playerPlayerCard}) {
    const {playerDiscardCard} = useContext(GameContext)
    return (
        <div className='hand'>
            {hand && hand.listOfCards && hand.listOfCards.map((card, idx) =>
                <Card
                    idx={idx}
                    card={card}
                    isPlayerTurn={isPlayerTurn}
                    isPlayerCard={true}
                    player={player}
                    dragType={playerPlayerCard || playerDiscardCard}
                />
            )}
        </div>
    );
}

export default Hand;