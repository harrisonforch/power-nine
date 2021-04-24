import React from "react";
import {Link} from "react-router-dom";
import '../../css/DeckPage.css';
import requestFromAPI from "../BackendAPI";
//import DeckDisplay from "./DeckDisplay";
import UserNavbar from "./DeckNavbar";
import user_logo from "../../static/user-logo.png";
import cardforDeckDisplay from "./cardforDeckDisplay";

class DeckDisplay extends React.Component {
    //call function to generate individal cards


    componentDidMount(){
        //add calculations functions here
    }
    generateCardTables(){

        const tableRows = [];
        var cards = this.props.deck.cards
        for (let i = 0; i < cards.length; i += 8) {
            //var current = cards[i]
            tableRows.push(
                <div className={"row"}>
                    <p>
                        i
                    </p>
                    {this.props.deck.cards.slice(i, i + 8).map(current =>
                        <div className={"col-8"}>
                            <cardforDeckDisplay card={current} />
                        </div>
                    )}
                </div>
            )
            tableRows.push(<br />)
        }
        return tableRows;

    }

    totalCardTable(){
        return (<div>
            <div>
                {this.generateCardTables()}
            </div>
        </div>);
    }
    render() {
        return (<div>
            <p>
                {this.props.deck.deckName}
            </p>
            <div>
                {this.totalCardTable()}
            </div>
        </div>);
    }
}
export default DeckDisplay;