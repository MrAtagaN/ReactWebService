import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";
import './Clothes.css';

/**
 *
 */
class Clothes extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Clothes');
    }

    render() {
        return (<div>
                    <h1>
                        Одежда
                    </h1>
                    <div className={"filters"}>
                        фильтры
                    </div>
                </div>
        );

    }
}

export default connectToStore(Clothes);