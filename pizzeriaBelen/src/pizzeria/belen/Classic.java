package pizzeria.belen;

/**
 * This class represents a Clasica.
 * @author Dani Dom
 *
 */
public class Classic extends Pizza {

	
	public boolean filled = false;

	/**
	 * Constructor
	 * @param temp
	 * @param price
	 * @param filled
	 */
	public Classic(int temp, double price, boolean filled) {
		super(temp, price);
		this.filled = filled;
	}

    @Override
    public String toString() {
        String chain = super.toString();
        if(this.filled) {
            chain+= " And the border is filled with cheese.";
        } else {
            chain+= " The border has no cheese.";
        }
        return chain;
    }
        
}
