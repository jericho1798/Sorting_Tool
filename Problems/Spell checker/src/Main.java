import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
       // Set<String> arrayList = Set.of();
        Set<String> dictionary = new HashSet<>();
        Set<String> text = new LinkedHashSet<>();
        int d = in.nextInt();
        int l;
        int i = 0;
        while(i < d) {
            arrayList.add(in.next().toLowerCase());
            i++;
        }
        dictionary.addAll(arrayList);
        l = in.nextInt();
        for(int j = 0; j < l; j++){
            arrayList.clear();
            while(in.hasNext()) {
                arrayList.add(in.next().toLowerCase());
                i++;
            }
            for(String s : arrayList) {
                if(!dictionary.contains(s)){
                    text.add(s);
                }
            }
        }
        text.forEach(System.out::println);
    }
}