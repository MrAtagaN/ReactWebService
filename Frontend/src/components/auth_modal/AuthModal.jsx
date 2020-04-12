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
                                <div>Введите логин и пароль</div>
                                <Input id={'username'}/>
                                <Input id={'password'}/>
                                <div>{this.state.message}</div>
                            </div>
                            <div className="modalFooter">
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

    /**
     * Выполняется при нажатии на кнопку Submit
     */
    handleSubmitAuth = async () => {
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        const response = await RestClient.sendForm(LOGIN_URL, {username: username, password: password});

        if (response.code === OK) {
            this.props.changeAppState.setIsAuthenticated(true);
            this.props.changeAppState.setUserInfo(response.data);
            this.props.appState.onSuccessAuth();
            this.props.changeAppState.setIsOpenAuthModal(false);
            this.setState({message: ''});
        } else if (response.code === AUTHENTICATION_FAILURE) {
            this.setState({message: 'неверный логин или пароль'});
        } else {
            this.setState({message: 'неизвестная ошибка'});
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

