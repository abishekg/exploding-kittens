import React, {useState, useEffect} from 'react';
import ExplodingKittensHeaderIcon from './exploding-kittens-header.webp';
import './Header.scss';

function Header(props) {
    return (
        <div className={'header'}>
            <div className={'header__img'}><img src={ExplodingKittensHeaderIcon} alt={'exploding-kittens-header-icon'}/></div>
        </div>
    );
}

export default Header;