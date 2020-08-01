
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int x = scanner.nextInt();
        int y = 0;
        if( water /200 == milk /50) {
            y = water/200;
        } else {
            y = water/200 < milk/50 ? water/200 : milk/50;
        }
        if(y != beans/15) {
            y = y < beans/15 ? y : beans/15;
        }
        if(x == y) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println(x < y ? "Yes, I can make that amount of coffee (and even " + (y - x) + " more than that)" 
            : "No, I can make only " + y + " cup(s) of coffee");
        }
        scanner.close();
    }
}