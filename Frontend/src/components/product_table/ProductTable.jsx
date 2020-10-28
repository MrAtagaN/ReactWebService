import React, {Component} from "react";
import {connectToStore} from "../../store/Connect";
import './ProductTable.css';
import RestClient from "../../services/RestClient";
import {DELETE_PRODUCT, OK, PRODUCT_URL} from "../../constants/RestConstants";

/**
 * Таблица отображения продуктов
 *
 * В props нужно передавать:
 * products - массив продуктов.
 *
 * Объект Product имеет параметры:
 *
 * Integer id;
 * String name;
 * String description;
 * String brand;
 * BigDecimal price;
 * Set<Integer> size;
 * Set<String> namedSize;
 * Gender gender;
 * String type;
 * Category category;
 * Age age;
 * Integer productTypeId;
 * String color;
 * Boolean isNew;
 * Boolean isSales;
 * Set<byte[]> images;
 * Integer mainImageNumber;
 */
class ProductTable extends Component {

    constructor(props) {
        super(props);
    }


    render() {

        let MakeSizeItem = function (size, searchParams) {
            if (searchParams.sizeFrom > size || searchParams.sizeTo < size) {
                return null;
            }
            return <option value={size}>{size}</option>;
        };

        let listProducts = this.props.appState.products.map((product) =>
            <div className='product-information'>
                <div className='product-image'>
                    {product.images.length === 0 && <img src="images/noImage.png"/>}
                    {product.images.length !== 0
                     && product.mainImageNumber != null
                     && <img className='product' src={"data:image/png;base64," + product.images[product.mainImageNumber]}/>}
                </div>
                <div className='product-description'>
                    <div className='product-name'>{product.name}</div>
                    <div className='product-price'>{product.price}</div>

                    <button onClick={() => {this.putProductInBag(product)}}>Положить в корзину</button>
                    <div> размер </div>
                    {product.size.length > 1 && <select id={'size' + product.id}>
                        {product.size.map(size =>  MakeSizeItem(size, this.props.appState.searchParams))}
                    </select>}
                    {product.size.length === 1 && product.size}

                    {this.props.appState.userInfo.authorities &&
                    this.props.appState.userInfo.authorities.some(a => a === 'ADMIN') &&
                        <div>
                            <button onClick={() => {this.deleteProduct(product.id)}}>Удалить товар</button>
                            <button onClick={() => {this.updateProduct(product)}}>Редактировать товар</button>
                        </div>
                    }
                </div>
            </div>
        );

        //TODO сделать отображение таблицей
        return (
            <div className={'rightContent'}>
                <div className={'productTableHeader'}>
                        Размер от
                    <form>
                        <input value={this.props.appState.searchParams.sizeFrom} className={'inputStyle'} onChange={event => this.setSizeFromValue(event.target.value)}/>
                    </form>
                            до
                    <form>
                        <input value={this.props.appState.searchParams.sizeTo} className={'inputStyle'} onChange={event => this.setSizeToValue(event.target.value)}/>
                    </form>
                    {this.props.appState.searchParams.name && <div>Поиск по названию '{this.props.appState.searchParams.name}'</div>}
                </div>
                <div>{listProducts}</div>

            </div>
        );

    }

    putProductInBag = async (product) => {
        const size = document.getElementById('size' + product.id).value;

        let selectedProduct = Object.assign({}, product);
        selectedProduct.size = size;

        let productsInBag = this.props.appState.productsInBag;
        productsInBag.push(selectedProduct);
        this.props.changeAppState.setProductsInBag(productsInBag);
    }

    updateProduct = async (product) => {
        this.props.changeAppState.setIsOpenUpdateProductModal(true);
        this.props.changeAppState.setUpdatingProduct(product);
    }

    deleteProduct = async (id) => {
        let params = {'productId': id};
        const response = await RestClient.get(DELETE_PRODUCT, params);

        if (response.code === OK) {
            alert('Товар удалён');
            let products = this.props.appState.products;
            products = products.filter(p => p.id !== id);
            this.props.changeAppState.setProducts(products);
        } else {
            alert('Неизвестная ошибка');
        }
        this.setState({ state: this.state});
    }

    setSizeFromValue = async (value) => {
        let params = this.props.appState.searchParams;
        params = {...params, sizeFrom: value}
        this.props.changeAppState.setSearchParams(params);
        const response = await RestClient.get(PRODUCT_URL + 'search', params);
        this.props.changeAppState.setProducts(response.data)
    }

    setSizeToValue = async (value) => {
        let params = this.props.appState.searchParams;
        params = {...params, sizeTo: value}
        this.props.changeAppState.setSearchParams(params);
        const response = await RestClient.get(PRODUCT_URL + 'search', params);
        this.props.changeAppState.setProducts(response.data)
    }
}


export default connectToStore(ProductTable);
