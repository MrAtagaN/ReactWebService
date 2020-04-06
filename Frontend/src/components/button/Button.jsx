import React, {Component} from 'react';

import './Button.css';


export default class Button extends Component {

    constructor(props) {
        super(props);
        this.classes = props.classes;
        this.disabled = props.disabled;
        this.onClickAction = props.onClickAction;
        this.children = props.children;
    }

    render() {
        return (<button
            className={this.classes}
            disabled={this.disabled}
            onClick={this.onClickAction}
        >
            {this.children}
        </button>)
    }

};