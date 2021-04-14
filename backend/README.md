# Back end API documentation

## Authentication

All endpoints require simple user:password authentication. This may be accomplished from the
client side:

```
sendRequest(url, username, password) {
    let options = {
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            Authorization: "Basic " + btoa(username + ":" + password),
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer'
    }
    return fetch(url, options)
        .then((res) => res.json())
        .then((text) => {
            console.log(text);
            return text.length ? JSON.parse(text) : {};
        })
        .catch((error) => {
            console.log(error);
            throw error;
        });
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
