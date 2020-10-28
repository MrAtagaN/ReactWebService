import React, {Component} from "react";
import '../product_table/ProductTable.css';
import {connectToStore} from "../../store/Connect";

class BagProductTable extends Component {

    constructor(props) {
        super(props);
    }


    render() {
        let listProducts = this.props.appState.productsInBag.map((product) =>
            <div className='product-information'>
                <div className='product-image'>
                    {product.images.length === 0 && <img src="images/noImage.png"/>}
                    {product.images.length !== 0
                    && product.mainImageNumber != null
                    && <img className='product' src={"data:image/png;base64," + product.images[product.mainImageNumber]}/>}
                </div>
                <div className='product-description'>
                    <div className='product-name'>{product.name}</div>
                    <div className='product-price'>цена {product.price}</div>
                    <div>размер {product.size}</div>

                    <div>
                        <button onClick={() => {this.deleteProductFromBag(product.id)}}>Удалить товар из корзины</button>
                    </div>

                </div>
            </div>
        );

        return (
            <div className={'rightContent'}>
                <div className={'productTableHeader'}>
                </div>
                <div>{listProducts}</div>
            </div>
        );

    }


    deleteProductFromBag = async (id) => {
        let productsInBag = this.props.appState.productsInBag;

        productsInBag = productsInBag.filter(product => product.id !== id);
        this.props.changeAppState.setProductsInBag(productsInBag);

        this.setState({state: this.state});
    }

}


export default connectToStore(BagProductTable);