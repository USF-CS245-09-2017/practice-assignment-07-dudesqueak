/*
The ArrayList class extends AbstractList and implements the List interface.
 ArrayList supports dynamic arrays that can grow as needed.
 Standard Java arrays are of a fixed length.
 */


public class ArrayList <T> implements List<T> {
    private Object[] items;
    private int size;
    public ArrayList(){
        items = new Object[10];
    }

    @Override
    public void add(T item) {
        if(items.length == size){
            Object[] temp = new Object[2*size];
            for(int i = 0; i < size; i++){
                temp[i] = items[i];
            }
            items = temp;
        }
        items[size] = item;
        size ++;
    }

    public void add(int pos, T item){
        if(items.length == size){
            Object[] temp = new Object[2*size];
            for(int i = 0; i < size; i++){
                temp[i] = items[i];
            }
            items = temp;
        }

        size ++;
        for(int i = size-1; i > pos; i++){
            items[i] = items[i-1];

        }
        items[pos] = item;

    }

    public T get(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException();
        }
        return (T) items[pos];
    }

    public T remove(int pos){
        T element = get(pos);
        for (int i=pos; i<size-1; i++) {
            items[i] = items[i+1];
        }
        size--;
        return element;
    }

    public int size(){
        return size;
    }

}
