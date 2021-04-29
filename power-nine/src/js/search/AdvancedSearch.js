import React, {Component} from "react";
import requestFromAPI from "../BackendAPI";
import LoggedInUser from "../user/LoggedInUser";
import UserNavbar from "../user/UserNavbar";
import DeckDisplay from "../user/DeckDisplay";

class AdvancedSearch extends Component{
    constructor(props){
        super(props)
        this.state = {
            name:'',
            color:'',
            rarity:'',
            isSubmitted: false,
            cardData: [],
            isCompleted: false
        }
        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
        this.addToDeck = this.addToDeck.bind(this)
        this.createDeck = this.createDeck.bind(this)
    }

// Form submitting logic, prevent default page refresh
    handleSubmit(event){
        const { name, color, rarity } = this.state
        event.preventDefault()
        this.setState({isSubmitted: true})
        // alert(`
        // ____Your Search____\n
        // Name : ${name}
        // Color : ${color}
        // Rarity : ${rarity}
	    // `)
        fetch(`https://api.scryfall.com/cards/search?q=${name}+c%3A${color}+r%3A${rarity}`,{
            method: "GET",
            dataType: "JSON",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
            }
        })
            .then(response => response.json())
            .then(data => {
                console.log(data)
                this.setState({cardData: []})
                for(let i = 0; i < data.total_cards; i++) {
                    this.setState(prevState => ({
                        cardData: [...prevState.cardData, data.data[i]],
                    }));
                }
                this.setState({isCompleted: true})
            })
    }

// Method causes to store all the values of the
// input field in react state single method handle
// input changes of all the input field using ES6
// javascript feature computed property names
    handleChange(event){
        this.setState({
            // Computed property names
            // keys of the objects are computed dynamically
            [event.target.name] : event.target.value
        })
    }

    createDeck(event){
        const ind = event.target.value
        const user = LoggedInUser.getUser();
        // TODO: Replace with drop-down of possible decks
        const enteredName = prompt('Please enter the name of your new deck')
        requestFromAPI("http://localhost:8080/decks", user.username, user.password, "POST",
            {deckName: enteredName, cards: []})
            .then(() => {
                requestFromAPI(`http://localhost:8080/decks/${enteredName}`, user.username, user.password, "PUT", this.state.cardData[ind])
                    .then(() => {
                        alert("Deck" + enteredName + " created!")
                    });
            });
    }

    addToDeck(event){
        const ind = event.target.value
        const user = LoggedInUser.getUser();
        const namedDeck = prompt('Please enter the name of the deck')
        requestFromAPI(`http://localhost:8080/decks/${namedDeck}`, user.username, user.password, "PUT", this.state.cardData[ind])
            .then(() => {
                alert("Card added to deck " + namedDeck)
            })
    }

    renderSearchResults(){
        const tableRows = [];
        for (let i = 0; i < this.state.cardData.length; i = i + 3) {
            if (i >= 50)
                return tableRows;
            tableRows.push(
                <div margin="20px" className={"row"}>
                    {this.state.cardData.slice(i, i + 3).map((_, k) => {
                        let j = k + i;
                        if (this.state.cardData[j] === undefined)
                            return;
                        return (<div>
                            <button onClick={this.addToDeck} value={j}>Add to deck</button>
                            <button onClick={this.createDeck} value={j}>Create a new deck with this card</button>

                            <a href={this.state.cardData[j].scryfall_uri}>
                                <figure>
                                    {this.state.cardData[j].layout === 'transform' || this.state.cardData[j].layout === 'modal_dfc' ?
                                        <img src={this.state.cardData[j].card_faces[1].image_uris.small}/> :
                                        <img src={this.state.cardData[j].image_uris.small}/>
                                    }
                                    <figcaption>{this.state.cardData[j].name}</figcaption>
                                </figure>
                            </a>
                        </div>)
                    })}
                </div>
            );
        }
        return tableRows;
    }

// Return a controlled form i.e. values of the
// input field not stored in DOM values are exist
// in react component itself as state
    render(){
        let i = 0;
        if (this.state.isSubmitted && !this.state.isCompleted)
            return (
                <div>
                    <UserNavbar />
                    <div>Loading...</div>
                </div>
            )
        return(
            <div>
                <UserNavbar />
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label htmlFor='name'>Name</label>
                        <input
                            name='name'
                            placeholder='Name'
                            value={this.state.name}
                            onChange={this.handleChange}
                        />
                    </div>
                    <div>
                        <label htmlFor='color'>Color</label>
                        <select name='color' value={this.state.color} onChange={this.handleChange}>
                            <option value="w">White</option>
                            <option value="u">Blue</option>
                            <option value="b">Black</option>
                            <option value="r">Red</option>
                            <option value="g">Green</option>
                            <option value="c">Colorless</option>
                        </select>
                    </div>
                    <div>
                        <label htmlFor='rarity'>Rarity</label>
                        <select name='rarity' value={this.state.rarity} onChange={this.handleChange}>
                            <option rarity="common">Common</option>
                            <option rarity="uncommon">Uncommon</option>
                            <option rarity="rare">Rare</option>
                            <option rarity="mythic">Mythic</option>
                        </select>
                    </div>
                    <div>
                        <button>Search</button>
                    </div>
                </form>
                {this.state.isCompleted && this.renderSearchResults()}
            </div>

        )
    }
}

export default AdvancedSearch;

