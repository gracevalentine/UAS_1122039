package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Games;
import Model.Transactions;
import Model.Users;

public class Controller {
    static DatabaseController connect = new DatabaseController();

    public static Users loginUser(String email, String password) {
        connect.connect();
        String query = "SELECT * FROM users WHERE email = '" + email + "'&&password = '" + password + "'";
        Users userData = new Users();
        try {
            PreparedStatement stmt = connect.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userData.setIdUser(rs.getInt("idUser"));
                userData.setName(rs.getString("nameUser"));
                userData.setEmail(rs.getString("email"));
                userData.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (userData);
    }

    public static boolean insertNewTrans(Transactions trans, Users user, Games games) {
        connect.connect();

        String query = "INSERT INTO transactions VALUES (?," + user.getIdUser() + ", " + games.getIdGames() + ") WHERE  ";
        try {
            PreparedStatement stmt = connect.con.prepareStatement(query);
            stmt.setInt(1, trans.getIdTrans());
            stmt.setInt(2, user.getIdUser());
            stmt.setInt(3, games.getIdGames());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public static ArrayList<Games> getAllGames() {
        connect.connect();
        String query = "SELECT * FROM games";
        ArrayList<Games> listGames = new ArrayList<>();
        try {
            Statement stmt = connect.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Games games = new Games();
                games.setName(rs.getString("nameGame"));
                games.setGenre(rs.getString("genre"));
                games.setPrice(rs.getString("price"));
                listGames.add(games);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listGames);
    }

    // public static ArrayList<Transactions> getTransaction(int idUser) {
    //     ArrayList<Transactions> toDoList = new ArrayList<>();
    //     try {
    //         connect.connect();
    //         String query = "SELECT t.idTrans, t.user_id, u.nameUser, t.game_id, g.nameGame, sum(g.price) FROM games g JOIN transaction t ON g.idGames = t.game_id JOIN users u ON u.idUser = t.user_id WHERE t.user_id = " + idUser ;
    //         Statement stmt = connect.con.createStatement();
    //         ResultSet rs = stmt.executeQuery(query);
    //         while (rs.next()) {
    //             Transactions trans = new Transactions();
    //             Games games = new Games();
    //             Users users = new Users();
    //             toDo.setId(rs.getInt("id"));
    //             toDo.setTitle(rs.getString("title"));
    //             toDo.setNote(rs.getString("note"));
    //             toDo.setUserId(rs.getInt("userId"));
    //             toDoList.add(toDo);
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("MASUK CATCH GET ALL TODOS : ");
    //         e.printStackTrace();
    //     } catch (NullPointerException e) {
    //         System.out.println("MASUK CATCH GET ALL TODOS NULL : ");
    //         e.printStackTrace();
    //     } catch (Exception e) {
    //         System.out.println("MASUK CATCH GET ALL TODOS NULL : ");
    //         e.printStackTrace();
    //     }
    // }
}