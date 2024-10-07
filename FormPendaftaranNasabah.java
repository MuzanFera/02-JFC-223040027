import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormPendaftaranNasabah extends JFrame {
    
    private JTextField namaField;
    private JTextField nomorHpField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JSpinner transaksiSpinner;
    private JSpinner tanggalLahirSpinner;
    private JTextArea outputArea;
    private JList<String> tabunganList;

    public FormPendaftaranNasabah() {
        setTitle("Form Pendaftaran Nasabah Bank");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Title
        JLabel formTitle = new JLabel("Form Pendaftaran Nasabah Bank");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 20, 0);
        add(formTitle, gbc);

        // Label for "Nama"
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel namaLabel = new JLabel("Nama:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(namaLabel, gbc);

        // Text field for "Nama"
        namaField = new JTextField(15);
        gbc.gridx = 1;
        add(namaField, gbc);

        // Label for "Nomor HP"
        JLabel nomorHpLabel = new JLabel("Nomor HP:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(nomorHpLabel, gbc);

        // Text field for "Nomor HP"
        nomorHpField = new JTextField(15);
        gbc.gridx = 1;
        add(nomorHpField, gbc);

        // Label for "Jenis Tabungan"
        JLabel jenisTabunganLabel = new JLabel("Jenis Tabungan:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(jenisTabunganLabel, gbc);

        // JList for Tabungan
        String[] tabunganOptions = {"Tabungan A", "Tabungan B", "Tabungan C", "Tabungan D"};
        tabunganList = new JList<>(tabunganOptions);
        tabunganList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane tabunganScrollPane = new JScrollPane(tabunganList);
        tabunganScrollPane.setPreferredSize(new Dimension(150, 60));
        gbc.gridx = 1;
        add(tabunganScrollPane, gbc);

        // Label for "Frekuensi Transaksi"
        JLabel transaksiLabel = new JLabel("Frekuensi Transaksi per Bulan:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(transaksiLabel, gbc);

        // JSpinner for Frekuensi Transaksi
        transaksiSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        gbc.gridx = 1;
        add(transaksiSpinner, gbc);

        // Label for "Tanggal Lahir"
        JLabel tanggalLahirLabel = new JLabel("Tanggal Lahir:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(tanggalLahirLabel, gbc);

        // JSpinner for Tanggal Lahir
        tanggalLahirSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(tanggalLahirSpinner, "dd-MM-yyyy");
        tanggalLahirSpinner.setEditor(dateEditor);
        gbc.gridx = 1;
        add(tanggalLahirSpinner, gbc);

        // Label for "Password"
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(passwordLabel, gbc);

        // Password field for "Password"
        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordField, gbc);

        // Label for "Confirm Password"
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(confirmPasswordLabel, gbc);

        // Password field for "Confirm Password"
        confirmPasswordField = new JPasswordField(15);
        gbc.gridx = 1;
        add(confirmPasswordField, gbc);

        // Output area
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 5, 10, 5);
        add(outputScrollPane, gbc);

        // Button "Daftar"
        JButton daftarButton = new JButton("Daftar");
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 9;
        daftarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                
                if (password.equals(confirmPassword)) {
                    String nama = namaField.getText();
                    String nomorHP = nomorHpField.getText();
                    String tabungan = tabunganList.getSelectedValue();
                    int frekuensiTransaksi = (Integer) transaksiSpinner.getValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String tanggalLahir = dateFormat.format((Date) tanggalLahirSpinner.getValue());

                    outputArea.setText("Pendaftaran Berhasil!\n");
                    outputArea.append("Nama: " + nama + "\n");
                    outputArea.append("Nomor HP: " + nomorHP + "\n");
                    outputArea.append("Jenis Tabungan: " + tabungan + "\n");
                    outputArea.append("Frekuensi Transaksi: " + frekuensiTransaksi + " kali/bulan\n");
                    outputArea.append("Tanggal Lahir: " + tanggalLahir + "\n");
                } else {
                    outputArea.setText("Password dan Konfirmasi Password tidak cocok!");
                }
            }
        });
        add(daftarButton, gbc);

        // Button "Reset"
        JButton resetButton = new JButton("Reset");
        gbc.gridx = 1;
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        add(resetButton, gbc);

        // Button "Exit"
        JButton exitButton = new JButton("Exit");
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton, gbc);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        resetMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        menu.add(resetMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitMenuItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Set frame properties
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void resetForm() {
        namaField.setText("");
        nomorHpField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        transaksiSpinner.setValue(1);
        tanggalLahirSpinner.setValue(new Date());
        tabunganList.clearSelection();
        outputArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormPendaftaranNasabah().setVisible(true);
        });
    }
}
