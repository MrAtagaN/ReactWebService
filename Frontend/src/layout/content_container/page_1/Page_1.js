import React, {Component} from "react";
import {connectToStore} from "../../../store/connect";


class Page_1 extends Component {

    constructor(props) {
        super(props);
        this.props.changeTitle('Page_1');
    }

    render() {
        return (<h1>
            page 1
        </h1>);

    }
}

export default connectToStore(Page_1);