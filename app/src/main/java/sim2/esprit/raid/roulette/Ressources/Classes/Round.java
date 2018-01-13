package sim2.esprit.raid.roulette.Ressources.Classes;

import com.backendless.BackendlessUser;

import java.util.Date;

/**
 * Created by GSC on 24/04/2017.
 */

public class Round {

    private Date created;

    private String objectId;

    BackendlessUser user ;
    Game game ;

    Double resultfloat ;

    int result ;

   public  String useremail ;


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public BackendlessUser getUser() {
        return user;
    }

    public void setUser(BackendlessUser user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Double getResultfloat() {
        return resultfloat;
    }

    public void setResultfloat(Double resultfloat) {
        this.resultfloat = resultfloat;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
