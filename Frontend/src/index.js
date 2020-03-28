import React, {Component} from 'react'
import ReactDOM from 'react-dom'
import Main from './components/Main'

/**
 * Точка входа, рендерит Main компонент
 */
class App extends Component {

    render() {
        return (
            <Main/>
        )
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));