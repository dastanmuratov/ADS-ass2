package assyn2;
public class MyStack<T extends Comparable<T>> {
    MyLinkedList<T> list = new MyLinkedList<T>();
    public T push(T item){
        list.add(item);
        return item;
    }
    public T peek(){
        return list.get(list.size()-1);
    }
    public T pop(){
        T removingItem = peek();
        list.removeLast();
        return removingItem;
    }
    public int size(){
        return list.size();
    }
    public int search(T item){
        return size()-list.indexOf(item);
    }
}