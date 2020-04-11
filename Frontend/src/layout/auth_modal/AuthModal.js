import React, {Component} from "react";
import Portal from '../../components/portal/Portal';
import '../../components/modal/Modal.css';

import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";
import Input from "../../components/input/Input";
import RestClient from "../../services/RestClient";
import {LOGIN_URL} from "../../constants/RestConstants";

/**
 * Окно авторизации
 */
class AuthModal extends Component {

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

    handleSubmitAuth = async () => {
        this.props.changeAppState.setIsOpenAuthModal(false);
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;

        let a =  RestClient.sendForm(LOGIN_URL, {username: username, password: password});

        alert(a);
    };



    handleCancelAuth = () => {
        this.props.changeAppState.setIsOpenAuthModal(false);
    };

}


export default connectToStore(AuthModal);

