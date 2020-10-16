import React, {Component} from "react";
import {connectToStore} from "../../store/Connect";
import './SearchProductTable.css';

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
class SearchProductTable extends Component {

    state = {
        sizeFrom: 0,
        sizeTo: 999
    };

    constructor(props) {
        super(props);
    }


    render() {
        let listProducts = this.props.appState.products.map((product) =>  this.sizeFilter(product) &&
            <div className='product-information'>
                <div className='product-image'>
                    {product.images.length === 0 && <img src="images/noImage.png"/>}
                    {product.images.length !== 0
                    && product.mainImageNumber != null
                    &&
                    <img className='product' src={"data:image/png;base64," + product.images[product.mainImageNumber]}/>}
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
                <div>
                        Размер от
                    <form>
                        <input style={{width: '30px'}} onChange={event => this.setSizeFromValue(event.target.value)}/>
                    </form>
                            до
                    <form>
                        <input style={{width: '30px'}} onChange={event => this.setSizeToValue(event.target.value)}/>
                    </form>
                </div>
                <div>{listProducts}</div>

            </div>
        );

    }

    sizeFilter = (product) => {
        return product.size.some(size => size >= this.state.sizeFrom) && product.size.some(size => size <= this.state.sizeTo)
    }

    setSizeFromValue = async (value) => {
        this.setState({ ...this.state, sizeFrom: value});
    }

    setSizeToValue = async (value) => {
        this.setState({ ...this.state, sizeTo: value});
    }
}


export default connectToStore(SearchProductTable);
