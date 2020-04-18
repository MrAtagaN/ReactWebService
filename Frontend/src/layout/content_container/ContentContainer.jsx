import React, {Component} from 'react';
import Page_1 from "./сlothes/Clothes";
import Page_2 from "./shoes/Shoes";
import {Route} from "react-router-dom";
import Switch from "react-bootstrap/esm/Switch";
import Home from "./home/Home";
import SecurePage from "./secure_page/SecurePage";
import './ContentContainer.css';

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
                    <Route path='/page1' component={Page_1}/>
                    <Route path='/page2' component={Page_2}/>
                    <Route path='/secure-page' component={SecurePage}/>
                </Switch>
            </div>
        )
    }
}
