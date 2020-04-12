import {IS_AUTHENTICATED, TITLE, USERNAME} from "../constants/ActionConstants";

/**
 * Возвращает объект Action. Нужен для изменения переменной isAuthenticated в appState
 */
export const setIsAuthenticated = (newValue) => {
    return {
        type: IS_AUTHENTICATED,
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