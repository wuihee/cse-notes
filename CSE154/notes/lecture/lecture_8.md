# Lecture 8 (10 Apr)

## Event Listeners

- `removeEventListener()`: Same set of parameters as `addEventListener`.

```javascript
button.removeEventListener("click", callback);
```

- `button.disabled`: This boolean attribute can be used to enable/disable buttons. When disabled, event listeners don't run.
- Other form elements also have the `disabled` attribute.

```javascript
button.disabled = true;
```

## Inserting JavaScript into HTML

- When we link to a JavaScript file at the start of the HTML document, stuff like eventListeners cannot be attached to elements because they haven't yet been defined.
- To solve this, add an eventListener to the `window` to activate upon the "load" event.

```javascript
window.addEventListener("load", init);

function init() {
    let button = document.querySelector("button");
    button.addEventListener("click", callback);
}
```

## Strict Mode

- Add the follwing to the start of JS file:

```javascript
"use strict";
```

## The Module Pattern

- Call all code within an anonymous function so that they are not defined in the global namespace.

```javascript
(function() {
    function yourFunction() {
        console.log("Do things");
    }
})();
```

## Changing Styles

- `element.classList`: Property returns a list of the element's classes.
- `element.classList.add()`: Add a new class to an element.
- `element.classList.remove()`: Remove a class from element.
- `element.classList.contains()`: Returns a boolean showing whether a given class exists.
- `element.classList.toggle()`: Toggles the existence of a class on an element.

## Event Object

- We can add an event object in the callback functions that we pass to our event listeners.
- `event.currentTarget`: The element whose event has been activated.

```javascript
element.addEventListener("click", callback);

function callback(event) {
    // event parameter represents the event that just happened.
}
```
