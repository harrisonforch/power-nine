import React from "react";
import Login from "./login.js";
import Registration from "./registration.js";
import SignupConfirm from "./SignupConfirm.js";
import LoginConfirm from "./Loginconfirmation.js"

import {
    BrowserRouter as Router,
    Route
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
                <Route path={"/logout"} />
                <Route exact path={"/login"} component={Login}></Route>
                <Route exact path={"/registration"} component={Registration}></Route>
                <Route exact path={"/signupconfirmation"} component={SignupConfirm}></Route>
                <Route exact path={"/loginconfirmation"} component={LoginConfirm}></Route>
               
            </Switch>
        </Router>
    );
};


