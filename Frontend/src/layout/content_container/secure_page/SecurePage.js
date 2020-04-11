import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";
import RestClient from "../../../services/RestClient";
import {NOT_AUTHENTICATED, OK} from "../../../constants/RestConstants";
import AuthModal from "../../auth_modal/AuthModal";

/**
 *
 */
class SecurePage extends Component {

    state = {
        data: '',
        isOpenModal: false
    };

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('SecurePage');
    }

    render() {
        return (<h1>
            <AuthModal isOpenModal={this.state.isOpenModal} onSuccessAuth={this.onSuccessAuth} onCancelModal={this.onCancelModal}/>
            <div>
                Secure Content
            </div>
            <div>
                {this.state.data}
            </div>

        </h1>);

    }

    componentDidMount() {
        this.fetchData();
    }


    /**
     * Получение данных с сервера
     */
    fetchData = async () => {
        let response = await RestClient.get('api/v1/user/test-user'); //TODO
        if (response.code === OK) {
            this.setState({...this.state, data: response.data});

        } else if (response.code === NOT_AUTHENTICATED) {
            this.setState({...this.state, isOpenModal: true})
        }
    };

    /**
     * Выполняется при закрытии окна авторизации
     */
    onCancelModal = () => {
        this.setState({...this.state, isOpenModal: false});
    };

    /**
     * Выполняется при успешной авторизации
     */
    onSuccessAuth = () => {
        this.setState({...this.state, isOpenModal: false});
        this.fetchData();
    }

}


export default connectToStore(SecurePage);