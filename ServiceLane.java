import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ServiceLane {



    public static List<Integer> serviceLane(int n,List<Integer> width, List<List<Integer>> cases) {
        List<Integer> res = new ArrayList<>();

        for(List<Integer> list : cases){
            int start = list.get(0);
            int end = list.get(1);
            int min = Integer.MAX_VALUE;
            for(int i=start;i<=end;i++){
                min = Math.min(min,width.get(i));
            }
            res.add(min);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int n = 8;
        int t = 5;

        List<Integer> width = Arrays.asList(2, 3, 1, 2, 3, 2, 3, 3);

        List<List<Integer>> cases = new ArrayList<>();
        cases.add(Arrays.asList(0, 3));
        cases.add(Arrays.asList(4, 6));
        cases.add(Arrays.asList(6, 7));
        cases.add(Arrays.asList(3, 5));
        cases.add(Arrays.asList(0, 7));

        List<Integer> result = serviceLane(n, width, cases);

        for (int val : result) {
            System.out.println(val);
        }
    }


}


