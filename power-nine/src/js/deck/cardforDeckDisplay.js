import '../../css/UserPage.css';
import React from "react";
import requestFromAPI from "../BackendAPI";
import user_logo from "../../static/user-logo.png";

//individual card being displayed here -- in its on shell
class cardforDeckDisplay extends React.Component {
    //call function to generate individal cards

    render() {
        return (<div classname = "individual-card">
            <p>
                individual image display
            </p>
            <img classname = "card-image" src = {this.props.card.image_uris.small} alt ="Not able to render!"/>
        </div>);
    }
}
export default cardforDeckDisplay;