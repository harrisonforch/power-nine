//import '../../css/DeckPage.css';
import React from "react";
import requestFromAPI from "../BackendAPI";
import DeckDisplay from "./DeckDisplay";
import user_logo from "../../static/user-logo.png";
import CompareNavBar from "./CompareNavBar";
import Button from 'react-bootstrap/Button';
//import FormControl from 'react-boostrap/lib/FormControl';
import { InputGroup } from 'react-bootstrap';
import { FormControl } from 'react-bootstrap';
import { Redirect } from 'react-router-dom';


class ComparePage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            noDeck: false,
            //unsure if this is true / needed
            //fix the ternary operator syntax
            deck1: this.props.location.state !== undefined ? this.props.location.state.deck: null,
            deck2: null,
            //deck: null,
            combinedDeck: null,
            isLoaded: false,
            error: null,
        }
        this.returnDefault = this.returnDefault.bind(this);
        //this.returnSame = this.returnSame.bind(this);
        //this.returnDifferent = this.returnDifferent.bind(this);
    }




    componentDidMount() {
        //this.loadFakeDecks();
        //initializing default decks
       // console.log(this.state.deck1);
        
    }

    loadFakeDecks(){
        requestFromAPI("http://localhost:8080/users/login", "admin", "welcome1", "POST",
            {username: "user", password: "password1"})
            .then(data => {
                //return data.decks[0];
                this.setState({
                    isLoaded: true,
                    deck1: data.decks[0],
                    deck2: data.decks[1]

                });
                console.log("DATA RECEIVED")
                this.returnDefault();

            })
            
            .catch(error => {
                this.setState({
                    isLoaded: true,
                    error: error
                })
                console.log("ERROR")
            })
            console.log("DECK 1")
            console.log(this.state.deck1)

    }

    getDecksDiv() {
        return (<div className={"decks-div border rounded"}>
            <div className={"container border-dark"}>
                {this.generateTable()}
            </div>
        </div>);
    }
    returnDefault(){
        //e.preventDefault();
        console.log(this.state)
        var length1 = this.state.deck1.cards.length;
        var length2 = this.state.deck2.cards.length;
        var returnedCards = []
        var cards1 = this.state.deck1.cards
        var cards2 = this.state.deck2.cards
        for (var i = 0; i < length1; i++){
            var inDeck = false
            for (var j = 0; j < returnedCards.length; j++){
                if (cards1[i].name === returnedCards[j].name){
                    inDeck = true
                }
            }
            if (inDeck == false){
                returnedCards.push(cards1[i])
            }
        }
        for (var i = 0; i < length2; i++){
            var inDeck = false
            for (var j = 0; j < returnedCards.length; j++){
                if (cards2[i].name === returnedCards[j].name){
                    inDeck = true
                }
            }
            if (inDeck == false){
                returnedCards.push(cards2[i])
            }
        }
        console.log("TESTING RETURNED CARDS")
        console.log(returnedCards)
        //var returnDeck = this.state.deck1
        //returnDeck.cards = returnedCards
        this.setState({
            combinedDeck: returnedCards,
            isLoaded: true
        });
        console.log("TESTING COMBINED DECK")
        console.log(this.state.combinedDeck)
        // this.state.editedDeck.cards = returnedCards;

    }
    



    render() {
        this.loadFakeDecks();
        if (!this.state.isLoaded)
            return <div />;
        if (this.state.error !== null) {
            return (<div>
                Error when loading <br/>
                {this.state.error}
            </div>);
        }
        var deck = this.state.combinedDeck
        if (this.state.combinedDeck == null){
            deck = this.state.combinedDeck;
        }
        else{
            deck = this.state.deck1
        }
        
        
 
        //deck = {cards: deck}
        
        console.log("TESTING COMBINED DECK")
        console.log(this.state)
        console.log("TESTED COMBINED DECK")
        /*if (deck === null) {
            deck = this.state.deck;
        } else {
            deck = {cards: deck}
        }*/


        return (<div>
            {/*adding a new test comment*/}
            {/*Navbar*/}
            <CompareNavBar />
            <br></br>
            {/*Left-side image and username*/}
                <div className = "flex-container" >

                    <Button variant="outline-dark" onClick = {this.returnDefault}>All</Button>{' '}
                    <Button variant="outline-primary" onClick = {this.returnSame}>Same</Button>{' '}
                    <Button variant="outline-warning" onClick = {this.returnDifferent}>Different</Button>{' '}
                    <br></br>
                    <br></br>
                    <DeckDisplay deck = {deck}/>

                </div>
            <div>
                
            </div>

        </div>);

    }
}


export default ComparePage;
