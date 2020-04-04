import React, {Component} from "react";
import Portal from '../../components/portal/Portal';
import './AuthModal.css';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import {changeIsOpenAuth} from '../../store/actions';

/**
 * Окно авторизации
 */
class AuthModal extends Component {

    render() {
        return (
            <>
                {this.props.isOpenAuth &&
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
        this.props.changeIsOpenAuth(false);

    };

    handleCancelAuth = () => {
        this.props.changeIsOpenAuth(false);
    };

}


/**
 * Из state Store копирует поля в props данного компонента
 */
const putStateFieldsToProps = (state) => {
    return {
        isOpenAuth: state.isOpenAuth
    };
};

/**
 * Кладет функции, возвращающие action в props
 */
const putActionsToProps = (dispatch) => {
    return {
        changeIsOpenAuth: bindActionCreators(changeIsOpenAuth, dispatch)
    };
};

export default connect(putStateFieldsToProps, putActionsToProps)(AuthModal);

