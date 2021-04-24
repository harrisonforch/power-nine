import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { Navbar } from 'react-bootstrap';
import {Nav} from "react-bootstrap";
import { Link } from "react-router-dom";
import request from "./backend.js";
import {useHistory} from 'react-router-dom';
import "./login.css";


function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessageUser, setErrorMessageUser] = useState("");
  const [errorMessagePwd, setErrorMessagePwd] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const history = useHistory();
  

  function handleSubmit(event) {
    event.preventDefault();
    setErrorMessageUser("");
    setErrorMessagePwd("");
    setErrorMessageUser("");

    if(username.trim().length === 0 || password.trim().length === 0 ){
      if(username.trim().length === 0 ){
        setErrorMessageUser("Username is required");
      }
      if(password.trim().length === 0 ) {
        setErrorMessagePwd("Password is required");
      }
     
    } 
    else {
      request("http://localhost:8080/users/login", "admin", "welcome1", "POST",
      {username: username, password: password})
      .then(data => {
        setUsername(data.username.toString());
        setPassword(data.password.toString());
        console.log("successful login");
        history.push("./profile", data);
      })
      .catch(error =>{
        setErrorMessage("Incorrect username or password");
        console.log("unsuccessful login");
      })
    }
  }

  return (
    <div className="Login">
      {/* navbar */}
      <Navbar bg="light" expand="lg">
        <Navbar.Brand href="/">Power Nine</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
      <Nav className="mr-auto">
        <Nav.Link href="/">Home</Nav.Link>
        <Nav.Link href="./registration">Sign Up</Nav.Link>
      </Nav>
        </Navbar.Collapse>
      </Navbar>


    <Form onSubmit={handleSubmit}>
      <h1>login</h1>

      {errorMessage && (
        <p className="error-user"> {errorMessage} </p>
      )}

      <Form.Group size="lg" controlId="username">
          <Form.Label>Username</Form.Label>
          <Form.Label className="required-star">*</Form.Label>
          <Form.Control
            autoFocus
            type="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          {errorMessageUser && (
            <p className="error-user"> {errorMessageUser} </p>
          )}
        </Form.Group>
      <Form.Group size="lg" controlId="password">
          <Form.Label>Password</Form.Label>
          <Form.Label className="required-star">*</Form.Label>
          <Form.Control
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          {errorMessagePwd && (
            <p className="error-pwd"> {errorMessagePwd} </p>
          )}
        </Form.Group>
        <Form.Group>
            <Button block size="lg" type="submit" >Login
            </Button>
        </Form.Group>
      
        <Form.Group>
        <Link to="/registration">
            <Button block size ="lg" id="sign-up">Sign up</Button>
        </Link>
        </Form.Group>
      </Form>
    </div>
  );
}

export default Login;