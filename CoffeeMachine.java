import java.util.Scanner;




public class CoffeeMachine {

    private int water = 400; 
    private int milk = 540; 
    private int beans = 120; 
    private int cups = 9;
    private int money = 550;
	enum State {
		MAIN,
		BUY,
		FILL_WATER,
		FILL_MILK,
		FILL_BEANS,
		FILL_CUPS;
		
	}
	private State state = State.MAIN;
	
    public void run(String action) {
        
       	//display();
		switch(state) {
			case MAIN:
				System.out.print("Write action (buy, fill, take, remaining, exit): \n>");
				System.out.println(action);
				switch(action) {
				case "buy":
					state = State.BUY;
					//display();
					break;
					
				case "fill":
					state = State.FILL_WATER;			
					//display();
					break;
					
				case "take":
					System.out.println("I gave you $" + money);
					money = 0;
					//display();
					break;
					
				case "remaining":
					display();
					break;
					
				case "exit":
					break;
				}
				break;
    
			case BUY:
				System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ");
				switch(action) {
				case "1":
					if(water < 250) {
						System.out.println("Sorry, not enough water!");
					} else if (beans < 16) {
						System.out.println("Sorry, not enough beans!");
					} else {
						water -= 250;
						beans -= 16;
						money += 4;
						cups -= 1;
						System.out.println("I have enough resources, making you a coffee!");
					}
					break;
					
				case "2":
					if(water < 350) {
						System.out.println("Sorry, not enough water!");
					} else if (beans < 20) {
						System.out.println("Sorry, not enough beans!");
					} else if (milk < 75) {
						System.out.println("Sorry, not enough milk!");
					}else {
						water -= 350;
						milk -= 75;
						beans -= 20;
						money += 7;
						cups -= 1;
						System.out.println("I have enough resources, making you a coffee!");
					}
					break;
					
				case "3":
					if(water < 200) {
						System.out.println("Sorry, not enough water!");
					} else if (beans < 12) {
						System.out.println("Sorry, not enough beans!");
					} else if (milk < 100) {
						System.out.println("Sorry, not enough milk!");
					}else {
						water -= 200;
						milk -= 100;
						beans -= 12;
						money += 6;
						cups -= 1;
						System.out.println("I have enough resources, making you a coffee!");
					}
					break;
					
				case "back":
					break;
				}
				state = State.MAIN;
				break;
				
		case FILL_WATER: 
				System.out.print("Write how many ml of water do you want to add:\n>");
				System.out.println(">" + action);
				water += Integer.parseInt(action);
				state = State.FILL_MILK;
				break;
			
		case FILL_MILK:
				System.out.print("Write how many ml of milk do you want to add:\n>");
				System.out.println(">" + action);
				milk += Integer.parseInt(action);
				state = State.FILL_BEANS;
				break;
			
		case FILL_BEANS:
				System.out.print("Write how many grams of coffee beans do you want to add:\n>");
				System.out.println(">" + action);
				beans += Integer.parseInt(action);
				state = State.FILL_CUPS;
				break;
			
		case FILL_CUPS:
				System.out.print("Write how many disposable cups of coffee do you want to add:\n>");
				System.out.println(">" + action);
				cups += Integer.parseInt(action);
				state = State.MAIN;
				break;
		}	
		

}
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String action = "";
	CoffeeMachine coffee = new CoffeeMachine();
	while(!action.equals("exit")) {
		action = scanner.next();
		coffee.run(action);
	}
}    
        
	
    public void display() {
    	System.out.println("\nThe coffee machine has:");
    	System.out.println(water + " of water");
    	System.out.println(milk + " of milk");
    	System.out.println(beans + " of coffee beans");
    	System.out.println(cups + " of disposable cups");
    	System.out.println(money + " of money\n");
    }

}