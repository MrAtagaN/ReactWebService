import {
    CHOSEN_GENDER,
    IS_AUTHENTICATED,
    IS_OPEN_AUTH_MODAL, IS_OPEN_REGISTRATION_MODAL, ON_CHOSEN_GENDER,
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

export const setIsOpenRegistrationModal = (newValue) => {
    return {
        type: IS_OPEN_REGISTRATION_MODAL,
        value: newValue
    }
}

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

/**
 * выбранный пол
 */
export const setChosenGender = (newValue) => {
    return {
        type: CHOSEN_GENDER,
        value: newValue
    }
};

/**
 * действие выполняемое при выборе пола
 */
export const setOnChosenGender = (newValue) => {
    return {
        type: ON_CHOSEN_GENDER,
        value: newValue
    }
};