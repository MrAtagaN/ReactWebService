import React, {Component} from 'react';
import ContentContainer from "./content_container/ContentContainer";
import LeftMenu from "./left_menu/LeftMenu";
import Header from "./header/Header";
import './Main.css';
import {OK, USER_URL} from "../constants/RestConstants";
import {connectToStore} from "../store/Connect";
import RestClient from "../services/RestClient";
import AuthModal from "../components/auth_modal/AuthModal";
import RegistrationModal from "../components/registration_modal/RegistrationModal";

/**
 * Главный компонент (весь сайт)
 */
class Main extends Component {

    render() {
        return (
            <div>
                <RegistrationModal/>
                <AuthModal/>
                <Header/>
                <LeftMenu/>
                <ContentContainer/>
            </div>
        )
    }

    componentDidMount() {
        this.fetchData();
    }

    /**
     * Получение данных о пользователе с сервера
     */
    fetchData = async () => {
        let response = await RestClient.get(USER_URL + 'info');
        if (response.code === OK) {
            this.props.changeAppState.setIsAuthenticated(true);
            this.props.changeAppState.setUserInfo(response.data);
        }
    };

}

export default connectToStore(Main);
