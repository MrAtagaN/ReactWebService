export const changeIsOpenAuthModal = (newValue) => {
    return {
        type: 'isOpenAuthModal',
        value: newValue
    }
};

export const changeTitle = (newValue) => {
    return {
        type: 'title',
        value: newValue
    }
};