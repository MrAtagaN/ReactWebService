import React, {Component} from 'react'
import ContentContainer from "./content_container/ContentContainer";
import LeftMenu from "./left_menu/LeftMenu";
import Header from "./header/Header";
import './Main.css'
import PopUp from "../common/PopUp";

/**
 * Главный компонент (весь сайт)
 */
export default class Main extends Component {

    render() {
        return (
            <div>
                <PopUp/>
                <Header/>
                <LeftMenu/>
                <ContentContainer/>
            </div>
        )
    }

}
