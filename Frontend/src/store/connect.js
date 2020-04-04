import {bindActionCreators} from 'redux';
import {changeIsOpenAuth, changeTitle} from '../store/actions';
import {connect} from "react-redux";

/**
 * Кладет значения из store в props данного компонента
 */
export const putStoreFieldsToProps = (store) => {
    return {
        isOpenAuth: store.isOpenAuth,
        title: store.title
    };
};


/**
 * Кладет функции на изменения переменных в props данного компонента.
 */
export const putActionsToProps = (dispatch) => {
    return {
        changeIsOpenAuth: bindActionCreators(changeIsOpenAuth, dispatch),
        changeTitle: bindActionCreators(changeTitle, dispatch)
    };
};


export const connectToStore = () => {
    return connect(putStoreFieldsToProps, putActionsToProps);
};