import java.util.Scanner;
import java.util.Arrays;

public class sorting_operator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers do you wanna to write?: ");
        int n = input.nextInt();

        // массив для хранения чисел
        int[] numbers = new int[n];

        // ввод чисел
        for (int i = 0; i < n; i++) {
            System.out.print("Input your number" + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        input.nextLine();
        // выбор как мы будем сортировать массив чисел
        System.out.println("How you want to sort?");
        System.out.println("1)ASC(sort in ascending order)");
        System.out.println("2)DESC(sort in descending order.");
        String a = input.nextLine();
        a = a.toLowerCase();
        Factory_asc_desc factory = new Factory_asc_desc();
        // тут используется метод understand для того что бы дать обьекту something определенный класс 
        Sorting Something = factory.understand(a);
        Something.numbers = numbers;
        Something.sorted();

    }
}
abstract class Sorting {
    int[] numbers;
    abstract void sorted();
}
// создание подкласса ASC который будет сортировать по возрастанию
class ASC extends Sorting {
    @Override
    void sorted() {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("Numbers sorted by order ASC");
    }
}
// создание подкласса DESC который будет сортировать по убыванию
class DESC extends Sorting {
    @Override
    void sorted() {
        Arrays.sort(numbers);
        for (int i = numbers.length - 1;  i >= 0; i--){
            System.out.println(numbers[i]);
        }
        System.out.println("Numbers sorted by order DESC");
    }
}
// тут получается идет метод understand который если мы вводим asc будет создавать обьект под класс asc и если desc то уже его обьект
class Factory_asc_desc {
    Sorting understand(String type) {
            if (type.equalsIgnoreCase("asc")) {
                return new ASC();
            } else if (type.equalsIgnoreCase("desc")) {
                return new DESC();
            } else {
                throw new IllegalArgumentException("Error: " + type);
            }

    }
}
