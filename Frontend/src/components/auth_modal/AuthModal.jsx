import React, {Component} from "react";
import Portal from '../portal/Portal';
import '../modal/Modal.css';

import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";
import Input from "../../components/input/Input";
import RestClient from "../../services/RestClient";
import {AUTHENTICATION_FAILURE, LOGIN_URL, OK} from "../../constants/RestConstants";

/**
 * Окно авторизации
 */
class AuthModal extends Component {

    state = {
      message: ''
    };

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <>
                {this.props.appState.isOpenAuthModal &&
                <Portal>
                    <div className="modalOverlay">
                        <div className="modalWindow">
                            <div className="modalHeader">
                                <div className="modalTitle">Авторизация</div>

                            </div>
                            <div className="modalBody">
                                <div>Введите адресс электронной почты и пароль</div>
                                <Input id={'email'}/>
                                <Input id={'password'}/>
                                <div>{this.state.message}</div>
                            </div>
                            <div className="modalFooter">
                                <Button onClickAction={this.handleRegistration} classes={"registrationButton"}>Регистрация</Button>
                                <Button onClickAction={this.handleCancelAuth}>Cancel</Button>
                                <Button onClickAction={this.handleSubmitAuth}>Submit</Button>
                            </div>
                        </div>
                    </div>
                </Portal>
                }
            </>
        );
    };


    handleRegistration  = async () => {
        this.props.changeAppState.setIsOpenAuthModal(false);
        this.setState({message: ''});
        this.props.changeAppState.setIsOpenRegistrationModal(true);
    }

    /**
     * Выполняется при нажатии на кнопку Submit
     */
    handleSubmitAuth = async () => {
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        //TODO переделать на RestClient post
        const response = await RestClient.sendForm(LOGIN_URL, {email: email, password: password});

        if (response.code === OK) {
            this.props.changeAppState.setIsAuthenticated(true);
            this.props.changeAppState.setUserInfo(response.data);
            this.props.appState.onSuccessAuth();
            this.props.changeAppState.setIsOpenAuthModal(false);
            this.setState({message: ''});
        } else if (response.code === AUTHENTICATION_FAILURE) {
            this.setState({message: 'неверный логин или пароль'});
            this.props.changeAppState.setIsAuthenticated(false);
        } else {
            this.setState({message: 'неизвестная ошибка'});
            this.props.changeAppState.setIsAuthenticated(false);
        }

    };


    /**
     * Выполняется при нажатии на кнопку Cancel
     */
    handleCancelAuth = () => {
        this.props.changeAppState.setIsOpenAuthModal(false);
        this.setState({message: ''});
    };

}


export default connectToStore(AuthModal);

