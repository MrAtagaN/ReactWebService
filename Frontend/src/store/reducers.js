const initialState = {
    isOpenAuth: true //открыто модальное окно авторизации
};

export const rootReducer = (store = initialState, action) => {
    switch (action.type) {
        case 'isOpenAuth':
            return {...store, isOpenAuth: action.value};
    }

    return store;
};