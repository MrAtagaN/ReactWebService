import React, {Component} from 'react'
import ContentContainer from "./content_container/ContentContainer";
import LeftMenu from "./left_menu/LeftMenu";
import Header from "./header/Header";
import './Main.css'
import AuthModal from "./authModal/AuthModal";

/**
 * Главный компонент (весь сайт)
 */
export default class Main extends Component {
    state = {
        isOpenAuth: true
    };

    constructor(props) {
        super(props);
    }


    handleSubmitAuth = () => {
        console.log('Submit function!');
        this.setState({ isOpenAuth: false });
    };

    handleCancelAuth = () => {
        console.log('Cancel function!');
        this.setState({ isOpenAuth: false });
    };

    render() {
        return (
            <div>
                <AuthModal state ={this.state} onCancel={this.handleCancelAuth} onSubmit={this.handleSubmitAuth}/>
                <Header/>
                <LeftMenu/>
                <ContentContainer/>
            </div>
        )
    }

}
