import React, {Component} from 'react';
import ContentContainer from "./content_container/ContentContainer";
import LeftMenu from "./left_menu/LeftMenu";
import Header from "./header/Header";
import './Main.css';

/**
 * Главный компонент (весь сайт)
 */
export default class Main extends Component {

    render() {
        return (
            <div>
                <LeftMenu/>
                <Header/>
                <ContentContainer/>
            </div>
        )
    }

}
