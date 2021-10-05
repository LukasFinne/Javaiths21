package se.iths.java21.arrays;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DynamicArray implements Iterable<Integer>{

    private int[] values = new int[10];
    private int count = 0;

    void add(int value) {
        if (count == values.length)
            grow();
        values[count] = value;
        count = count + 1;
    }

    private void grow() {
        //Create a new array with double size
        int[] newArray = new int[values.length * 2];
        //Copy data from old array to new array
        System.arraycopy(values, 0, newArray, 0, values.length);
        //Set values reference to point to new array in memory
        values = newArray;
    }

    int removeLast() {
        if (count == 0)
            return 0;
        return values[--count];
    }

    int length() {
        return count;
    }

    public int get(int i) {
        return values[i];
    }

    public int[] get() {
        return values;
    }
    public Spliterator<Integer> spliterator(){
        return new DynamicArraySpliterator();
    }

    public Stream<Integer> stream(){
        return StreamSupport.stream(spliterator(), false   );
    }


    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        dynamicArray.add(2);
        for (int value : dynamicArray)
            System.out.println(value);


        dynamicArray.stream().forEach(System.out::println);

    }

    private static void loopWithRiskOfException(DynamicArray dynamicArray)  {
        //Enhanced for-loop uses iterator
        Iterator<Integer> iterator = dynamicArray.iterator();

        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println(value);
        }
        throw new RuntimeException();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DynamicArrayIterator();
    }

    class DynamicArrayIterator implements Iterator<Integer> {

        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < count;
        }

        @Override
        public Integer next() {
            if (position >= count)
                throw new NoSuchElementException("Iterator next outside limits");
            return values[position++];
        }
    }

    class DynamicArraySpliterator implements Spliterator<Integer>{

        private int position = 0;


        @Override
        public boolean tryAdvance(Consumer<? super Integer> action) {
            if( position < count){
                action.accept(values[position]);
                position++;
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<Integer> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return count;
        }

        @Override
        public int characteristics() {
            return SIZED;
        }
    }

}
