import React, {useState, useEffect, useContext} from 'react';
import Header from "../Header/Header";
import {Link, useNavigate} from "react-router-dom";
import './Home.scss';
import {APIContext, APIProvider, useAPI} from "../../Providers/APIProvider";

function Home(props) {

    let navigate = useNavigate();

    const api = useContext(APIContext);

    const onStartGame = async () => {
        await api.startGame();
        navigate('/player-names');
    };

    return <div className='home'>
        <div className={'home__header'}>Welcome to the Two Player Version of Exploding Kittens!</div>
        <div className={'home__sub-header'}>where friends become enemies and enemies be strangers</div>
        <button className='home__button' onClick={onStartGame}>
            Start Game
        </button>
    </div>;
}

export default Home;