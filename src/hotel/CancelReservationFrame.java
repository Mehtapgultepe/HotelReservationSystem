package hotel;

import javax.swing.*;
/**
 * CancelReservationFrame sınıfı, kullanıcıların mevcut bir rezervasyonu iptal edebilmesini sağlayan GUI penceresidir.
 * Kullanıcı oda numarasını girerek rezervasyonu iptal edebilir. Başarılı veya başarısız durumlar için
 * bilgilendirme mesajları gösterilir.
 */

public class CancelReservationFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    /** Rezervasyonu iptal edilecek oda numarasını almak için metin alanı */
	private JTextField txtRoom;
    private Hotel hotel;
    /**
     * CancelReservationFrame yapıcı metodu.
     * GUI bileşenlerini oluşturur ve rezervasyon iptal işlevini tanımlar.
     */

    public CancelReservationFrame(Hotel hotel){

        this.setHotel(hotel);
        setTitle("Cancel Reservation");
        setSize(300,150);
     // GUI bileşenlerini oluşturur
        JLabel lbl = new JLabel("Room Number:");
        txtRoom = new JTextField(10);

        JButton btnCancel = new JButton("Cancel Reservation");
     // İptal butonuna aksiyon ekle
        btnCancel.addActionListener(e -> {
            int roomNo = Integer.parseInt(txtRoom.getText());
            if(hotel.cancelReservation(roomNo))
                JOptionPane.showMessageDialog(this,"Reservation cancelled!");
            else
                JOptionPane.showMessageDialog(this,"This room is not reserved!");
        });
     // Panel oluştur ve bileşenleri ekler
        JPanel p = new JPanel();
        p.add(lbl);
        p.add(txtRoom);
        p.add(btnCancel);

        add(p);
        setLocationRelativeTo(null);
        setVisible(true);
    }

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
