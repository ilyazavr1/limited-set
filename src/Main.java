import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        MyLimitedSet<Integer> set = new MyLimitedSet<>();
        test1();
    }


    // Tests perform actions on the 'set'
    // prints entry set of MyLimitedSet 'set' [T = counter of contains(T);]
    public static void test2() {
        MyLimitedSet<String> set = new MyLimitedSet<>();

        for (int i = 1; i < 11; i++) {
            set.add(String.valueOf(i));
        }
        set.contains("1");
        set.add("11");
        set.print();
        set.remove("3");
        set.print();
        set.add("42");
        set.add("452");
        set.print();
        set.add("423");
        set.print();

    }

    public static void test1() {
        MyLimitedSet<Integer> set = new MyLimitedSet<>(15);
        for (int i = 1; i < 16; i++) {
            set.add(i);
        }
        for (int i = 1; i < 16; i++) {
            set.contains(i);
        }

        set.contains(5);
        set.contains(5);
        set.contains(5);
        set.contains(5);
        set.contains(5);
        set.print();
        set.add(23);
        set.contains(23);
        set.print();
        set.add(100);

        set.print();

    }

}
