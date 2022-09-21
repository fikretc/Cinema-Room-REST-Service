
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String answer;
        int selection = scanner.nextInt();
        switch (selection) {
            case 1:
                answer = "move up";
                break;
            case 2:
                answer = "move down";
                break;
            case 3:
                answer = "move left";
                break;
            case 4:
                answer = "move right";
                break;
            case 0:
                answer = "do not move";
                break;
            default:
                answer = "error!";

        }
        System.out.println(answer);

    }
}