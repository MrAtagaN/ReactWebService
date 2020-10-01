import React, {Component} from "react";
import {connectToStore} from "../../store/Connect";
import Portal from "../portal/Portal";
import '../modal/Modal.css';

import Input from "../input/Input";
import Button from "../button/Button";
import RestClient from "../../services/RestClient";
import {OK, REGISTRATION_REQUEST} from "../../constants/RestConstants";


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
                                <div>{this.state.message}</div>
                            </div>
                            <div className="modalFooter">
                                <Button onClickAction={this.handleCancelAuth}>Cancel</Button>
                                <Button onClickAction={this.handleSubmitRegistration}>Submit</Button>
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
    handleSubmitRegistration = async () => {
        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        const response = await RestClient.sendForm(REGISTRATION_REQUEST, {username: username, email: email, password: password});

        if (response.code === OK) {


            this.setState({message: ''});
        } else {
            this.setState({message: 'неизвестная ошибка'});
        }

    };

    /**
     * Выполняется при нажатии на кнопку Cancel
     */
    handleCancelAuth = () => {
        this.props.changeAppState.setIsOpenRegistrationModal(false);
        this.setState({message: ''});
    };

}

export default connectToStore(RegistrationModal);