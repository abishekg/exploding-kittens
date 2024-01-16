import React, {useContext} from 'react';
import './DiscardedDeck.scss';
import Deck from "../Deck/Deck";
import {useDrop} from "react-dnd";
import {WebSocketContext} from "../../../../Providers/WebSocketProvider";
import {GameContext} from "../../../../Providers/GameProvider";

function DiscardedDeck({deck}) {
    const {connect, playTurn, withdrawCard} = useContext(WebSocketContext);
    const {game, playerDiscardCard, shouldPlayDefuse, setDefuseFlagOff, stopDefuseTimer} = useContext(GameContext);

    const [{canDrop, isOver}, dropRef] = useDrop(() => ({
        accept: playerDiscardCard,
        drop: (item) => {
            if (shouldPlayDefuse) {
                if (item.card.type === "Defuse") {
                    setDefuseFlagOff(item.card);
                    stopDefuseTimer();
                } else {
                    console.log("Invalid Card");
                }
            } else if (item.card.type === "Defuse") {
                console.log("Invalid Card");
            } else {
                connect && playTurn(item.player, item.card)
            }
        },
        collect: (monitor) => ({
            isOver: monitor.isOver(),
            canDrop: monitor.canDrop()
        })
    }), [game]);

    return (
        <div ref={dropRef} className='discarded-deck'>
            <Deck deck={deck} isWithdrawDeck={false}/>
        </div>
    );
}

export default DiscardedDeck;