import React, {Component} from 'react'
import './Header.css';
import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";
import RestClient from "../../services/RestClient";
import {LOGOUT_URL, NOT_AUTHENTICATED, OK, PRODUCT_URL, USER_URL} from "../../constants/RestConstants";
import Redirect from "react-router-dom/es/Redirect";
import {Link} from "react-router-dom";
import {BOY, FEMALE, GIRL, MALE} from "../../constants/AppConstants";


/**
 * Заголовок сайта
 */
class Header extends Component {

    state = {
        redirectURL: false, //меняется по нажатию кнопок, на url редиректа
        searchByNameParam: ''
    };

    render() {
        //механизм редиректа
        const redirectURL = this.state.redirectURL;
        if (redirectURL) {
            this.setState({...this.state, redirectURL: false});
            return <Redirect to={redirectURL} />;
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
                    <Button onClickAction={this.onClickSearch} classes={"search"}><img src="images/search.svg"/><br/>Поиск</Button>
                    <input value={this.state.searchByNameParam} id="searchByName" className={"inputSearch"} onChange={event => this.searchByName(event.target.value)}/>

                    {this.props.appState.isAuthenticated && <span className={"username"}> {this.props.appState.userInfo.username}</span>}

                    {this.props.appState.isAuthenticated && <Button onClickAction={this.onClickProfile}><img src="images/user-green.svg"/><br/>Профиль</Button>}
                    {!this.props.appState.isAuthenticated && <Button onClickAction={this.onClickProfile}><img src="images/user.svg"/><br/>Профиль</Button>}

                    <Button onClickAction={this.onClickFavorite}><img src="images/favorite.svg"/><br/>Избранное</Button>
                    <Button onClickAction={this.onClickBag}><img src="images/bag.svg"/><br/>Корзина</Button>

                    {this.props.appState.isAuthenticated && <Button classes={"logout"} onClickAction={this.onClickLogout} ><img src="images/login2.svg"/><br/>Выход</Button>}
                    {!this.props.appState.isAuthenticated && <Button classes={"login"} onClickAction={this.onClickLogin}><img src="images/login2.svg"/><br/>Вход</Button>}
                </span>


            </div>
        )
    }

    searchByName = async (value) => {
        this.setState({...this.state, searchByNameParam: value});
        let params = {name: value}
        const response = await RestClient.get(PRODUCT_URL + 'searchbyname', params);
        if (response.code === OK) {
            this.props.changeAppState.setProducts(response.data);
            this.setState({...this.state, redirectURL: '/product-table'})
        }
        document.getElementById("searchByName").focus();
    }


    onClickSearch = async () => {

    };

    onClickLogout = () => {
        RestClient.get(LOGOUT_URL);
        this.props.changeAppState.setIsAuthenticated(false);
        this.props.changeAppState.setUserInfo({});
        this.setState({...this.state, redirectURL: '/'});
    };

    onClickLogin = () => {
        this.props.changeAppState.setIsOpenAuthModal(true);
    };

    onClickProfile = async () => {
        if (this.props.appState.isAuthenticated) {
            this.setState({...this.state, redirectURL: '/profile'});
        } else {
            this.props.changeAppState.setOnSuccessAuth(this.onClickProfile);
            this.props.changeAppState.setIsOpenAuthModal(true);
        }
    };

    onClickFavorite = async () => {
        const response = await RestClient.get(USER_URL + 'info');//TODO поменять
        if (response.code === OK) {


        } else if (response.code === NOT_AUTHENTICATED) {
            this.props.changeAppState.setIsOpenAuthModal(true);
            this.props.changeAppState.setIsAuthenticated(false);
        }
    };

    onClickBag = async () => {
        const response = await RestClient.get(USER_URL + 'info');//TODO поменять
        if (response.code === OK) {


        } else if (response.code === NOT_AUTHENTICATED) {
            this.props.changeAppState.setIsOpenAuthModal(true);
            this.props.changeAppState.setIsAuthenticated(false);
        }
    };


     onClickFemale = async () => {
        await this.props.changeAppState.setChosenGender(FEMALE);
        this.props.appState.onChosenGender();
    };

    onClickMale = async () => {
        await this.props.changeAppState.setChosenGender(MALE);
        this.props.appState.onChosenGender();
    };

    onClickGirl = async () => {
        await this.props.changeAppState.setChosenGender(GIRL);
        this.props.appState.onChosenGender();
    };

    onClickBoy = async () => {
        await this.props.changeAppState.setChosenGender(BOY);
        this.props.appState.onChosenGender();
    };


}


export default connectToStore(Header);
