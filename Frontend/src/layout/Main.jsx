import React, {Component} from 'react';
import ContentContainer from "./content_container/ContentContainer";
import LeftMenu from "./left_menu/LeftMenu";
import Header from "./header/Header";
import './Main.css';
import {OK, USER_URL} from "../constants/RestConstants";
import {connectToStore} from "../store/Connect";
import RestClient from "../services/RestClient";

/**
 * Главный компонент (весь сайт)
 */
class Main extends Component {

    render() {
        return (
            <div>
                <LeftMenu/>
                <Header/>
                <ContentContainer/>
            </div>
        )
    }

    componentDidMount() {
        this.fetchData();
    }

    /**
     * Получение данных с сервера
     */
    fetchData = async () => {
        let response = await RestClient.get(USER_URL + 'info');
        if (response.code === OK) {
            this.props.changeAppState.setIsAuthenticated(true);
        }
    };

}

export default connectToStore(Main);
