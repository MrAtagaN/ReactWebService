import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";
import './Clothes.css';
import RestClient from "../../../services/RestClient";
import {OK, PRODUCT_TYPE_URL, USER_URL} from "../../../constants/RestConstants";

/**
 * Одежда
 */
class Clothes extends Component {

    state = {
        clothesTypes: ['desd','sd']
    };



    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Clothes');
    }

    render() {
        const listTypes = this.state.clothesTypes.map((type) =>
            <li className={'clothesTypes'}>{type}</li>
        );

        return (<div>
                    <h1>
                        Одежда
                    </h1>
                    <div className={"filters"}>
                        <ul className={'clothesTypes'}>{listTypes}</ul>
                    </div>
                </div>
        );

    }


    componentDidMount() {
        this.fetchData();
    }

    /**
     * Получение типов одежды
     */
    fetchData = async () => {
        let response = await RestClient.get(PRODUCT_TYPE_URL + 'search', {category: 'clothes'});
        if (response.code === OK) {
            this.setState({...this.state, clothesTypes: response.data});
        }
    };
}

export default connectToStore(Clothes);
