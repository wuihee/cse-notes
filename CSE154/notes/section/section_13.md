# Section 13: Introduction to Node

## Setup

```javascript
const express = require("express");

const app = express();
const PORT = 8000;

app.listen(PORT);
```

## Basic Endpoint

```javascript
app.get("/", (req, res) => {
    res.type("text").send("Hello, World!");
})
```

## Path Parameters

```javascript
app.get("/math/circle/:r", (req, res) => {
    const radius = parseFloat(req.params.r);
    res.json({
        area: Math.PI * radius ** 2,
        circumference: 2 * Math.PI * radius
    })
})
```

## Query Parameters

```javascript
app.get("/math/power/:base/:exponent", (req, res) => {
    const { root } = req.query;
    const base = parseFloat(req.params.base);
    const exponent = parseFloat(req.params.exponent);
    let data = {result: base ** exponent};
    if (root) {
        data.root = Math.sqrt(base);
    }
    res.json(data);
})
```
