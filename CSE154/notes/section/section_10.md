# Section 10 - Objects & AJAX w Fetch

## Objects & JSON

- We can access object attributes using *dot notation* or with *square brackets*. Note that square brackets must be used when attributes contain special characters.
- The JavaScript `Object` can be converted to and from JSON.

## AJAX with Fetch

- **AJAX**: A combination of technologies which allow JavaScript to interact with servers across the internet and retrieve useful information.
- Requests are made using the `fetch` function which returns a `Promise`.
- The *promise pipeline* is the process of making a request, checking for status code errors, retrieving JSON/text, and finally processing the contents of the request, using appropriate error handling on the way.

## `async` & `await`

- `async` & `await` are syntactic sugar for the *promise chain*.

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
