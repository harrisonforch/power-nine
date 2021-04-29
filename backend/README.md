# Back end API documentation

## Authentication

All endpoints require simple user:password authentication.

## General usage

```javascript
async function request(url, username, password, method="get", body=null) {
    let options = {
        mode: 'cors',
        credentials: 'same-origin',
        headers: {
            Authorization: "Basic " + btoa(username + ":" + password),
            'Content-Type': 'application/json'
        },
        method: method
    };

    if (body !== null)
        options.body = JSON.stringify(body);

    const response = await fetch(url, options);
    return response.json();
}
export default request;
```

## Endpoints

### `/users`

Access: admin only

HTTP 401 error for attempt to use non-admin account for these operations


---

#### All users:

View all users' info

Success: JSON list

```javascript
request("http://localhost:8080/users", "admin", "welcome1", "GET")
```

---

#### Login:

Will return a User with deck of cards

Success: JSON object

Failure: 404 if unable to validate user's login credentials

```javascript
request("http://localhost:8080/users/login", "admin", "welcome1", "POST",
    {username: "user", password: "password1"})
```

---

#### New User:

Will create a user and return the newly-created User

Success: User JSON object

Failure: 409 if user already exists

```javascript
request("http://localhost:8080/users", "admin", "welcome1", "POST",
    {username: "user", password: "password1", firstName: "fname", lastName: "lname", email: "address@email.com"})
```

---

#### Update Information:

Changes User's info and returns new User object

Must provide `username` and `password` fields, can optionally update using `newPassword`, `firstName`, `lastName`, and `email`

Success: Updated User JSON 

Failure: 404 if unable to validate user's login credentials

```javascript
request("http://localhost:8080/users", "admin", "welcome1", "PUT",
    {username: "user", password: "password1", newPassword: "newpassword"})
```

---

#### Delete User:

Delete user from database

Success: 200

Failure: 404 if unable to validate user's login credentials

```javascript
request("http://localhost:8080/users", "admin", "welcome1", "DELETE",
    {username: "user", password: "password1"})
```

---

### `/decks`

Access: Any user. Information returned is user-specific.

The `Card` object refers to the JSON blobs that are returned by the [scryfall API](https://scryfall.com/docs/api/cards/random).


---

#### Get all decks for user:

Get signed-in user's decks

```javascript
request("http://localhost:8080/decks", "user", "password1", "GET")
```

Note that this information is returned immediately on from the `/users/login` endpoint.

---

#### Add deck to user

Add a deck to a user's stored deck list. Provide list of `Card` objects

```javascript
request("http://localhost:8080/decks", "user", "password1", "POST",
    {deckName: "new-deck", cards: []})
```

Deck-names must be unique for a given user

---

#### Get deck by deck name

Get a user's deck by name

```javascript
request("http://localhost:8080/decks/{user}/{deckname}", null, null, "GET")
```

---

#### Delete deck

Delete a user's deck by deck name

```javascript
request("http://localhost:8080/decks/{deckname}", "user", "password1", "DELETE")
```

---

#### Add a card to a deck

Add a `Card` to a user's deck

```javascript
request("http://localhost:8080/decks/{deckname}", "user", "password1", "PUT", card)
```

---

#### Delete a card from a deck

Delete `Card` from a user's deck

```javascript
request("http://localhost:8080/decks/delete-card/{deckname}", "user", "password1", "DELETE", card)
```

---

#### Rate a user's deck

Assign a `rating` from 0-5 (inclusive) to the deck named `name` belonging to the user named `username`

```javascript
request("http://localhost:8080/decks/rate/{name}/{username}/{rating}", "user1", "password", "POST")
```

---

#### Get the rating for a user's deck

Get the ratings for the deck named `name` that belongs to the user named `username`

```javascript
request("http://localhost:8080/decks/rate/{name}/{username}", null, null, "POST")
```
