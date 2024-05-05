# Lecture 18 - Introduction to Node.js

## Creating a Node.js Application

First, initialize a node project using the default settings.

```bash
npm init -y
```

Install express.

```bash
npm install express
```

## Simple Node.js Application

- `get(ENDPOINT, callback)`: Specifies an endpoint which to call `callback` when visited.
- `listen(PORT, callback)`: `callback` function is called when `PORT` is visited.

```javascript
const express = require("express");

app = express();

app.get("/", (req, res) => {
  res.send("Hello, World!");
});

app.listen(3000, () => {
  console.log("Server is running on port 3000.");
});
```

## Running Application

Start server by running:

```bash
node index.js
```

Visit server by searching

```text
http://localhost:3000
```
