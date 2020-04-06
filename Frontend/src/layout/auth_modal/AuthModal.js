import React, {Component} from "react";
import Portal from '../../components/portal/Portal';
import '../../components/modal/Modal.css';

import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";

/**
 * Окно авторизации
 */
class AuthModal extends Component {

    constructor(props) {
        super(props);
        console.log(props);
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

    handleSubmitAuth = () => {
        this.props.changeAppState.setIsOpenAuthModal(false);

    };

    handleCancelAuth = () => {
        this.props.changeAppState.setIsOpenAuthModal(false);
    };

}


export default connectToStore(AuthModal);

