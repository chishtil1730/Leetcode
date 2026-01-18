import java.util.stream.Collectors;

public class Lambdas {
    public static void main(String[] args) {

        String str = "12345678";
        //To print only the string with the specific condition.
        String string = str.chars().filter(s -> s%2==0).mapToObj(s->String.valueOf((char) s))
                .collect(Collectors.joining());
        System.out.println(string);

        System.out.println();

        //To print individually
        String string1 = "12345678";
        string1.chars().filter(s2->s2%2==0).mapToObj(s2->String.valueOf((char) s2)).forEach(s2-> System.out.println(s2));

    }
}

//chars()   => returns a IntStream.
//mapToObj  => to convert from one data type to another using wrapper class.
//filter()  => to filter out with a specific condition.
//forEach() => to iterate through the items.
