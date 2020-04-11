import {IS_OPEN_AUTH_MODAL, TITLE} from "../constants/ActionConstants";

/**
 * Возвращает объект Action. Нужен для изменения переменной isOpenAuthModal в appState
 */
export const setIsOpenAuthModal = (newValue) => {
    return {
        type: IS_OPEN_AUTH_MODAL,
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