import React, {Component} from "react";
import requestFromAPI from "../BackendAPI";
import LoggedInUser from "../user/LoggedInUser";

class AdvancedSearch extends Component{
    constructor(props){
        super(props)
        this.state = {
            name:'',
            color:'',
            rarity:'',
            isSubmitted: false,
            cardData: []
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
        alert(`
        ____Your Search____\n
        Name : ${name}
        Color : ${color}
        Rarity : ${rarity}
	    `)
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
                        cardData: [...prevState.cardData, data.data[i]]
                    }));
                }
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
        const enteredName = prompt('Please enter the name of your new deck')
        requestFromAPI("http://localhost:8080/decks", "admin", "welcome1", "POST",
            {deckName: enteredName, cards: []})
        requestFromAPI(`http://localhost:8080/decks/${enteredName}`, "admin", "welcome1", "PUT", this.state.cardData[ind])
    }

    addToDeck(event){
        const ind = event.target.value
        const namedDeck = prompt('Please enter the name of the deck')
        requestFromAPI(`http://localhost:8080/decks/${namedDeck}`, "admin", "welcome1", "PUT", this.state.cardData[ind])
    }

    renderSearchResults(i){
        if(this.state.cardData.length > i) {
            if(this.state.cardData[i].layout == 'transform' || this.state.cardData[i].layout == 'modal_dfc') {
                return(
                    <div margin="20px">
                        <button onClick={this.addToDeck} value={i}>Add to deck</button>
                        <button onClick={this.createDeck} value={i}>Create a new deck with this card</button>

                        <a href={this.state.cardData[i].scryfall_uri}>
                            <figure>
                                <img src={this.state.cardData[i].card_faces[1].image_uris.small}/>
                                <figcaption>{this.state.cardData[i].name}</figcaption>
                            </figure>
                        </a>
                    </div>
                )
            }
            return (
                <div margin="20px">
                    <button onClick={this.addToDeck} value={i}>Add to 'new-deck' (test)</button>
                    <button onClick={this.createDeck} value={i}>Create 'new-deck' with this card</button>
                    <a href={this.state.cardData[i].scryfall_uri}>
                        <figure>
                            <img src={this.state.cardData[i].image_uris.small}/>
                            <figcaption>{this.state.cardData[i].name}</figcaption>
                        </figure>
                    </a>
                </div>
            )
        }
    }

// Return a controlled form i.e. values of the
// input field not stored in DOM values are exist
// in react component itself as state
    render(){
        return(
            <div>
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
                <div class = "row">
                    {this.state.isSubmitted && this.renderSearchResults(1)}
                    {this.state.isSubmitted && this.renderSearchResults(2)}
                    {this.state.isSubmitted && this.renderSearchResults(3)}
                    {this.state.isSubmitted && this.renderSearchResults(4)}
                    {this.state.isSubmitted && this.renderSearchResults(5)}
                    {this.state.isSubmitted && this.renderSearchResults(6)}
                    {this.state.isSubmitted && this.renderSearchResults(7)}
                    {this.state.isSubmitted && this.renderSearchResults(8)}
                    {this.state.isSubmitted && this.renderSearchResults(9)}
                    {this.state.isSubmitted && this.renderSearchResults(10)}
                    {this.state.isSubmitted && this.renderSearchResults(11)}
                    {this.state.isSubmitted && this.renderSearchResults(12)}
                    {this.state.isSubmitted && this.renderSearchResults(13)}
                    {this.state.isSubmitted && this.renderSearchResults(14)}
                    {this.state.isSubmitted && this.renderSearchResults(15)}
                    {this.state.isSubmitted && this.renderSearchResults(16)}
                    {this.state.isSubmitted && this.renderSearchResults(17)}
                    {this.state.isSubmitted && this.renderSearchResults(18)}
                    {this.state.isSubmitted && this.renderSearchResults(19)}
                    {this.state.isSubmitted && this.renderSearchResults(20)}
                    {this.state.isSubmitted && this.renderSearchResults(21)}
                    {this.state.isSubmitted && this.renderSearchResults(22)}
                    {this.state.isSubmitted && this.renderSearchResults(23)}
                    {this.state.isSubmitted && this.renderSearchResults(24)}
                    {this.state.isSubmitted && this.renderSearchResults(25)}
                    {this.state.isSubmitted && this.renderSearchResults(26)}
                    {this.state.isSubmitted && this.renderSearchResults(27)}
                    {this.state.isSubmitted && this.renderSearchResults(28)}
                    {this.state.isSubmitted && this.renderSearchResults(29)}
                    {this.state.isSubmitted && this.renderSearchResults(30)}
                    {this.state.isSubmitted && this.renderSearchResults(31)}
                    {this.state.isSubmitted && this.renderSearchResults(32)}
                    {this.state.isSubmitted && this.renderSearchResults(33)}
                    {this.state.isSubmitted && this.renderSearchResults(34)}
                    {this.state.isSubmitted && this.renderSearchResults(35)}
                    {this.state.isSubmitted && this.renderSearchResults(36)}
                    {this.state.isSubmitted && this.renderSearchResults(37)}
                    {this.state.isSubmitted && this.renderSearchResults(38)}
                    {this.state.isSubmitted && this.renderSearchResults(39)}
                    {this.state.isSubmitted && this.renderSearchResults(40)}
                    {this.state.isSubmitted && this.renderSearchResults(41)}
                    {this.state.isSubmitted && this.renderSearchResults(42)}
                    {this.state.isSubmitted && this.renderSearchResults(43)}
                    {this.state.isSubmitted && this.renderSearchResults(44)}
                    {this.state.isSubmitted && this.renderSearchResults(45)}
                    {this.state.isSubmitted && this.renderSearchResults(46)}
                    {this.state.isSubmitted && this.renderSearchResults(47)}
                    {this.state.isSubmitted && this.renderSearchResults(48)}
                    {this.state.isSubmitted && this.renderSearchResults(49)}
                    {this.state.isSubmitted && this.renderSearchResults(50)}
                </div>
            </div>

        )
    }
}

export default AdvancedSearch

