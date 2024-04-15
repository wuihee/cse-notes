# Lecture 10

## Creating New Elements

- `document.createElement("tag")`: Create and returns new DOM node.

```javascript
// Create new node.
let newHeader = document.createElement("h2");

// Modify new node.
newHeader.textContent = "This is a newly created header";
newHeader.id = "new-id";
newHeader.classList.add("new-class");
```

## Adding and Moving Nodes

- `parentNode.appendChild(childNode)`: Adds `childNode` as the very last element to `parentNode`.

```javascript
let body = document.querySelector("body");
body.appendChild(newHeader);
```

- `parentNode.insertBefore(newNode, oldNode)`: Places `newNode` before `oldNode` under `parentNode`.
- `parentNode.replaceChild(newNode, oldNode)`: Replaces `oldNode` with `newNode` under `parentNode`.

## Removing Nodes

- `parentNode.removeChild(node)`: Remove `node` from `parentNode`.
- `node.remove()`: Remove `node`.
- We can also use the `.innerHTML` property of an element to remove all children within.

```javascript
let parent = document.querySelector("body");
parent.innerHTML = "";
```

## DOM Traversal Methods

DOM nodes contain the following properties which can be used to access other nodes:

- `firstElementChild`: First child of node.
- `lastElementChild`: Last child of node.
- `children`: Array of children nodes.
- `nextElementSibling`, `previousElementSibling`: Neighboring nodes.
- `parentNode`: Element that contains the node.

## Miscellaneous

- `Math.random()`: Generate random number bewteen 0 and 1.
- `Math.floor(number)`: Round `number` down.
