import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MyLimitedSet<T> implements LimetedSet<T> {
    //HashMap takes 'T' and Integer that stores calls to 'T'
    private final HashMap<T, Integer> hashMap;
    private int size = 10;

    //default size 10
    public MyLimitedSet() {
        hashMap = new HashMap<>(size);
    }
    //takes input size
    public MyLimitedSet(int size) {
        hashMap = new HashMap<>(size);
        this.size = size;
    }

    //before putt it check:
    // 1 if - (limit_size(10) and presence of input T)
    //remove(findeMinCalls()) finds min calls to 'T' and removes it
    //calls to 'T' counts in method contains()
    // 2 if - puts 'T'
    @Override
    public void add(T t) {
        if (!hashMap.containsKey(t)) {
            if (hashMap.size() == size) {
                remove(findeMinCalls());
                hashMap.put(t, 0);
            }
            hashMap.put(t, 0);
        }
    }

    @Override
    public boolean remove(T t) {
        return hashMap.remove(t) != null;
    }

    @Override
    public boolean contains(T t) {
        if (hashMap.containsKey(t)) {
            hashMap.put(t, hashMap.get(t) + 1);
            return true;
        }
        return false;
    }


    //findes 'T' with min calls and returns it
    //removes first found 'T' with min calls if set has similar calls
    //if map is empty then returns null
    public T findeMinCalls() {
        try {
            return hashMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        } catch (NoSuchElementException e) {
            System.out.println("Set is empty.");
        }
        return null;
    }

    //for test my test in main
    public void print() {
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.size());
    }
}
