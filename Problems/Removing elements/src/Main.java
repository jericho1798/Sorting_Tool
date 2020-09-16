import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        Set <Integer> set = new TreeSet<>();
        Set <String> sest = Set.of(str.split("\\s+"));
        sest.forEach(e -> set.add(Integer.parseInt(e)));
        return set;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        SortedSet<Integer> sortedSet = new TreeSet<>(set);
        set.clear();
        set.addAll(sortedSet.headSet(11));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}