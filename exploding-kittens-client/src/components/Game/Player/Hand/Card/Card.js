import React from 'react';
import {useDrag} from "react-dnd";
import './Card.scss';
import WithdrawDeck from "../../../Table/WithdrawDeck/WithdrawDeck";

function Card({card, isPlayerCard, isPlayerTurn, style, isTopCard, isWithdrawDeck, dragType, player, showTopCard}) {

    const [{isDragging}, cardRef] = useDrag(() => ({
        type: dragType,
        item: {card, player},
        collect: (monitor) => ({
            isDragging: monitor.isDragging()
        })
    }), [card]);

    const isDraggableDisabled = () => {
        if (isPlayerCard)
            return !isPlayerTurn
        else {
            return !isWithdrawDeck || (isWithdrawDeck && !isTopCard);
        }
    }

    const disableDragIfNoTurn = (event) => {
        if (isDraggableDisabled()) {
            event.preventDefault();
            return;
        }
    }

    return (
        <div ref={cardRef}
             className={`card ${isPlayerCard ? 'card--player' : 'card--deck'}`}
             style={!isPlayerCard && style || {
                 opacity: isDragging ? 0.5 : 1,
                 cursor: isDragging ? 'move' : 'default',
                 scale: isDragging ? 1.5 : 1
             }}
             onDragStart={disableDragIfNoTurn}
             onDragEnd={disableDragIfNoTurn}
        >
            {!isWithdrawDeck ? card.type : 'Withdraw Card'}
            {showTopCard && <div>(Top Card)</div>}
        </div>
    );
}

export default Card;