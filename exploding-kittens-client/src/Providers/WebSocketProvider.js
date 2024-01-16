import {createContext, useContext, useState} from "react";
import SockJS from 'sockjs-client';
import {over} from 'stompjs';
import {GameContext} from "./GameProvider";
import card from "../components/Game/Player/Hand/Card/Card";

const SOCKET_URL = 'http://localhost:8080/ws-message';
var stompClient = null;

export const WebSocketContext = createContext(undefined);

export function WebSocketProvider({children}) {
    const {
        updateGame,
        defuseCardPlayed,
        emptyDefuseCardPlayed,
        defuseTimer,
        initializeDefuseTimer
    } = useContext(GameContext);
    const [connected, setConnected] = useState(false);

    let onConnected = () => {
        setConnected(true);
        stompClient.subscribe('/topic/message', onMessageReceived);
    }

    let onDisconnected = () => {
        setConnected(false);
        console.log('>>>> disconnected');
    }

    let onError = (err) => {
        setConnected(false);
        console.log(err);
    }

    let onMessageReceived = (message) => {
        console.log("Message Received game", JSON.parse(message.body));
        console.log("Message Received player 1", JSON.parse(message.body).listOfPlayers[0]);
        console.log("Message Received player 2", JSON.parse(message.body).listOfPlayers[1]);
        console.log("Message Received deck", JSON.parse(message.body).deck);
        console.log("Message Received discardedCards", JSON.parse(message.body).discardedCards);
        console.log("Message Received currentPlayerId", JSON.parse(message.body).currentPlayerId);
        updateGame({
            ...JSON.parse(message.body)
        });
    }

    const connect = () => {
        let Sock = new SockJS(SOCKET_URL);
        stompClient = over(Sock);
        stompClient.connect({}, onConnected, onError);
    }

    const disconnect = () => {
        stompClient.disconnect({}, onDisconnected, onError)
    }

    const playTurn = (player, cardPlayed) => {
        console.log('player - ', player);
        console.log('cardPlayed - ', cardPlayed);
        if (stompClient) {
            stompClient.send('/app/play-card', {}, JSON.stringify({
                ...player,
                lastCardPlayed: cardPlayed
            }));
        }
    }

    const withdrawCard = (cardPlayed) => {
        if (stompClient) {
            stompClient.send('/app/withdraw-card', {}, JSON.stringify({
                ...cardPlayed
            }));
        }
    }

    const stealACard = (cardStolen) => {
        if (stompClient) {
            stompClient.send('/app/steal-a-card', {}, JSON.stringify({
                ...cardStolen
            }));
        }
    }

    const insertExplodingKittenIntoDeck = (idx) => {
        if (stompClient) {
            stompClient.send('/app/insert-exploding-kitten-card', {}, JSON.stringify({
                card: {...defuseCardPlayed},
                idx
            }));
            emptyDefuseCardPlayed();
        }
    }

    const onGameEnd = () => {
        if (defuseTimer === 1) {
            initializeDefuseTimer(0)
            if (stompClient) {
                stompClient.send('/app/end-game', {}, JSON.stringify({}));
            }
        } else {
            initializeDefuseTimer(1);
        }

    }

    const onRestartGame = () => {
        if (stompClient) {
            stompClient.send('/app/restart-game', {}, JSON.stringify({}));
        }
    }

    return (
        <WebSocketContext.Provider
            value={{
                connected,
                onConnected,
                connect,
                disconnect,
                playTurn,
                withdrawCard,
                stealACard,
                insertExplodingKittenIntoDeck,
                onGameEnd,
                onRestartGame,
            }}>
            {children}
        </WebSocketContext.Provider>
    )
}