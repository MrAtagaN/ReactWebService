import React, {Component} from "react";
import {connectToStore} from "../../../store/connect";


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


export default connectToStore()(Home);