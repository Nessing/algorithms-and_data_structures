package ru.nessing.hash_table;

class HashNode<K, V> {
    K key;
    V value;

    //Reference to next node
    HashNode<K, V> next;

    //Constructor
    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "HashNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
