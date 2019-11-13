/**
 * An app for a mobile device
 *
 * @author Richard Brown
 * 
 */
public class App
{
    private String name;
    private String author;
    private double price;
    private int rating; // valid ratings are 1-4; 0 means not rated

    /**
     * Create an app with the given name, author, price, and rating
     * @param appName the app name
     * @param appAuthor the app author
     * @param appPrice the price of the app (0 if the app is free)
     * @param appRating the app's rating
     */
    public App(String appName, String appAuthor, double appPrice, int appRating)
    {
        name = appName;
        author = appAuthor;
        price = appPrice;
        setRating(appRating);
    }

    /**
     * Create an app with the given name, author, and price that is not rated
     * @param appName the app name
     * @param appAuthor the app author
     * @param appPrice the price of the app (0 if the app is free)
     */
    public App(String appName, String appAuthor, double appPrice)
    {
        name = appName;
        author = appAuthor;
        price = appPrice;
        rating = 0;
    }

    /**
     * @return the app name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the app author
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * @return the app price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Set the price of this app to the value given
     * @param newPrice new price for this app
     */
    public void setPrice(double newPrice)
    {
        if (newPrice >= 0) {
            price = newPrice;
        }
        else {
            System.out.println("Error: Price must be greater than or equal to 0");
        }
    }

    /**
     * @return true if this app is free, false otherwise
     */
    public boolean isFree()
    {
        return price == 0;
    }

    /**
     * @return the app rating
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * Set the rating of this app to the value given
     * @param newRating new rating for this app
     */
    public void setRating(int newRating)
    {
        if (newRating >= 1 && newRating <= 4) {
            rating = newRating;
        }
        else {
            System.out.println("Error: Valid range for rating is 1 to 4");
        }
    }

    /**
     * Reset the rating of this app to not rated
     */
    public void resetRating()
    {
        rating = 0;
    }

    /**
     * Increase the rating of this app by 1
     */
    public void increaseRating()
    {
        if (rating < 4) {
            rating = rating + 1;
        }
    }

    /**
     * Decrease the rating of this app by 1
     */
    public void decreaseRating()
    {
        if (rating > 1) {
            rating = rating - 1;
        }
    }

    /**
     * Print information on this app
     */
    public void printAppInfo()
    {
        System.out.println("---------------------------------");
        System.out.println("App: " + name);
        System.out.println("Author: " + author);
        if (price == 0) {
            System.out.println("Price: FREE");
        }
        else {
            System.out.println("Price: $" + price);
        }
        if (rating == 0) {
            System.out.println("Rating: (not rated)");
        }
        else {
            System.out.println("Rating: " + rating);
        }
        System.out.println("---------------------------------");
    }
}

