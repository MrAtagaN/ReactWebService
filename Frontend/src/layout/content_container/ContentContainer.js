import React, {Component} from 'react'
import Page_1 from "./page_1/Page_1";
import Page_2 from "./page_2/Page_2";
import Route from "react-router-dom/es/Route";
import Switch from "react-bootstrap/esm/Switch";
import Home from "./home/Home";

/**
 * Контейнер с контентом сайта
 */
export default class ContentContainer extends Component {

    render() {
        return (
            <div>
                <Switch>
                    <Route exact path='/' component={Home}/>
                    <Route path='/page1' component={Page_1}/>
                    <Route path='/page2' component={Page_2}/>
                </Switch>
            </div>
        )
    }
}
