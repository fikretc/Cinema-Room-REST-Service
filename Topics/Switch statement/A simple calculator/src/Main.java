import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        long num1 = scanner.nextLong();
        String op = scanner.next();
        long num2 = scanner.nextLong();
        boolean error = false;
        long result = switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0l){
                    System.out.println("Division by 0!");
                    error = true;
                    yield 0l;
                }
                else yield  num1 / num2;
            }
            default -> {
                System.out.println("Unknown operator");
                error = true;
                yield 0l;
            }
        };
        if (!error) {
            System.out.println(result);
        }

    }
}