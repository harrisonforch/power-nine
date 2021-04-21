import React from "react";
import {
    BrowserRouter as Router,
    Route
} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

import UserPage from "./js/user/UserPage";
import Switch from "react-bootstrap/Switch";

export default function App() {
    return (
        <Router>
            <Switch>
                <Route exact path={"/"} />
                <Route path={"/deck"} />
                <Route path={"/profile"} component={UserPage} />
                <Route path={"/search"} />
                <Route path={"/logout"} />
                <Route path={"/login"} />
                <Route path={"/register"} />
            </Switch>
        </Router>
    );
};


