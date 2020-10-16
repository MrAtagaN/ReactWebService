import React, {Component} from 'react';
import Clothes from "./clothes/Clothes";
import Shoes from "./shoes/Shoes";
import {Route} from "react-router-dom";
import Switch from "react-bootstrap/esm/Switch";
import Home from "./home/Home";
import Profile from "./profile/Profile";
import './ContentContainer.css';
import Accessories from "./accessories/Accessories";
import NewProducts from "./new_products/NewProducts";
import Sale from "./sale/Sale";
import SearchProductTable from "../../components/search_product_table/SearchProductTable";

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
                    <Route path='/new-products' component={NewProducts}/>
                    <Route path='/clothes' component={Clothes}/>
                    <Route path='/shoes' component={Shoes}/>
                    <Route path='/accessories' component={Accessories}/>
                    <Route path='/sale' component={Sale}/>
                    <Route path='/profile' component={Profile}/>
                    <Route path='/product-table' component={SearchProductTable}/>
                </Switch>
            </div>
        )
    }
}
