import {bindActionCreators} from 'redux';
import {changeIsOpenAuthModal, changeTitle} from './Actions';
import {connect} from "react-redux";

/**
 * Возвращает объект с переменными state.
 */
export const putStateFieldsToProps = (state) => {
    return {
        appState : {
            isOpenAuthModal: state.isOpenAuthModal,
            title: state.title
        }
    };
};


/**
 * Возвращает объект с функциями для изменения переменных state.
 */
export const putActionsToProps = (dispatch) => {
    return {
        changeAppState : {
            changeIsOpenAuthModal: bindActionCreators(changeIsOpenAuthModal, dispatch),
            changeTitle: bindActionCreators(changeTitle, dispatch)
        }
    };
};


/**
 * Кладет в props компонента объекты appState, changeAppState
 * appState - переменные state
 * changeAppState - функции для изменения переменных state
 */
export const connectToStore = connect(putStateFieldsToProps, putActionsToProps);