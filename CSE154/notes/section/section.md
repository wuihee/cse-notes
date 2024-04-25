# Section Notes

## Mar 28

- HTML revision.
- Simple HTML exercises.

## Apr 4

- `display: flex`: Make a container a flexbox.
- `justify-content: center`: Center children along the main axis.
- 'align-items: center`: Center items along cross-axis.
- `flex-wrap: wrap`: Wrap items.

## Apr 9

- `document.querySelector()`
- `document.querySelectorAll()`
- `document.getElementById()`
- `element.addEventListener("click", () => {})`

## Apr 11

- `addEventListener()`
- `removeEventListener()`
- `element.classList.add()`
- `element.classList.remove()`
- `element.classList.contains()`
- `parseInte()`
- `event.currentTarget`: Retrieves the element of the event.
- `element.textContent`: Get the text of the element.

## Apr 16

- In a normal function `this` returns `window`.
- In an event listener on a button, `this` returns the button.
- In an anonymous arrow function even listener on a button, `this` returns `window`.

## Apr 18

- `setInterval(callback, time)`: Repeated calls.
- `setTimeout(callback, time)`: Single delay.
- `clearInterval(timerId)`

```javascript
const START = 3;
function timeout() {
    let delay = 1000;
    for (let i = START; i > 0; i--) {
        setTimeout(console.log, delay, i);
        delay += 1000;
    }
    setTimeout(console.log, delay, "Go!");
}
```

- How can you call a variable before it's been defined???
- **Hoisting**: JavaScript initializes these lines of code first. This means we can access these variables/functions before they are declared.

```javascript
console.log(square(5)); // We can use 'square' before it is defined because of hoisting.

function square(x) {
    return x * x;
}
```

- **Temporal Dead Zone**: Variables declared with `let` and `const` are in scope but not yet initialized and cannot be accessed.

```javascript
console.log(a); // ReferenceError: TDZ for a.
let a = 3; // End of TDZ for a.
console.log(a);
```

## 23 Apr

- Promises are resolved or rejected.
- To create a promise, we must pass it an executor function as an argument, which in turn takes two arguments - `resolve` and `reject`, which are called when the promise is resolved or rejected respectively.

## Section 10

- Objects and JSON
- **AJAX**: The use of *requests* to communicate with servers through the internet.
- Promise Pipeline
- `async` / `await` with requests.

```javascript
async function makeRequest() {
    const URL = "https://...";
    try {
        let response = await fetch(URL);
        let json = await response.json();
        return json;
    } catch (error) {
        console.log(error);
    }
}
```
