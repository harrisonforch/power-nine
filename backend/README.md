# Back end API documentation

## Authentication

All endpoints require simple user:password authentication. This may be accomplished from the
client side:

```
sendRequest(url, method, body, username, password) {
    const options = {
        method: method,
        headers: new Headers({
            'content-type': 'application/json',
            'Authorization': "Basic " + btoa(username + ":" + password)
        }),
        mode: 'no-cors'
    };

    options.body = JSON.stringify(body);

    fetch(url, options)
        .then(res => res.json())
        .then(
            (result) => {
                return result
            },
            (error) => {
                return error
            }
        );
}
```

## Endpoints

### `/users`

Access: admin only

---

View table:
```
curl -i http://localhost:8080/users --user admin:welcome1
```

This will return a list of JSONified User objects.

---

Add user:
```
curl -i http://localhost:8080/users --user admin:welcome1 -X POST -H 'Content-type:application/json' -d '{"username": "user2", "password": "password"}'
```

This will return the newly created User as a JSON object.

---

Delete user:
```
curl -i http://localhost:8080/users --user admin:welcome1 -X DELETE -H 'Content-type:application/json' -d '{"username": "user2", "password": "password"}'
```

This will respond with HTTP 200 status if properly processed.

---
