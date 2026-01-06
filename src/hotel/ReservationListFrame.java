package hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Sistemdeki tüm rezervasyon kayıtlarını tablo halinde
 * görüntülemek için kullanılan arayüz sınıfıdır.
 * Veriler reservations.txt dosyasından çekilir.
 */
public class ReservationListFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    /** Rezervasyonların listelendiği tablo */
    private JTable table;
    private DefaultTableModel model;

    public ReservationListFrame() {

        setTitle("Hotel Reservation Records");
        setSize(700, 400);
        setLayout(new BorderLayout());

        // Tablo kolonları
        String[] columns = {"Room No", "Customer Name", "TC No", "Phone", "Days", "Total Price", "Date"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        // Dosyadan oku ve tabloya ekle
        try (BufferedReader br = new BufferedReader(new FileReader("reservations.txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length >= 7) {
                    model.addRow(new Object[]{
                        data[0], // Room No
                        data[1], // Customer Name
                        data[2], // TC No
                        data[3], // Phone
                        data[4], // Days
                        data[5], // Total Price
                        data[6]  // Date
                    });
                    found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "No reservations found in file!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Could not read reservations.txt!");
        }

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> dispose());
        add(btnClose, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
