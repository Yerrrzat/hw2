public class TestMyLinkedList {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();

        // 1. size on new list
        assertTest("size on new list", list.size(), 0);

        // 2. add / addFirst / addLast
        list.add(10);
        list.add(20);
        list.addFirst(5);   // [5, 10, 20]
        list.addLast(30);   // [5, 10, 20, 30]
        assertTest("getFirst after adds", list.getFirst(), 5);
        assertTest("getLast after adds", list.getLast(), 30);
        assertTest("size after adds", list.size(), 4);

        // 3. get и set
        assertTest("get(1)", list.get(1), 10);
        list.set(1, 15);    // [5, 15, 20, 30]
        assertTest("get(1) after set", list.get(1), 15);

        // 4. indexOf, lastIndexOf, exists
        list.add(15);       // [5, 15, 20, 30, 15]
        assertTest("indexOf(15)", list.indexOf(15), 1);
        assertTest("lastIndexOf(15)", list.lastIndexOf(15), 4);
        assertTest("exists(20)", list.exists(20), true);
        assertTest("exists(100)", list.exists(100), false);

        // 5. toArray
        Object[] arr = list.toArray();
        assertTest("toArray length", arr.length, list.size());
        assertTest("toArray[2]", arr[2], 20);

        // 6. remove / removeFirst / removeLast
        list.remove(2);     // remove 20 → [5,15,30,15]
        assertTest("size after remove(2)", list.size(), 4);
        list.removeFirst(); // remove 5  → [15,30,15]
        list.removeLast();  // remove last 15 → [15,30]
        assertTest("final list contents", list.get(0) + "," + list.get(1), "15,30");

        // 7. clear
        list.clear();
        assertTest("size after clear", list.size(), 0);

        // 8. сортировка
        MyList<String> sList = new MyLinkedList<>();
        sList.add("banana");
        sList.add("apple");
        sList.add("cherry");
        sList.sort();       // [apple, banana, cherry]
        assertTest("sort[0]", sList.get(0), "apple");
        assertTest("sort[2]", sList.get(2), "cherry");

        System.out.println("All tests passed.");
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
