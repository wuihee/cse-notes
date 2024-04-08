# Lecture 7

## JS / HTML Connction

- Link a JS script in the HTML.

```html
<script src="example.js"></script>
```

## Event Driven Programming

- **Definition**: Writing programs drien by *user events*; i.e. every piece of JS code is tied to a functionality on the page.

## Accessing Elements

- `document`: Variable referencing the entire HTML page.
- `document.getElementById()`: Reference an element by its ID.
- `document.querySelector()`: Reference only the first element by CSS selector.

```javascript
document.querySelector(".test-class")
document.querySelector("#test-id")
document.querySelector("section > div")
```

- `document.querySelectorAll()`: Returns a `NodeList` of all selectors that match.
- We can reference and manipulate the properties of elements:

```javascript
let myImg = document.querySelector("img");
myImg.alt // 'alt' attribute of img.
myImg.src = newSrc; // Change img 'src'.
```

- We can also extract the text of an element using `textContent` property.

```javascript
let header = document.querySelector("h1");
header.textContent = "New content";
```

## Event Listener

- We can add event listeners to `Elements` which calls a callback function upon a specified event.

```javascript
element.addEventListener("click", handleFunction);

function handleFunction() {
    // Event handler code.
}
```
