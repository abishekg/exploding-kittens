import React from 'react';
import {Route, Routes} from "react-router-dom";
import Home from "./components/Home/Home";
import PlayerNames from "./components/PlayerNames/PlayerNames";
import Game from "./components/Game/Game";

function AppRoutes(props) {
    return (
        <div>
            <Routes>
                <Route exact path={'/player-names'} element={<PlayerNames />}/>
                <Route exact path={'/game'} element={<Game />}/>
                <Route exact path={'/'} element={<Home />}/>
            </Routes>
        </div>
    );
}

export default AppRoutes;