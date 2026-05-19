package homework9.task3;

public class Item {
    private final String itemName;
    private int quantity = 1;
    private final double itemPrice;

    Item(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateSubtotal() {
        return this.itemPrice * this.quantity;
    }

    String formatItemDetails() {
        return String.format("%s - $%.2f", itemName, itemPrice);
    }
}
