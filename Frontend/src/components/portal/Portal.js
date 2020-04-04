import React, { Component } from "react";
import ReactDOM from 'react-dom';

/**
 * Компонент, создающийся вне DOM дерева
 * Нужен для модальных окон
 */
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