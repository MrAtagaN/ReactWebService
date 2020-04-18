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
        redirect: false,
        chosenGender: 'FEMALE'
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

                <span className={"chooseGender"}>
                    <Button classes={"gender"} onClickAction={this.onClickFemale} chosen={this.state.chosenGender === 'FEMALE'}>Женская</Button>
                    <Button classes={"gender"} onClickAction={this.onClickMale} chosen={this.state.chosenGender === 'MALE'}>Мужская</Button>
                    <Button classes={"gender"} onClickAction={this.onClickGirl} chosen={this.state.chosenGender === 'GIRL'}>Девочки</Button>
                    <Button classes={"gender"} onClickAction={this.onClickBoy} chosen={this.state.chosenGender === 'BOY'}>Мальчики</Button>
                </span>

                <span className={"userBlock"}>
                    <Button classes={"search"}><img src="images/search.svg"/><br/>Поиск</Button>
                    {this.props.appState.isAuthenticated && <span className={"username"}> {this.props.appState.userInfo.username}</span>}
                    {this.props.appState.isAuthenticated && <Button onClickAction={this.onClickLogout}><img src="images/user.svg"/><br/>Выход</Button>}
                    {!this.props.appState.isAuthenticated && <Button onClickAction={this.onClickLogin}><img src="images/user.svg"/><br/>Вход</Button>}
                    <Button><img src="images/favorite.svg"/><br/>Избранное</Button>
                    <Button><img src="images/bag.svg"/><br/>Корзина</Button>
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
        this.setState({...this.state, chosenGender: 'FEMALE'});
    };

    onClickMale = () => {
        this.setState({...this.state, chosenGender: 'MALE'});
    };

    onClickGirl = () => {
        this.setState({...this.state, chosenGender: 'GIRL'});
    };

    onClickBoy = () => {
        this.setState({...this.state, chosenGender: 'BOY'});
    };




}


export default connectToStore(Header);