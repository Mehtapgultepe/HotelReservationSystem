package hotel;

import javax.swing.*;
/**
 * Kullanıcının yeni rezervasyon oluşturmasını sağlayan arayüz sınıfıdır.
 * Müşteri bilgileri, oda numarası, kalış süresi ve ödeme yöntemi alınır.
 * Gerekli doğrulamalar yapıldıktan sonra rezervasyon sisteme kaydedilir.
 */

public class AddReservationFrame extends JFrame {
    private static final long serialVersionUID = 1L;
	private JTextField txtTC, txtName, txtRoom,txtPhone, txtDays;
    private JComboBox<String> comboPayment;
    private JButton btnSave;
    private Hotel hotel; // Mevcut otel verilerine erişim için

    public AddReservationFrame(Hotel hotel) {
        this.hotel = hotel;

        setTitle("New Reservation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /** Müşteri TC numarası girişi */

        txtTC = new JTextField();
        txtName = new JTextField();
        txtPhone = new JTextField();
        txtRoom = new JTextField();
        txtDays = new JTextField();
        /** Ödeme yöntemi seçim kutusu */

        comboPayment = new JComboBox<>(new String[]{"Credit Card","Cash"});
        btnSave = new JButton("Complete Reservation");
        btnSave.addActionListener(e -> saveAction());

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel lblTC = new JLabel("Customer TC:");
        JLabel lblName = new JLabel("Customer Name:");
        JLabel lblPhone = new JLabel("Customer Phone:");
        JLabel lblRoom = new JLabel("Room Number:");
        JLabel lblDays = new JLabel("Stay Duration (Days):");
        JLabel lblPayment = new JLabel("Payment Method:");

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTC).addComponent(lblName).addComponent(lblPhone)
                    .addComponent(lblRoom).addComponent(lblDays).addComponent(lblPayment))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtTC).addComponent(txtName).addComponent(txtPhone)
                    .addComponent(txtRoom).addComponent(txtDays)
                    .addComponent(comboPayment).addComponent(btnSave))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup().addComponent(lblTC).addComponent(txtTC))
                .addGroup(layout.createParallelGroup().addComponent(lblName).addComponent(txtName))
                .addGroup(layout.createParallelGroup().addComponent(lblPhone).addComponent(txtPhone))
                .addGroup(layout.createParallelGroup().addComponent(lblRoom).addComponent(txtRoom))
                .addGroup(layout.createParallelGroup().addComponent(lblDays).addComponent(txtDays))
                .addGroup(layout.createParallelGroup().addComponent(lblPayment).addComponent(comboPayment))
                .addComponent(btnSave)
        );

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void saveAction() {
        try {
            // Verileri al
            String tc = txtTC.getText();
            String name = txtName.getText();
            int roomNo = Integer.parseInt(txtRoom.getText());
            String phone = txtPhone.getText();
            int days = Integer.parseInt(txtDays.getText());
            String method = (String) comboPayment.getSelectedItem();

            // Rezervasyon oluştur (Hotel sınıfındaki mevcut metodunu çağırır)
            
            Reservation res = hotel.createReservation(roomNo, name,tc, phone, days, method);

            if (res != null) {
                // rezervasyon başarılı mesajı
                JOptionPane.showMessageDialog(this,
                        "Reservation successful!\n" +
                        "Customer: " + name);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Room not available or not found!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }
}