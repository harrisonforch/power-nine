import React from "react";

class Deck extends React.Component {
    render() {
        return JSON.stringify(this.props.location.state.deck)
    }
}
export default Deck;