import {createContext, useRef, useState} from "react";

export const GameContext = createContext(undefined);

export function GameProvider({children}) {
    const [game, setGame] = useState({});
    const [withdrawPlayerCard, setWithdrawPlayerCard] = useState('withdraw-card')
    const [playerDiscardCard, setPlayerDiscardCard] = useState('player-card')
    const [playerPlayerCard, setPlayerPlayerCard] = useState('');
    const [showFutureCardsModal, setShowFutureCardModal] = useState(false);
    const [shouldPlayDefuse, setShouldPlayDefuse] = useState(false);
    const [insertExplodingKittensCardInsideDeck, setInsertExplodingKittensCardInsideDeck] = useState(false);
    const [defuseCardPlayed, setDefuseCardPlayed] = useState({});
    const [defuseTimer, setDefuseTimer] = useState(null);
    const [isGameOver, setIsGameOver] = useState(false);
    let timer = useRef(-1);

    const closeSeeTheFutureModel = () => {
        setShowFutureCardModal(false);
    }

    const initializeDefuseTimer = (val) => {
        timer.current = setTimeout(() => {
            if (val === 0) {
                setDefuseTimer(null);
            } else {
                setDefuseTimer(prevState => prevState - 1);
            }
        }, 1000);

        console.log(timer);
    }

    const stopDefuseTimer = () => {
        clearTimeout(timer.current);
        setDefuseTimer(null);
    }

    const setDefuseFlagOff = (defuseCard) => {
        console.log('DEFUSE FLAG ON CALLEd');
        setShouldPlayDefuse(false);
        setDefuseCardPlayed(defuseCard);
        setInsertExplodingKittensCardInsideDeck(true);
    }

    const emptyDefuseCardPlayed = () => {
        setDefuseCardPlayed({})
    }

    const updateGame = (updatedGame) => {
        const playStyle = updatedGame.playStyle;
        console.log('updatedGame.playStyle', updatedGame.playStyle);
        setGame({...updatedGame, playStyle: null});
        if (playStyle === 'ChangePlayerAndGiveACard') {
            setPlayerPlayerCard('player-player-card');
        } else if (playStyle === 'ShowNextThreeCards') {
            setShowFutureCardModal(true);
        } else if (playStyle === 'ExplodingKittenCardInserted') {
            setInsertExplodingKittensCardInsideDeck(false);
        } else if (playStyle === 'MightExplode') {
            setShouldPlayDefuse(true);
            setDefuseTimer(6);
        } else if (playStyle === 'EndGame') {
            setIsGameOver(true);
        } else {
            setPlayerPlayerCard('');
        }
    }

    return (
        <GameContext.Provider
            value={{
                game,
                withdrawPlayerCard,
                playerDiscardCard,
                playerPlayerCard,
                showFutureCardsModal,
                shouldPlayDefuse,
                insertExplodingKittensCardInsideDeck,
                defuseCardPlayed,
                defuseTimer,
                isGameOver,
                setDefuseFlagOff,
                closeSeeTheFutureModel,
                updateGame,
                emptyDefuseCardPlayed,
                initializeDefuseTimer,
                stopDefuseTimer
            }}>
            {children}
        </GameContext.Provider>
    );
}
