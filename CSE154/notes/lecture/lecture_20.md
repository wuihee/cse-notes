# Lecture 20 - Errors, Post & Full Stack

## HTTP Status Codes

- 4XX Client Errors: Indicates invalid requests caused by the client.
- 5XX Server Errors: Indicates errors caused on the server-side.

```javascript
app.get("/getItems/:category", (req, res) => {
    res.type("text");
    if (category === "") {
        res.status(400).send("Category is required.");
    } else {
        res.send("success");
    }
})
```

## POST Endpoints

- POST endpoints have the same format as GET endpoints.

```javascript
app.post("/helloWorld", (req, res) => {
  console.log("Hello, World!");
});
```

## Middleware

- A webserver's role is to recieves a requests and output a corresponding response. As such, we can view a webserver as a function with an input and output, which we can decompose into smaller functions with separate roles. *Middleware* are these "smaller functions".
- Middleware have access to the request object, response object, and the next middleware function in the application's *request-response cycle*.
- Middleware functions can perform the following tasks:
  - Execute any code.
  - Make changes to the request and the response objects.
  - End the request-response cycle.
  - Call the next middleware function in the stack.
- We can use `multer` to access the body of a POST request.

### Custom Middleware Example

- In the example below, every request that gets sent to our server will now get "logged".

```javascript
function loggerMiddleware(req, res, next) {
  console.log("Request Logged");
  next();
}

app.use(loggerMiddleware);
```

## POST / Middleware Setup

- Here is a basic setup which allows us to retrieve the body of POST requests.
  - `express.json()`: Middleware to parse JSON bodies.
  - `express.urlEncoded{express: true}`: Middleware to parse URL-encoded bodies.
  - `multer().none()`: Used to parse multipart/form data.

```javascript
const express = require("express");
const multer = require("multer");

app.use(express.json());
app.use(express.urlEncoded{express: true});
app.use(multer().none());

app.post("/submit", (req, res) => {
  console.log(req.body);
  res.type("text").send("POST request received");
});
```
