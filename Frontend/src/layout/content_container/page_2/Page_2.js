import React, {Component} from "react";
import {changeTitle} from "../../../store/actions";
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';


class Page_2 extends Component {

    constructor(props) {
        super(props);
        this.props.changeTitle('Page_2');
    }

    render() {
        return (<h1>
            page 2
        </h1>);

    }


}



/**
 * Кладет значение title из store в props данного компонента
 */
const putTitleToProps = (store) => {
    return {
        title: store.title
    };
};

/**
 * Кладет функцию changeTitle в props данного компонента.
 * Функция changeTitle будет отправлять action в dispatch
 */
const putActionsToProps = (dispatch) => {
    return {
        changeTitle: bindActionCreators(changeTitle, dispatch)
    };
};

export default connect(putTitleToProps, putActionsToProps)(Page_2);