import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";

/**
 *
 */
class Sale extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Sale');
    }

    render() {
        return (<h1>
            Распродажа
        </h1>);

    }
}


export default connectToStore(Sale);