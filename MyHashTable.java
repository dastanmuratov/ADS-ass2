package assyn2;
public class MyHashTable<K,V> {
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key, V value) {
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString() {
            return "{"+key+" "+value+"}";
        }
    }
    private HashNode<K,V>[]chainArray;
    private int M=11;
    private int size=0;
    private float loadFactor=0.75F;
    public MyHashTable() {
        chainArray=new HashNode[M];
    }
    public MyHashTable(int initialcap) {
        int newcap=(int)(initialcap*loadFactor);
        if(newcap<1) {
            chainArray=new HashNode[M];
            return;
        }
        M=newcap;
        chainArray=new HashNode[M];
    }
    private int hash(K key) {
        return (key.hashCode()&0x7FFFFFFF) % M;
    }
    public void put(K key, V value) {
        HashNode<K,V> newNode=new HashNode<>(key,value);
        int index=hash(key);
        if(chainArray[index]==null) {
            chainArray[index]=newNode;
        } else {
            newNode.next=chainArray[index];
            chainArray[index]=newNode;
        }
        size++;
    }
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        if (current == null)
            return null;
        while (current != null){
            if (current.key == key){
                return current.value;
            }
            else{
                current = current.next;
            }
        }
        return null;
    }
    public V remove(K key) {
        V value = null;
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        if (current == null){
            return null;
        }
        if (current.key == key){
            chainArray[index] = current.next;
            value = current.value;
        }
        else{
            HashNode<K, V> prev = current;
            current = current.next;
            while (current != null){
                if (current.key == key){
                    value = current.value;
                    prev.next = current.next;
                    current.next = null;
                    break;
                }
                current = current.next;
            }
        }
        size--;
        return value;
    }
    public boolean contains(V value) {
        HashNode<K,V> node;
        for (int i =0;i<size;i++) {
            for (node = chainArray[i]; node != null; node = node.next) {
                if (node.value==value) {
                    return true;
                }
            }
        }
        return false;
    }
    public K getKey(V value) {
        HashNode<K,V> node;
        for (int i =0;i<size;i++) {
            for (node = chainArray[i]; node != null; node = node.next) {
                if (node.value==value) {
                    return node.key;
                }
            }
        }
        return null;
    }
}