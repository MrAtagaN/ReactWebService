import React, { Component } from "react";
import Portal from "./Portal";
import './Modal.css'
import PropTypes from 'prop-types';

/**
 * Модальное окео
 * https://github.com/YauhenKavalchuk/react-components/tree/12_modal
 */
const Modal = ({
                   title, isOpen, onCancel, onSubmit, children,
               }) => {

    return (
        <>
            { isOpen &&
            <Portal>
                <div className="modalOverlay">
                    <div className="modalWindow">
                        <div className="modalHeader">
                            <div className="modalTitle">{title}</div>

                        </div>
                        <div className="modalBody">
                            {children}
                        </div>
                        <div className="modalFooter">
                            <button onClick={onCancel}>Cancel</button>
                            <button onClick={onSubmit}>Submit</button>
                        </div>
                    </div>
                </div>
            </Portal>
            }
        </>
    );
};

Modal.propTypes = {
    title: PropTypes.string,
    isOpen: PropTypes.bool,
    onCancel: PropTypes.func,
    onSubmit: PropTypes.func,
    children: PropTypes.node,
};

Modal.defaultProps = {
    title: 'Modal title',
    isOpen: false,
    onCancel: () => {},
    onSubmit: () => {},
    children: null,
};

export default Modal;