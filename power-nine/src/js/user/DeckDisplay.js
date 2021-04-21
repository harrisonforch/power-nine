import React from "react";
import {Link} from "react-router-dom";

class DeckDisplay extends React.Component {
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
export default DeckDisplay;