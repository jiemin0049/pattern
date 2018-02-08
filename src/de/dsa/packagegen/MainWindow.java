package de.dsa.packagegen;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    private static MainWindow frame;
    private JTextField tfPcid;
    private JTextField tfCreationDate;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnCreate;
    private boolean useTableWatermark = true;
    DefaultTableModel tabModel;
    final String[] columnNames = { "Laufzeitrechte Paket", "Paket ID", "Ablaufdatum (Tage)", "Ablauftage (Stunden)" };
    final static int PCID_LENGTH = 8;

    /**
     * Create the frame.
     * @throws MalformedURLException
     */
    public MainWindow() throws MalformedURLException {
        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
        add(basic);

        // ----------------top------------------
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        JLabel lblPcid = new JLabel("PC-ID(8 Chars)");
        topPanel.add(lblPcid);

        tfPcid = new JTextField();
        tfPcid.setDocument(new JTextFieldLimit(8));
        topPanel.add(tfPcid);

        JLabel lblCreationDate = new JLabel("Creation Date(yyyy.MM.dd)");
        topPanel.add(lblCreationDate);

        tfCreationDate = new JTextField();
        tfCreationDate.setDocument(new JTextFieldLimit(10));
        topPanel.add(tfCreationDate);
        basic.add(topPanel);

        // --------------table------------
        tabModel = new DefaultTableModel(null, columnNames);
        table = new JTable(tabModel);
        scrollPane = new JScrollPane();
        if (useTableWatermark) {
            scrollPane = new TableWatermark(table, new File("c:/8d218d4330.png").toURL());
        } else {
            scrollPane.setViewportView(table);
        }

        btnCreate = new JButton("Create LZR File");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PackageGenerator.generatePcidData(tabModel, tfPcid.getText(), tfCreationDate.getText());
                PackageGenerator.generateSign(tfPcid.getText(), tfCreationDate.getText());
                PackageGenerator.generateZip(tfPcid.getText(), tfCreationDate.getText());
            }
        });
        basic.add(scrollPane);

        // ---------------bottom------------
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnAdd = new JButton("Add LZR");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddRightsPackage dialog = new AddRightsPackage(frame);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                tabModel.addRow(dialog.getData());
            }
        });
        btnDelete = new JButton("Delete LZR");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tabModel.removeRow(selectedRow);
                }
            }
        });
        btnCreate = new JButton("Create LZR File");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((tfPcid.getText().length() != 8)) {
                    JOptionPane.showMessageDialog(new JFrame(), "PC-ID must 8 chars", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                PackageGenerator.generatePcidData(tabModel, tfPcid.getText(), tfCreationDate.getText());
                PackageGenerator.generateSign(tfPcid.getText(), tfCreationDate.getText());
                PackageGenerator.generateZip(tfPcid.getText(), tfCreationDate.getText());
            }
        });
        bottomPanel.add(btnAdd);
        bottomPanel.add(btnDelete);
        bottomPanel.add(btnCreate);
        basic.add(bottomPanel);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new MainWindow();
                    frame.setSize(800, 600);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
