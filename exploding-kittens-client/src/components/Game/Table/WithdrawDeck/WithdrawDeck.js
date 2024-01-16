import React from 'react';
import './WithdrawDeck.scss';
import Deck from "../Deck/Deck";

function WithdrawDeck({deck, currentPlayerRef}) {

    return (
        <div className='withdraw-deck'>
            <Deck
                deck={deck}
                isWithdrawDeck={true}
                currentPlayerRef={currentPlayerRef}
            />
        </div>
    );
}

export default WithdrawDeck;