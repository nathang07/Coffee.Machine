package machine;
import java.sql.SQLOutput;
import java.util.Scanner;
public class CoffeeMachine {

    public static class Machine {
        private int water;
        private int milk;
        private int beans;
        private int money;
        private int cups;

        public Machine(int water, int milk, int beans, int cups, int money) {
            this.water = water;
            this.milk = milk;
            this.beans = beans;
            this.cups = cups;
            this.money = money;
        }

        public void printStatus() {
            System.out.println();
            System.out.println("The coffee machine has:");
            System.out.println(this.water + " ml of water");
            System.out.println(this.milk + " ml of milk");
            System.out.println(this.beans + " g of coffee beans");
            System.out.println(this.cups + " disposable cups");
            System.out.println("$" + this.money + " of money");
            System.out.println();
        }

        public void buyEspresso() {
            this.water -= 250;
            this.beans -= 16;
            this.money += 4;
        }

        public void buyLatte() {
            this.water -= 350;
            this.milk -= 75;
            this.beans -= 20;
            this.money += 7;
        }

        public void buyCappuccino() {
            this.water -= 200;
            this.milk -= 100;
            this.beans -= 12;
            this.money += 6;
        }

        public void buy() {
            Scanner in = new Scanner(System.in);

            System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String buyChoice = in.nextLine();

            if (this.enough(buyChoice) ) {
                System.out.println("I have enough resources, making you a coffee!\n");
                if (buyChoice.equals("1")) {
                    this.buyEspresso();
                }
                else if (buyChoice.equals("2")) {
                    this.buyLatte();
                }
                else if (buyChoice.equals("3")) {
                    this.buyCappuccino();
                }
            } else if (buyChoice.equals("back")) {
                System.out.println();
            } else {
                System.out.println("Sorry, not enough " + getLimiter(buyChoice) + "!\n");
            }
        }

        public boolean enough(String choice) {
            if (choice.equals("1") ) {
                return this.water - 250 >= 0 && this.beans - 16 >= 0 && this.cups-- >= 0;

            } else if (choice.equals("2")) {
                return this.water - 350 >= 0 && this.milk - 75 >= 0 && this.beans - 20 >= 0 && this.cups-- >= 0;

            } else if (choice.equals("3") ) {
                return this.water - 200 >= 0 && this.milk - 100 >= 0 && this.beans - 12 >= 0 && this.cups-- >= 0;

                }
            return false;
        }

        public String getLimiter(String choice) {
            if (choice.equals("1") ) {
                if (this.water - 250 < 0) {
                    return "water";
                } else if (this.beans - 16 < 0) {
                    return "coffee";
                } else if (this.cups-- < 0) {
                    return "cups";
                }
            } else if (choice.equals("2")) {
                if (this.water - 350 < 0) {
                    return "water";
                } else if (this.milk - 75 < 0) {
                    return "milk";
                } else if (this.beans - 20 < 0) {
                    return "coffee";
                } else if (this.cups-- < 0) {
                    return "cups";
                }
            } else {
                if (this.water - 200 < 0) {
                    return "water";
                } else if (this.milk - 100 < 0) {
                    return "milk";
                } else if (this.beans - 12 < 0) {
                    return "coffee";
                } else if (this.cups-- < 0) {
                    return "cups";
                }
            } return "";
        }

        public void fillAction() {
            Scanner in = new Scanner(System.in);

            System.out.println("\nWrite how many ml of water you want to add:");
            this.water += in.nextInt();

            System.out.println("Write how many ml of milk you want to add:");
            this.milk += in.nextInt();

            System.out.println("Write how many grams of coffee beans you want to add:");
            this.beans += in.nextInt();

            System.out.println("Write how many disposable cups you want to add:");
            this.cups += in.nextInt();

            System.out.println();
        }
        public void take() {
            System.out.println("\nI gave you $" + this.money + "\n");
            this.money = 0;
        }
    }
    public static void main(String[] args) {

        Machine coffee = new Machine(400, 540, 120, 9, 550);
        Scanner in = new Scanner(System.in);

        while (true) {
            String input;
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            input = in.nextLine();

            if (input.equals("buy")) {
                coffee.buy();

            } if (input.equals("fill")) {
                coffee.fillAction();

            } if (input.equals("take")) {
                coffee.take();

            } if (input.equals("remaining")) {
                coffee.printStatus();

            } if (input.equals("exit") ) {
                break;

            }
        }
    }
}


