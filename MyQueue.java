package assyn2;
public class MyQueue<T extends Comparable<T>> {
    MyArrayList<T> arr = new MyArrayList<>();
    public boolean isEmpty(){
        if(arr.size()==0)
            return true;
        else
            return false;
    }

    public int size(){
        return arr.size();
    }

    public T peek(){
        if(arr.size()==0){
            return null;
        }
        return arr.get(0);
    }

    public T enqueue(T item){
        arr.add(item);
        return arr.get(size()-1);
    }

    public T dequeue(){
        if(arr.size()==0){
            return null;
        }
        T item = arr.get(0);
        arr.remove(0);
        return item;
    }

}