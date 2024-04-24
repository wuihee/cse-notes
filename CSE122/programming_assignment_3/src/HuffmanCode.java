// Wuihee 
// 12/06/2023
// CSE 123 
// P3: Huffman Coding
// TA: Heon Jwa

import java.util.*;
import java.io.*;

/**
 * HuffmanCode class which is used for compressing and decompressing data using Huffman Coding.
 */
public class HuffmanCode {

    // Fields
    HuffmanNode root;

    /**
     * Instantiate HuffmanCode with an array of character frequencies.
     * 
     * @param frequencies Where frequencies[i] is the count of the character with ASCII value i.
     */
    public HuffmanCode(int[] frequencies) {
        root = encode(frequencies);
    }

    /**
     * Create a huffman encoding from the given frequencies.
     * 
     * @return The root node of the Huffman tree.
     */
    private HuffmanNode encode(int[] frequencies) {
        Queue<HuffmanNode> queue = new PriorityQueue<>();
        for (int ascii = 0; ascii < frequencies.length; ascii++) {
            if (frequencies[ascii] != 0) {
                queue.add(new HuffmanNode(frequencies[ascii], ascii));
            }
        }

        while (queue.size() > 1) {
            HuffmanNode leftNode = queue.poll();
            HuffmanNode rightNode = queue.poll();
            HuffmanNode newNode = new HuffmanNode(
                leftNode, rightNode, leftNode.frequency + rightNode.frequency
            );
            queue.add(newNode);
        }

        return queue.poll();
    }

    /**
     * Initialize HuffmanCode by reading a previously constructed code from a .code file.
     * @param input Scanner object to read .code file.
     */
    public HuffmanCode(Scanner input) {
        root = constructHuffmanTree(input);
    }

    /**
     * Read Huffman encoding from given .code file.
     * 
     * @param input Scanner object to .code file.
     * @return The root node of the Huffman tree.
     */
    private HuffmanNode constructHuffmanTree(Scanner input) {
        root = new HuffmanNode();
        while (input.hasNext()) {
            int ascii = Integer.parseInt(input.next());
            String code = input.next();
            addNode(code, ascii, root, 0);
        }
        return root;
    }

    /**
     * Recursive helper method to add nodes to the Huffman tree.
     * 
     * @param code The Huffman encoding.
     * @param ascii The ASCII value of the node to add.
     * @param node The current node in traversal.
     * @param index The current index position in the Huffman encoding.
     */
    private void addNode(String code, int ascii, HuffmanNode node, int index) {
        if (index == code.length()) {
            node.value = ascii;
        } else {
            if (code.charAt(index) == '0') {
                if (node.left == null) {
                    node.left = new HuffmanNode();
                }
                addNode(code, ascii, node.left, index + 1);
            } else {
                if (node.right == null) {
                    node.right = new HuffmanNode();
                }
                addNode(code, ascii, node.right, index + 1);
            }
        }
    }

    /**
     * Stores the current Huffman Code to the given output stream, where each character encoding
     * is represented with 2 lines - the first line being the ASCII code of the character and the
     * second line being the Huffman encoding.
     * 
     * @param output
     */
    public void save(PrintStream output) {
        save(output, root, "");
    }

    /**
     * Recursive helper method to save a Huffman encoding into a given output stream.
     * 
     * @param output Given output stream.
     * @param node The current node.
     * @param encoding The encoding of the current character.
     */
    private void save(PrintStream output, HuffmanNode node, String encoding) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                output.println(node.value);
                output.println(encoding);
            } 
            if (node.left != null) {
                save(output, node.left, encoding + "0");
            }
            if (node.right != null) {
                save(output, node.right, encoding + "1");
            }
        }
    }

    /**
     * Read individual bits from the input stream and decode the corresponding characters to the output.
     * 
     * @param input The input stream.
     * @param output The output to print decoded bits.
     */
    public void translate(BitInputStream input, PrintStream output) {
        HuffmanNode trav = root;
        while (input.hasNextBit()) {
            if (trav.left == null && trav.right == null) {
                output.write((char) trav.value);
                trav = root;
            } else {
                int bit = input.nextBit();
                if (bit == 0) {
                    trav = trav.left;
                } else {
                    trav = trav.right;
                }
            }
        }
        output.print((char) trav.value);
    }

    /**
     * HuffmanNode class representing a node in the Huffman tree.
     */
    private static class HuffmanNode implements Comparable<HuffmanNode> {

        // Fields
        HuffmanNode left;
        HuffmanNode right;
        int frequency;
        int value;

        /**
         * Instantiate HuffmanNode with a frequency and value.
         * 
         * @param left The left child.
         * @param right The right child.
         * @param frequency The frequency which the given value occurs.
         * @param value The ASCII value of the given character.
         */
        public HuffmanNode(HuffmanNode left, HuffmanNode right, int frequency, int value) {
            this.left = left;
            this.right = right;
            this.frequency = frequency;
            this.value = value;
        }

        /**
         * Instantiate an combined HuffmanNode with no value.
         * 
         * @param left The left child.
         * @param right The right child.
         * @param frequency The combined frequency of two other nodes.
         */
        public HuffmanNode(HuffmanNode left, HuffmanNode right, int frequency) {
            this(left, right, frequency, -1);
        }

        /**
         * Instantiate a HuffmanNode leaf with no children.
         * 
         * @param frequency The frequency which the given value occurs.
         * @param value The ASCII value of the given character.
         */
        public HuffmanNode(int frequency, int value) {
            this(null, null, frequency, value);
        }

        /**
         * Initialize an empty HuffmanHode.
         */
        public HuffmanNode() {
            this(null, null, 0, -1);
        }

        /**
         * compareTo method required by Comparable interface that dictates that HuffmanNodes are
         * compared to each other in order of ascending frequency.
         */
        @Override
        public int compareTo(HuffmanNode other) {
            return frequency - other.frequency;
        }
    }
}
