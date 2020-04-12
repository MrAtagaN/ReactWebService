import {IS_AUTHENTICATED, TITLE, USERNAME} from "../constants/ActionConstants";

/**
 * Начальное состояние переменных
 */
const initialState = {
    isAuthenticated: false, //открыто модальное окно авторизации
    title: '',
    username: ''
};


export const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case IS_AUTHENTICATED:
            return {...state, isAuthenticated: action.value};
        case TITLE:
            return {...state, title: action.value};
        case USERNAME:
            return {...state, username: action.value};
    }

    return state;
};