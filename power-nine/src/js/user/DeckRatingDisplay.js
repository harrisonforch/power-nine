import React from "react";
import LoggedInUser from "./LoggedInUser";
import BackendAPI from "../BackendAPI";
import {Link} from "react-router-dom";

class DeckRatingDisplay extends React.Component {
    constructor(props) {
        super(props);
        this.sendRating = this.sendRating.bind(this);
    }

    sendRating(event) {
        let user = LoggedInUser.getUser();
        let deckUser = this.props.deck.userUID;
        let deckName = this.props.deck.deckName;
        let rating = event.target.value;
        BackendAPI("http://localhost:8080/decks/rate/" + deckName + "/" + deckUser + "/" + rating, user.username, user.password, "POST")
            .then(result => {
                alert(result);
            })
            .catch(error => {

            });
    }

    render() {
        let idxOfImage = -1;
        for (let i = 0; i < this.props.deck.cards.length; i++) {
            let card = this.props.deck.cards[i];
            if (card.image_uris !== undefined && card.image_uris.art_crop !== undefined) {
                idxOfImage = i;
                break;
            }
        }
        return <Link to={{
            pathname: "/deck",
            state: {
                deck: this.props.deck
            }
        }}>
            <div className={"card page-link"}>
                {idxOfImage !== -1 ?
                    <img className={"card-img-top"} src={this.props.deck.cards[idxOfImage].image_uris.art_crop}  alt="Card in deck" /> :
                    <img alt={"No cards stored!"} />
                }

                <div className={"card-body"}>
                    <h5 className={"card-title deck-card-display"}>{this.props.deck.deckName}</h5>
                    <p className={"card-subtitle deck-card-display"}>
                        Number of cards in deck: {this.props.deck.cards.length}
                    </p>
                    <select className={"btn dropdown-toggle container"} id={"rating-selector"} onSelect={this.sendRating}>
                        <option value="5">5</option>
                        <option value="4">4</option>
                        <option value="3">3</option>
                        <option value="2">2</option>
                        <option value="1">1</option>
                    </select>
                </div>
            </div>
        </Link>
    }
}
export default DeckRatingDisplay;