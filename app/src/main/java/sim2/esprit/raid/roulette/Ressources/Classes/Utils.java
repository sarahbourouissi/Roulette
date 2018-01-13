package sim2.esprit.raid.roulette.Ressources.Classes;

/**
 * Created by GSC on 28/04/2017.
 */

public class Utils {

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
