import React, { Component } from "react";
import ReactDOM from 'react-dom';


export default class Portal extends Component {

    elem = document.createElement('div');


    componentDidMount() {
        document.body.appendChild(this.elem);
    }


    componentWillUnmount() {
        document.body.removeChild(this.elem);
    }

    render() {
        return ReactDOM.createPortal(this.props.children, this.elem)
    }
}