import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";

/**
 *
 */
class Page_2 extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Page_2');
    }

    render() {
        return (<h1>
            page 2 content
        </h1>);

    }

}


export default connectToStore(Page_2);