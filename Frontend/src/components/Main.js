import React from 'react'
import ContentContainer from "./content_container/ContentContainer";
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
            <ContentContainer/>
        </div>
    )
}