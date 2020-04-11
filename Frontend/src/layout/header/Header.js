import React, {Component} from 'react'
import './Header.css';
import {connectToStore} from "../../store/Connect";
import Button from "../../components/button/Button";
import RestClient from "../../services/RestClient";
import {LOGOUT_URL} from "../../constants/RestConstants";
import Redirect from "react-router-dom/es/Redirect";


/**
 * Заголовок сайта
 */
class Header extends Component {

    state = {
        redirect: false
    };

    render() {
        if (this.state.redirect) {
            this.setState({redirect: false});
            return <Redirect to="/" />;
        }

        return (
            <div className="header">
                <span>
                  {this.props.appState.title}
                </span>
                <span>
                    Welcome to Site!
                </span>
                <Button onClickAction={this.onClickButton}>Logout</Button>
            </div>
        )
    }

    /**
     * Выполняется при разлогине
     */
    onClickButton = () => {
        RestClient.get(LOGOUT_URL);
        this.setState({redirect: true});
    }

}


export default connectToStore(Header);