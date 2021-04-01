package org.hsmak.datastructures.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * A Trie (also known as digital tree) is an ordered tree structure used commonly for storing strings. Its name comes from the fact that Trie is reTrieval data structure.
 * Its performance is better than a binary tree.
 * Except for the root of the Trie, every node of a Trie contains a single character (for example, for the word hey, there will be three nodes).
 * Mainly, each node of a Trie contains the following:
 *      - A value (a character, or a digit)
 *      - Pointers to children nodes
 *      - A flag that is true if the current node completes a word
 *      - A single root used for branching nodes
 */
public class Trie {

    TrieNode root;

    /*
     * Consider the current node as the root.
     *   - Loop the given word character by character, starting from the first character.
     *   - If the current node (the Map<Character, Node>) maps a value (a Node) for the current character,
     *       - then simply advance to this node. Otherwise, create a new Node, set its character equal to the current character, and advance to this node.
     *   - Repeat from step 2 (pass to next character) until the end of the word.
     *   - Mark the current node as a node that completes the word.
     */
    void insert(String word) {
        if (root == null)
            root = new TrieNode();

        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    boolean delete(String word) {
        return delete(root, word, 0);
    }

    /*
     * Consider the current node as the root.
     *   - Loop the given word character by character (start from the first character).
     *   - For each character, check its presence in the Trie (in Map<Character, Node>).
     *   - If a character is not present, then return false.
     *   - Repeat from step 2 until the end of the word.
     *   - At the end of the word, return true if this was a word, or false if it was just a prefix.
     */
    boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    boolean isEmpty() {
        return root == null;
    }

    /*
     * Verify whether the given word is part of the Trie.
     *   - If it is part of the Trie, then simply remove it.
     *   - Deletion takes place in a bottom-up manner using recursion and following these rules:
     *
     *   - If the given word is not in the Trie, then nothing happens (return false)
     *   - If the given word is unique (not part of another word), then delete all corresponding nodes (return true)
     *   - If the given word is a prefix of another long word in the Trie, then set the leaf node flag to false (return false)
     *   - If the given word has at least another word as a prefix,
     *      - then delete the corresponding nodes from the end of the given word until the first leaf node of the longest prefix word (return false)
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        private boolean endOfWord;

        Map<Character, TrieNode> getChildren() {
            return children;
        }

        boolean isEndOfWord() {
            return endOfWord;
        }

        void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }
    }
}
