import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";

/**
 *
 */
class NewProducts extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('NewProducts');
    }

    render() {
        return (<h1>
            Новинки
        </h1>);

    }
}


export default connectToStore(NewProducts);