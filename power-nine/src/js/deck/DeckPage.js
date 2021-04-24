import '../../css/DeckPage.css';
import React from "react";
import requestFromAPI from "../BackendAPI";
import DeckDisplay from "./DeckDisplay";
import user_logo from "../../static/user-logo.png";
import DeckNavbar from "./DeckNavbar";


class DeckPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            noDeck: false,
            //unsure if this is true / needed
            //fix the ternary operator syntax
            deck: this.props.location.state !== undefined ? this.props.location.state.deck: null,
            isLoaded: false,
            error: null
        }
    }

    componentDidMount() {
        //don't need to do this
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

    render() {
        /*
        if (!this.state.isLoaded)
            return <div />;
        if (this.state.error !== null) {
            return <div>
                Error when loading <br />
                {this.state.error}
            </div>;
        }*/

        return <div>
            {/*Navbar*/}
            <DeckNavbar />
            <p className = "all-color">
                testing on the deck page
            </p>
            {/*Left-side image and username*/}
            <div>
                <DeckDisplay deck = {this.state.deck}/>
            </div>

        </div>;

    }
}


export default DeckPage;
