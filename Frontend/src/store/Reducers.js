import {IS_AUTHENTICATED, TITLE} from "../constants/ActionConstants";

/**
 * Начальное состояние переменных
 */
const initialState = {
    isAuthenticated: false, //открыто модальное окно авторизации
    title: ''
};


export const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case IS_AUTHENTICATED:
            return {...state, isAuthenticated: action.value};
        case TITLE:
            return {...state, title: action.value};
    }

    return state;
};