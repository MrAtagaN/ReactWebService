import React from 'react'

export default LeftMenu

/**
 * Левое меню
 */
function LeftMenu() {
    return (
        <div className="leftMenu">
            <a className="homeLink"> Домой </a>
            <ol>
                <ul>
                    <li>
                        <a> Страница 1 </a>
                    </li>
                    <li>
                        <a> Страница 2 </a>
                    </li>
                </ul>
            </ol>

        </div>
    )
}