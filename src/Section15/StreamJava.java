package Section15;

import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJava {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Test");
        names.add("Automation");
        names.add("Security");
        names.add("Performance");
        names.add("LoadingTest");
        //regular
        int count = 0;
        for (String actual : names) {
            if (actual.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
        //streamFilter
        Long c = names.stream().filter(s -> s.startsWith("L")).count();
        System.out.println(c);

        //StreamMap
        Stream.of("Auto","Test","Application","Run").filter(s -> s.endsWith("n")).map(String::toUpperCase).forEach(System.out::println);

        //Filter and sort
        List<String> names1 = Arrays.asList("IronMan","Tonystark","CaptainAmerica","Hulk");
        names1.stream().filter(s -> s.contains("a")).sorted().map(String::toUpperCase).forEach(System.out::println);

        //merge to stream
        Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
        System.out.println(newStream);
        boolean flag = newStream.anyMatch(s -> s.contains("4c966a"));
        System.out.println("Comparation is: "+flag);
        Assert.assertFalse(flag);

        //get unique value from stream using Collector
        List<Integer> values = Arrays.asList(1,5,3,5,2,9,0,1,3,4);
        List<Integer> uniqueValues = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("Unique list is: "+uniqueValues);
        List<Integer>li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("value at 4th order is "+li.get(3));
    }
}
