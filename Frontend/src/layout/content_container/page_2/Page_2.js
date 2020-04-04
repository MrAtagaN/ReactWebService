import React, {Component} from "react";
import {connect} from 'react-redux';
import {putActionsToProps} from "../../../store/connect";


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


 export default connect(putActionsToProps, putActionsToProps)(Page_2);