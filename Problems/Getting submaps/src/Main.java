import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SortedMap<Integer, String> map = new TreeMap<>();
        Map<Integer, String> out = new TreeMap<>();
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            map.put(in.nextInt(), in.next());
        }
        out.putAll(map.subMap(a, b + 1));
        out.forEach((key, value) -> System.out.println(key + " " + value));
    }
}