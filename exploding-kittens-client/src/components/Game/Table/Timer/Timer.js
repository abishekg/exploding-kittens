import React, {useContext, useEffect, useState} from 'react';
import './Timer.scss';
import {WebSocketContext} from "../../../../Providers/WebSocketProvider";
import {GameContext} from "../../../../Providers/GameProvider";

function Timer({defuseTimer, initializeDefuseTimer}) {
    const {onGameEnd} = useContext(WebSocketContext);

    useEffect(() => {
        onGameEnd();
    }, [defuseTimer])

    return (
        <div className='timer'>{defuseTimer - 1}</div>
    );
}

export default Timer;