import React, {Component} from "react";
import Portal from "./Portal";
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
                {this.props.isOpen &&
                <Portal>
                    <div className="modalOverlay">
                        <div className="modalWindow">
                            <div className="modalHeader">
                                <div className="modalTitle">{this.props.title}</div>

                            </div>
                            <div className="modalBody">
                                {this.props.children}
                            </div>
                            <div className="modalFooter">
                                <button onClick={this.props.onCancel}>Cancel</button>
                                <button onClick={this.props.onSubmit}>Submit</button>
                            </div>
                        </div>
                    </div>
                </Portal>
                }
            </>
        );
    };
}


