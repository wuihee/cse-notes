# Lecture 6 (5 Apr)

## CSS Pseudoselectors

- `:hover`: Allows changes on mouse hover.
- We don't need to have `:hover` be on the last element. E.g. in the snippet below when we hover over `<article>`, changes are made to `<img>`.

```css
article:hover img {
  width: 100px;
}
```

## JavaScript

- **Client-Side Scripting**: Code which runs on the user's browser without needing internet.

### Variables

- `const`: Keyword define constant variables that cannot be changed.
- `let`: Block-scoped; Only available in the block of code it is defined.
- `var`: Global-scoped; Available everywhere. We don't use `var`.

### Equality

- Use `===` instead of `==` for strict equality.

### Special Values

- `null`: Similar to `null` in Java or `None` in Python.
- `undefined`: When a variable hasn't been assigned yet.

### Truthy & Falsey Values

- Numbers have truthy values:

```javascript
if (13) {
  console.log("hi");
}
```

- However, empty arrays have truthy values too.
- `undefined` and `null` have falsely values.
