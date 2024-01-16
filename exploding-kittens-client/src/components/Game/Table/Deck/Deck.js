import React, {useContext, useRef, useState} from 'react';
import './Deck.scss';
import Card from "../../Player/Hand/Card/Card";
import {GameContext} from "../../../../Providers/GameProvider";

function Deck({deck, isWithdrawDeck, currentPlayerRef}) {
    const {withdrawPlayerCard} = useContext(GameContext);
    return (
        <div className='deck'>
            {Array.isArray(deck) && deck.length >= 1 ? deck.map((card, idx) => {
                return (
                    <Card
                        key={idx}
                        dragType={withdrawPlayerCard}
                        card={card}
                        idx={idx}
                        isPlayerCard={false}
                        isTopCard={isWithdrawDeck && (idx + 1) === deck.length}
                        isWithdrawDeck={isWithdrawDeck}
                        style={{
                            position: "absolute",
                            zIndex: isWithdrawDeck ? (10 + idx) : idx,
                            left: `${-50 + (idx * 2.5)}px`,
                            top: `${-80}px`,
                            textAlign: "center"
                        }}
                    />
                )
            }) : <div>Place here</div>}
        </div>
    );
}

export default Deck;