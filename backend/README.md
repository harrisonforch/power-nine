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

Login:
```javascript
request("http://localhost:8080/users/login", "admin", "welcome1", "POST",
            {username: "user", password: "password1"})
```
Will return a User with deck of cards

---

New User:
```javascript
request("http://localhost:8080/users", "admin", "welcome1", "POST",
            {username: "user", password: "password1"})
```
Will create a user and return the newly-created User.

---

Update Password:
```javascript
request("http://localhost:8080/users", "admin", "welcome1", "PUT",
            {username: "user", password: "password1", newPassword: "newpassword"})
```
Changes User's password and returns new User object

---

Delete User:
```javascript
request("http://localhost:8080/users", "admin", "welcome1", "DELETE",
            {username: "user", password: "password1"})
```
Delete user from database.
