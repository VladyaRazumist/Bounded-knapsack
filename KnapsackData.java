import java.io.*;
import java.util.*;

// Class representing input data.
// @author nicolas et hadrien, refactoring by a.melnikov
public class KnapsackData {
    private int numOfItems;
    private Item[] items;
    private int capacity;

    public KnapsackData(int[] quantity, int[] weight, double[] value, int capacity) {
        this.numOfItems = weight.length;
        this.capacity = capacity;
        
        this.items = new Item[this.numOfItems];
        for (int i = 0; i < numOfItems; i++) {
            items[i] = new Item(i+1, quantity[i], weight[i], value[i]);
        }
    }

    // Accessors

    public int NumOfItems() {
        return this.numOfItems;
    }
    
    public int Capacity() {
        return this.capacity;
    }
    
    public Item GetItem(int i) {
        return items[i];
    }
}
