package homework9.task3;

import utils.InputHelper;

public class RestaurantMenu {
    private final Item[] foodsMenu;
    private final Item[] drinksMenu;
    private final Item[] basketMenu;

    private static final int FOOD_SIZE = 5;
    private static final int DRINK_SIZE = 5;
    private static final int BASKET_SIZE = 10;

    public static void main(String[] args) {
        RestaurantMenu restaurantMenu = new RestaurantMenu();
        restaurantMenu.run();
    }


    public RestaurantMenu() {
        foodsMenu = new Item[FOOD_SIZE];
        foodsMenu[0] = new Item("Grilled Salmon with Lemon Butter Sauce",24.99);
        foodsMenu[1] = new Item("Classic Margherita Pizza (Wood-Fired)",16.50);
        foodsMenu[2] = new Item("Chicken Parmesan with Spaghetti", 18.75);
        foodsMenu[3] = new Item("House Caesar Salad", 7.00);
        foodsMenu[4] = new Item("Gourmet Beef Burger with Crispy Fries", 15.99);

        drinksMenu = new Item[DRINK_SIZE];
        drinksMenu[0] = new Item("Freshly Squeezed Lemonade", 4.50);
        drinksMenu[1] = new Item("House Brewed Iced Tea", 3.75);
        drinksMenu[2] = new Item("Sparkling Mineral Water", 5.00);
        drinksMenu[3] = new Item("Glass of Cabernet Sauvignon", 12.00);
        drinksMenu[4] = new Item("Local Craft IPA on Tap", 8.50);

        basketMenu = new Item[BASKET_SIZE];
    }

    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            int choice = InputHelper.getInt("""
                    \n=== MAIN MENU ====
                    1 - Food Menu
                    2 - Drink Menu
                    3 - View Basket
                    4 - Checkout & Exit
                    Choose an option:\s""");

            switch (choice) {
                case 1 -> handleMenuSelection(foodsMenu, "Food Menu");
                case 2 -> handleMenuSelection(drinksMenu, "Drink Menu");
                case 3 -> displayBasket();
                case 4 -> {
                    System.out.println("Thank you for visiting! Goodbye");
                    keepRunning = false;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void handleMenuSelection(Item[] menu, String menuName) {
        while (true) {
            displaySpecificMenu(menu, menuName);
            int itemChoice = InputHelper.getInt("Enter item number to add to basket" +
                    " (0 to go back): ");

            if (itemChoice == 0) {
                System.out.println("Returning to Main Menu...");
                break;
            } else if (itemChoice > 0 && itemChoice <= menu.length) {
                addToBasket(menu, itemChoice - 1);
            } else {
                System.out.println("Invalid item number.");
            }
        }
    }

    private void displaySpecificMenu(Item[] menuToDisplay, String menuName) {

        System.out.println("\n=== " + menuName + " ===");

        boolean isEmpty = true;
        for (int i = 0; i < menuToDisplay.length; i++) {

            if (menuToDisplay[i] != null) {
                System.out.println((i + 1) + " - " + menuToDisplay[i].formatItemDetails());
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println(" (Empty) ");
        }
        System.out.println("-------------------");
    }

    private void displayBasket() {
        System.out.println("\n=== YOUR BASKET ===");
        double grandTotal = 0;
        int totalItemCount = 0;
        boolean isempty = true;

        for (int i = 0; i < basketMenu.length; i++) {
            Item item = basketMenu[i];
            if (item != null) {
                isempty = false;
                double subtotal = item.calculateSubtotal();
                System.out.printf("%d x %-38s | Subtotal: $%.2f%n",
                        item.getQuantity(), item.getItemName(), subtotal);

                grandTotal += subtotal;
                totalItemCount += item.getQuantity();
            }
        }

        if (isempty) {
            System.out.println("(Your basket is empty)");
        } else {
            System.out.println("-".repeat(19));
            System.out.printf("Total Items: %d | Grand Total: $%.2f%n",
                    totalItemCount, grandTotal);
            System.out.println("-".repeat(19));
        }
    }

    private void addToBasket(Item[] sourceMenu, int menuIndex) {
        Item selectedItem = sourceMenu[menuIndex];

        for (int i = 0; i < basketMenu.length; i++) {

            if (basketMenu[i] != null &&
                    basketMenu[i].getItemName().equals(selectedItem.getItemName())) {
                basketMenu[i].incrementQuantity();
                System.out.println("Increased " + basketMenu[i].getItemName() +
                        " quantity to: " + basketMenu[i].getQuantity());
                return;
            }

            if (basketMenu[i] == null) {
                basketMenu[i] = new Item(selectedItem.getItemName(), selectedItem.getItemPrice());
                System.out.println(selectedItem.getItemName() + " has been added to the basket.");
                return;
            }
        }
        System.out.println("Basket is full!");
    }
}
