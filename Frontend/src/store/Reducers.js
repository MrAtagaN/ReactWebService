import {
    CHOSEN_GENDER,
    IS_AUTHENTICATED,
    IS_OPEN_AUTH_MODAL, IS_OPEN_REGISTRATION_MODAL, ON_CHOSEN_GENDER,
    ON_SUCCESS_AUTH, SET_CLOTHES_SEARCH_PARAMS, SET_PRODUCTS, SUCCESS_REGISTRATION_REQUEST,
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
    isOpenRegistrationModal: false, // открыто модальное окно регистрации
    isSuccessRegistrationRequest: false, // успешный ответ решистрации нового пользователя
    onSuccessAuth: ()=>{}, //действие при успешной авторизации
    title: '',
    userInfo: '',
    chosenGender: FEMALE,
    onChosenGender: ()=>{}, //действие при выборе пола
    clothesSearchParams: {},
    products: []
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
        case ON_CHOSEN_GENDER:
            return {...state, onChosenGender: action.value};
        case IS_OPEN_REGISTRATION_MODAL:
            return {...state, isOpenRegistrationModal: action.value}
        case SUCCESS_REGISTRATION_REQUEST:
            return {...state, isSuccessRegistrationRequest: action.value}
        case SET_CLOTHES_SEARCH_PARAMS:
            return {...state, clothesSearchParams: action.value}
        case SET_PRODUCTS:
            return {...state, products: action.value}
    }

    return state;
};