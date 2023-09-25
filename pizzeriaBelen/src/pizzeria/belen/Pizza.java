package pizzeria.belen;

/**
 * This class represents a Pizza.
 *
 * @author Dani Dom
 *
 */
public abstract class Pizza {

    /**
     * Accumulate ID
     */
    private static int idP = 0;
    
  /** 
   * pizza ID
   */
    private int id;

    /**
     * Cooking time.
     */
    private int temp;

    /**
     * Price.
     */
    private double price;

    /**
     * Constructor.
     *
     * @param temp
     * @param price
     */
    public Pizza(int temp, double price) {
        id = idP++;
        this.temp = temp;
        this.price = price;
    }

    /**
     * Id getter
     *
     * @return
     */
    public static int getId() {
        return idP;
    }

    /**
     * Temp getter
     *
     * @return
     */
    public int getTemp() {
        return temp;
    }

    /**
     * Temp setter
     *
     * @param temp
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }

    /**
     * Price getter
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Price setter
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * String to show information.
     * @return 
     */
    @Override
    public String toString() {
        String chain = "";
        chain += "Pizza : " + this.getClass().getSimpleName() + " " + this.id+" , its price is : " + this.getPrice() + " . Estimated cooking time: " + this.getTemp();
        return chain;
    }

}
