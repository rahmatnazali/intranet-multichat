/**
 * Created by rahmat
 */

package multichatguiclient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.text.Position;


public class ClientFrame extends javax.swing.JFrame{                            // class berisi GUI dan implementasinya agar client dapat chatting
                                                                                // ----------------- variable utama --------------------------------------//
    private static Socket clientSocket = null;                                  // buat client socket
    private static PrintStream os = null;                                       // buat output stream
    private static DataInputStream is = null;                                   // buat input stream
    private static BufferedReader inputLine = null;                             // buat buffereader untuk menerima pesan dari server
    private static String message = null;                                       // buat string untuk menampung pesan dari user
    DefaultListModel<String> model = new DefaultListModel<>();                  // buat list model untuk panduan pembuatan JList
    private int portNumber = 1234;                                              // buat port dan isi default
    private String host = "localhost";                                          // buat host dan isi default dengan "localhost"
    
                                                                                // ----------------- constructor frame & fungsi --------------------------//
    public ClientFrame() {
        initComponents();                                                       // buat komponen GUI sesuai perancangan
        this.userList = new JList<>( model );                                   // targetkan Jlist yang sudah dibuat agar menggunakan list model
        Random r = new Random();                                                // generate username random - jika saja client tidak ingin mengisi
        int result = r.nextInt(9999-1000) + 1000;
        this.usernameInput.setText("Guest-" + result);
        this.chatSendButton.setEnabled(false);                                  // sebelum di sambung, input area di disable
        this.groupCombobox.setEnabled(false);
        this.groupJoinButton.setEnabled(false);
        this.chatStoryBoard.setText(null);
        this.chatInputTextArea.setText(null);
        this.chatInputTextArea.setEnabled(false);
    }
    
