import '../../css/DeckPage.css';
import React from "react";
import requestFromAPI from "../BackendAPI";
import DeckDisplay from "./DeckDisplay";
import user_logo from "../../static/user-logo.png";
import DeckNavbar from "./DeckNavbar";
import DeckStatsDisplay from "./deckStatsDisplay";
import Button from 'react-bootstrap/Button';


class DeckPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            noDeck: false,
            //unsure if this is true / needed
            //fix the ternary operator syntax
            deck: this.props.location.state !== undefined ? this.props.location.state.deck: null,
            //deck: null,
            editedDeck: null,
            isLoaded: false,
            error: null
        }
        this.returnDefault = this.returnDefault.bind(this);
        this.returnLand = this.returnLand.bind(this);
        this.returnCreature = this.returnCreature.bind(this);
        this.returnSorcery = this.returnSorcery.bind(this);
        this.returnInstant = this.returnInstant.bind(this);
        this.returnEnchantment = this.returnEnchantment.bind(this);
        this.returnArtifact = this.returnArtifact.bind(this);
    }

    componentDidMount() {
        //this.loadFakeDeck();
        this.setState({
            isLoaded: true
        });
    }

    loadFakeDeck(){
        requestFromAPI("http://localhost:8080/users/login", "admin", "welcome1", "POST",
            {username: "user", password: "password1"})
            .then(data => {
                //return data.decks[0];
                this.setState({
                    isLoaded: true,
                    deck: data.decks[0],
                    editedDeck: null,
                });
            })
            .catch(error => {
                this.setState({
                    isLoaded: true,
                    error: error,
                    editedDeck: null,
                })
            })

    }

    

    getUserDiv() {
        return (
            <div className={"card user-div"}>
                <img className={"card-img-top"} src={user_logo}  alt="User Logo"/> <br /> <br />
                <div className={"card-body"}>
                    <p className={"card-title"}>
                        <b className={"b"}>Username: </b> {this.state.user.username} <br />
                        <b className={"b"}>Name: </b> {this.state.user.firstName} {this.state.user.lastName} <br />
                        <b className={"b"}>Email: </b> {this.state.user.email} <br />
                    </p>
                    <p className={"card-subtitle"}>
                        <b className={"b"}>Number of decks: </b> {this.state.user.decks.length}
                    </p>
                </div>
            </div>
        )
    }

    getDecksDiv() {
        return (<div className={"decks-div border rounded"}>
            <div className={"container border-dark"}>
                {this.generateTable()}
            </div>
        </div>);
    }
    returnDefault(e){
        //e.preventDefault();
        var currentcards = this.state.deck.cards;
        var returnedCards = [];
        for (var i = 0; i < currentcards.length; i++){
            var cardType = currentcards[i].type_line;
            if (cardType.includes("creature") || cardType.includes("Creature")){
                returnedCards.push(currentcards[i]);
            }

        }
        this.setState({editedDeck: currentcards});
        // this.state.editedDeck.cards = returnedCards;

    }
    
    returnLand(e){
        //e.preventDefault();
        var currentcards = this.state.deck.cards;
        var returnedCards = [];
        for (var i = 0; i < currentcards.length; i++){
            var cardType = currentcards[i].type_line;
            if (cardType.includes("land") || cardType.includes("Land")){
                returnedCards.push(currentcards[i]);
            }

        }
        this.setState({editedDeck: returnedCards});
        // this.state.editedDeck.cards = returnedCards;

    }

    returnCreature(e){
        //e.preventDefault();
        var currentcards = this.state.deck.cards;
        var returnedCards = [];
        for (var i = 0; i < currentcards.length; i++){
            var cardType = currentcards[i].type_line;
            if (cardType.includes("creature") || cardType.includes("Creature")){
                returnedCards.push(currentcards[i]);
            }

        }
        this.setState({editedDeck: returnedCards});
        // this.state.editedDeck.cards = returnedCards;

    }

    returnEnchantment(e){
        //e.preventDefault();
        var currentcards = this.state.deck.cards;
        var returnedCards = [];
        for (var i = 0; i < currentcards.length; i++){
            var cardType = currentcards[i].type_line;
            if (cardType.includes("enchantment") || cardType.includes("Enchantment")){
                returnedCards.push(currentcards[i]);
            }

        }
        this.setState({editedDeck: returnedCards});
        // this.state.editedDeck.cards = returnedCards;

    }

    returnArtifact(e){
        //e.preventDefault();
        var currentcards = this.state.deck.cards;
        var returnedCards = [];
        for (var i = 0; i < currentcards.length; i++){
            var cardType = currentcards[i].type_line;
            if (cardType.includes("artifact") || cardType.includes("Artifact")){
                returnedCards.push(currentcards[i]);
            }

        }
        this.setState({editedDeck: returnedCards});
        // this.state.editedDeck.cards = returnedCards;

    }

    returnInstant(e){
        //e.preventDefault();
        var currentcards = this.state.deck.cards;
        var returnedCards = [];
        for (var i = 0; i < currentcards.length; i++){
            var cardType = currentcards[i].type_line;
            if (cardType.includes("instant") || cardType.includes("Instant")){
                returnedCards.push(currentcards[i]);
            }

        }
        this.setState({editedDeck: returnedCards});
        // this.state.editedDeck.cards = returnedCards;

    }

    returnSorcery(e){
        //e.preventDefault();
        var currentcards = this.state.deck.cards;
        var returnedCards = [];
        for (var i = 0; i < currentcards.length; i++){
            var cardType = currentcards[i].type_line;
            if (cardType.includes("sorcer") || cardType.includes("Sorcer")){
                returnedCards.push(currentcards[i]);
            }

        }
        this.setState({editedDeck: returnedCards});
        // this.state.editedDeck.cards = returnedCards;

    }



    render() {
        if (!this.state.isLoaded)
            return <div />;
        if (this.state.error !== null) {
            return (<div>
                Error when loading <br/>
                {this.state.error}
            </div>);
        }
        let deck = this.state.editedDeck;
        if (deck === null) {
            deck = this.state.deck;
        } else {
            deck = {cards: deck}
        }


        return (<div>
            {/*adding a new test comment*/}
            {/*Navbar*/}
            <DeckNavbar />
            <br></br>
            {/*Left-side image and username*/}
            <div className = "flex-container" >
                <div className = "left-align">
                    <DeckStatsDisplay deck = {this.state.deck}/>
                </div>
                <div className = "right-align">
                    <Button variant="outline-dark" onClick = {this.returnDefault}>Default</Button>{' '}
                    <Button variant="outline-primary" onClick = {this.returnLand}>Land</Button>{' '}
                    <Button variant="outline-secondary" onClick = {this.returnCreature}>Creatures</Button>{' '}
                    <Button variant="outline-success" onClick = {this.returnEnchantment}>Enchantments</Button>{' '}
                    <Button variant="outline-warning" onClick = {this.returnArtifact}>Artifacts</Button>{' '}
                    <Button variant="outline-danger" onClick = {this.returnInstant}>Instants</Button>{' '}
                    <Button variant="outline-info" onClick = {this.returnSorcery}>Sorceries</Button>{' '}
                    <br></br>
                    <DeckDisplay deck = {deck}/>

                </div>
                
            </div>
            <div>
                
            </div>

        </div>);

    }
}


export default DeckPage;
