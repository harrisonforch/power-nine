import React from 'react';
import {Link} from "react-router-dom";
import LoggedInUser from "./LoggedInUser";

class UserNavbar extends React.Component {
    handleLogout() {
        // LoggedInUser.clearUser();
        return <Link to={"/login"} className="nav-link">Logout</Link>;
    }

    render() {
        return (
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <Link to={"/"} className="navbar-brand" href="#">PowerNine</Link>

                <div className="collapse navbar-collapse">
                    <ul className="navbar-nav mr-auto">
                        <Link to={"/"} className="nav-link active">Home</Link>
                        <Link to={"/search"} className="nav-link">Search</Link>
                        <Link to={"/deck"} className="nav-link">User Decks</Link>
                    </ul>
                    <ul className="navbar-nav ml-auto">
                        {this.handleLogout()}
                    </ul>
                </div>
            </nav>
        );
    }
}
export default UserNavbar