import {connectToStore} from "../../../store/Connect";
import React, {Component} from "react";

/**
 *
 */
class Accessories extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Accessories');
    }

    render() {
        return (<h1>
            Аксесуары content
        </h1>);

    }
}

export default connectToStore(Accessories);