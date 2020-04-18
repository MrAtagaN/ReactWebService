import {
    CHOSEN_GENDER,
    IS_AUTHENTICATED,
    IS_OPEN_AUTH_MODAL,
    ON_SUCCESS_AUTH,
    TITLE,
    USER_INFO
} from "../constants/ActionConstants";
import {FEMALE} from "../constants/AppConstants";

/**
 * Начальное состояние переменных приложения
 */
const initialState = {
    isAuthenticated: false,
    isOpenAuthModal: false, //открыто модальное окно авторизации
    onSuccessAuth: ()=>{}, //действие при успешной авторизации
    title: '',
    userInfo: '',
    chosenGender: FEMALE
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
        case CHOSEN_GENDER:
            return {...state, chosenGender: action.value};
    }

    return state;
};