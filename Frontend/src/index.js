import React from 'react'
import ReactDOM from 'react-dom'
import Main from './components/Main'

ReactDOM.render(<App/>, document.getElementById('root'));

/**
 * Точка входа
 */
function App() {
    return (
        <div>
            <Main/>
        </div>
    )
}