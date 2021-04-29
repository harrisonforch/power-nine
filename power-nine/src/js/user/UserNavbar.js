import React from 'react';
import {Link} from "react-router-dom";
import LoggedInUser from "./LoggedInUser";

class UserNavbar extends React.Component {
    handleLogout() {
        if (LoggedInUser.isLoggedIn())
            return <Link to={"/login"} className="nav-link">Logout</Link>;
        return <Link to={"/login"} className="nav-link">Login</Link>;
    }

    render() {
        return (
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <Link to={"/"} className="navbar-brand" href="#">PowerNine</Link>

                <div className="collapse navbar-collapse">
                    <ul className="navbar-nav mr-auto">
                        {
                            LoggedInUser.isLoggedIn() ?
                                <Link to={"/profile"} className="nav-link active">Profile</Link> :
                                <div></div>
                        }
                        <Link to={"/search"} className="nav-link">Search</Link>
                        <Link to={"/alldecks"} className="nav-link">All decks</Link>
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