import {IS_AUTHENTICATED, IS_OPEN_AUTH_MODAL, ON_SUCCESS_AUTH, TITLE, USER_INFO} from "../constants/ActionConstants";

/**
 * Начальное состояние переменных
 */
const initialState = {
    isAuthenticated: false,
    isOpenAuthModal: false,         //открыто модальное окно авторизации
    onSuccessAuth: ()=>{},
    title: '',
    userInfo: ''
};


export const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case IS_AUTHENTICATED:
            return {...state, isAuthenticated: action.value};
        case IS_OPEN_AUTH_MODAL:
            return {...state, isOpenAuthModal: action.value};
        case ON_SUCCESS_AUTH:
            return {...state, onSuccessAuth: action.value};
        case TITLE:
            return {...state, title: action.value};
        case USER_INFO:
            return {...state, userInfo: action.value};
    }

    return state;
};