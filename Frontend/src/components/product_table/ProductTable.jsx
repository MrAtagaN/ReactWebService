import React, {Component} from "react";
import {connectToStore} from "../../store/Connect";
import './ProductTable.css';
import RestClient from "../../services/RestClient";
import {PRODUCT_URL} from "../../constants/RestConstants";

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
 * String subType;
 * String brand;
 * BigDecimal price;
 * Set<Integer> size;
 * Set<String> namedSize;
 * Gender gender;
 * String type;
 * Category category;
 * Age age;
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

    setSizeFromValue = async (value) => {
        let params = this.props.appState.searchParams;
        params = {...params, sizeFrom: value}
        this.props.changeAppState.setSearchParams(params);
        const response = await RestClient.get(PRODUCT_URL + 'search', params);
        this.props.changeAppState.setProducts(response.data)
        this.setState({ state: this.state});
    }

    setSizeToValue = async (value) => {
        let params = this.props.appState.searchParams;
        params = {...params, sizeTo: value}
        this.props.changeAppState.setSearchParams(params);
        const response = await RestClient.get(PRODUCT_URL + 'search', params);
        this.props.changeAppState.setProducts(response.data)
        this.setState({ state: this.state});
    }
}


export default connectToStore(ProductTable);
