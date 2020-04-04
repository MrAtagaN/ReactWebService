const initialState = {
    isOpenAuth: true, //открыто модальное окно авторизации
    title: ''
};

export const rootReducer = (store = initialState, action) => {
    switch (action.type) {
        case 'isOpenAuth':
            return {...store, isOpenAuth: action.value};
        case 'title':
            return {...store, title: action.value};
    }

    return store;
};