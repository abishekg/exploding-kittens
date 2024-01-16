import React, {useContext} from 'react';
import {GameContext} from "../../../Providers/GameProvider";
import {WebSocketContext} from "../../../Providers/WebSocketProvider";
import {useNavigate} from 'react-router-dom';
import './GameOver.scss';

function GameOver(props) {
    const {game} = useContext(GameContext);
    const {onRestartGame, disconnect} = useContext(WebSocketContext);


    let navigate = useNavigate();

    const playerName = game.listOfPlayers.filter(player => {
        return player.hasPlayerWon
    })[0].name;

    const handleClick = () => {
        disconnect();
        navigate('/');
    }

    return (
        <div className='game-over'>
            <div>Game Over</div>
            <div>{playerName} wins the game</div>
            <button onClick={handleClick}>Restart game</button>
        </div>
    );
}

export default GameOver;