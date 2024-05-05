# Section 11 - `.then` / `.catch`

- When we create a new `Promise`, the executor function immediately executes. In the example below, "1" gets logged before "2".

```javascript
let promise = new Promise (() => {
    console.log("1");
})
console.log("2");
```
