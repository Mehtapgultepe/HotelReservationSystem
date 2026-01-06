package hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 * AvailableRoomsFrame sınıfı, oteldeki mevcut ve boş odaları listeleyen GUI penceresidir.
 * Kullanıcı boş odaları tablo şeklinde görebilir ve 1 günlük fiyatlarını görüntüleyebilir.
 * 
 * Oluşturulan tablo oda numarası, oda tipi (Deluxe veya Standard) ve günlük fiyat sütunlarını içerir.
 * Eğer boş oda yoksa kullanıcıya bilgilendirme mesajı gösterilir.
 */
public class AvailableRoomsFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public AvailableRoomsFrame(Hotel hotel) {

        setTitle("Available Rooms");
        setSize(500, 350);
        setLayout(new BorderLayout());

        // Tablo kolonları
        String[] columns = {"Room No", "Type", "Price (1 Day)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        List<Room> rooms = hotel.getRooms();
        boolean found = false;
     // Boş odaları tabloya ekle
        for (Room room : rooms) {
            if (room.isAvailable()) {

                String type = (room instanceof DeluxeRoom) ? "Deluxe" : "Standard";

                model.addRow(new Object[]{
                        room.getRoomNumber(),
                        type,
                        room.calculatePrice(1)
                });

                found = true;
            }
        }
     // Eğer boş oda yoksa bilgilendirme mesajı göster
        if (!found) {
            JOptionPane.showMessageDialog(this, "No rooms available!");
        }

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnClose = new JButton("Back to Menu");
        btnClose.addActionListener(e -> dispose());
        add(btnClose, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}