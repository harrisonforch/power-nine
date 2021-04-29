import '../../css/UserPage.css';
import React from "react";

import requestFromAPI from "../BackendAPI";
import DeckDisplay from "./DeckDisplay";
import user_logo from "../../static/user-logo.png";
import Badge from 'react-bootstrap/Badge';


//all to be changed -- fix internal code
class DeckStatsDisplay extends React.Component {

    constructor(props){
        super(props);
        this.deck = this.props.deck;
        console.log(this.deck);
        this.cards = this.deck.cards;
        this.aCMC = "";
        this.CB = 0;
        this.aPower = 0;
        this.aToughness = 0;

        this.aCMC = this.average_cmc();
        this.aPower = this.average_power();
        this.aToughness = this.average_toughness();

    }
    average_power(){
        var averagepower = 0;
        var count = 0;
        
        for (let i = 0; i < this.cards.length; i++){
           
            if (this.cards[i].power != null){
                averagepower += parseInt(this.cards[i].power)
                count++;
            }
            
        }
        averagepower = averagepower / count;
        //console.log(averageCMC);
        return String(averagepower);

    }
   
    average_cmc(){
        var averageCMC = 0;
        for (let i = 0; i < this.cards.length; i++){
            averageCMC += this.cards[i].cmc
        }
        averageCMC = averageCMC / this.cards.length;
        return String(averageCMC);

    }
    componentDidMount(){
        
    }

    //functions to make - land, mana_cost, loyalty, 
    //cmc - average cmc
    //break down by color
    //average power
    //average toughness
    //number of lands
    //if it contains land --> then its a land
    
    /*
    color_breakdown(){

    }*/

   
    average_toughness(){
        var averagetoughness = 0;
        var count = 0;
        
        for (let i = 0; i < this.cards.length; i++){
            console.log("TESTING POWER")
            console.log(this.cards[i].toughness)
            if (this.cards[i].power != null){
                averagetoughness += parseInt(this.cards[i].toughness)
                count++;
            }
            
        }
        averagetoughness = averagetoughness / count;
        //console.log(averageCMC);
        return String(averagetoughness);

    }

    render() {
        return (<div classname = "deckstats container row">
            <h1>
                {this.props.deck.deckName}
            </h1>
            <h2>
                Statistics:
            </h2>
            <Badge classname = " mana-badge " color = "danger" variant = "danger"> Average Mana Cost: {this.aCMC}
            </Badge>{' '}
            <br></br>
            <Badge classname = " mana-badge " color = "dangprimer" variant= "danger">Average Power: {this.aPower}
            </Badge>{' '}
            <br></br>
            <Badge classname = " mana-badge " color = "dangprimer" variant= "danger">Average Toughness: {this.aToughness}
            </Badge>{' '}
        </div>);
    }
}
export default DeckStatsDisplay;