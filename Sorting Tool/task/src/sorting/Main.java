package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String name = "null";
    public static String inType = "normal";
    public static String outType = "normal";
    public static String oName = "null";
    public static void main(final String[] args) throws IOException {
        String type = "word";
        String sortingType = "natural";
        boolean br = false;
        boolean br1 = false;
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("-sortingType")) {
                if(i == args.length - 1) {
                    sortingType = "null";
                } else {
                    if (!args[i + 1].equals("-dataType")) {
                        sortingType = args[i + 1];
                        br = true;
                    }
                }
            }
            if(args[i].equals("-dataType")) {
                if(i == args.length - 1) {
                    type = "null";
                } else {
                    type = args[i + 1];
                    br1 = true;
                }
            }
            if(args[i].equals("-inputFile")) {
                inType = "damn";
                name = args[i + 1];
            }
            if(args[i].equals("-outputFile")) {
                outType = "damn";
                name = args[i + 1];
            }
        }
       if(br && br1) {
            for(int i = 4; i < args.length; i++){
                System.out.println("\"" + args[i] + "\" isn't a valid parameter. It's skipped.");
            }
        }

        switch (type) {
            case "word":
                wordType(sortingType);
                break;
            case "line":
                lineType(sortingType);
                break;
            case "long":
                sortLong (sortingType, inType, name, outType, oName);
                break;
            case "null":
                System.out.println("No data type defined");
                break;
            default: break;
        }
    }

    public static void wordType(String sortingType) throws IOException {
        List<String> list = new LinkedList<>();
        switch (inType) {
            case "normal":
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    list.add(word);
                }
                break;
            case "damn":
                File file = new File(name);
                try {
                    Scanner in = new Scanner(file);
                    while(in.hasNextLine()) {
                        list.add(String.valueOf(in.nextLine()));
                    }
                    in.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }

        sortString(list, sortingType, inType, name, outType, oName);
    }

    public static void lineType(String sortingType) throws IOException {
        List<String> list = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        sortString(list, sortingType, inType, name, outType, oName);
    }

    public static void sortLong(String sortingType, String inType, String name, String outType, String oName) throws IOException {
        FileWriter writer;
        List<Long> list = new LinkedList<>();
        switch (inType) {
            case "normal":
                while (scanner.hasNext()) {
                    if(scanner.hasNextInt()) {
                        long number = scanner.nextInt();
                        list.add(number);
                    } else {
                        System.out.println("\"" + scanner.next() + "\"isn't a long. It's skipped.");
                    }
                }
                break;
            case "damn":
                File file = new File(name);
                try {
                    Scanner in = new Scanner(file);
                    while(in.hasNextLine()) {
                        list.add(Long.valueOf(in.nextLine()));
                    }
                    in.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
        switch (sortingType) {
            case "natural": {
                list.sort(Comparator.naturalOrder());
                if(!outType.equals("damn")) {
                    System.out.println("Total numbers: " + list.size());
                    list.forEach(e -> System.out.print(e + " "));
                } else {
                    File file = new File(oName);
                    writer = new FileWriter(file);
                    list.forEach(e -> {
                        try {
                            writer.write(String.valueOf(e));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                }
                break;
            }
            case "byCount": {
                SortedMap<Long, Integer> map = new TreeMap<>();
                for(Long l : new HashSet<>(list)) {
                    map.put(l, Collections.frequency(list,l));
                }
                if(!outType.equals("damn")) {
                    System.out.println("Total numbers: " + list.size() + ".");
                    map.entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " time(s), " +
                                    Math.round((e.getValue() / (double) list.size()) * 100) + "%"));
                } else {
                    System.out.println("info");
                    File file = new File(oName);
                    writer = new FileWriter(file);
                    list.forEach(e -> {
                        try {
                            writer.write(String.valueOf(e));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                }
                break;
            }
            case "null":
                System.out.println("No sorting type defined");
                break;
            default: break;
        }

    }

    public static void sortString(List<String> list, String sortingType, String inType, String name, String outType, String oName) throws IOException {
        FileWriter writer;
        switch (sortingType) {
            case "natural": {
                list.sort(Comparator.naturalOrder());
                if(!outType.equals("damn")) {
                    System.out.println("Total numbers: " + list.size());
                    list.forEach(e -> System.out.print(e + " "));
                } else {
                    File file = new File(oName);
                    writer = new FileWriter("out.txt");
                    list.forEach(e -> {
                        try {
                            writer.write(String.valueOf(e));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                }
                break;
            }
            case "byCount": {
                SortedMap<String, Integer> map = new TreeMap<>();
                for(String s : new HashSet<>(list)) {
                    map.put(s, Collections.frequency(list,s));
                }
                if(!outType.equals("damn")) {
                    System.out.println("Total numbers: " + list.size() + ".");
                    map.entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " time(s), " +
                                    Math.round((e.getValue() / (double) list.size()) * 100) + "%"));
                } else {
                    File file = new File(oName);
                    writer = new FileWriter("out.txt");
                    list.forEach(e -> {
                        try {
                            writer.write(String.valueOf(e));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                }
                break;

            }
            case "null":
                System.out.println("No sorting type defined");
                break;
            default: break;
        }
    }
}
