import React, {Component} from "react";
import Portal from "../portal/Portal";
import Button from "../button/Button";
import {connectToStore} from "../../store/Connect";
import RestClient from "../../services/RestClient";
import {SAVE_PRODUCT} from "../../constants/RestConstants";


class UpdateProductModal extends Component {


    constructor(props) {
        super(props);
    }

    render() {
        return (
            <>
                {this.props.appState.isOpenUpdateProductModal &&
                <Portal>
                    <div className="modalOverlay">
                        <div className="updateProductModalWindow">
                            <div className="modalHeader">
                            </div>

                            <div className={'productProperty'}>
                                Название
                                <input value={this.props.appState.updatingProduct.name}  onChange={event => this.handleChangeName(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Цена
                                <input value={this.props.appState.updatingProduct.price}  onChange={event => this.handleChangePrice(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Описание
                                <input value={this.props.appState.updatingProduct.description} onChange={event => this.handleChangeDescription(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Бренд
                                <input value={this.props.appState.updatingProduct.brand} onChange={event => this.handleChangeBrand(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Размеры
                                <input value={this.props.appState.updatingProduct.size} onChange={event => this.handleChangeSize(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Именованые размеры
                                <input value={this.props.appState.updatingProduct.namedSize} onChange={event => this.handleChangeNamedSize(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Пол (male/female)
                                <input value={this.props.appState.updatingProduct.gender} onChange={event => this.handleChangeGender(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Тип
                                <input value={this.props.appState.updatingProduct.type} onChange={event => this.handleChangeType(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Катеория
                                <input value={this.props.appState.updatingProduct.category} onChange={event => this.handleChangeCategory(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Возраст
                                <input value={this.props.appState.updatingProduct.age} onChange={event => this.handleChangeAge(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Цвет
                                <input value={this.props.appState.updatingProduct.color} onChange={event => this.handleChangeColor(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Новая
                                <input value={this.props.appState.updatingProduct.isNew} onChange={event => this.handleChangeIsNew(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Распродажа
                                <input value={this.props.appState.updatingProduct.isSales} onChange={event => this.handleChangeIsSales(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Изображение
                                <input value={this.props.appState.updatingProduct.images} onChange={event => this.handleChangeImages(event)}/>
                            </div>

                            <div className={'productProperty'}>
                                Главная картинка
                                <input value={this.props.appState.updatingProduct.mainImageNumber} onChange={event => this.handleChangeMainImageNumber(event)}/>
                            </div>

                            <div className="modalFooter">
                                <Button onClickAction={this.cancelUpdateProduct}>Cancel</Button>
                                <Button onClickAction={this.saveProduct}>Save</Button>
                            </div>
                        </div>

                    </div>
                </Portal>
                }
            </>
        );
    };

    cancelUpdateProduct = async () => {
        this.props.changeAppState.setIsOpenUpdateProductModal(false);
        this.props.changeAppState.setUpdatingProduct({});
    }

    saveProduct = async () => {

        let product =
            {
                id: this.props.appState.updatingProduct.id,
                name: this.props.appState.updatingProduct.name,
                price: this.props.appState.updatingProduct.price,
                description: this.props.appState.updatingProduct.description,
                brand: this.props.appState.updatingProduct.brand,
                size: this.props.appState.updatingProduct.size,
                namedSize: this.props.appState.updatingProduct.namedSize,
                gender: this.props.appState.updatingProduct.gender,
                type: this.props.appState.updatingProduct.type,
                category: this.props.appState.updatingProduct.category,
                age: this.props.appState.updatingProduct.age,
                color: this.props.appState.updatingProduct.color,
                isNew: this.props.appState.updatingProduct.isNew,
                isSales: this.props.appState.updatingProduct.isSales,
                images: this.props.appState.updatingProduct.images,
                mainImageNumber: this.props.appState.updatingProduct.mainImageNumber
            };

        const response = RestClient.sendForm(SAVE_PRODUCT, product);

    }

    handleChangeName = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, name: event.target.value});
    }

    handleChangePrice = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, price: event.target.value});
    }

    handleChangeDescription = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, description: event.target.value});
    }

    handleChangeBrand = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, brand: event.target.value});
    }

    handleChangeSize = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, size: event.target.value});
    }

    handleChangeNamedSize = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, namedSize: event.target.value});
    }

    handleChangeGender = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, gender: event.target.value});
    }

    handleChangeType = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, type: event.target.value});
    }

    handleChangeCategory = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, category: event.target.value});
    }

    handleChangeAge = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, age: event.target.value});
    }

    handleChangeColor = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, color: event.target.value});
    }

    handleChangeIsNew = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, isNew: event.target.value});
    }

    handleChangeIsSales = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, isSales: event.target.value});
    }

    handleChangeImages = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, images: event.target.value});
    }

    handleChangeMainImageNumber = (event) => {
        this.props.changeAppState.setUpdatingProduct({...this.props.appState.updatingProduct, mainImageNumber: event.target.value});
    }
}

export default connectToStore(UpdateProductModal);