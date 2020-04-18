import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";

/**
 *
 */
class Shoes extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Shoes');
    }

    render() {
        return (<h1>
            Обувь content
        </h1>);

    }

}


export default connectToStore(Shoes);