# Lecture 5 (3 Apr)

- **`text-align: center;`**: Center elements within the container holding the element.
- Block level elements take up the entire width of the page and height of the content.
- Inline level elmeents take up the width and height of the content.

## Box Model Properties

- **Margin**: Space between element and neightbor.
- **Border**: Requires style, width, and color.
- **Padding**: Space between the content and the border.

## Flexbox

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
