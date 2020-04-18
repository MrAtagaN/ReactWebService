import {
    CHOSEN_GENDER,
    IS_AUTHENTICATED,
    IS_OPEN_AUTH_MODAL,
    ON_SUCCESS_AUTH,
    TITLE,
    USER_INFO
} from "../constants/ActionConstants";

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

export const setTitle = (newValue) => {
    return {
        type: TITLE,
        value: newValue
    }
};

export const setUserInfo = (newValue) => {
    return {
        type: USER_INFO,
        value: newValue
    }
};

export const setChosenGender = (newValue) => {
    return {
        type: CHOSEN_GENDER,
        value: newValue
    }
};