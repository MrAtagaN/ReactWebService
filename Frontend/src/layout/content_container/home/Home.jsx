import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";

/**
 *
 */
class Home extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Home');
    }

    render() {
        return (<h1>
            Home page content
        </h1>);

    }
}


export default connectToStore(Home);