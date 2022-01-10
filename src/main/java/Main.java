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
        List<String> list0 = new ArrayList();
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();

        Files.readAllLines(Path.of(path)).stream().map(s -> s.split(";"))
                .filter(strings -> strings.length == 3)
                .forEach(str -> {
                    list0.add(str[0]);
                    list1.add(str[1]);
                    list2.add(str[2]);
                });

        //System.out.println(list0.size());
        Set items = new HashSet<>();
        //System.out.println(items.size());

        Stream.of(list0).filter(n -> !items.add(n))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //System.out.println(list0.size() + "-" + list1.size() + "-" + list2.size());

        long finish = System.currentTimeMillis();
        System.out.println((finish-start)/1000);

    }
}
