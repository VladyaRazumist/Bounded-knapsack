/**
 * A class representing an item of the loot.
 * @author nicolas et hadrien, refactoring by a.melnikov
 */
public class Item {

    /**
     * Index of the item
     */
    private int idx;

    /**
     * Quantity of items
     */
    private int quantity;

    /**
     * Weight of the item
     */
    private int weight;

    /**
     * Value of the item
     */
    private double value;
    
    
    /**
     * Builds an item of the loot.
     * @param idx: index of the item
     * @param quantity: number of item copies
     * @param weight: weight of the item
     * @param value: value (in dollars) in the item
     */
    public Item(int idx, int quantity, int weight, double value) {
        this.idx = idx;
        this.quantity = quantity;
        this.weight = weight;
        this.value = value;
    }
    
    /**
     * @return index of the item
     */
    public int Idx() {
        return idx;
    }

    /**
     * @return number of copies of the item
     */
    public int Quantity() {
        return quantity;
    }

    /**
     * @return weight of the item
     */
    public int Weight() {
        return weight;
    }
    
    /**
     * @return monetary value (dollars) of the item
     */
    public double Value() {
        return value;
    }

    public String ToString() {
        return "idx="+idx+"\tw="+weight+"\tv="+value;
    }
   
}
