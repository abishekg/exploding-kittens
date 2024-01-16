import './App.scss';
import AppRoutes from "./AppRoutes";
import {APIProvider} from "./Providers/APIProvider";
import Header from "./components/Header/Header";
import WebSocketClient from "./WebSocketClient";
import {GameProvider} from "./Providers/GameProvider";
import {WebSocketProvider} from "./Providers/WebSocketProvider";

function App() {
    return (
        <div className="App">
            <GameProvider>
                <WebSocketProvider>
                    <APIProvider>
                        <Header/>
                        <AppRoutes/>
                    </APIProvider>
                </WebSocketProvider>
            </GameProvider>
        </div>
    );
}

export default App;
