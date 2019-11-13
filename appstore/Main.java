
/**
 * Constructor and populate apps
 *
 * @author (Richard Brown)
 * @version (8/11/2019)
 */
public class Main
{
    public static void main(String[] args) {
        AppStore store = new AppStore("Richard's");
        store.populateApps();
        store.printAppStoreSummaryStats();
    }
}
