import {bindActionCreators} from 'redux';
import {changeIsOpenAuthModal, changeTitle} from './Actions';
import {connect} from "react-redux";

/**
 * Кладет значения переменных из state в props
 */
export const putStateFieldsToProps = (store) => {
    return {
        isOpenAuthModal: store.isOpenAuthModal,
        title: store.title
    };
};


/**
 * Кладет функции для изменения переменных state в props
 */
export const putActionsToProps = (dispatch) => {
    return {
        changeIsOpenAuthModal: bindActionCreators(changeIsOpenAuthModal, dispatch),
        changeTitle: bindActionCreators(changeTitle, dispatch)
    };
};


/**
 * Кладет в props компонента переменные state и функции для изменения переменных state
 */
export const connectToStore = connect(putStateFieldsToProps, putActionsToProps);