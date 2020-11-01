import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.*;

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

        Function<LocalDate, String> currentDate = x -> "Current date: " + x;
        System.out.println(currentDate.apply(LocalDate.now()));

        Consumer<LocalDate> tomorrowDate = x -> System.out.printf("Tomorrow date: %s \n", x);
        tomorrowDate.accept(LocalDate.now().plusDays(1));

        Supplier<Developer> developerFactory = () -> {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter name, title, experience: ");
            String name = s.nextLine();
            String title = s.nextLine();
            String experience = s.nextLine();
            return new Developer(name, title, experience);
        };

        Developer developerFirst = developerFactory.get();
        System.out.println(developerFirst.toString());

        BinaryOperator<Double> stepen = Math::pow;
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
