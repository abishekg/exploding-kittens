import React, {useContext, useEffect, useRef, useState} from 'react';
import Player from "./Player/Player";
import './Game.scss';
import Table from "./Table/Table";
import {GameContext} from "../../Providers/GameProvider";
import {WebSocketContext} from "../../Providers/WebSocketProvider";
import Card from "./Player/Hand/Card/Card";
import DynamicModal from "../DynamicModal/DynamicModal";

function Game() {
    const [modalFlag, setModalFlag] = useState(false);
    const {game, showFutureCardsModal, insertExplodingKittensCardInsideDeck, defuseTimer, initializeDefuseTimer, isGameOver} = useContext(GameContext);
    const {connect} = useContext(WebSocketContext);

    useEffect(() => {
        connect();
    }, []);

    useEffect(() => {
        setModalFlag(!!(showFutureCardsModal || insertExplodingKittensCardInsideDeck || isGameOver));
    }, [showFutureCardsModal, insertExplodingKittensCardInsideDeck, isGameOver])

    console.log('game', game);

    return (
        <div className='game'>
            <div className='game-container'>
                <Player
                    details={game && game.listOfPlayers && game.listOfPlayers.length >= 1 && game.listOfPlayers[1]}
                    currentPlayerId={game.currentPlayerId}
                />
                <Table
                    game={game} defuseTimer={defuseTimer} initializeDefuseTimer={initializeDefuseTimer}
                />
                <Player
                    details={game && game.listOfPlayers && game.listOfPlayers.length >= 1 && game.listOfPlayers[0]}
                    currentPlayerId={game.currentPlayerId}
                />
                {modalFlag && <DynamicModal flag={modalFlag}/>}
            </div>
        </div>
    );
}

export default Game;