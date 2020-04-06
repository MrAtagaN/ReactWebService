import React, {Component} from 'react';
import './Input.css';


export default class Input extends Component {

    constructor(props) {
        super(props);
        this.id = props.id;
        this.label = props.label;
        this.classes = props.classes;
        this.error = props.error;
    }

    render() {
        return (
            <div className="inputWrapper">
                <div className="labelsWrapper">
                    {this.label
                    && <label className="inputLabel" htmlFor={this.id}>{this.label}</label>
                    }
                </div>
                <input
                    name={this.id}
                    id={this.id}
                    className={this.classes}
                />
                {this.error
                && <span className="inputError">{this.error}</span>
                }
            </div>
        );
    }
};


