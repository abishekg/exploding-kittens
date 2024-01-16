import React, {createContext, useContext, useEffect, useState} from "react";
import axios from "axios";
import {GameContext} from "./GameProvider";

export const APIContext = createContext(undefined);

export function APIProvider({children}) {

    const {updateGame} = useContext(GameContext);

    const getStartGame = async () => {
        const data = await axios.get('http://localhost:8080/api/v1/game');
    }

    const postPlayerNames = async (names) => {
        const {data} = await axios.post('http://localhost:8080/api/v1/player', JSON.stringify(names), {headers: {'Content-Type': 'application/json'}});
        updateGame(data);
    }

    return (
        <APIContext.Provider value={{startGame: getStartGame, postPlayerNames}}>
            {children}
        </APIContext.Provider>
    )
}