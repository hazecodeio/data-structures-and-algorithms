package org.hsmak.datastructures.tree;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrieTest {
    @Test
    public void whenEmptyTrie_thenNoElements() {
        Trie trie = new Trie();

        assertThat(trie.isEmpty()).isTrue();
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieNotEmpty() {
        Trie trie = createExampleTrie();

        assertThat(trie.isEmpty()).isFalse();
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieHasThoseElements() {
        Trie trie = createExampleTrie();

        assertThat(trie.containsNode("3")).isFalse();
        assertThat(trie.containsNode("vida")).isFalse();

        assertThat(trie.containsNode("Programming")).isTrue();
        assertThat(trie.containsNode("is")).isTrue();
        assertThat(trie.containsNode("a")).isTrue();
        assertThat(trie.containsNode("way")).isTrue();
        assertThat(trie.containsNode("of")).isTrue();
        assertThat(trie.containsNode("life")).isTrue();
    }

    @Test
    public void givenATrie_whenLookingForNonExistingElement_thenReturnsFalse() {
        Trie trie = createExampleTrie();

        assertThat(trie.containsNode("99")).isFalse();
    }

    @Test
    public void givenATrie_whenDeletingElements_thenTreeDoesNotContainThoseElements() {

        Trie trie = createExampleTrie();

        assertThat(trie.containsNode("Programming")).isTrue();
        trie.delete("Programming");
        assertThat(trie.containsNode("Programming")).isFalse();
    }

    @Test
    public void givenATrie_whenDeletingOverlappingElements_thenDontDeleteSubElement() {

        Trie trie1 = new Trie();

        trie1.insert("pie");
        trie1.insert("pies");

        trie1.delete("pies");

        assertThat(trie1.containsNode("pie")).isTrue();
    }

    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        return trie;
    }

}