package de.dsa.packagegen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AddRightsPackage extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField tfExpiryHours;
    private JTextField tfExpiryDays;
    private JComboBox cbRightsPackage;
    private String[] data = { "", "", "", "" };
    final static private String XML_FILE = "C:/export_runtimerightpackage_000000.xml";

    // /**
    // * Launch the application.
    // */
    // public static void main(String[] args) {
    // try {
    // AddRightsPackage dialog = new AddRightsPackage();
    // dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    // dialog.setVisible(true);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    /**
     * Create the dialog.
     */
    public AddRightsPackage(Frame f) {
        super(f, true);
        setBounds(100, 100, 550, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
        gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
        gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0,
                Double.MIN_VALUE };
        gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, Double.MIN_VALUE };
        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel lblLaufzeitrechtePaket = new JLabel("Laufzeitrechte Paket");
            GridBagConstraints gbc_lblLaufzeitrechtePaket = new GridBagConstraints();
            gbc_lblLaufzeitrechtePaket.anchor = GridBagConstraints.EAST;
            gbc_lblLaufzeitrechtePaket.insets = new Insets(0, 0, 5, 5);
            gbc_lblLaufzeitrechtePaket.gridx = 0;
            gbc_lblLaufzeitrechtePaket.gridy = 0;
            contentPanel
                    .add(lblLaufzeitrechtePaket, gbc_lblLaufzeitrechtePaket);
        }

        String[] lzr = parserXml(new File(XML_FILE));

        cbRightsPackage = new JComboBox(lzr);
        GridBagConstraints gbc_cbRightsPackage = new GridBagConstraints();
        gbc_cbRightsPackage.insets = new Insets(0, 0, 5, 0);
        gbc_cbRightsPackage.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbRightsPackage.gridx = 1;
        gbc_cbRightsPackage.gridy = 0;
        contentPanel.add(cbRightsPackage, gbc_cbRightsPackage);

        {
            JLabel lblAblaufdatumtage = new JLabel("Ablaufdatum (Tage: 0-2047)");
            GridBagConstraints gbc_lblAblaufdatumtage = new GridBagConstraints();
            gbc_lblAblaufdatumtage.anchor = GridBagConstraints.EAST;
            gbc_lblAblaufdatumtage.insets = new Insets(0, 0, 5, 5);
            gbc_lblAblaufdatumtage.gridx = 0;
            gbc_lblAblaufdatumtage.gridy = 1;
            contentPanel.add(lblAblaufdatumtage, gbc_lblAblaufdatumtage);
        }
        {
            tfExpiryDays = new JTextField();
            tfExpiryDays.setDocument(new JTextFieldLimit(4));
            GridBagConstraints gbc_tfExpiryDays = new GridBagConstraints();
            gbc_tfExpiryDays.insets = new Insets(0, 0, 5, 0);
            gbc_tfExpiryDays.fill = GridBagConstraints.HORIZONTAL;
            gbc_tfExpiryDays.gridx = 1;
            gbc_tfExpiryDays.gridy = 1;
            contentPanel.add(tfExpiryDays, gbc_tfExpiryDays);
            tfExpiryDays.setColumns(10);
        }
        {
            JLabel lblAblaufdatumstunden = new JLabel(
                    "Ablaufdatum (Stunden: 0-23)");
            GridBagConstraints gbc_lblAblaufdatumstunden = new GridBagConstraints();
            gbc_lblAblaufdatumstunden.anchor = GridBagConstraints.EAST;
            gbc_lblAblaufdatumstunden.insets = new Insets(0, 0, 5, 5);
            gbc_lblAblaufdatumstunden.gridx = 0;
            gbc_lblAblaufdatumstunden.gridy = 2;
            contentPanel.add(lblAblaufdatumstunden, gbc_lblAblaufdatumstunden);
        }
        {
            tfExpiryHours = new JTextField();
            tfExpiryHours.setDocument(new JTextFieldLimit(2));
            GridBagConstraints gbc_tfExpiryHours = new GridBagConstraints();
            gbc_tfExpiryHours.insets = new Insets(0, 0, 5, 0);
            gbc_tfExpiryHours.fill = GridBagConstraints.HORIZONTAL;
            gbc_tfExpiryHours.gridx = 1;
            gbc_tfExpiryHours.gridy = 2;
            contentPanel.add(tfExpiryHours, gbc_tfExpiryHours);
            tfExpiryHours.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (checkDays() && checkHours()) {
                            String rightsPackage = (String) cbRightsPackage
                                    .getSelectedItem();
                            int idx = rightsPackage.lastIndexOf('|');
                            data[0] = rightsPackage.substring(0, idx).trim();
                            data[1] = rightsPackage.substring(idx + 1,
                                    rightsPackage.length()).trim();
                            data[2] = tfExpiryDays.getText();
                            data[3] = tfExpiryHours.getText();
                            dispose();

                        }
                    }
                });
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
            }
        }
    }

    private boolean checkDays() {
        String dayStr = tfExpiryDays.getText();
        if (isIntNumber(dayStr)) {
            int day = Integer.parseInt(dayStr);
            if (day >= 0 && day <= 2047) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(new JFrame(),
                "Ablaufdatum(Tage) must be number and 0-2047", "Error",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private boolean checkHours() {
        String hourStr = tfExpiryHours.getText();
        if (isIntNumber(hourStr)) {
            int hour = Integer.parseInt(hourStr);
            if (hour >= 0 && hour < 24) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(new JFrame(),
                "Ablaufdatum(Stunden) must be number and 0-23", "Error",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private boolean isIntNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String[] getData() {
        return data;
    }

    private String[] parserXml(File file) {
        // RuntimeRightPackage//DisplayName
        // RuntimeRightPackage//No
        List<String> list = new ArrayList<String>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            // System.out.println("Root element " + doc.getDocumentElement().getNodeName());
            NodeList nodeLst = doc.getElementsByTagName("RuntimeRightPackage");
            //System.out.println("Information of all RuntimeRightPackage");

            for (int s = 0; s < nodeLst.getLength(); s++) {
                Node fstNode = nodeLst.item(s);
                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element fstElmnt = (Element) fstNode;
                    NodeList fstNmElmntLst = fstElmnt
                            .getElementsByTagName("DisplayName");
                    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    // System.out.println("DisplayName : " + ((Node) fstNm.item(0)).getNodeValue());
                    NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("No");
                    Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
                    NodeList lstNm = lstNmElmnt.getChildNodes();
                    // System.out.println("No : " + ((Node) lstNm.item(0)).getNodeValue());
                    list.add(((Node) fstNm.item(0)).getNodeValue() + " | "
                            + ((Node) lstNm.item(0)).getNodeValue());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[list.size()]);
    }

}
