import React from "react";
import {
    BrowserRouter as Router,
    Route
} from "react-router-dom";
import "../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import Switch from "react-bootstrap/Switch";

import UserPage from "./js/user/UserPage";
import DeckPage from "./js/deck/DeckPage";
import ComparePage from "./js/compare/ComparePage";

export default function App() {
    return (
        <Router>
            <Switch>
                <Route exact path={"/"} />
                <Route path={"/deck"} component={DeckPage} />
                <Route path={"/profile"} component={UserPage} />
                <Route path={"/search"} />
                <Route path={"/logout"} />
                <Route path={"/login"} />
                <Route path={"/register"} />
                <Route path={"/compare"} component = {ComparePage}/>
            </Switch>
        </Router>
    );
};


