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
                            <Link to="/new-products"><div className={"link"}><img width={45} src="images/newProducts.png"/>Новинки</div></Link>
                        </li>
                        <li>
                            <Link to="/clothes-types"><div className={"link"}><img width={45} src="images/clothes.png"/>Одежда</div></Link>
                        </li>
                        <li>
                            <Link to='/shoes'><div className={"link"}><img  width={50} src="images/shoes.png"/>Обувь</div></Link>
                        </li>
                        <li>
                            <Link to='/accessories'><div className={"link"}><img  width={50} src="images/accessories.png"/>Аксессуары</div></Link>
                        </li>
                        <li>
                            <Link to='/sale'><div className={"link"}><img  width={50} src="images/sale.png"/>Распродажа</div></Link>
                        </li>
                    </ul>
                </ol>
            </div>
        )
    }
}
