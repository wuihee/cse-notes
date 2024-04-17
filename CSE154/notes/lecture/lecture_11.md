# Lecture 11

## Timers

- `setTimeout(callback, delay)`: Delay callback function call. Returns identifier for timer.

```javascript
let timerId = setTimeout(() => console.log("hello"), 2000);
```

- `setInterval(callback, delay, arg1, arg2, ...)`: Delay callback function call in an infinite loop. At each iteration pass in each argument to the callback.

```javascript
setInterval((arg) => console.log(arg), 1000, arg1, arg2);
```

- `clearTimeout(timer)`: Get rid of a timer and its callback.
