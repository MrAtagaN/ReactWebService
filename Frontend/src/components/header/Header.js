import React, {Component} from 'react'

/**
 * Заголовок сайта сайта
 */
class Header extends Component {

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

export default Header