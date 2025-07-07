package GreedyApproach;

import java.util.*;

// Class to represent an item with value and weight
class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        // Sample items with value and weight
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        int capacity = 50;

        // Sort items by decreasing value/weight ratio
        Arrays.sort(items, (a, b) -> 
            Double.compare((double)b.value / b.weight, (double)a.value / a.weight)
        );

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0)
                break;

            if (item.weight <= capacity) {
                // Take the full item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take fraction of the item
                totalValue += item.value * ((double) capacity / item.weight);
                capacity = 0; // Knapsack is full
            }
        }

        System.out.printf("Maximum value: %.2f\n", totalValue);
    }
}
