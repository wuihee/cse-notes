# Lecture 13: APIs, Data & Fetch

## AJAX

- Uses JavaScript to facilitate making requests.

## JavaScript Objects

- Everything that is not a primitive type is an object.
- Objects can hold functions, making them almost like classes.
- We can access object values using *dot notation* or *bracket notation*.

```javascript
obj = {
    "attribute": 1,
    "method": () => console.log("This is a method");
};

console.log(obj["attribute"]);
console.log(obj.attribute);
obj.method();
```

## JavaScript Object Notation

- **JSON**: Standardized, language-agnostic string format often used to send data.
- `JSON.parse(data)`: Converts a JSON string into a JavaScript object.
- `JSON.stringify()`: Converts a JavaScript object into a JSON string. Functions get nullified.

## Application Programming Interface (API)

- Calling APIs will take time.
- `fetch(url)`: Is used to make requests and returns a `Promise`.
- `.json()` and `.text()`: Methods called on the `Response` object which returns a `Promise`.

### API Components

- What's the hostname?
- Are we allowed to access it?
- What content does it give us?
- In what ftrmat should the response be?
