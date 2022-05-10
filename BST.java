package assyn2;
import java.util.Iterator;
public class BST<K extends Comparable <K>,V> implements Iterable<K> {
    private Node root;
    private static class Node<K extends Comparable<K>,V>{
        private K key;
        private V val;
        private Node<K,V> left, right;
        public Node(K key, V val) {
            this.key=key;
            this.val=val;
        }
        private Node<K,V> root;
        private int length;
        public void put(K key, V val) {
            Node<K, V> newNode=new Node<K, V>(key, val);
            root=put(root,newNode);
        }
        private Node<K,V> put(Node<K,V> current, Node<K,V> node){
            if(current==null) {
                length++;
                return node;
            }
            int cmp=node.key.compareTo(current.key);
            if(cmp>0) {
                current.right=put(current.right,node);
                current.length=current.right.length+1;
            }	else if(cmp<0) {
                current.left=put(current.left,node);
                current.length=current.left.length+1;
            }else {
                current.val=node.val;
            }
            current.length=( current.right==null ? 0 :current.right.length)
                    + (current.left==null ? 0 : current.left.length)+1;
            return current;
        }
        public int size() {
            return size(root);

        }
        private int size(Node<K,V> node) {
            return node==null ? 0 :node.length;
        }
        public V get(K key) {
            return get(root,key);
        }
        private V get(Node current, K key) {
            if(current==null)
                return null;
            if(current.key.compareTo(key)==0)
                return (V)current.val;
            if(current.key.compareTo(key)>0)
                return get(current.left,key);
            return get(current.right,key);
        }
        public MyLinkedList<K> keys(){
            MyLinkedList<K> current = new MyLinkedList<>();
            inorder(root,current);
            return current;
        }
        private void inorder(Node<K,V> node,MyLinkedList<K> current){
            if(node!=null){
                inorder(node.left,current);
                current.add(node.key);
                inorder(node.right,current);
            }
        }
        public void delete(K key){
            delete(root, key);
        }
        private Node delete(Node current, K key){
            if (current == null) return current;

            int compare = key.compareTo((K) current.key);

            if (compare < 0) current.left = delete(current.left, key);
            else if (compare > 0) current.right = delete(current.right, key);
            else {
                if (current.left == null) return current.right;
                else if (current.right == null) return current.left;

                current.key = min(current.right);
                current.right = delete(current.right, (K) current.key);
            }
            return current;
        }
        private K min(Node current){
            K min = (K) current.key;

            while(current.left != null){
                min = (K) current.left.key;
                current = current.left;
            }

            return min;
        }

        public Iterable<K> iterator(){
            Iterator<K> I = (Iterator<K>) keys();
            return (Iterable<K>) I;
        }
    }
    @Override
    public Iterator<K> iterator() {
        return null;
    }
}