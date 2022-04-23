package assyn2;
public class MyHeap<T extends Comparable<T>> {
    MyArrayList<T> arr = new MyArrayList<>();

    public void add(T item){
        arr.add(item);
    }
    public T removeRoot(){
        heapify();
        T item = arr.get(0);
        arr.remove(0);
        arr.add(arr.get(arr.size()-2),0);
        arr.remove(arr.size()-2);
        heapify();
        return item;
    }

    public boolean remove(T item){
        int index = arr.indexOf(item);
        arr.remove(index);
        if(arr.contains(item))
            return false;
        else
            return true;
    }

    private void heapify(){
        int i = 0;
        int j = 0;
        while (j<arr.size()){
            i=0;
            while(i<arr.size()) {
                if (leftChildIndex(i) < arr.size()) {
                    if (arr.get(i).compareTo(arr.get(leftChildIndex(i))) > 0) {
                        swap(i, leftChildIndex(i));
                    }
                }
                if (rightChildIndex(i) < arr.size()) {
                    if (arr.get(i).compareTo(arr.get(rightChildIndex(i))) > 0) {
                        swap(i, rightChildIndex(i));
                    }
                }
                if(((i-2)/2)>0){
                    if (arr.get(i).compareTo(arr.get((i-2)/2))<0){
                        swap(i,(i-2)/2);
                    }
                }
                i++;
            }
            j++;
        }

    }

    public int size(){
        return arr.size();
    }

    private void swap(int a, int b) {
        Object swap = arr.get(a);
        Object swap1 = arr.get(b);
        arr.remove(a);
        arr.add(arr.get(b-1),a);
        arr.remove(b);
        arr.add((T)swap,b);
    }

    private int leftChildIndex(int index){
        return (2*index)+1;
    }
    private int rightChildIndex(int index){
        return (2*index)+2;
    }

}