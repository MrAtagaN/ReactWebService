import React, {Component} from 'react'
import './Header.css';
import {connect} from "react-redux";


/**
 * Заголовок сайта
 */
class Header extends Component {


    render() {
        return (
            <div className="header">
                <span>
                  {this.props.title}
                </span>
                <span>
                    Welcome to Site!
                </span>
            </div>
        )
    }

}



/**
 * Кладет значение title из store в props данного компонента
 */
const putPageNameToProps = (store) => {
    return {
        title: store.title
    };
};


export default connect(putPageNameToProps)(Header);