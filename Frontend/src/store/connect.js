import {bindActionCreators} from 'redux';
import {changeIsOpenAuth, changeTitle} from '../store/actions';
import {connect} from "react-redux";

/**
 * Кладет значения переменных из store в props
 */
export const putStoreFieldsToProps = (store) => {
    return {
        isOpenAuth: store.isOpenAuth,
        title: store.title
    };
};


/**
 * Кладет функции для изменения переменных store в props
 */
export const putActionsToProps = (dispatch) => {
    return {
        changeIsOpenAuth: bindActionCreators(changeIsOpenAuth, dispatch),
        changeTitle: bindActionCreators(changeTitle, dispatch)
    };
};


/**
 * Кладет в props компонента переменные store и функции для изменения переменных store
 */
export const connectToStore = connect(putStoreFieldsToProps, putActionsToProps);