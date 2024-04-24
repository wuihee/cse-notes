// Wuihee 
// 11/23/2023
// CSE 123 
// C3: BrettFeed Quiz
// TA: Heon Jwa

import java.io.*;
import java.util.*;

/**
 * QuizzTree class uses a Binary Tree to represent the BrettFeed Quiz.
 */
public class QuizTree {

    // Fields
    QuizTreeNode overallRoot;

    /**
     * Instantiate QuizTree from an text file dictating the quiz structure.
     * @param inputFile The input file containing the information for the quiz structure.
     */
    public QuizTree(Scanner inputFile) {
        Queue<QuizTreeNode> binaryTree = new LinkedList<>();
        while (inputFile.hasNextLine()) {
            binaryTree.add(new QuizTreeNode(inputFile.nextLine()));
        }
        overallRoot = buildTree(binaryTree);
    }

    /**
     * Recursive helper method to build the quiz's binary tree given a pre-order ArrayList of
     * QuizTreeNodes.
     * 
     * @param binaryTree A Queue of QuizTreeNodes representing the Binary Tree in pre-order
     *                   traversal.
     */
    private QuizTreeNode buildTree(Queue<QuizTreeNode> binaryTree) {
        if (!binaryTree.isEmpty()) {
            QuizTreeNode node = binaryTree.poll();

            if (isEndNode(node)) {
                return node;
            }

            node.left = buildTree(binaryTree);
            node.right = buildTree(binaryTree);
            return node;
        }

        return null;
    }

    /**
     * Method to allow user to take the quiz.
     * 
     * @param console Scanner object that reads the user's response.
     */
    public void takeQuiz(Scanner console) {
        QuizTreeNode node = overallRoot;

        while (!isEndNode(node)) {
            String[] nodeValues = node.value.split("/");
            String left = nodeValues[0];
            String right = nodeValues[1];
            System.out.print("Do you prefer " + left + " or " + right + "? ");

            String userChoice = console.nextLine().toLowerCase();
            if (userChoice.equals(left)) {
                node = node.left;
            } else if (userChoice.equals(right)) {
                node = node.right;
            } else {
                System.out.println("Invalid response; try again.");
            }
        }
        System.out.println("Your result is: " + node.value.substring(4));
    }

    /**
     * Helper method to check if node is an end node.
     * 
     * @param node Node to check.
     * @return True if the node is an end node, otherwise false.
     */
    private boolean isEndNode(QuizTreeNode node) {
        return (node.value.indexOf(":") != -1);
    }

    /**
     * Print the current quiz to the provided output file.
     * 
     * @param outputFile The output file provided.
     */
    public void export(PrintStream outputFile) {
        export(outputFile, overallRoot);
    }

    /**
     * Helper method to recursively print the tree to a given output file.
     * 
     * @param outputFile The output file provided.
     * @param node The current node.
     */
    private void export(PrintStream outputFile, QuizTreeNode node) {
        if (node != null) {
            outputFile.println(node.value);
            export(outputFile, node.left);
            export(outputFile, node.right);
        }
    }

    /**
     * Replace the node for the result toReplace with a new node representing a choice between
     * leftChoice and rightChoice leading to leftResult and rightResult respectively.
     * 
     * @param toReplace The node value to replace.
     * @param leftChoice The left choice of the new choice.
     * @param rightChoice The right choice of the new choice.
     * @param leftResult The left result of the new choice.
     * @param rightResult The right result of the new choice.
     */
    public void addQuestion(String toReplace, String leftChoice, String rightChoice,
                            String leftResult, String rightResult) {
        QuizTreeNode leftChild = new QuizTreeNode("END:" + leftResult);
        QuizTreeNode rightChild = new QuizTreeNode("END:" + rightResult);
        QuizTreeNode newNode = new QuizTreeNode(leftChoice + "/" + rightChoice, leftChild,
                                                rightChild);
        replace(toReplace.toLowerCase(), newNode, overallRoot);
    }

    /**
     * Method to assist addQuestion in adding a new choice.
     * 
     * @param toReplace The node ot replace.
     * @param newNode The new node to replace with.
     * @param node The current node.
     */
    private void replace(String toReplace, QuizTreeNode newNode, QuizTreeNode node) {
        if (node != null) {
            if (shouldReplace(node.left, toReplace)) {
                node.left = newNode;
            } else if (shouldReplace(node.right, toReplace)) {
                node.right = newNode;
            } else {
                replace(toReplace, newNode, node.left);
                replace(toReplace, newNode, node.right);
            }
        }
    }

    /**
     * Helper method for replace method to check if node should be replaced.
     * 
     * @param node The node being checked.
     * @param toReplace The value of the node taht should be replaced.
     * @return True if node should be replaced, else false.
     */
    private boolean shouldReplace(QuizTreeNode node, String toReplace) {
        return (node != null && isEndNode(node) &&
                node.value.substring(4).toLowerCase().equals(toReplace));
    }

    /**
     * QuizTreeNode class represents a node in the binary tree data structure that represents the
     * quiz.
     */
    public static class QuizTreeNode {

        // Fields
        String value;
        QuizTreeNode left;
        QuizTreeNode right;

        /**
         * Construct a QuizTreeNode object with a value and its left and right children.
         * 
         * @param value The value of the node.
         * @param left The left child of the node.
         * @param right The right child of the node.
         */
        public QuizTreeNode(String value, QuizTreeNode left, QuizTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * Construct a QuizTreeNode object with a value and no children.
         * 
         * @param value The value of the node.
         */
        public QuizTreeNode(String value) {
            this(value, null, null);
        }

        /**
         * Construct an empty QuizTreeNode.
         */
        public QuizTreeNode() {
            this(null);
        }
    }
}
