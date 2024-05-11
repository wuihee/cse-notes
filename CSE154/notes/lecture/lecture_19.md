# Lecture 19: Node.js

## Ports

- *IP addresses* are like the address of your apartment, while *ports* are doors to the homes in the building.

```javascript
const PORT = process.env.PORT || 8000;
app.listen(PORT);
```

## Sending Responses

- Sending responses to HTTP requests is a fundamental part of web interactions, which include serving web pages, sending JSON data, or simply responding to queries with appropriate status codes and messages.
- `res.send([body])`: Sends a response of default `html` type.
- `res.json([body])`: Sends a JSON response.

```javascript
app.get("/", (req, res) => {
    res.type("text").send("Welcome to the homepage!");
});

app.get("/data", (req, res) => {
    const data = { id: 1, name: "example" };
    res.status(200).json(data);
})
```

## Request Parameters

### Path Parameters

- *Path parameters* are used to capture values specified at a particular position in the URL path.
- Used to specify an essential resource to access.

```javascript
const express = require("express");
const app = express();
const PORT = 3000;

app.get("/users/:userId", (req, res) => {
    const userId = req.params.userId;
    res.send("Fetching user with ID: ${userId}");
});

app.listen(PORT, () => {
    console.log("Server running on http://localhost:${PORT}");
});
```

- The route `/users/:userId` includes a path parameter `userId`.
- `:userId` in the path defines that part of the URL as a variable.
- Express makes this variable available in `req.params`.

### Query Parameters

- *Query parameters* are used to provide optional or additional data in GET requests.
- They are appeneded to the URL using `?` followed by key-value pairs separated by `&`.
- Query parameters are typically used for filtering, soring or specifying the nature of the request.

```javascript
app.get("/search", (req, res) => {
    const { query, type, } = req.query;
    res.send("Search for ${query} with type ${type}");
});
```

- The route will look like `/search?query=nodejs&type=article`.
- `req.query` contains an object with all the query parameters: `{ query: "nodejs", type: "article" }`.
