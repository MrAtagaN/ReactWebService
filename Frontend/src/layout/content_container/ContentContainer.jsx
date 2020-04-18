import React, {Component} from 'react';
import Clothes from "./сlothes/Clothes";
import Shoes from "./shoes/Shoes";
import {Route} from "react-router-dom";
import Switch from "react-bootstrap/esm/Switch";
import Home from "./home/Home";
import SecurePage from "./secure_page/SecurePage";
import './ContentContainer.css';
import Accessories from "./accessories/Accessories";

/**
 * Контейнер с контентом сайта.
 * Содержимое переключается в зависимости от выбранной ссылки в компоненте LeftMenu
 */
export default class ContentContainer extends Component {

    render() {
        return (
            <div className={"contentContainer"}>
                <Switch>
                    <Route exact path='/' component={Home}/>
                    <Route path='/clothes' component={Clothes}/>
                    <Route path='/shoes' component={Shoes}/>
                    <Route path='/accessories' component={Accessories}/>
                    <Route path='/secure-page' component={SecurePage}/>
                </Switch>
            </div>
        )
    }
}
