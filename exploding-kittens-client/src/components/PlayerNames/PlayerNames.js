import React, {useContext, useState} from 'react';
import Header from "../Header/Header";
import {Link, useNavigate} from "react-router-dom";
import './PlayerNames.scss';
import PlayerNamesCard from "./PlayerNamesCard/PlayerNamesCard";
import {APIContext} from "../../Providers/APIProvider";

function PlayerNames(props) {
    const [player1Name, setPlayer1Name] = useState('');
    const [player2Name, setPlayer2Name] = useState('');

    const api = useContext(APIContext);

    let navigate = useNavigate();

    const onLetsGo = async () => {
        await api.postPlayerNames({player1Name, player2Name});
        navigate('/game');
    }

    return (<div className={'player-names'}>
        <div className='player-names--body'>
            <PlayerNamesCard number={'1'} update={setPlayer1Name}/>
            <PlayerNamesCard number={'2'} update={setPlayer2Name}/>
        </div>
        {player1Name && player2Name &&
            <button className='player-names__button' onClick={onLetsGo}>
                Let's GO
            </button>
        }
    </div>);
}

export default PlayerNames;