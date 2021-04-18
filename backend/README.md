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
