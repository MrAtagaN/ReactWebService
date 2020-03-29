import React, {Component} from 'react'
import ContentContainer from "./content_container/ContentContainer";
import LeftMenu from "./left_menu/LeftMenu";
import Header from "./header/Header";
import './Main.css'
import Modal from "../components/modal/Modal";

/**
 * Главный компонент (весь сайт)
 */
export default class Main extends Component {
    state = {
        isOpen: true,
    };

    constructor(props) {
        super(props);
    }


    handleSubmit = () => {
        console.log('Submit function!');
        this.setState({ isOpen: false });
    };

    handleCancel = () => {
        console.log('Cancel function!');
        this.setState({ isOpen: false });
    };

    render() {
        return (
            <div>
                <Modal
                    title="Test Dialog window"
                    isOpen={this.state.isOpen}
                    onCancel={this.handleCancel}
                    onSubmit={this.handleSubmit}
                >
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                        the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley
                        of type and scrambled it to make a</p>
                </Modal>
                <Header/>
                <LeftMenu/>
                <ContentContainer/>
            </div>
        )
    }

}
