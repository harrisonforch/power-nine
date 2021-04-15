# Back end API documentation

## Authentication

All endpoints require simple user:password authentication. This may be accomplished from the
client side.

Basic usage:

```
let options = {
    mode: 'cors',
    credentials: 'same-origin',
    headers: {
        Authorization: "Basic " + btoa("admin:welcome1"), // Substitute user info as needed
        'Content-Type': 'application/json'
    },
    method: "GET"  // Or POST/PUT/DELETE
};
const body = null;  // Provide body here as needed
if (body !== null)
    options.body = body;
fetch("http://localhost:8080", options)
    .then((res) => res.json())
    .catch((error) => throw error);
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
