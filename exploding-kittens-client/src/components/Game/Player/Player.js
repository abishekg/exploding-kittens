import React, {useContext, useEffect, useState} from 'react';
import Hand from "./Hand/Hand";
import classNames from "classnames";
import './Player.scss';
import {useDrop} from "react-dnd";
import {WebSocketContext} from "../../../Providers/WebSocketProvider";
import {GameContext} from "../../../Providers/GameProvider";

function Player({details, currentPlayerId}) {
    const {connect, withdrawCard, stealACard} = useContext(WebSocketContext);
    const {game, withdrawPlayerCard, playerPlayerCard, shouldPlayDefuse} = useContext(GameContext);

    const isPlayerTurn = details.id === currentPlayerId;
    const isReceivingAStolenCard = !!(!isPlayerTurn && playerPlayerCard)


    const [{canDrop, isOver}, dropRef] = useDrop(() => ({
        accept: (isReceivingAStolenCard && playerPlayerCard) || withdrawPlayerCard,
        drop: (item) => {
            if (shouldPlayDefuse) {
                console.log('Invalid Move');
            } else if (!isPlayerTurn && playerPlayerCard) {
                connect && stealACard(item.card);
            } else if (withdrawPlayerCard) {
                console.log(item);
                connect && withdrawCard(item.card)
            }
        },
        collect: (monitor) => ({
            isOver: monitor.isOver(),
            canDrop: monitor.canDrop()
        })
    }), [game, playerPlayerCard]);
    let playerReverse = classNames({
        'player--reverse': details.id % 2 === 0,
        'player--active': isPlayerTurn
    });


    return (
        <div
            ref={((isReceivingAStolenCard || isPlayerTurn) && dropRef) || undefined}
            className={`player ${playerReverse}`}
        >
            <Hand
                player={details}
                hand={details.hand}
                isPlayerTurn={isPlayerTurn}
                playerPlayerCard={isPlayerTurn && playerPlayerCard}
            />
            {details.name}{isPlayerTurn && '\'s turn'}
        </div>
    );
}

export default Player;