    public static void main(String args[]) {
        
        try {                                                                   /* Set tampilan ke Nimbus */
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }  
        java.awt.EventQueue.invokeLater(new Runnable() {                        /* Buat form lalu tampilkan */
            public void run() {
                new ClientFrame().setVisible(true);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        chatSendButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatStoryBoard = new javax.swing.JTextArea();
        grupNowLabel = new javax.swing.JLabel();
        groupCombobox = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        chatInputTextArea = new javax.swing.JTextArea();
        groupJoinButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hostInput = new javax.swing.JTextField();
        portInput = new javax.swing.JTextField();
        sambungButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Chat");

        userList.setModel(model);
        userList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        userList.setToolTipText("Klik 2x untuk chat pribadi");
        jScrollPane1.setViewportView(userList);

        jLabel1.setText("User yang terdaftar");

        chatSendButton.setText("Kirim");
        chatSendButton.setToolTipText("Kirim pesan");
        chatSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatSendButtonActionPerformed(evt);
            }
        });

        chatStoryBoard.setEditable(false);
        chatStoryBoard.setColumns(20);
        chatStoryBoard.setLineWrap(true);
        chatStoryBoard.setRows(5);
        chatStoryBoard.setWrapStyleWord(true);
        chatStoryBoard.setAutoscrolls(false);
        jScrollPane2.setViewportView(chatStoryBoard);

        grupNowLabel.setText("Grup saat ini : ");

        groupCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grup Utama", "IT", "Keuangan", "Manajerial" }));
        groupCombobox.setToolTipText("Pilih grup yang ingin diikuti");

        chatInputTextArea.setColumns(20);
        chatInputTextArea.setLineWrap(true);
        chatInputTextArea.setRows(5);
        chatInputTextArea.setToolTipText("Ketikkan pesan. \\quit untuk keluar");
        chatInputTextArea.setWrapStyleWord(true);
        chatInputTextArea.setAutoscrolls(false);
        jScrollPane3.setViewportView(chatInputTextArea);

        groupJoinButton.setText("Gabung Grup");
        groupJoinButton.setToolTipText("Gabung ke grup yang dipilih");
        groupJoinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupJoinButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Host :");

        jLabel5.setText("Port :");

        hostInput.setText("localhost");
        hostInput.setToolTipText("masukkan alamat host");
        hostInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostInputActionPerformed(evt);
            }
        });

        portInput.setText("1234");
        portInput.setToolTipText("masukkan port");

        sambungButton.setText("Sambung");
        sambungButton.setToolTipText("tekan untuk mencoba menyambung");
        sambungButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sambungButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("username :");

        usernameInput.setText("Guest");
        usernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameInputActionPerformed(evt);
            }
        });

        jLabel3.setText("(C) DPTSI ITS Surabaya");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hostInput, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sambungButton)
                        .addGap(94, 208, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grupNowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chatSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(groupCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupJoinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(hostInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sambungButton)
                    .addComponent(grupNowLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(groupCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupJoinButton))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
                                                                                // jika tombol kirim ditekan
    private void chatSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatSendButtonActionPerformed
        if(!this.chatInputTextArea.getText().equals(null)){                     // selama form input terisi (tidak null)
            if(this.chatInputTextArea.getText().startsWith("@join")){           // jika user meminta join grup, maka label di client juga harus diganti
                String message = this.chatInputTextArea.getText();
                String container[] = message.split("#", 2);
                message = container[1];                                
                if(message.equals("Grup Utama") ||                              // hanya diteruskan bila grup yang diminta disediakan oleh server
                        message.equals("IT") || 
                        message.equals("Keuangan") || 
                        message.equals("Manajerial")){
                    this.grupNowLabel.setText("Grup saat ini : " + message);
                    os.println(this.chatInputTextArea.getText());
                }
                else{                                                           // jika salah, maka akan muncul pesan error
                    JOptionPane.showMessageDialog(this, 
                            "Grup tidak disediakan server", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else                                                                // jika tidak ada perintah khusus yang bisa ditangani di client, maka kirim pesan
            os.println(this.chatInputTextArea.getText());
            this.chatInputTextArea.setText(null);                               // tiap akhir opreasi, selalu setting chat input kembali ke null
        }
    }//GEN-LAST:event_chatSendButtonActionPerformed

                                                                                // jika tombol "Gabung Grup" ditekan, secara otomatis mengirim pesan untuk join grup, sama dengan ketik manual "@join#xxx"
    private void groupJoinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupJoinButtonActionPerformed
        String newGroup = this.groupCombobox.getSelectedItem().toString();
        if(newGroup.equals("Grup Utama") || 
                newGroup.equals("IT") || 
                newGroup.equals("Keuangan") || 
                newGroup.equals("Manajeral")){
            os.println("@join#" + newGroup);
            grupNowLabel.setText("Grup saat ini: " + newGroup);
        }
    }//GEN-LAST:event_groupJoinButtonActionPerformed

    private void hostInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostInputActionPerformed
        // Sementara kosongkan dahulu
    }//GEN-LAST:event_hostInputActionPerformed

                                                                                // jika menekan tombol sambung (memulai chat)
    private void sambungButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sambungButtonActionPerformed
        this.chatInputTextArea.setEnabled(true);                                // sesuaikan GUI agar bsia dioperasikan client1
        this.grupNowLabel.setText("Grup saat ini : " + "Grup Utama");           // ubah title untuk menginfokan bahwa default grup adalah Grup Utama
                                                                                // disable kan semua GUI yang sudah tidak diperlukan
        this.hostInput.setEnabled(false);                                           // form input host
        this.portInput.setEnabled(false);                                           // form input port
        this.usernameInput.setEnabled(false);                                       // form input username
        this.sambungButton.setText("Tersambung");                                   // update button tersambung
        this.sambungButton.setEnabled(false);                                       // tombol sambung
                                                                                // enable kan GUI yang penting
        this.chatSendButton.setEnabled(true);                                       // tombol Kirim chat
        this.groupCombobox.setEnabled(true);                                        // combobox list grup
        this.groupJoinButton.setEnabled(true);                                      // tombol gabung grup

        String myName = this.usernameInput.getText().trim();                    // ambil username yang diisikan client

        Sender sender = new Sender(myName);                                     // jalankan Thread Sender, untuk melayani pengiriman pesan
        sender.start();
    }//GEN-LAST:event_sambungButtonActionPerformed

    private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed
        // sementara kosongkan dahulu
    }//GEN-LAST:event_usernameInputActionPerformed
    
                                                                                // ---------------------- class untuk Reader dan Sender -----------------------------//
      
    public class Reader extends Thread{                                         // membaca inputan dari server --> munculkan di chatStoryBoard client
        @Override
        public void run() {
            String responseLine;                                                // string untuk menampung pesan dari server
            try {                                                               // mencoba untuk mulai melayani
                while ((responseLine = is.readLine()) != null) {                // selama pesan dari server tidak null (menunggu diisi)
                    if (responseLine.equals("QUIT")){                           // jika server memerintahkan untuk keluar, maka keluar
                        os.close();
                        is.close();
                        clientSocket.close();
                        System.exit(0);
                    }
                                                                                // kondisi lain seperti update list, sesuai dengan kode :
                                                                                /*
                                                                                    [01] notification
                                                                                    [02] user joined
                                                                                    [03] user left
                                                                                    [04] delete all list
                                                                                    [05] user change group
                                                                                    [06] user broadcast chat
                                                                                    [07] user private message
                                                                                */
                    
                    else if(responseLine.startsWith("[02]")){                   // tambahkan user ke user list
                        model.addElement(responseLine.substring(5));
                    }
                    else if(responseLine.startsWith("[03]")){                   // kurangkan user dari user list
                        String userLeft = responseLine.substring(5);            // ambil nilai index user yang ingin dihapus, lalu hapus
                        int index = userList.getNextMatch(userLeft, 0, 
                                Position.Bias.Forward);
                        if(index != -1) model.remove(index);
                    }
                    else if(responseLine.equals("[04]")){                       // hapus seluruh userlist
                        model.removeAllElements();                              // kosongakan semua userlist, untuk kemudian ditulis ulang
                    }
                    else                                                        // sisanya,  tampilkan pesan dari server
                    chatStoryBoard.append(responseLine+ "\n");
                }
                os.close();                                                     // jika selesai dari while, langsung close
                is.close();
                clientSocket.close();
                System.exit(0);
            } catch (IOException e) {
                chatStoryBoard.append("\nIOException:  " + e + "\n");
            }
        }
    }
    
    
    public class Sender extends Thread{                                         // class Sender untuk menangani pengiriman pesan dari client ke server
        String username;                                                        // username client
        Sender(String username){                                                // konstruktor: menggunakan parameter masukan sebagai user name
            this.username = username;
        }
        
        @Override                                                               // overriding run methodnya
        public void run(){
                                                                                // ------------------------- inisialisasi ------------------------//
            
            host = hostInput.getText();                                         // mengambil host yang diinginkan client
            portNumber = Integer.parseInt(portInput.getText());                 // mengambil nilai port yang dimasukkan
            chatStoryBoard.setText(null);                                       // set storyboard ke null (mirip dengan clear screen)
            chatStoryBoard.append("Java MultiChat GUI <"+ host + 
                    "> <" + portNumber +">\n");                                 // tulis iformasi pada awal operasi
            setTitle("Client Chat <" + host + ":" + portNumber + 
                    "> " + this.username);                                      // update title aplikasi
            
                                                                                // ------------------------ membuka socket -----------------------//
            try{                                                                // mencoba membuat I/O stream
                clientSocket = new Socket(host, portNumber);                    // buat clientsocket sesuai host dan portnumber yang diinginkan
                inputLine = new BufferedReader(new InputStreamReader(System.in));// buat bufferreader untuk menampung pesan ketikan client
                os = new PrintStream(clientSocket.getOutputStream());           // buat I/O stream
                is = new DataInputStream(clientSocket.getInputStream());
            }
            catch(UnknownHostException e){
                chatStoryBoard.append("Host tidak ditemukan <" + host + ":" 
                        + portNumber + ">\n");
            }
            catch(IOException e){
                chatStoryBoard.append("Tidak dapat menstabilkan I/O\n");
            }           
                                                                                // ----------------- menyiapkan thread chat --------------------------//
            if(clientSocket != null && os != null && is != null){               // jika socket tersebu valid (bisa diakses), maka layani
                    os.println(this.username);                                  // kirimkan username nya ke server agar dicatat        
                    Reader reader = new Reader();                               // buat thread Reader dan jalankan
                    reader.start();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea chatInputTextArea;
    private javax.swing.JButton chatSendButton;
    protected javax.swing.JTextArea chatStoryBoard;
    private javax.swing.JComboBox<String> groupCombobox;
    private javax.swing.JButton groupJoinButton;
    private javax.swing.JLabel grupNowLabel;
    protected javax.swing.JTextField hostInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JTextField portInput;
    private javax.swing.JButton sambungButton;
    private javax.swing.JList<String> userList;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
