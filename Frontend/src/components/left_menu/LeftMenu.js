import React, {Component} from 'react'
import './LeftMenu.css'

/**
 * Левое меню
 */
class LeftMenu extends Component {

    render() {
        return (
            <div className="leftMenu">
                <a className="homeLink"> Домой </a>
                <ol>
                    <ul>
                        <li>
                            <a> Страница 1 </a>
                        </li>
                        <li>
                            <a> Страница 2 </a>
                        </li>
                    </ul>
                </ol>
            </div>
        )
    }
}

export default LeftMenu