import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        SortedMap<Integer, String> in = new TreeMap<>(map.descendingMap());
        Map<Integer, String> out = new LinkedHashMap<>();
        if (in.lastKey() % 2 != 0) {
            in.forEach((key, value) -> {
                out.putAll(in.subMap(in.lastKey() + 4, in.lastKey() - 1));
            });
        } else {
            in.forEach((key, value) -> {
                out.putAll(in.subMap(in.firstKey(), in.firstKey() - 5));
            });
        }
        return out;
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
