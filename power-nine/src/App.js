import React from "react";
import Login from "./login.js";
import Registration from "./registration.js";
import SignupConfirm from "./SignupConfirm.js";
import LoginConfirm from "./Loginconfirmation.js"

import {
    BrowserRouter as Router,
    Route
} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Switch from "react-bootstrap/Switch";

import UserPage from "./js/user/UserPage";

export default function App() {
    return (
        <Router>
            <Switch>
                <Route exact path={"/"} />
                <Route path={"/deck"} />
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


