# Huffman Coding

## Objective

- Implement Huffman Coding algorithm.

## Implementation

### `HuffmanCode`

- **`public HuffmanCode(int[] frequencies)`**
  - This constructor should initialize a new HuffmanCode object using the algorithm described above for building a Huffman code from an array of frequencies. frequencies is an array of frequencies where frequences[i] is the count of the character with ASCII value i.
  - If there exists a character with a frequency <= 0, the character should not be included in the HuffmanCode object.
- **`public HuffmanCode(Scanner input)`**
  - This constructor should initialize a new HuffmanCode object by reading in a previously constructed code from a .code file.
- **`public void save(PrintStream output)`**
  - This method should store the current Huffman Code to the given output stream in the standard format.
- **`public void translate(BitInputStream input, PrintStream output)`**
  - This method should read individual bits from the input stream and write the corresponding characters to the output. It should stop reading when the BitInputStream is empty. You may assume that the input stream contains a legal encoding of characters for this tree’s Huffman Code.

- **`HuffmanNode`**
