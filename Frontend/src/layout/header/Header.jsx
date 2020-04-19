import React, {Component} from 'react'
import './Header.css';
import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";
import RestClient from "../../services/RestClient";
import {LOGOUT_URL} from "../../constants/RestConstants";
import Redirect from "react-router-dom/es/Redirect";
import {Link} from "react-router-dom";
import {BOY, FEMALE, GIRL, MALE} from "../../constants/AppConstants";


/**
 * Заголовок сайта
 */
class Header extends Component {

    state = {
        redirect: false //при разлогине меняется на true
    };

    render() {
        //редирект на домашнюю страницу
        if (this.state.redirect) {
            this.setState({redirect: false});
            return <Redirect to="/" />;
        }

        return (
            <div className="header">
                <Link to="/" className="homeLink"><img className='logo' src="images/logo-lamoda.png"/></Link>

                <span className={"chooseGender"}>
                    <Button classes={"gender"} onClickAction={this.onClickFemale} chosen={this.props.appState.chosenGender === FEMALE}>Женская</Button>
                    <Button classes={"gender"} onClickAction={this.onClickMale} chosen={this.props.appState.chosenGender === MALE}>Мужская</Button>
                    <Button classes={"gender"} onClickAction={this.onClickGirl} chosen={this.props.appState.chosenGender === GIRL}>Девочки</Button>
                    <Button classes={"gender"} onClickAction={this.onClickBoy} chosen={this.props.appState.chosenGender === BOY}>Мальчики</Button>
                </span>

                <span className={"userBlock"}>
                    <Button classes={"search"}><img src="images/search.svg"/><br/>Поиск</Button>
                    {this.props.appState.isAuthenticated && <span className={"username"}> {this.props.appState.userInfo.username}</span>}


                    {this.props.appState.isAuthenticated && <Button><img src="images/user-green.svg"/><br/>Профиль</Button>}
                    {!this.props.appState.isAuthenticated && <Button><img src="images/user.svg"/><br/>Профиль</Button>}

                    <Button><img src="images/favorite.svg"/><br/>Избранное</Button>
                    <Button><img src="images/bag.svg"/><br/>Корзина</Button>

                    {this.props.appState.isAuthenticated && <Button classes={"logout"} onClickAction={this.onClickLogout} ><img src="images/login2.svg"/><br/>Выход</Button>}
                    {!this.props.appState.isAuthenticated && <Button classes={"login"} onClickAction={this.onClickLogin}><img src="images/login2.svg"/><br/>Вход</Button>}
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


    onClickFemale = () => {
        this.props.changeAppState.setChosenGender(FEMALE);
    };

    onClickMale = () => {
        this.props.changeAppState.setChosenGender(MALE);
    };

    onClickGirl = () => {
        this.props.changeAppState.setChosenGender(GIRL);
    };

    onClickBoy = () => {
        this.props.changeAppState.setChosenGender(BOY);
    };


}


export default connectToStore(Header);