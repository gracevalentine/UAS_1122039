package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Model.Games;
import Model.Users;

public class GameList {
    JFrame frame;
    JPanel photoPanel;
    JFileChooser fileFoto;

    public GameList (Users user) {
    // public GameList() {
        frame = new JFrame("Game Store");
        frame.setSize(400, 500);
        frame.setLayout(null);

        

        JLabel namaGame = new JLabel("Nama Game: ");
        namaGame.setBounds(25, 60, 200, 25);
        frame.add(namaGame);
        JTextField isiNamaGame = new JTextField();
        isiNamaGame.setBounds(120, 60, 200, 25);
        frame.add(isiNamaGame);

        JLabel genreGame = new JLabel("Genre Game: ");
        genreGame.setBounds(25, 100, 200, 25);
        frame.add(genreGame);
        JTextField isiGenreGame = new JTextField();
        isiGenreGame.setBounds(120, 100, 200, 25);
        frame.add(isiGenreGame);

        JLabel priceGame = new JLabel("Price Game: ");
        priceGame.setBounds(25, 140, 200, 25);
        frame.add(priceGame);
        JTextField isiPriceGame = new JTextField();
        isiPriceGame.setBounds(120, 140, 200, 25);
        frame.add(isiPriceGame);

        JButton transButton = new JButton("Transactions");
        transButton.setBounds(50, 20, 200, 25);
        frame.add(transButton);
        transButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                new MenuTransactions(user);
            }
        });
        ArrayList<Games> listGames = Controller.getAllGames();

        DefaultTableModel tableModel = new DefaultTableModel();

        JTable table = new JTable(tableModel);
        tableModel.addColumn("Name");
        tableModel.addColumn("Genre");
        tableModel.addColumn("Price");

        for (int i = 0; i < listGames.size(); i++) {
            String name = listGames.get(i).getName();
            String genre = listGames.get(i).getGenre();
            String price = listGames.get(i).getPrice();

            Object[] data = {name, genre, price};

            tableModel.insertRow(i, data);

        }
        table.setBounds(50, 50, 400, 200);
        table.setRowHeight(100);

        JButton buyGameButton = new JButton("Buy Game");
        buyGameButton.setBounds(150, 270, 150, 25);
        frame.add(buyGameButton);
        // frame.add(isiFoto);

        buyGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                String addNameGame = isiNamaGame.getText();
                String addGenreGame = isiGenreGame.getText();
                String addPriceGame = (String) isiPriceGame.getText();
                
            }
        });

        frame.setVisible(true);
    }

    

    // public static void main(String[] args) {
    //     new GameList();
    // }
}
