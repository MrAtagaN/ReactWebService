const initialState = {
    isOpenAuth: true
};

export const rootReducer = (state = initialState, action) => {

    switch (action.type) {
        case 'isOpenAuth':
            console.log(action.value);
            return {...state, isOpenAuth: action.value};
    }

    return state;
};