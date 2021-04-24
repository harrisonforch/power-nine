import '../../css/DeckPage.css';
import React from "react";
import requestFromAPI from "../BackendAPI";
import user_logo from "../../static/user-logo.png";


//individual card being displayed here -- in its on shell
class CardforDeckDisplay extends React.Component {
    //call function to generate individal cards

    render() {
        console.log(this.props)
        return (<div classname = "card individual-card card-link">
            <p>
                {this.props.card.id}
            </p>
            <img classname = "card-image" src = {this.props.card.image_uris.small} alt ="Not able to render!"/>
        </div>);
    }
}
export default CardforDeckDisplay;