import React, {Component} from "react";
import Portal from "../portal/Portal";
import './Modal.css'

/**
 * Модальное окно
 *
 * https://github.com/YauhenKavalchuk/react-components/tree/12_modal
 */
export default class Modal extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <>
                {this.props.isOpenModal &&
                <Portal>
                    <div className="modalOverlay">
                        <div className="modalWindow">
                            <div className="modalHeader">
                                <div className="modalTitle">{this.props.titleModal}</div>

                            </div>
                            <div className="modalBody">
                                {this.props.children}
                            </div>
                            <div className="modalFooter">
                                <button onClick={this.props.onCancelModal}>Cancel</button>
                                <button onClick={this.props.onSubmitModal}>Submit</button>
                            </div>
                        </div>
                    </div>
                </Portal>
                }
            </>
        );
    };
}


