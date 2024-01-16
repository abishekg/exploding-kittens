import React, {useContext} from 'react';
import Card from "../Game/Player/Hand/Card/Card";
import {GameContext} from "../../Providers/GameProvider";
import Modal from 'react-modal';
import './DynamicModal.scss';
import SeeTheFuture from "./SeeTheFuture/SeeTheFuture";
import InsertExplodingKittenCardIntoTheDeck
    from "./InsertExplodingKittenCardIntoTheDeck/InsertExplodingKittenCardIntoTheDeck";
import GameOver from "./GameOver/GameOver";

function DynamicModal({flag}) {
    const {
        showFutureCardsModal,
        closeSeeTheFutureModel,
        insertExplodingKittensCardInsideDeck,
        isGameOver
    } = useContext(GameContext);

    const customStyles = {
        content: {
            top: '50%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
        },
    };

    return (
        <Modal
            isOpen={flag}
            onRequestClose={() => closeSeeTheFutureModel(false)}
            onAfterClose={() => closeSeeTheFutureModel(false)}
            style={customStyles}
            contentLabel="See_The_Future-Label"
            shouldCloseOnOverlayClick={!insertExplodingKittensCardInsideDeck}
        >
            {showFutureCardsModal && <SeeTheFuture/>}

            {insertExplodingKittensCardInsideDeck && <InsertExplodingKittenCardIntoTheDeck/>}
            {isGameOver && <GameOver/>}
        </Modal>
    );
}

export default DynamicModal;