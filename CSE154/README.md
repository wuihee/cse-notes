# CSE 154

## Notes

### Mar 27

- Hyper Text Markup Language (HTML)
- HTML Element: Open Tag + Closed Tag

```html
<p>Content</p>
```

- Block level elements: Take up the entire width of the page and force a line break.

#### Basic Tags

- `html`: Should contain everything.
- `<head>`: Contain meta data and where we load in additional resources.
- `<meta>`: Specify encodings.
- `<title>`: Displays title in tab
- `<h1>` to `<h6>`: Header tags.

#### Content Tags

- `article`: Group standalone content.
- `section`: Group content that is part of a greater whole.
- `div`: Last choice for grouping content because it's generic.
- `p`: Hold paragraphs of text.
- `<img>`: Displays images.
  - `src`: Link to image source.
  - `alt`: Text that shows if image fails to display.

#### Lists

- `<ol>`: Ordered list.
- `<ul>`: Unordered list.
- `<li>`: List item tags.

```html
<ol>
    <li>First item.</li>
    <li>Second item.</li>
    <li>Third item.</li>
</ol>
```

### Mar 28

- HTML revision.
- Simple HTML exercises.

### Mar 29

#### Nested Lists

- Nested lists must be placed with `<li></li>` tags.

```html
<ol>
  <li>Item 1</li>
  <li>
    <ol>
      <li>Item 2</li>
    </ol>
  </li>
```

#### Block and Inline Elements

- Block elements start a newline.
- Inline elements do not.

#### Common Inline Elements

- `<a>`: Anchor tag for links.
  - `href`: Link address.
  - `target=_blank`: Open link in new tab.
  - `title`: Text that displays when you hover over image.
- `<em>`: Italicize.
- `<strong>`: Bold.
- `<span>`: Inline container.

#### Nesting Tags

- Close tags like brackets: `[()]`, not like `[(])`.

#### Miscellaneous

- Everything lowercase.
- Make sure to cite external material.

#### Cascading Style Sheets (CSS)

- Including a CSS style sheet.

```html
<link href="filename" rel="stylesheet">
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
p, li {
  color: red;
}
```

#### `id` and `class` Attributes

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
