import React, {Component} from "react";
import Portal from "../../components/portal/Portal";
import './AuthModal.css'

/**
 *
 */
export default class AuthModal extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <>
                {this.props.state.isOpenAuth &&
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
                                <button onClick={this.props.onCancel}>Cancel</button>
                                <button onClick={this.props.onSubmit}>Submit</button>
                            </div>
                        </div>
                    </div>
                </Portal>
                }
            </>
        );
    };

    handleSubmit = () => {
        console.log('Submit function!');
        this.props.state.isOpenAuth = false;
    };

    handleCancel = () => {
        console.log('Cancel function!');
        this.props.state.isOpenAuth = false;
    };


}


