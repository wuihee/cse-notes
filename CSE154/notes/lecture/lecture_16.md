# Lecture 16 - More with `then` / `catch` & `async` / `await`

## Promise Chain

- An error at any point jumps to the `.catch()`.
- `.catch()` can also returns a promise which gets passed along the chain.

```javascript
fetch(url)
  .then(response => response.json())
  .then(console.log)
  .catch(console.log)
  .then(console.log("This will execute"));
```

- Remember to return values in `.then()` callbacks so they get successfully passed down the chain.

## `async` / `await`

- `await` pauses the execution of code, but only with then `async` function.
- So your code runs synchronously inside your function which runs asynchronously outside.
- `async` functions always return a `Promise`.
