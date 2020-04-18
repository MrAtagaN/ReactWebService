import {bindActionCreators} from 'redux';
import {
    setChosenGender,
    setIsAuthenticated,
    setIsOpenAuthModal,
    setOnSuccessAuth,
    setTitle,
    setUserInfo
} from './Actions';
import {connect} from "react-redux";

/**
 * Возвращает объект с переменными state.
 */
export const putStateFieldsToProps = (state) => {
    return {
        appState : {
            isAuthenticated: state.isAuthenticated,
            title: state.title,
            userInfo: state.userInfo,
            isOpenAuthModal: state.isOpenAuthModal,
            onSuccessAuth: state.onSuccessAuth,
            chosenGender: state.chosenGender
        }
    };
};


/**
 * Возвращает объект с функциями для изменения переменных state.
 */
export const putActionsToProps = (dispatch) => {
    return {
        changeAppState : {
            setIsAuthenticated: bindActionCreators(setIsAuthenticated, dispatch),
            setTitle: bindActionCreators(setTitle, dispatch),
            setUserInfo: bindActionCreators(setUserInfo, dispatch),
            setIsOpenAuthModal: bindActionCreators(setIsOpenAuthModal, dispatch),
            setOnSuccessAuth: bindActionCreators(setOnSuccessAuth, dispatch),
            setChosenGender: bindActionCreators(setChosenGender, dispatch)


        }
    };
};


/**
 * Кладет в props компонента объекты appState, changeAppState
 * appState - переменные state
 * changeAppState - функции для изменения переменных state
 */
export const connectToStore = connect(putStateFieldsToProps, putActionsToProps);