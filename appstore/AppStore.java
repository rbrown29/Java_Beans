import java.util.ArrayList;

/**
 * An app store containing apps
 *
 * Modifications:
 * Create AppStore with a list of apps and basic methods to add, clear, and print apps
 * Created Methods getAppByName, removeApp, getAppByAuthor, 
 *      getNumAppsWithRating, getMaxRatingOfAnApp, 
 *      and printAppStoreSummaryStats. added items to list. 
 *
 * @author Richard Brown
 * @version 8/7/2019
 */
public class AppStore
{
    private String appStoreName;
    private ArrayList<App> appList;

    /**
     * Create an app store with the given name
     * @param name the name of this app store
     */
    public AppStore(String name)
    {
        appStoreName = name;
        appList = new ArrayList<App>();
    }

    /**
     * Populate the store with a few apps.
     * Use this method to make testing easier. After creating an AppStore,
     * call this method to populate the apps, and then test your methods.
     */
    public void populateApps()
    {
        addApp("Pandora Music", "Pandora", 0);
        addApp(new App("Minecraft", "Mojang", 6.99, 3));
        addApp("Instagram", "Facebook", 0); // added item
        addApp("Roku Remote", "Roku", 0);   // added item
    }

    /**
     * Add the given app to the app store
     * @param anApp an app to add
     */
    public void addApp(App anApp)
    {
        appList.add(anApp);
    }

    /**
     * Create an app with the given name, author, and price and add it to the store.
     * The app starts out unrated.
     * @param name name of the app
     * @param author the app author
     * @param price the price of the app
     */
    public void addApp(String name, String author, double price)
    {
        appList.add(new App(name, author, price));
    }

    /**
     * @return the number of apps in the store
     */
    public int getNumberOfApps()
    {
        return appList.size();
    }

    /**
     * Removes all the apps from the store
     */
    public void clearAppStore()
    {
        appList.clear();
    }

    /**
     * Print all the apps in the store
     */
    public void printAppList()
    {
        System.out.println("============= " + appStoreName + " =============");
        if (appList.size() == 0) {
            System.out.println("No apps in the store");
        }
        else {
            for (App currentApp : appList) {
                currentApp.printAppInfo();
            }
        }
        System.out.println("===========================================");
    }

    /**
     * Find an app based on its name
     * @param name use the given name search for
     * @return the app with the given name
     *         or null if there is no app with that name
     */
    public App findApp(String name)
    {
        for (App app : appList) {
            if (app.getName().equalsIgnoreCase(name)) {
                return app;
            }
        }
        return null;
    }
    /**
     * Remove app
     * @param name finds app name and removes it from the appList.
    **/
    public void removeApp(String name) {
        App appRemove = findApp(name);
        if (appRemove != null) {
            appList.remove(appRemove);
        }
    }
    /**
     * Get app by author
     * @param String author
     * Creates an empty list
     * Loops through the current list and searches for apps with the given
     * author name. If the search is successful, it adds the app to the empty
     * list and returns the list.
     * Otherwise returns empty list.
     **/
    public ArrayList<App> getAppsByAuthor(String author) {
        ArrayList<App> appAuthor = new ArrayList<>();
        for (App appByAuthor : appList) {
            if (appByAuthor.getAuthor() == author) {
                    appAuthor.add(appByAuthor);
                    // For Testing
                   // System.out.println(appByAuthor.getAuthor() +
                   //  " " + appByAuthor.getName());
            }
                }
        return appAuthor;
    }
    /**
     * Get the number of app for a givin rating.
     * @param int rating
     * Loops through the appList if that rating is found then adds to 
     * the counter.
     * returns count
     **/
    public int getNumAppsWithRating(int rating) {
        int count = 0;
        for (App appRating : appList) {
            if (appRating.getRating() == rating) {
                count++;
            }
        }
        return count;
    }
    /**
     * Get max rating of apps
     * @param int max,three,two, one
     * Gets all apps that are rated. Uses a controlled if statement to find
     * the max rating. 
     **/
    public int getMaxRatingOfAnApp () {
        int max = getNumAppsWithRating(4); int three = getNumAppsWithRating(3);
        int two = getNumAppsWithRating(2); int one = getNumAppsWithRating(1);
        if (max > 0) {
            return 4;
        }
        else if(three > 0 && max == 0) {
            return 3;
        }
        else if (two > 0 && (three + max) == 0) {
            return 2;
        }
        else if (one > 0 && (two + three + max) == 0) {
            return 1;
        }
       return 0;
    }
    /**
     * Print app store stats
     * Prints store name, list size, how many apps are rated 1 -4.
     * Loops through  the list with a counter to find the number of apps
     * without a rating then prints it.
     * Prints the max rating
     **/
    public void  printAppStoreSummaryStats() {
        System.out.println("################### " + appStoreName + " ########################");
        System.out.println("Total # of Apps: " + appList.size());
        System.out.println("# Apps rated 4: " + getNumAppsWithRating(4));
        System.out.println("# Apps rated 3: " + getNumAppsWithRating(3));
        System.out.println("# Apps rated 2: " + getNumAppsWithRating(2));
        System.out.println("# Apps rated 1: " + getNumAppsWithRating(1));
        int count = 0;
        for (App rate : appList) {
            if (rate.getRating() == 0) {
                count ++;
            }
        }
        System.out.println("# of unrated Apps: " + count);
        System.out.println("Max rating: " + getMaxRatingOfAnApp());
    }
}

