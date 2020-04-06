import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";
import instance from "../../../services/RestClient";


class SecurePage extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.changeTitle('SecurePage');
    }

    render() {
        return (<h1>
            Secure Content
        </h1>);

    }

}


export default connectToStore(SecurePage);