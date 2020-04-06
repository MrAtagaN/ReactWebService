import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";


class Home extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.changeTitle('Home');
    }

    render() {
        return (<h1>
            Home
        </h1>);

    }
}


export default connectToStore(Home);