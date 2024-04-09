# Lecture 3 (29 Mar)

## Nested Lists

- Nested lists must be placed with `<li></li>` tags.

```html
<ol>
  <li>Item 1</li>
  <li>
    <ol>
      <li>Item 2</li>
    </ol>
  </li>
</ol>
```

## Block and Inline Elements

- Block elements start a newline.
- Inline elements do not.

## Common Inline Elements

- `<a>`: Anchor tag for links.
  - `href`: Link address.
  - `target=_blank`: Open link in new tab.
  - `title`: Text that displays when you hover over image.
- `<em>`: Italicize.
- `<strong>`: Bold.
- `<span>`: Inline container.

## Nesting Tags

- Close tags like brackets: `[()]`, not like `[(])`.

## Miscellaneous

- Everything lowercase.
- Make sure to cite external material.

## Cascading Style Sheets (CSS)

- Including a CSS style sheet.

```html
<link href="filename" rel="stylesheet" />
```

- **Selectors**: Designate which elements the styles apply to.
- **Properties**: The styles that will be applied.
- **Value**: Each property must contain a value.

```css
p {
  font-family: mono;
  color: blue;
}
```

- Group selectors:

```css
p,
li {
  color: red;
}
```

## `id` and `class` Attributes

- `id`: Unique identifier for an element that should only appear once.

```css
#demo {
  color: red;
}
```

- `class`: Non-unique attribute used to group elements.

```css
.demo {
  color: green;
}
```
