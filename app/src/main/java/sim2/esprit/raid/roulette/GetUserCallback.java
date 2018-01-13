package sim2.esprit.raid.roulette;

/**
 * Created by Mohamed Raid Raddaou on 02-Jun-16.
 */

//methods to call when we've done getting user informations' after logging in
public interface GetUserCallback {

    /**
     * Invoked when background task is completed
     */

    public abstract void done(int returnedUser);
}