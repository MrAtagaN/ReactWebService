import React, {Component} from "react";
import {connect} from 'react-redux';
import {putActionsToProps} from "../../../store/connect";


class Home extends Component {

    constructor(props) {
        super(props);
        this.props.changeTitle('Home');
    }

    render() {
        return (<h1>
            Home
        </h1>);

    }
}



export default connect(putActionsToProps, putActionsToProps)(Home);