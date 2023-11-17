package Model;

public class Games {
    private int idGames;
    private String name, genre, price;
    private static String pathGamePhoto;

    public Games() {
    }

    

    public Games(int idGames, String name, String genre, String price) {
        this.idGames = idGames;
        this.name = name;
        this.genre = genre;
        this.price = price;
    }



    public int getIdGames() {
        return idGames;
    }

    public void setIdGames(int idGames) {
        this.idGames = idGames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public static String getPathGamePhoto() {
        return pathGamePhoto;
    }

    public static void setPathGamePhoto(String pathGamePhoto) {
        Games.pathGamePhoto = pathGamePhoto;
    }

    
    

    
}
