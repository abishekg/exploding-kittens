import React, {useState} from 'react';
import SockJS from 'sockjs-client';
import {over} from 'stompjs';

const SOCKET_URL = 'http://localhost:8080/ws-message';
var stompClient = null;

export default function WebSocketClient(props) {
    const [message, setMessage] = useState('Your server message');
    let [data, setData] = useState({
        val: 'Initial'
    })
    const [connected, setConnected] = useState(false);

    let onConnected = () => {
        setConnected(true);
        stompClient.subscribe('/topic/message', onMessageReceived);
    }

    let onError = (err) => {
        setConnected(false);
        console.log(err);
    }

    let onMessageReceived = (message) => {
        setMessage(JSON.stringify(message));
    }

    const handleUserName = (event) => {
        const {value} = event.target;
        setData({
            ...data, val: value
        })
    }

    const connect = () => {
        let Sock = new SockJS(SOCKET_URL);
        stompClient = over(Sock);
        stompClient.connect({}, onConnected, onError);
    }

    const sendValue = () => {
        if (stompClient) {
            data = {
                ...data,
                message: 'HEllo There12'
            }
            stompClient.send('/app/message', {}, JSON.stringify(data));
        }
    }

    return (<div>
        <div>{connected.toString()}</div>
        <div>{message}</div>
        <input
            id={'user-name'}
            placeholder={'Enter the username'}
            value={data.val}
            onChange={handleUserName}
        />
        <button onClick={() => connect()}>connect</button>
        <button onClick={sendValue}>Send Value</button>
    </div>);
}