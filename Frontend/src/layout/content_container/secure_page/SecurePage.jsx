import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";
import RestClient from "../../../services/RestClient";
import {NOT_AUTHENTICATED, OK, USER_URL} from "../../../constants/RestConstants";


/**
 *
 */
class SecurePage extends Component {

    state = {
        data: ''
    };

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('SecurePage');
    }

    render() {
        return (<h1>
            <div>

            </div>
            <div>
                Your id: {this.state.data.id}
                <br/>
                Your username: {this.state.data.username}
                <br/>
            </div>

        </h1>);

    }

    componentDidMount() {
        this.props.changeAppState.setOnSuccessAuth(this.fetchData);
        this.fetchData();
    }


    /**
     * Получение данных с сервера
     */
    fetchData = async () => {
        const response = await RestClient.get(USER_URL + 'info');
        if (response.code === OK) {
            this.setState({...this.state, data: response.data});

        } else if (response.code === NOT_AUTHENTICATED) {
            this.props.changeAppState.setIsOpenAuthModal(true);
            this.props.changeAppState.setIsAuthenticated(false);
        }
    };


}


export default connectToStore(SecurePage);