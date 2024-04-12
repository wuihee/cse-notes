# Lecture 9 (12 Apr)

## Anonymous Functions

- `function` syntax:

```javascript
function(param) {
    console.log("Anonymous function syntax 1 with param " + param);
}
```

- "Arrow" syntax:

```javascript
(param) => {
    console.log("Anonymous function syntax 2 with param " + param);
}

param => {
    console.log("Anonymous function syntax 3 with param " + param);
}
```

### Anonymous Functions & Event Listeners

```javascript
let name = "you name";
button.addEventListener("click", () => {console.log(name)});
```

- Normally, if we try to add multiple event listeners to an element, the browser prevents the redudancy.
- However, if we add event listeners using anonymous functions, duplicates will occur because the browser has no way of determining that anonymous functions are the same.
- You cannot remove an event listener that has been defined by an anonymous function.

## `this` Keyword

- The `this` keyword refers to the object it belongs to.

```javascript
element.addEventListener("click", function() {
    this.classList.add(".styled");
})
```

- **Global Context**: Outside of any function, `this` refers to the global object (i.e. `window`).
- **Function Context**: Inside a function, what `this` refers to depends on how the fucntion is called:
  - **Function is a Method of an Object**: `this` refers to the object.
  - **Function Invoked By Itself**: `this` refers to the global object (non-strict mode) or `undefined` (strict mode).
- **Arrow Functions**: Arrow functions do not have their own `this` context; they inherit from the outer function where the arrow function is defined.
