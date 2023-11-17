package View;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Model.Transactions;
import Model.Users;

public class MenuTransactions {
    JFrame frame;

    public MenuTransactions(Users loginUser) {

        //ini copyan dari tugas lalu" ci:(
        frame = new JFrame("Sistem Pencarian Film");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        String userName = loginUser.getName();
        JLabel homePageLabel = new JLabel("Selamat Datang, " + userName + "! Senang berjumpa dengan Anda.");
        frame.add(homePageLabel, BorderLayout.NORTH);

        ArrayList<Transactions> toDoList = Controller.getToDoList(loginUser.getIdUser());

        // Create columns for the table
        String[] columns = { "ID", "Title", "Note" };
        Object[][] data = new Object[toDoList.size()][columns.length];

        // Fill data array with userTodos information
        for (int i = 0; i < toDoList.size(); i++) {
            data[i][0] = toDoList.get(i).getId();
            data[i][1] = toDoList.get(i).getTitle();
            data[i][2] = toDoList.get(i).getNote();
        }

        // Create JTable with data and columns
        DefaultTableModel tableModel = new DefaultTableModel(data, columns);
        JTable todoTable = new JTable(tableModel);

        // Set up JScrollPane to contain the JTable
        JScrollPane scrollPane = new JScrollPane(todoTable);
        frame.add(scrollPane, BorderLayout.CENTER);
    }
}
