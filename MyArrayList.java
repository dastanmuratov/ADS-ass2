package assyn2;
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;
    public MyArrayList() {
        arr = new Object[capacity];
    }

    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if(index>length){
            throw new IndexOutOfBoundsException("position is not allowed");
        }

        if(length==capacity){
            increaseCapacity();
        }

        for(int i = length;i>index;i--){
            arr[i] = arr[i-1];
        }

        arr[index]=item;
        length++;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    @Override
    public boolean remove(T item) {
        for(int i=0;i<length;i++){
            if(arr[i]==item){
                arr[i]=null;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T removedItem = (T)arr[index];
        for (int i=index;i<size()-1;i++){
            arr[i]=arr[i+1];
        }
        length--;
        return removedItem;
    }

    @Override
    public void clear() {

        for (int i = 0; i < length; i++)
            arr[i] = null;

        length = 0;
    }

    public T get(int index) {
        return (T)arr[index];
    }
    @Override
    public int indexOf(Object o) {
        int index=-1;
        for(int i=0;i<length;i++){
            if(arr[i].equals(o)){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("There is no such "+o.getClass().getSimpleName());
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index=-1;
        for(int i=length-1;i>=0;i--){
            if(arr[i].equals(o)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("There is no such "+o.getClass().getSimpleName());
        }
        return index;
    }

    @Override
    public void sort() {
        int n = length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                T a = (T) arr[j];
                T b = (T) arr[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = false;
        for(int i=0;i<length;i++){
            if(arr[i].equals(o)){
                flag = true;
            }
        }
        return flag;
    }
    public Object clone(){
        Object[] cloned = new Object[length];
        for(int i = 0;i < length;i++){
            cloned[i]=arr[i];
        }
        return cloned;
    }
    public boolean addAll(MyArrayList<T> col){
        boolean flag = false;
        for(int i = 0;i < col.length;i++){
            if (length == capacity)
                increaseCapacity();

            arr[length++] = col.get(i);
            flag = true;
        }
        return flag;
    }

}