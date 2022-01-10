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


        Set items = new HashSet<>();
        System.out.println(list0.stream().filter(n -> !items.add(n))
                .collect(Collectors.toSet())
                .size()); //количество строчек с повторяющимися элементами в первом столбце.
        //попробовать вытащить из всей коллекции строк элементы с таким значением в первом столбце,
        // которое соответствует элементу из первого столбца какой либо строки из списка строк, которые не вошли в коллекцию...


        long finish = System.currentTimeMillis();
        System.out.println((finish-start)/1000);

    }
}
