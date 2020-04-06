import React, {Component} from "react";
import Portal from '../../components/portal/Portal';
import '../../components/modal/Modal.css';

import {connectToStore} from "../../store/Connect";

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
                                <button onClick={this.handleCancelAuth}>Cancel</button>
                                <button onClick={this.handleSubmitAuth}>Submit</button>
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

