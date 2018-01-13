package sim2.esprit.raid.roulette.Ressources.Classes;

import java.util.Date;

/**
 * Created by GSC on 24/04/2017.
 */

public class Game {

    private Date created;

    private String objectId;

    private  String dateFin ;
    private String typeGame ;


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

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(String typeGame) {
        this.typeGame = typeGame;
    }
}
