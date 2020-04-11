import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";



class SecurePage extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('SecurePage');
    }

    render() {
        return (<h1>
            Secure Content
        </h1>);

    }

}


export default connectToStore(SecurePage);