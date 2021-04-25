import {Redirect} from "react-router-dom";
import React from "react";

let LoggedInUser = (function() {
    let getUser = () => {
        return JSON.parse(localStorage.getItem("user"));
    }

    let setUser = (user) => {
        localStorage.setItem("user", JSON.stringify(user));
    }

    let isLoggedIn = () => {
        return localStorage.getItem("user") !== "none";
    }

    let clearUser = () => {
        localStorage.setItem("user", "none");
    }

    let redirect = () => {
        return <Redirect to="/login" />;
    }

    return {
        getUser: getUser,
        setUser: setUser,
        isLoggedIn: isLoggedIn,
        clearUser: clearUser,
        redirect: redirect
    }
})();
export default LoggedInUser;