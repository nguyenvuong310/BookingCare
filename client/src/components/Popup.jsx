import React from "react";

const Popup = props => {
    return(
        <div className="fixed top-0 flex size-full bg-gray-400">
            <button className="close-btn" onClick={props.handleClose}>close</button>
            {props.content}
        </div>
    );
};


export default Popup