const initialState = {
    isOpenAuthModal: true, //открыто модальное окно авторизации
    title: ''
};

export const rootReducer = (store = initialState, action) => {
    switch (action.type) {
        case 'isOpenAuthModal':
            return {...store, isOpenAuthModal: action.value};
        case 'title':
            return {...store, title: action.value};
    }

    return store;
};