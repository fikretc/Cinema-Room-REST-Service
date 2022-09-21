import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int selection = scanner.nextInt();
        String response = "Unknown number";
        switch (selection) {
            case 1:
                response = "Yes!";
                break;
            case 2:
            case 3:
            case 4:
                response = "No!";
        }
        System.out.println(response);
    }
}