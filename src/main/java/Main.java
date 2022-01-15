import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static final String path = "src\\main\\resources\\lng.csv";

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        List<String[]> list0 = new ArrayList();
        List<String[]> list1 = new ArrayList();
        List<String[]> list2 = new ArrayList();
        Set<String> setIndex0 = new HashSet<>();
        Set<String> setIndex1 = new HashSet<>();
        Set<String> setIndex2 = new HashSet<>();
        Set<String[]> setGroups = new HashSet<>();

        Files.readAllLines(Path.of(path)).stream().map(s -> s.split(";"))
                .filter(strings -> strings.length == 3)
                .forEach(str -> {
                    String s0 = str[0];
                    if(!s0.isEmpty() && !setIndex0.add(s0)) {
                        list0.add(str);
                        list0.add(str); // 1 стобец
                    }
                    String s1 = str[1];
                    if(!setIndex1.add(s1)) {
                        list1.add(str);
                        list1.add(str); // 2 стобец
                    }
                    String s2 = str[2];
                    if(!setIndex2.add(s2)) {
                        list2.add(str);
                        list2.add(str); // 3 стобец
                    }
                });
        System.out.println(list0.size());
        System.out.println(list1.size());
        System.out.println(list2.size());






        /*Set items = new HashSet<>();
        System.out.println(list0.stream().filter(n -> !items.add(n))
                .collect(Collectors.toSet())
                .size());
         */


        System.out.println("Время выполнения: " + (System.currentTimeMillis()-start)/1000);


    }
}
