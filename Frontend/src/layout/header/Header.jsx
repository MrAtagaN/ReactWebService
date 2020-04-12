import React, {Component} from 'react'
import './Header.css';
import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";
import RestClient from "../../services/RestClient";
import {LOGOUT_URL} from "../../constants/RestConstants";
import Redirect from "react-router-dom/es/Redirect";


/**
 * Заголовок сайта
 */
class Header extends Component {

    state = {
        redirect: false
    };

    render() {
        //редирект на домашнюю страницу
        if (this.state.redirect) {
            this.setState({redirect: false});
            return <Redirect to="/" />;
        }

        return (
            <div className="header">
                <span>
                  {this.props.appState.title}
                </span>
                <span>
                    Welcome to Site!
                </span>
                {this.props.appState.isAuthenticated && <span> {this.props.appState.userInfo.username}</span>}

                {this.props.appState.isAuthenticated && <Button onClickAction={this.onClickLogout}>Logout</Button>}
                {!this.props.appState.isAuthenticated && <Button onClickAction={this.onClickLogin}>Login</Button>}

            </div>
        )
    }

    /**
     * Выполняется при нажатии на кнопку Logout
     */
    onClickLogout = () => {
        RestClient.get(LOGOUT_URL);
        this.props.changeAppState.setIsAuthenticated(false);
        this.props.changeAppState.setUserInfo({});
        this.setState({...this.state, redirect: true});
    };

    /**
     * Выполняется при нажатии на кнопку Login
     */
    onClickLogin = () => {
        this.props.changeAppState.setIsOpenAuthModal(true);
    };




}


export default connectToStore(Header);