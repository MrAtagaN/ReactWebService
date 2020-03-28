import React from 'react'
import MainContent from "./main_content/MainContent";
import LeftMenu from "./left_menu/LeftMenu";
import Header from "./header/Header";

export default Main

/**
 * Главный компонент
 */
function Main() {
    return (
        <div>
            <Header/>
            <LeftMenu/>
            <MainContent/>
        </div>
    )
}