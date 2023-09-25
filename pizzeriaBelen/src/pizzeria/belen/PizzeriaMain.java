package pizzeria.belen;

/**
 * Main class.
 *
 * @author Dani Dom
 *
 */
public class PizzeriaMain {

    /**
     * Basic menu.
     *
     * @return Selected option.
     */
    public static int menu() {

        // Value of the option.
        int option = 0;

        // Menu options.
        do {

            System.out.println("\n -- MENU --");
            System.out.println("1. Insert new Pizza");
            System.out.println("2. Show percentage of pizza with the cheese roll.");
            System.out.println("3. Start Oven");
            System.out.println("0. Exit");
            option = Input.inputInt("Choose an option:  ");
        } while ((option < 0) || (option > 3));

        return option;
    }

    /**
     * Method to insert a Pizza.
     *
     * @param q1
     */
    public static void insertPizza(Queue q1) {

        // Pizza to add
        Pizza p1;

        // Pizza Price.
        int price;

        // Pizza Cooking Time.
        int temp;

        // Type of Pizza to create
        String pizzaType = "";

        //Information request.
        do {
            pizzaType = Input.inputString("Is a classic or a Calzone?: ");
        } while (!pizzaType.equalsIgnoreCase("calzone") && !pizzaType.equalsIgnoreCase("classic"));

        if (pizzaType.equalsIgnoreCase("calzone")) {
            price = Input.inputInt("How much is the calzone?: ");
            temp = Input.inputInt("How long does it take?: ");
            p1 = new Calzone(temp, price);
        } else {
            String filled = Input.inputString("is the border filled? Y or N: ");
            price = Input.inputInt("How much is the classic?: ");
            temp = Input.inputInt("How long does it take?: ");
            if (filled.equalsIgnoreCase("Y")) {
                p1 = new Classic(temp, price, true);
            } else {
                p1 = new Classic(temp, price, false);
            }
        }
        //Insertion
        if (q1.push(p1)) {
            System.out.println("Your order was submitted!");
        } else {
            System.out.println("We are busy at the moment and can't attend your petition, try again later.");
        }

    }

    /**
     * Method that provide the percentage of pizzas with the border filled.
     *
     * @param q1
     * @return
     */
    public static double cheeseAmount(Queue q1) {

        // Number of pizzas filled.
        int count = 0;

        double percentage = 0;

        // Number of classic pizzas.
        int classicCounter = 0;
        for (int i = 0; i < q1.getNumElements(); i++) {
            Object p1 = q1.pop();
            if (p1 instanceof Classic) {
                classicCounter++;
                if (((Classic) p1).filled) {
                    count++;
                }
            }
            q1.push(p1);
        }
        if (classicCounter > 0) {
            percentage = (100 * count) / classicCounter;
            System.out.println("The percentage of classic pizzas with border filled with cheese is: " + percentage + "%.");
        } else {
            System.out.println("There are no classic pizzas in the oven");
        }
        return percentage;
    }

    /**
     * Start the oven
     * @param q1 
     */
    public static void startOven(Queue q1) {
        int elements = q1.getNumElements();
        try {
            for (int i = 0; i < elements; i++) {
                Object p1 = q1.pop();
                if (p1 instanceof Classic) {
                    q1.push(p1);
                } else {
                    System.out.println(p1);
                    Thread.sleep(((Pizza) p1).getTemp() * 1000);
                }
            }
            for (int i = 0; i < elements; i++) {
                Object p1 = q1.pop();
                if (p1 instanceof Classic) {
                    System.out.println(p1);
                    Thread.sleep(((Pizza) p1).getTemp() * 1000);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        // Oven queue and size.
        Queue q1 = new Queue(5);

        // Menu option
        int option = 0;
        do {
            option = menu();
            switch (option) {
                case 1 ->

                    insertPizza(q1);

                case 2 ->

                    cheeseAmount(q1);

                case 3 ->
                    startOven(q1);

            }
        } while (option != 0);
        System.out.println("Thanks for trusting us, see you soon!");
    }

}
