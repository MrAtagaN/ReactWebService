import React, {Component} from 'react'
import ReactDOM from 'react-dom'
import Main from './layout/Main'
import {BrowserRouter} from 'react-router-dom';
import createBrowserHistory from 'history/createBrowserHistory'



/**
 * Точка входа, рендерит Main компонент
 */
class App extends Component {

    constructor(props) {
        super(props);
        this.history = createBrowserHistory();
    }

    render() {
        return (
            <BrowserRouter history={this.history}>
                <Main/>
            </BrowserRouter>
        )
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));