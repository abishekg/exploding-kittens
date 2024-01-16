import React, {useContext} from 'react';
import './InsertExplodingKittenCardIntoTheDeck.scss';
import Card from "../../Game/Player/Hand/Card/Card";
import {GameContext} from "../../../Providers/GameProvider";
import {WebSocketContext} from "../../../Providers/WebSocketProvider";

function InsertExplodingKittenCardIntoTheDeck({}) {
    const {game} = useContext(GameContext);
    const {insertExplodingKittenIntoDeck} = useContext(WebSocketContext);

    const insertCard = (idx) => {
        insertExplodingKittenIntoDeck(idx);
    }
    return (
        <div className='insert-exploding-kitten-card-into-the-deck'>
            <div className='insert-exploding-kitten-card-into-the-deck__header'>
                Place Exploding Kitten Card back into the Deck
            </div>
            <div className='insert-exploding-kitten-card-into-the-deck__container'>
                <div className='insert-exploding-kitten-card-into-the-deck__container__card'>
                    <Card
                        card={{type: 'ExplodingKittens'}}
                        dragType={'cant-drag'}
                    />
                </div>
                <div className='insert-exploding-kitten-card-into-the-deck__container__btn__container'>
                    <button
                        className='insert-exploding-kitten-card-into-the-deck__container__btn'
                        onClick={() => insertCard(0)}
                    >
                        On Top
                    </button>
                    {game.deck.length > 2 &&
                        <button
                            className='insert-exploding-kitten-card-into-the-deck__container__btn'
                            onClick={() => insertCard(1)}>
                            Second
                        </button>}
                    {game.deck.length > 3 &&
                        <button
                            className='insert-exploding-kitten-card-into-the-deck__container__btn'
                            onClick={() => insertCard(2)}>
                            Third
                        </button>}
                    {game.deck.length > 4 &&
                        <button
                            className='insert-exploding-kitten-card-into-the-deck__container__btn'
                            onClick={() => insertCard(3)}>
                            Fourth
                        </button>}
                    {game.deck.length > 5 &&
                        <button
                            className='insert-exploding-kitten-card-into-the-deck__container__btn'
                            onClick={() => insertCard(4)}>
                            Fifth
                        </button>}
                    <button
                        className='insert-exploding-kitten-card-into-the-deck__container__btn'
                        onClick={() => insertCard(5)}>
                        Bottom
                    </button>
                </div>
            </div>
        </div>
    );
}

export default InsertExplodingKittenCardIntoTheDeck;