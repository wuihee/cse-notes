# Section 14

## POST Endpoints

```javascript
app.post("/add", (req, res) => {
    const {movie, year, song, rating} = req.body;
    MOVIEDATA[movie] = {
        "year": year,
        "song": song,
        "rating": rating
    }
    res.send("Success");
})
```
