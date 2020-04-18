import React, {Component} from 'react'
import './Header.css';
import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";
import RestClient from "../../services/RestClient";
import {LOGOUT_URL} from "../../constants/RestConstants";
import Redirect from "react-router-dom/es/Redirect";
import {Link} from "react-router-dom";


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
                <Link to="/" className="homeLink"><img width={170} src="images/logo-lamoda.png"/></Link>
                <span className={"clothesGender"}>
                  {this.props.appState.title}
                </span>

                <span className={"userBlock"}>
                    <Button classes={"button search"}><img src="images/search.svg"/><br/>Поиск</Button>
                    {this.props.appState.isAuthenticated && <span className={"username"}> {this.props.appState.userInfo.username}</span>}
                    {this.props.appState.isAuthenticated && <Button onClickAction={this.onClickLogout} classes={"button"}><img src="images/user.svg"/><br/>Выход</Button>}
                    {!this.props.appState.isAuthenticated && <Button onClickAction={this.onClickLogin} classes={"button"}><img src="images/user.svg"/><br/>Вход</Button>}
                    <Button classes={"button"}><img src="images/favorite.svg"/><br/>Избранное</Button>
                    <Button classes={"button"}><img src="images/bag.svg"/><br/>Корзина</Button>
                </span>


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