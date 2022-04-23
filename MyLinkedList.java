package assyn2;
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
        MyNode(MyNode<T> prev, T data, MyNode<T> next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        int count = 0;
        MyNode<T> current = head;
        while (count != index){
            current = current.next;
            count++;
        }
        MyNode<T> prevNode = current.prev;
        prevNode.next = newNode;
        newNode.next = current;

        length++;
    }
    @Override
    public boolean remove(T item) {
        boolean flag = true;
        MyNode<T> current = head;
        if(current.next == null){
            removeLast();
        }
        while (current.next != null){
            if(current.data.equals(item)){
                if(current.prev == null){
                    removeFirst();
                    flag = false;
                }
                else {
                    MyNode<T> prevNode = current.prev;
                    MyNode<T> nextNode = current.next;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    flag = false;
                    length--;
                    break;
                }
            }
            current = current.next;
        }

        return flag;

    }


    @Override
    public T remove(int index) {
        MyNode<T> current = head;

        int count = 0;

        while (current.next != null){
            if(count == index){
                if(current.prev == null){
                    removeFirst();
                    break;
                }
                else if(current.next == null){
                    removeLast();
                    break;
                }
                else{
                    MyNode<T> prevNode = current.prev;
                    MyNode<T> nextNode = current.next;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    break;
                }
            }
            current = current.next;
            count++;
        }

        length--;
        return (T)current.data;
    }

    @Override
    public void clear() {
        head.next = null;
        tail.prev = null;
        head = tail = null;
        length = 0;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> current = head;
        int index = -1;
        int count = 0;
        while (current != null){
            if(current.data.equals(o)){
                index = count;
                break;
            }
            current = current.next;
            count++;
        }
        if(index == -1){
            System.out.println("There is no such "+o.getClass().getSimpleName());
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> current = head;
        int index = -1;
        int count = 0;
        while (current != null){
            if(current.data.equals(o)){
                index = count;
            }
            current = current.next;
            count++;
        }
        if(index == -1){
            System.out.println("There is no such "+o.getClass().getSimpleName());
        }
        return index;

    }

    @Override
    public void sort() {
        if (length > 1) {
            boolean wasChanged;

            do {
                MyNode<T> current = head;
                MyNode<T> previous = null;
                MyNode<T> next = head.next;
                wasChanged = false;

                while ( next != null ) {
                    if (current.data.compareTo(next.data) > 0) {
                        wasChanged = true;

                        if ( previous != null ) {
                            MyNode<T> temp= next.next;

                            previous.next = next;
                            next.next = current;
                            current.next = temp;
                        } else {
                            MyNode<T> temp = next.next;

                            head = next;
                            next.next = current;
                            current.next = temp;
                        }

                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while( wasChanged );
        }
    }



    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = false;
        MyNode<T> current = head;
        while (current.next != null){
            if(current.data.equals(o)){
                flag = true;
            }
            current = current.next;
        }
        return flag;
    }

    public void removeFirst(){
        head = head.next;
        length--;
    }

    public void removeLast(){
        tail = tail.prev;
        length--;
    }

}