import React from "react";
import Login from "./login.js";
import Registration from "./registration.js";
import {
    BrowserRouter as Router,
    Route,
    Redirect
} from "react-router-dom";
import "../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import Switch from "react-bootstrap/Switch";

import UserPage from "./js/user/UserPage";
import DeckPage from "./js/deck/DeckPage";

export default function App() {
    return (
        <Router>
            <Switch>
                <Route exact path={"/"} />
                <Route path={"/deck"} component={DeckPage} />
                <Route path={"/profile"} component={UserPage} />
                <Route path={"/search"} />
                <Route path={"/logout"} component={Login} />
                <Route exact path={"/login"} component={Login} />
                <Route exact path={"/registration"} component={Registration} />
            </Switch>
        </Router>
    );
};


