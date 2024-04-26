# Lecture 15 - `then` / `catch`

## The Promise Chain

- `.then()` is a method we can chain to a function tha returns a promise.
- Inside `then(callback)` we have a callback that is called when the promise is resolved.
- We can chain together `.then()` methods, where the resolved value of the promise gets passed to the next `.then()`.
- Add `.catch()` to the end of the chain to catch errors.

```javascript
fetch(url)
  .then(response => {
    if (!response.ok) {
        throw new Error("Request failed.");
    } else {
        return response.json();
    }
  })
  .then(data => console.log(data.json()))
  .catch(error => console.log(error));
```
