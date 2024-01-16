import React, {useContext} from 'react';
import Card from "../../Game/Player/Hand/Card/Card";
import {GameContext} from "../../../Providers/GameProvider";
import './SeeTheFuture.scss';

function SeeTheFuture(props) {
    const {
        game,
        showFutureCardsModal,
    } = useContext(GameContext);

    const seeTheFutureDeck = showFutureCardsModal && game && game.deck && game.deck.length > 0 && game.deck.slice(-3);
    return (
        <div className='see-the-future'>
            <div className='see-the-future__header'>Top {seeTheFutureDeck.length} Cards</div>
            {seeTheFutureDeck.length > 0 && seeTheFutureDeck.map((card, idx) => {
                return <Card
                    card={card}
                    key={idx}
                    dragType={'cant-drag'}
                    style={{
                        position: "absolute",
                        zIndex: 10 + idx,
                        left: `${-50 + (idx * 100)}px`,
                        top: `${-80}px`,
                        scale: 1.5,
                    }}
                    showTopCard={idx === seeTheFutureDeck.length - 1}
                />
            })}
        </div>
    );
}

export default SeeTheFuture;