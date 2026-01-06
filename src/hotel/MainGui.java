package hotel;

import javax.swing.*;
import java.awt.*;
/**
 * MainGui sınıfı, otel yönetim sistemi için ana grafik kullanıcı arayüzünü sağlar.
 * Bu arayüz üzerinden kullanıcı yeni rezervasyon ekleyebilir, mevcut rezervasyonları görüntüleyebilir,
 * müsait odaları görebilir ve rezervasyon iptali yapabilir.
 */

public class MainGui extends JFrame {

    private static final long serialVersionUID = 1L;
    /** Otel nesnesi, tüm rezervasyon ve oda bilgilerini tutar */
	private Hotel hotel;
	/**
     * MainGui sınıfının yapıcı metodu.
     * GUI bileşenlerini oluşturur, renkleri ve butonları ayarlar ve olay dinleyicilerini ekler.
     */

    public MainGui(){

        hotel = new Hotel("Queen Hotel");

        setTitle("Hotel Management System");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(220, 235, 255)); // açık mavi

        JButton btnAdd = new JButton("New Reservation");
        JButton btnView = new JButton("View Reservation Details");
        JButton btnAvailable = new JButton("Available Rooms");
        JButton btnCancel = new JButton("Cancel Reservation"); 
        
        
     // Buton renklerini ayarlamak
        btnAdd.setBackground(new Color(255,182,193));
        btnView.setBackground(new Color(255,182,193));
        btnAvailable.setBackground(new Color(255,182,193));
        btnCancel.setBackground(new Color(255,182,193));
     // Butonlara aksiyon eklemek
        btnAdd.addActionListener(e -> new AddReservationFrame(hotel));
        btnView.addActionListener(e -> new ReservationListFrame());
        btnAvailable.addActionListener(e -> new AvailableRoomsFrame(hotel));
        btnCancel.addActionListener(e -> new CancelReservationFrame(hotel)); 

        setLayout(new GridLayout(4,1,10,10));
        
     // Butonları ekle
        add(btnAdd);
        add(btnView);
        add(btnAvailable);
        add(btnCancel);  

        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * Uygulamanın giriş noktası.
     * MainGui sınıfını başlatır ve ana pencereyi açar.
     */
    public static void main(String[] args) {
        new MainGui();
    }
}