import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";

/**
 *
 */
class Clothes extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Clothes');
    }

    render() {
        return (<h1>
            Одежда content
        </h1>);

    }
}

export default connectToStore(Clothes);