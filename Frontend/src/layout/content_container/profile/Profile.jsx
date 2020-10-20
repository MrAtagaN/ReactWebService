import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";


/**
 *
 */
class Profile extends Component {

    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Profile');
    }

    render() {
        return (<h1>
            <div>

            </div>
            <div>
                Id: {this.props.appState.userInfo.id};
                <br/>
                Username: {this.props.appState.userInfo.username}
                <br/>
                Email: {this.props.appState.userInfo.email}
                <br/>
                Last enter: {this.props.appState.userInfo.lastEnter}
                <br/>
           {this.props.appState.userInfo.authorities && this.props.appState.userInfo.authorities.some(a => a === 'ADMIN') &&
           <div>you have administrator rights</div>}
           </div>

        </h1>);

    }

}


export default connectToStore(Profile);
