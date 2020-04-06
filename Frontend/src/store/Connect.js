import {bindActionCreators} from 'redux';
import {changeIsOpenAuthModal, changeTitle} from './Actions';
import {connect} from "react-redux";

/**
 * Кладет значения переменных из state в props.appState
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
 * Кладет функции для изменения переменных state в props.changeAppState
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
 */
export const connectToStore = connect(putStateFieldsToProps, putActionsToProps);