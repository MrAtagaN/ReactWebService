import React, {Component} from "react";
import Portal from "../../components/portal/Portal";
import './AuthModal.css'

/**
 * Окно авторизации
 */
export default class AuthModal extends Component {

    constructor(props) {
        super(props);
        this.parentComponent = props.parentComponent; //TODO сделать состояние в обзем компоненте

    }

    render() {
        return (
            <>
                {this.parentComponent.state.isOpenAuth &&
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
        console.log('Submit function!');
        this.parentComponent.setState({ isOpenAuth: false });

    };

    handleCancelAuth = () => {
        console.log('Cancel function!');
        this.parentComponent.setState({ isOpenAuth: false });
    };

}


