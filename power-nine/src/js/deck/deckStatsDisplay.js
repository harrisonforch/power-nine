import '../../css/UserPage.css';
import React from "react";

import requestFromAPI from "../BackendAPI";
import DeckDisplay from "./DeckDisplay";
import UserNavbar from "./UserNavbar";
import user_logo from "../../static/user-logo.png";

//all to be changed -- fix internal code
class deckStatsDisplay extends React.Component {
    

    //functions to make - land, mana_cost, loyalty, 
    //cmc - average cmc
    //break down by color
    //average power
    //average toughness
    //number of lands
    //if it contains land --> then its a land
    average_cmc(){

    }

    render() {
        return <Link to={{
            pathname: "/deck",
            state: {
                deck: this.props.deck
            }
        }}>

            <div className={"card page-link"}>
                {this.props.deck.cards.length > 0 ?
                    <img className={"card-img-top"} src={this.props.deck.cards[0].image_uris.art_crop}  alt="Card in deck" /> :
                    <img alt={"No cards stored!"} />
                }

                <div className={"card-body"}>
                    <h5 className={"card-title deck-card-display"}>{this.props.deck.deckName}</h5>
                    <p className={"card-subtitle deck-card-display"}>
                        Number of cards in deck: {this.props.deck.cards.length}
                    </p>
                </div>
            </div>
        </Link>
    }
}
export default deckStatsDisplay;