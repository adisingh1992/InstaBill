package instabill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author scorpion
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        jTextField1.addKeyListener(new KeyListeners(jTextField1));
        jPasswordField1.addKeyListener(new KeyListeners(jPasswordField1));
        jButton1.addKeyListener(new KeyListeners(jButton1));
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(232, 232, 232));
        jPanel1.setToolTipText("");

        jTextField1.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jTextField1.setMaximumSize(new java.awt.Dimension(175, 35));
        jTextField1.setMinimumSize(new java.awt.Dimension(175, 35));
        jTextField1.setPreferredSize(new java.awt.Dimension(175, 35));

        jPasswordField1.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N

        jButton1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 15)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/instabill/images/login.png"))); // NOI18N
        jButton1.setText("Login");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setContentAreaFilled(false);
        jButton1.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome To InstaBill");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login To Continue");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(131, 131, 131))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton1ActionPerformed
        try {
            String username = jTextField1.getText();
            String password = new String(jPasswordField1.getPassword());
            authenticateUser(username, password);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_JButton1ActionPerformed

    private void authenticateUser(String username, String password) throws SQLException {
        if (username.isEmpty() || password.isEmpty()) {
            showMessageDialog(null, "Please Provide The Details Correctly!");
            return;
        }
        DBase DB = new DBase();
        Connection conn = DB.dbConnect();
        String sql = "SELECT username, password FROM users WHERE username = ? AND password = ? LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    showMessageDialog(null, "Invalid Credentials, Try Again!");
                } else {
                    UserData userdata = UserData.getInstance();
                    userdata.setUserData(username, password);
                    this.dispose();
                    java.awt.EventQueue.invokeLater(() -> {
                        new dashboard();
                    });
                }
            }
        }
        DB.dbClose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}