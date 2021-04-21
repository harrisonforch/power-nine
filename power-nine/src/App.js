import React from "react";
import {
    BrowserRouter as Router,
    Route
} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

import UserPage from "./js/user/UserPage";
import Landing from "./js/landing";
import Deck from "./js/deck/Deck";
import Switch from "react-bootstrap/Switch";

export default function App() {
    return (
        <Router>
            <Switch>
                {/*Note ordering: Switch is a literal switch statement and stops at first match*/}
                <Route exact path={"/"} component={Landing} />
                <Route path={"/deck"} component={Deck} />
                <Route path={"/profile"} component={UserPage} />
                <Route path={"/search"} />
                <Route path={"/logout"} />
                <Route path={"/login"} />
                <Route path={"/register"} />
            </Switch>
        </Router>
    );
};


