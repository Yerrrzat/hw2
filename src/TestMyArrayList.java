public class TestMyArrayList {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        assertTest("isEmpty on new list", list.isEmpty(), true);
        assertTest("size on new list", list.size(), 0);

        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(30);
        assertTest("getFirst after adds", list.getFirst(), 5);
        assertTest("getLast after adds", list.getLast(), 30);
        assertTest("size after adds", list.size(), 4);


        assertTest("get(1)", list.get(1), 10);
        list.set(1, 15);
        assertTest("get(1) after set", list.get(1), 15);


        list.add(15);
        assertTest("indexOf(15)", list.indexOf(15), 1);
        assertTest("lastIndexOf(15)", list.lastIndexOf(15), 4);
        assertTest("exists(20)", list.exists(20), true);
        assertTest("exists(100)", list.exists(100), false);


        Object[] arr = list.toArray();
        assertTest("toArray length", arr.length, list.size());
        assertTest("toArray[2]", arr[2], 20);


        list.remove(2);
        assertTest("size after remove(2)", list.size(), 4);
        list.removeFirst();
        list.removeLast();
        assertTest("final list contents", list.get(0) + "," + list.get(1), "15,30");


        list.clear();
        assertTest("isEmpty after clear", list.isEmpty(), true);


        MyList<String> sList = new MyArrayList<>();
        sList.add("banana");
        sList.add("apple");
        sList.add("cherry");
        sList.sort();
        assertTest("sort[0]", sList.get(0), "apple");
        assertTest("sort[2]", sList.get(2), "cherry");

        System.out.println("Все тесты выполнены.");
    }

    private static void assertTest(String name, boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.printf("%-30s PASS%n", name);
        } else {
            System.out.printf("%-30s FAIL (got %s, expected %s)%n", name, actual, expected);
        }
    }

    private static <T> void assertTest(String name, T actual, T expected) {
        boolean pass = (actual == null ? expected == null : actual.equals(expected));
        if (pass) {
            System.out.printf("%-30s PASS%n", name);
        } else {
            System.out.printf("%-30s FAIL (got %s, expected %s)%n", name, actual, expected);
        }
    }
}
