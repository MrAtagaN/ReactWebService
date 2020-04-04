import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import Main from './layout/Main';
import {Provider} from 'react-redux';
import {createStore} from 'redux';
import {rootReducer} from "./store/reducers";
import createBrowserHistory from "history/createBrowserHistory";
import {BrowserRouter} from "react-router-dom";


/**
 * Точка входа, рендерит Main компонент
 */
class App extends Component {

    render() {
        const store = createStore(rootReducer);
        const history = createBrowserHistory();

        return (
            <Provider store={store}>
                <BrowserRouter history={history}>
                    <Main/>
                </BrowserRouter>
            </Provider>

        )
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));

