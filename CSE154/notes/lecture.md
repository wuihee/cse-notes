# Lecture Notes

## Lecture 2 (27 Mar)

- Hyper Text Markup Language (HTML)
- HTML Element: Open Tag + Closed Tag

```html
<p>Content</p>
```

- Block level elements: Take up the entire width of the page and force a line break.

### Basic Tags

- `html`: Should contain everything.
- `<head>`: Contain meta data and where we load in additional resources.
- `<meta>`: Specify encodings.
- `<title>`: Displays title in tab
- `<h1>` to `<h6>`: Header tags.

### Content Tags

- `article`: Group standalone content.
- `section`: Group content that is part of a greater whole.
- `div`: Last choice for grouping content because it's generic.
- `p`: Hold paragraphs of text.
- `<img>`: Displays images.
  - `src`: Link to image source.
  - `alt`: Text that shows if image fails to display.

### Lists

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

## Lecture 3 (29 Mar)

### Nested Lists

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

### Block and Inline Elements

- Block elements start a newline.
- Inline elements do not.

### Common Inline Elements

- `<a>`: Anchor tag for links.
  - `href`: Link address.
  - `target=_blank`: Open link in new tab.
  - `title`: Text that displays when you hover over image.
- `<em>`: Italicize.
- `<strong>`: Bold.
- `<span>`: Inline container.

### Nesting Tags

- Close tags like brackets: `[()]`, not like `[(])`.

### Miscellaneous

- Everything lowercase.
- Make sure to cite external material.

### Cascading Style Sheets (CSS)

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

### `id` and `class` Attributes

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

## Lecture 4 (1 Apr)

- **The Document Object Model (DOM)**: Describes the hierarchy of a webpage - how tags are ranked (i.e. nested).

### Selector Combinations

#### Descendent Combinator

- **Format**: `A B`
- **Definition**: Select all `B` nested inside `A`.

```css
div p {
  color: red;
}

#test p {
  color: blue;
}
```

#### Child Combinator

- **Format**: `A > B`
- **Definition**: Select all `B` that are only direct children of `A`.

```css
div > p {
  color: blue;
}
```

#### Adjacent Siblings

- **Format**: `A + B`
- **Definition**: Select one instance of `B` only if it immediately follows `A` and both share a parent.

```css
img + p {
  font-weight: bold;
}
```

#### General Siblings

- **Format**: `A ~ B`
- **Definition**: Select all instances of `B` that follow `A` (not necessarily immediately), where `A` and `B` share a parent.

```css
img ~ p {
  color: red;
}
```

### Style Conflicts

- Different rulesets with different properties will "cascade".

```css
p {
  color: red;
}

p {
  font-weight: bold;
}
```

- If the same rulesets are used the latter will so overwrite the former.

```css
p {
  color: red;
}

p {
  color: blue;
}
```

- Styles can be inherited from parents.
- However, selectors with higher *selector specificity* will override those with lower. However, this is only considered when we have conflicting selectors for the same element.
- Selector specificity ranking: inline > id > class > element.

```css
/* p tag with id=text will be color blue. */
#text {
  color: blue;
}

p {
  color: red;
}
```

## Lecture 5 (3 Apr)

- **`text-align: center;`**: Center elements within the container holding the element.
- Block level elements take up the entire width of the page and height of the content.
- Inline level elmeents take up the width and height of the content.

### Box Model Properties

- **Margin**: Space between element and neightbor.
- **Border**: Requires style, width, and color.
- **Padding**: Space between the content and the border.

### Flexbox

- Check out [this](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) guide.
- Elements are either *containers* or *items*.
  - **Container**: The direct parent of elements which you want to control.
  - **Items**: The nested items which you want to control the layout for.
- We will set the styles on the containers.

```css
.flex-container {
  display: flex;
}
```

- `flex-direction`: Defines the direction of the main axis.
- `flex-wrap`: Defines how items wrap.
- `justify-content`: Defines spacing along main-axis.
- `align-items`: Defines how items are spaced along the cross-axis.
- `gap`: Controls space around flex items.

## Lecture 6 (5 Apr)

### CSS Pseudoselectors

- `:hover`: Allows changes on mouse hover.
- We don't need to have `:hover` be on the last element. E.g. in the snippet below when we hover over `<article>`, changes are made to `<img>`.

```css
article:hover img {
  width: 100px;
}
```

### JavaScript

- **Client-Side Scripting**: Code which runs on the user's browser without needing internet.

#### Variables

- `const`: Keyword define constant variables that cannot be changed.
- `let`: Block-scoped; Only available in the block of code it is defined.
- `var`: Global-scoped; Available everywhere. We don't use `var`.

#### Equality

- Use `===` instead of `==` for strict equality.

#### Special Values

- `null`: Similar to `null` in Java or `None` in Python.
- `undefined`: When a variable hasn't been assigned yet.

#### Truthy & Falsey Values

- Numbers have truthy values:

```javascript
if (13) {
  console.log("hi");
}
```

- However, empty arrays have truthy values too.
- `undefined` and `null` have falsely values.
