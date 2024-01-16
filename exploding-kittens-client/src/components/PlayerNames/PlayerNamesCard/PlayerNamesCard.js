import React from 'react';
import './PlayerNamesCard.scss';

function PlayerNamesCard({number, update}) {
    return (
        <div className='player-names-card'>
            <span className='player-names-card--num'>Player {number}</span> Name
            <div>
                <input type='text' name='name' placeholder={'Enter Name'} onChange={(e) => update(e.target.value)}/>
            </div>
        </div>
    );
}

export default PlayerNamesCard;