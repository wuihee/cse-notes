# Lecture 4 (1 Apr)

- **The Document Object Model (DOM)**: Describes the hierarchy of a webpage - how tags are ranked (i.e. nested).

## Selector Combinations

### Descendent Combinator

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

### Child Combinator

- **Format**: `A > B`
- **Definition**: Select all `B` that are only direct children of `A`.

```css
div > p {
  color: blue;
}
```

### Adjacent Siblings

- **Format**: `A + B`
- **Definition**: Select one instance of `B` only if it immediately follows `A` and both share a parent.

```css
img + p {
  font-weight: bold;
}
```

### General Siblings

- **Format**: `A ~ B`
- **Definition**: Select all instances of `B` that follow `A` (not necessarily immediately), where `A` and `B` share a parent.

```css
img ~ p {
  color: red;
}
```

## Style Conflicts

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
