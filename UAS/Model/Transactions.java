package Model;

public class Transactions {
    private int idTrans, userId, gamesId;

    public Transactions() {
    }

    public Transactions(int idTrans, int userId, int gamesId) {
        this.idTrans = idTrans;
        this.userId = userId;
        this.gamesId = gamesId;
    }

    public int getIdTrans() {
        return idTrans;
    }

    public void setIdTrans(int idTrans) {
        this.idTrans = idTrans;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGamesId() {
        return gamesId;
    }

    public void setGamesId(int gamesId) {
        this.gamesId = gamesId;
    }

    
}
