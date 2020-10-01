import {bindActionCreators} from 'redux';
import {
    setChosenGender,
    setIsAuthenticated,
    setIsOpenAuthModal,
    setIsOpenRegistrationModal,
    setOnChosenGender,
    setOnSuccessAuth, setSuccessRegistrationRequest,
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
            isOpenRegistrationModal: state.isOpenRegistrationModal,
            isSuccessRegistrationRequest: state.isSuccessRegistrationRequest,
            onSuccessAuth: state.onSuccessAuth,
            chosenGender: state.chosenGender,
            onChosenGender: state.onChosenGender
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
            setIsOpenAuthModal: bindActionCreators(setIsOpenAuthModal, dispatch), //открыто модальное окно авторизации
            setIsOpenRegistrationModal: bindActionCreators(setIsOpenRegistrationModal, dispatch),
            setSuccessRegistrationRequest: bindActionCreators(setSuccessRegistrationRequest, dispatch),
            setOnSuccessAuth: bindActionCreators(setOnSuccessAuth, dispatch), //действие при успешной авторизации
            setChosenGender: bindActionCreators(setChosenGender, dispatch),
            setOnChosenGender: bindActionCreators(setOnChosenGender, dispatch) //действие при выборе пола
        }
    };
};


/**
 * Кладет в props компонента объекты appState, changeAppState
 * appState - переменные state
 * changeAppState - функции для изменения переменных state
 */
export const connectToStore = connect(putStateFieldsToProps, putActionsToProps);