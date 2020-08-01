import React, {Component} from "react";
import {connectToStore} from "../../../store/Connect";
import './Clothes.css';
import RestClient from "../../../services/RestClient";
import {OK, PRODUCT_TYPE_URL, PRODUCT_URL, USER_URL} from "../../../constants/RestConstants";
import {BOY, FEMALE, GIRL, MALE} from "../../../constants/AppConstants";
import Button from "../../../components/button/Button";
import ProductTable from "../../../components/product_table/ProductTable";

/**
 * Одежда
 */
class Clothes extends Component {

    state = {
        clothesTypes: [],
        clothes: []
    };


    constructor(props) {
        super(props);
        this.props.changeAppState.setTitle('Clothes'); //TODO не используется
        this.props.changeAppState.setOnChosenGender(this.fetchClothesTypes);
    }


    render() {
        //множество тегов li с кнопкой
        const listTypes = this.state.clothesTypes.map((clothesTypes) =>
            <li key={clothesTypes.name} className={'clothesTypes'}>
                <Button classes={'type'} onClickAction={() => this.fetchClothesByType(clothesTypes.name)}>{clothesTypes.name} </Button>
            </li>
        );

        return (
            <div>
                <div className={'leftContent'}>
                    <h1>
                        Одежда
                    </h1>
                    <div className={"filters"}>
                        <ul className={'clothesTypes'}>{listTypes}</ul>
                    </div>
                </div>
                <ProductTable products={this.state.clothes}/>
            </div>
        );
    }


    componentDidMount() {
        this.fetchClothesTypes();
    }


    /**
     * Получение одежды с сервера по типу
     */
    fetchClothesByType = async (name) => {
        if (name !== null) {
            const params = {type: name};
            const response = await RestClient.get(PRODUCT_URL + 'search', params);
            if (response.code === OK) {
                this.setState({...this.state, clothes: response.data});
            }
        }
    };


    /**
     * Получение типов одежды с сервера
     */
    fetchClothesTypes = async () => {
        let params;

        const gender = this.props.appState.chosenGender;
        if (gender === FEMALE) {
            params = {category: 'clothes', age:'adult', gender: 'female'}
        }
        if (gender === MALE) {
            params = {category: 'clothes', age:'adult', gender: 'male'}
        }
        if (gender === GIRL) {
            params = {category: 'clothes', age:'kids', gender: 'female'}
        }
        if (gender === BOY) {
            params = {category: 'clothes', age:'kids', gender: 'male'}
        }

        const response = await RestClient.get(PRODUCT_TYPE_URL + 'search', params);
        if (response.code === OK) {
            this.setState({...this.state, clothesTypes: response.data});
        }
    };
}

export default connectToStore(Clothes);
