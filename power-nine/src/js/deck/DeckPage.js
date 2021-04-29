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
            //deck: this.props.location.state !== undefined ? this.props.location.state.deck: null,
            deck: null,
            editedDeck: null,
            isLoaded: false,
            error: null
        }
    }

    componentDidMount() {
        //don't need to do this
        // this.loadFakeDeck();
    }

    loadFakeDeck(){
        requestFromAPI("http://localhost:8080/users/login", "admin", "welcome1", "POST",
            {username: "user", password: "password1"})
            .then(data => {
                //return data.decks[0];
                this.setState({
                    isLoaded: true,
                    deck: data.decks[0],
                    editedDeck: data.decks[0]
                });
            })
            .catch(error => {
                this.setState({
                    isLoaded: true,
                    error: error
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

    returnLand(e){
        e.preventDefault();
        var currentcards = this.state.deck.cards;
        var returnedCards = [];
        for (var i = 0; i < currentcards.length; i++){
            var cardType = currentcards[i].type_line;
            if (cardType.includes("land")){
                returnedCards.push(currentcards[i]);
            }

        }
        this.state.editedDeck.cards = returnedCards;

    }

    render() {
        this.loadFakeDeck();
        if (!this.state.isLoaded)
            return <div />;
        if (this.state.error !== null) {
            return (<div>
                Error when loading <br/>
                {this.state.error}
            </div>);
        }

        return (<div>
            {/*adding a new test comment*/}
            {/*Navbar*/}
            <DeckNavbar />
            <h2 className = "all-color">
                PAGE STILL BEING WORKED ON
            </h2>
            {/*Left-side image and username*/}
            <div >
                <div className = "right-align">
                    <Button variant="outline-primary" onClick = {this.returnLand}>Land</Button>{' '}
                    <Button variant="outline-secondary">Creatures</Button>{' '}
                    <Button variant="outline-success">Enchantments</Button>{' '}
                    <Button variant="outline-warning">Warning</Button>{' '}
                    <Button variant="outline-danger">Artifacts</Button>{' '}
                    <Button variant="outline-info">Instants</Button>{' '}
                    <Button variant="outline-light">Sorceries</Button>{' '}
                </div>
                <DeckStatsDisplay deck = {this.state.editedDeck}/>
            </div>
            <div>
                <DeckDisplay deck = {this.state.editedDeck}/>
            </div>

        </div>);

    }
}


export default DeckPage;
