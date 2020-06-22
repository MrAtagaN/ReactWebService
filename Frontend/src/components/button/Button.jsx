import React, {Component} from 'react';

import './Button.css';

/**
 * В props нужно передавать:
 * onClickAction - функция при нажатии
 * classes - строка с классами кнопками через пробед
 * children - теги в кнопке
 * chosen - boolean, есть ли класс chosen
 */
export default class Button extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (<button
            className={'button' + ' ' + this.props.classes + (this.props.chosen ? ' chosen': '')}
            disabled={this.props.disabled}
            onClick={this.props.onClickAction}
        >
            {this.props.children}
        </button>);
    }

};
