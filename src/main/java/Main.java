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
        Map<String,Set<String[]>> map0 = new HashMap<>();
        Map<String,Set<String[]>> map1 = new HashMap<>();
        Map<String,Set<String[]>> map2 = new HashMap<>();
        Set<String> setIndex0 = new HashSet<>();
        Set<String> setIndex1 = new HashSet<>();
        Set<String> setIndex2 = new HashSet<>();
        Set<String[]> setGroups = new HashSet<>();

        Files.readAllLines(Path.of(path)).stream().map(s -> s.split(";"))
                .filter(strings -> strings.length == 3)
                .forEach(str -> {

                            String s0 = str[0];
                            if (!s0.isEmpty() && !setIndex0.add(s0)) {
                                if (map0.containsKey(s0)) {
                                    map0.get(s0).add(str);
                                } else {
                                    Set<String[]> setValue0 = new HashSet<>();
                                    setValue0.add(str);
                                    map0.put(s0, setValue0);
                                }
                            }

                            String s1 = str[1];
                            if (!s1.isEmpty() && !setIndex1.add(s1)) {
                                if (map1.containsKey(s1)) {
                                    map1.get(s1).add(str);
                                } else {
                                    Set<String[]> setValue1 = new HashSet<>();
                                    setValue1.add(str);
                                    map1.put(s1, setValue1);
                                }
                            }


                            String s2 = str[2];
                            if (!s2.isEmpty() && !setIndex2.add(s2)) {
                                if (map2.containsKey(s2)) {
                                    map2.get(s2).add(str);
                                } else {
                                    Set<String[]> setValue2 = new HashSet<>();
                                    setValue2.add(str);
                                    map2.put(s2, setValue2);
                                }
                            }
                        });


        Map<Integer, String[]> mapRes = new TreeMap<>();
        int i = 0;

        });



         System.out.println(map0.size());
         System.out.println(map1.size());
         System.out.println(map2.size());



        System.out.println("Время выполнения: " + (System.currentTimeMillis() - start) / 1000);
    }
}