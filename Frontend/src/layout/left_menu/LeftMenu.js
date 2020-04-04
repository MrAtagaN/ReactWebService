import React, {Component} from 'react'
import './LeftMenu.css'
import {Link} from 'react-router-dom';

/**
 * Левое меню
 */
export default class LeftMenu extends Component {

    render() {
        return (
            <div className="leftMenu">
                <Link to="/" className="homeLink"> Домой </Link>
                <ol>
                    <ul>
                        <li>
                            <Link to="/page1"> Страница 1 </Link>
                        </li>
                        <li>
                            <Link to='/page2'> Страница 2 </Link>
                        </li>
                    </ul>
                </ol>
            </div>
        )
    }
}
