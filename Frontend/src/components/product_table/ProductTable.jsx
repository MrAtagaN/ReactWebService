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
 */
class ProductTable extends Component {

    constructor(props) {
        super(props);
    }


    render() {
        const listClothes = this.props.products.map((product) =>
            <div>
                {product.name} - {product.price}
            </div>
        );

        //TODO сделать отображение таблицей
        return (
            <div className={'rightContent'}>
                {listClothes}
            </div>
        );

    }
}


export default connectToStore(ProductTable);