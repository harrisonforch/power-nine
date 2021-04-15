# Back end API documentation

## Authentication

All endpoints require simple user:password authentication.

## Endpoints

### `/users`

Access: admin only

---

View table:
```
curl -i http://localhost:8080/users --user admin:welcome1
```

```javascript
let options = {
    mode: 'cors',
    credentials: 'same-origin',
    headers: {
        Authorization: "Basic " + btoa("admin:welcome1"),
        'Content-Type': 'application/json'
    },
};
fetch("http://localhost:8080/users", options)
    .then((res) => res.json())
    .catch((error) => throw error);
```


This will return a list of JSONified User objects.

---

Add user:
```
curl -i http://localhost:8080/users --user admin:welcome1 -X POST -H 'Content-type:application/json' -d '{"username": "user2", "password": "password"}'
```

```javascript
let options = {
    mode: 'cors',
    credentials: 'same-origin',
    headers: {
        Authorization: "Basic " + btoa("admin:welcome1"),
        'Content-Type': 'application/json'
    },
    method: "POST"
};
const body = {
    username: "user2",
    password: "password"
};
options.body = body;
fetch("http://localhost:8080/users", options)
    .then((res) => res.json())
    .catch((error) => throw error);
```

This will return the newly created User as a JSON object.

---

Delete user:
```
curl -i http://localhost:8080/users --user admin:welcome1 -X DELETE -H 'Content-type:application/json' -d '{"username": "user2", "password": "password"}'
```

```javascript
let options = {
    mode: 'cors',
    credentials: 'same-origin',
    headers: {
        Authorization: "Basic " + btoa("admin:welcome1"),
        'Content-Type': 'application/json'
    },
    method: "DELETE"  // Or POST/PUT/DELETE
};
const body = {
    username: "user2",
    password: "password"
};
options.body = body;
fetch("http://localhost:8080/users", options)
    .then((res) => res.json())
    .catch((error) => throw error);
```

This will respond with HTTP 200 status if properly processed.

---
