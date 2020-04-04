import React, {Component} from 'react'
import ContentContainer from "./content_container/ContentContainer";
import LeftMenu from "./left_menu/LeftMenu";
import Header from "./header/Header";
import './Main.css'
import AuthModal from "./auth_modal/AuthModal";

/**
 * Главный компонент (весь сайт)
 */
export default class Main extends Component {
    state = {
        isOpenAuth: true
    };

    constructor(props) {
        super(props);
    }


    render() {
        return (
            <div>
                <AuthModal parentComponent = {this}/>
                <Header/>
                <LeftMenu/>
                <ContentContainer/>
            </div>
        )
    }

}
