import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.function.*;

interface Expression {

    boolean isDivided(int n);
}

class ExpressionHelper {

    static boolean isDivided(int n) {
        return n % 3 == 0;
    }
}

public class Program {

    public static void main(String[] args) {
        //1
        Scanner in = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = in.nextDouble();
        System.out.println("Area: " + calculateCircleArea(radius));

        int[] nums = {1, 3, 9, 11, 53, 33, 34, 612};
        Expression func = ExpressionHelper::isDivided;
        printNumbersDividedByThree(nums, func);

        Predicate<String> containsSubstring = x -> x.contains("Ivory");
        String strA = "Ivy is the best cat";
        String strB = "My inglish iz bad";
        String strC = "Ivory is going to be whity";
        System.out.println(containsSubstring.test(strA));
        System.out.println(containsSubstring.test(strB));
        System.out.println(containsSubstring.test(strC));

        Function<LocalDate, String> currentDate = x -> "Current date: " + String.valueOf(x);
        System.out.println(currentDate.apply(LocalDate.now()));

        Consumer<String> tomorrowDate = x -> System.out.printf("Tomorrow date: %s \n", x);
        tomorrowDate.accept(LocalDate.now().plusDays(1).toString());

        Supplier<Developer> developerFactory = () -> {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter name, title, experience: ");
            String name = s.nextLine();
            String title = s.nextLine();
            String experience = s.nextLine();
            return new Developer(name, title, experience);
        };

        Developer developerFirst = developerFactory.get();
        System.out.printf("%s: %s with %s experience", developerFirst.getTitle(), developerFirst.getName(), developerFirst.getExperience());

        BinaryOperator<Double> stepen = (x, y) -> Math.pow(x, y);
        if ((stepen.apply(2.0, 3.0)) % 2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }

    private static void printNumbersDividedByThree(int[] numbers, Expression func) {
        for (int i : numbers) {
            if (func.isDivided(i)) {
                System.out.println(i);
            }
        }
    }

    public static double calculateCircleArea(double radius) {
        double circleArea = Math.PI * Math.pow(radius, 2);
        return circleArea;
    }


}