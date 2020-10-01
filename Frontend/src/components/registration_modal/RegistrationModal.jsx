import React, {Component} from "react";
import {connectToStore} from "../../store/Connect";
import Portal from "../portal/Portal";
import '../modal/Modal.css';

import Input from "../input/Input";
import Button from "../button/Button";
import RestClient from "../../services/RestClient";
import {
    OK,
    WRONG_CONFIRM_CODE,
    REGISTRATION_REQUEST,
    CONFIRM_REQUEST,
    USER_EMAIL_ALREADY_EXIST
} from "../../constants/RestConstants";


/**
 * Окно регистрации
 */
class RegistrationModal extends Component {

    state = {
        message: ''
    };

    constructor(props) {
        super(props);
    }

    render() {
        return(
            <>
                {this.props.appState.isOpenRegistrationModal &&
                <Portal>
                    <div className="modalOverlay">
                        {!this.props.appState.isSuccessRegistrationRequest &&
                        <div className="modalRegistrationWindow">
                            <div className="modalHeader">
                                <div className="modalTitle">Регистрация</div>
                            </div>
                            <div className="modalBody">
                                <div>Введите имя</div>
                                <Input id={'username'}/>
                                <div>Введите адрес электронной почты</div>
                                <Input id={'email'}/>
                                <div>Введите пароль</div>
                                <Input id={'password'}/>
                                <div>Подтвердите пароль</div>
                                <Input id={'confirmPassword'}/>
                                <div>{this.state.message}</div>
                            </div>
                            <div className="modalFooter">
                                <Button onClickAction={this.handleCancelRegistration}>Cancel</Button>
                                <Button onClickAction={this.handleSubmitRegistration}>Submit</Button>
                            </div>
                        </div>}
                        {this.props.appState.isSuccessRegistrationRequest &&
                        <div className="modalConfirmWindow">
                            <div className="modalHeader">
                                <div className="modalTitle">Регистрация</div>
                            </div>
                            <div className="modalBody">
                                <div>Введите проверочный код высланный на электронную почту</div>
                                <Input id={'confirmcode'}/>
                                <div>{this.state.message}</div>
                                <div className="modalFooter">
                                    <Button onClickAction={this.handleCancelRegistration}>Cancel</Button>
                                    <Button onClickAction={this.handleSubmitConfirmCode}>Submit</Button>
                                </div>
                            </div>
                         </div>
                        }
                    </div>
                </Portal>
                }
            </>
        );
    };

    /**
     * Выполняется при нажатии на кнопку Submit при отправке данных регистрации
     */
    handleSubmitRegistration = async () => {
        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;
        this.state.email = email;
        if(password !== confirmPassword) {
            this.setState({message: 'Пароли не совпадают'});
        } else {
            const response = await RestClient.sendForm(REGISTRATION_REQUEST, {
                username: username,
                email: email,
                password: password
            });

            if (response.code === OK) {
                this.props.changeAppState.setSuccessRegistrationRequest(true);
                this.setState({message: ''});
            } else if (response.code === USER_EMAIL_ALREADY_EXIST) {
                this.setState({message: 'Пользователь с таким email уже существует'});
            } else {
                this.setState({message: 'Неизвестная ошибка'});
            }
        }
    };

    /**
     * Выполняется при нажатии на кнопку Submit при отправке проверочного кода
     */
    handleSubmitConfirmCode = async () => {
        const confirmcode = document.getElementById('confirmcode').value;
        const email = this.state.email;
        const response = await RestClient.sendForm(CONFIRM_REQUEST, {confirmCode: confirmcode, email: email});

        if (response.code === WRONG_CONFIRM_CODE) {
            this.setState({message: 'неправильный проверочный код'})
        } else if (response.code === OK) {
            this.props.changeAppState.setIsOpenRegistrationModal(false);
            this.props.changeAppState.setSuccessRegistrationRequest(false);
        }
    }

    /**
     * Выполняется при нажатии на кнопку Cancel
     */
    handleCancelRegistration = () => {
        this.props.changeAppState.setIsOpenRegistrationModal(false);
        this.props.changeAppState.setSuccessRegistrationRequest(false);
        this.setState({message: ''});
    };

}

export default connectToStore(RegistrationModal);