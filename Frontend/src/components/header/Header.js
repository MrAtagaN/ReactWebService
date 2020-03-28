import React from 'react'

export default Header

/**
 * Заголовок сайта сайта
 */
function Header() {
    const pageName = "Имя сайта";
    const title = "Заголовок";
    return (
        <div className="header">
            <span>
                {pageName}
            </span>
            <span>
                Welcome to {title}!
            </span>
        </div>
    )
}