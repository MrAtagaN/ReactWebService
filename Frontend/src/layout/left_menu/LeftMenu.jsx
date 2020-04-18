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
                <ol>
                    <ul>
                        <li>
                            <Link to="/page1"><div className={"link"}><img width={45} src="images/clothes.png"/>Одежда</div></Link>
                        </li>
                        <li>
                            <Link to='/page2'><div className={"link"}><img  width={50} src="images/shoes.png"/>Обувь</div></Link>
                        </li>
                        <li>
                            <Link to='/secure-page'>Приватная страница</Link>
                        </li>
                    </ul>
                </ol>
            </div>
        )
    }
}
