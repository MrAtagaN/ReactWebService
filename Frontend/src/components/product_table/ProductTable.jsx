import React, {Component} from "react";
import {connectToStore} from "../../store/Connect";
import './ProductTable.css';

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
 */
class ProductTable extends Component {

    constructor(props) {
        super(props);
    }


    render() {
        const listProducts = this.props.products.map((product) =>
            <div className='product-information'>
                <div className='product-image'>
                    {product.images.length === 0 && <img src="images/noImage.png"/>}
                    {product.images.length !== 0 && <img src={"data:image/png;base64," + product.images[0]}/>}
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
                <div>{listProducts}</div>

            </div>
        );

    }
}


export default connectToStore(ProductTable);
