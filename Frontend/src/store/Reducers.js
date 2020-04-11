import {IS_OPEN_AUTH_MODAL, TITLE} from "../constants/ActionConstants";

/**
 * Начальное состояние переменных
 */
const initialState = {
    isOpenAuthModal: true, //открыто модальное окно авторизации
    title: ''
};


export const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case IS_OPEN_AUTH_MODAL:
            return {...state, isOpenAuthModal: action.value};
        case TITLE:
            return {...state, title: action.value};
    }

    return state;
};