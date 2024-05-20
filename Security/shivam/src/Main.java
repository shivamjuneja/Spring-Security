import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        List<Integer> m= l.stream().filter(i->i>2).collect(Collectors.toList());
        System.out.println(m);
    }
}