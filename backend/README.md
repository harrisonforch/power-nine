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


---

#### Login:

Will return a User with deck of cards

```javascript
request("http://localhost:8080/users/login", "admin", "welcome1", "POST",
    {username: "user", password: "password1"})
```

---

#### New User:

Will create a user and return the newly-created User

```javascript
request("http://localhost:8080/users", "admin", "welcome1", "POST",
    {username: "user", password: "password1"})
```

---

#### Update Password:

Changes User's password and returns new User object

```javascript
request("http://localhost:8080/users", "admin", "welcome1", "PUT",
    {username: "user", password: "password1", newPassword: "newpassword"})
```

---

#### Delete User:

Delete user from database

```javascript
request("http://localhost:8080/users", "admin", "welcome1", "DELETE",
    {username: "user", password: "password1"})
```

---

### `/decks`

Access: Any user. Information returned is user-specific.

The `Card` object refers to the JSON blobs that are returned by the [scryfall API](https://scryfall.com/docs/api/cards/random).

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
request("http://localhost:8080/decks/{deckname}", "user", "password1", "GET")
```

#### Delete deck

Delete a user's deck by deck name

```javascript
request("http://localhost:8080/decks/{deckname}", "user", "password1", "DELETE")
```

---

#### Add a card to a deck

Add a `Card` to a user's deck

```javascript
request("http://localhost:8080/decks/{deckname}", "user", "password1", "PUT", 
    card)
```

---

#### Delete a card from a deck

Delete `Card` from a user's deck

```javascript
request("http://localhost:8080/decks/delete-card/{deckname}", "user", "password1", "PUT", 
    card)
```
