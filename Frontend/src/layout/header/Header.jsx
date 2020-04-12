import React, {Component} from 'react'
import './Header.css';
import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";
import RestClient from "../../services/RestClient";
import {LOGOUT_URL} from "../../constants/RestConstants";
import Redirect from "react-router-dom/es/Redirect";
import AuthModal from "../../components/auth_modal/AuthModal";


/**
 * Заголовок сайта
 */
class Header extends Component {

    state = {
        redirect: false,
        isOpenModal: false
    };

    render() {
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
                {this.props.appState.isAuthenticated && <span> залогинин</span>}

                <AuthModal isOpenModal={this.state.isOpenModal} onSuccessAuth={this.onSuccessAuth} onCancelModal={this.onCancelModal}/>
                {this.props.appState.isAuthenticated && <Button onClickAction={this.onClickLogout}>Logout</Button>}
                {!this.props.appState.isAuthenticated && <Button onClickAction={this.onClickLogin}>Login</Button>}

            </div>
        )
    }

    /**
     * Выполняется при разлогине
     */
    onClickLogout = () => {
        RestClient.get(LOGOUT_URL);
        this.props.changeAppState.setIsAuthenticated(false);
        this.setState({...this.state, redirect: true});
    };

    /**
     * Выполняется при нажатии на кнопку Login
     */
    onClickLogin = () => {
        this.setState({...this.state, isOpenModal: true});
    };

    /**
     * Выполняется при закрытии окна авторизации
     */
    onCancelModal = () => {
        this.setState({...this.state, isOpenModal: false});
    };

    /**
     * Выполняется при успешной авторизации
     */
    onSuccessAuth = () => {
        this.setState({...this.state, isOpenModal: false});
    }



}


export default connectToStore(Header);