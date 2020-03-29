import React, {Component} from 'react'
import './Header.css'

/**
 * Заголовок сайта
 */
export default class Header extends Component {

    constructor(props) {
        super(props);

        this.pageName = "Имя сайта";
        this.title = "Заголовок";
    }


    render() {
        return (
            <div className="header">
                <span>
                  {this.pageName}
                </span>
                <span>
                    Welcome to {this.title}!
                </span>
            </div>
        )
    }

}
