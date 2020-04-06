import React, {Component} from 'react'
import './Header.css';
import {connectToStore} from "../../store/Connect";


/**
 * Заголовок сайта
 */
class Header extends Component {

    render() {
        return (
            <div className="header">
                <span>
                  {this.props.appState.title}
                </span>
                <span>
                    Welcome to Site!
                </span>
            </div>
        )
    }

}


export default connectToStore(Header);