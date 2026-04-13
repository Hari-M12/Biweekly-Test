import java.util.ArrayList;
import java.util.List;

public class AppleAndOrange {
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int count  = 0;
        for(Integer i : apples){
            int sum = a + i;
            if(sum>= s && sum<=t ){
                count++;
            }
        }
        System.out.println(count);
        count = 0;
        for(Integer i : oranges){
            int sum = b + i;
            if(sum>= s && sum<=t ){
                count++;
            }
        }
        System.out.println(count);

    }

    public static void main(String[] args) {

        int s = 7, t = 11;
        int a = 5, b = 15;

        List<Integer> apples = new ArrayList<>();
        apples.add(-2);
        apples.add(2);
        apples.add(1);

        List<Integer> oranges = new ArrayList<>();
        oranges.add(5);
        oranges.add(-6);

        countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}
