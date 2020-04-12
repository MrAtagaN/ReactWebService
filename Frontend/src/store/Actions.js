import {IS_AUTHENTICATED, IS_OPEN_AUTH_MODAL, ON_SUCCESS_AUTH, TITLE, USERNAME} from "../constants/ActionConstants";

/**
 * Возвращает объект Action. Нужен для изменения переменной isAuthenticated в appState
 */
export const setIsAuthenticated = (newValue) => {
    return {
        type: IS_AUTHENTICATED,
        value: newValue
    }
};

export const setIsOpenAuthModal = (newValue) => {
    return {
        type: IS_OPEN_AUTH_MODAL,
        value: newValue
    }
};


export const setOnSuccessAuth = (newValue) => {
    return {
        type: ON_SUCCESS_AUTH,
        value: newValue
    }
};

/**
 * Возвращает объект Action. Нужен для изменения переменной title в appState
 */
export const setTitle = (newValue) => {
    return {
        type: TITLE,
        value: newValue
    }
};

/**
 * Возвращает объект Action. Нужен для изменения переменной username в appState
 */
export const setUsername = (newValue) => {
    return {
        type: USERNAME,
        value: newValue
    }
};