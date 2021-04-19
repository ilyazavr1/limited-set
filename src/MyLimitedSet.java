import java.util.HashMap;
import java.util.Map;

public class MyLimitedSet<T> implements LimetedSet<T> {
    //HashMap takes 'T' and Integer that stores calls to 'T'
    private final HashMap<T, Integer> hashMap;

    public MyLimitedSet() {
        hashMap = new HashMap<>(10);
    }

    //before putt it check:
    // 1 if - (limit_size(10) and presence of input T)
    //remove(findeMinCalls()) finds min calls to 'T' and removes it
    //calls to 'T' counts in method contains()
    // 2 if - puts 'T'
    @Override
    public void add(T t) {
        if (hashMap.size() == 10 && !hashMap.containsKey(t)) {
            remove(findeMinCalls());
        }
        if (!hashMap.containsKey(t)) {
            hashMap.put(t, 0);
        }
    }

    @Override
    public boolean remove(T t) {
        if (hashMap.get(t) != null) {
            hashMap.remove(t);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T t) {
        if (hashMap.get(t) != null) {
            int temp = hashMap.get(t) + 1;
            hashMap.put(t, temp);
            return hashMap.containsKey(t);
        }
        return false;
    }
    //findes 'T' with min calls and returns it
    //removes first found 'T' with min calls if set has similar calls
    private T findeMinCalls() {
        int min = Integer.MAX_VALUE;
        T toReturn = null;
        for (Map.Entry<T, Integer> pair : hashMap.entrySet()) {
            if (pair.getValue() < min) {
                min = pair.getValue();
                toReturn = pair.getKey();
            }
        }
        return toReturn;
    }
    //for test my test in main
    public void print() {
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.size());
    }
}
