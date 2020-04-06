const initialState = {
    isOpenAuthModal: true, //открыто модальное окно авторизации
    title: ''
};


export const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'isOpenAuthModal':
            return {...state, isOpenAuthModal: action.value};
        case 'title':
            return {...state, title: action.value};
    }

    return state;
};