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

Will create a user and return the newly-created User.

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

Delete user from database.

```javascript
request("http://localhost:8080/users", "admin", "welcome1", "DELETE",
{username: "user", password: "password1"})
```
