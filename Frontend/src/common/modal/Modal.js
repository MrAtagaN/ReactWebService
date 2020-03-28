import React, { Component } from "react";
import Portal from "./Portal";
import './Modal.css'

/**
 * https://github.com/YauhenKavalchuk/react-components/tree/12_modal
 */
export default class Modal extends Component {

    constructor(props) {
        super(props);

        this.title = props.title;
        this.isOpen = props.isOpen;
        this.onCancel = props.onCancel;
        this.onSubmit = props.onSubmit;
        this.children = props.children;
    }


    render() {
        return (
            <>
                {this.isOpen &&
                <Portal>
                    <div className="modalOverlay">
                        <div className="modalWindow">
                            <div className="modalHeader">
                                <div className="modalTitle">{this.title}</div>

                            </div>
                            <div className="modalBody">
                                {this.children}
                            </div>
                            <div className="modalFooter">
                                <button onClick={this.onCancel}>Cancel</button>
                                <button onClick={this.onSubmit}>Submit</button>
                            </div>
                        </div>
                    </div>
                </Portal>
                }
            </>
        );
    }
}