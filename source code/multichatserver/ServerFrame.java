/**
 * Created by rahmat
 */

package multichatguiserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ServerFrame extends javax.swing.JFrame {                           // class berisi GUI dan implementasinya agar server dapat memantau chatting
                                                                                // ----------------------- variable utama --------------------------------//
    private static ServerSocket serverSocket = null;                            // pembuatan server socket
    private static Socket clientSocket = null;                                  // pembuatan client socket
    private static final int maxClientsCount = 30;                              // menentukan jumlah maksimal user yang dapat ditampung
    private static final clientThread[] threads = 
            new clientThread[maxClientsCount];
    public DefaultListModel<String> model = new DefaultListModel<>();           // pembuatan model list yang akan digunakan untuk membuat JList user yang online
    int portNumber = 1234;                                                      // membuat port number, dan defaultnya dibuat bernilai 1234
    Scanner input = new Scanner(System.in);                                     // membuat objek Scanner untuk menerima input COMMAND SERVER
    String serverInput;                                                         // membuat string untuk menampung masukan COMMAND SERVER

                                                                                // ----------------------- konstruktor dan method-------------------------//
    public ServerFrame() {
        initComponents();                                                       // buat komponen-komponen GUI sesuai rancangan
        this.userList = new JList<>( model );                                   // JList yang telah dibuat diarahkan ke model list yang tadi sudah dibuat
                                                                                // setting semua tombol dan form isian agar tidak bisa digunakan
        this.serverOFFButton.setEnabled(false);                                     // tombol off
        this.chatInputTextField.setEnabled(false);                                  // form input chat
        this.chatInputTextField.setText(null);                                      // form input chat dikosongkan
        this.userList.setEnabled(false);                                            // list user dimatikan
        try {                                                                   // mencoba mendapatkan alamat server, kemudian menaruhnya masuk ke label IP
            this.ipAddressLabel.setText(Inet4Address.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ipAddressLabel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portInputLabel = new javax.swing.JTextField();
        serverONButton = new javax.swing.JButton();
        serverOFFButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatStoryBoard = new javax.swing.JTextArea();
        chatInputTextField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server frame");

        jLabel1.setText("IP:");

        ipAddressLabel.setEditable(false);

        jLabel2.setText("port: ");

        portInputLabel.setText("1234");
        portInputLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portInputLabelActionPerformed(evt);
            }
        });

        serverONButton.setText("Hidupkan");
        serverONButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverONButtonActionPerformed(evt);
            }
        });

        serverOFFButton.setText("Matikan");
        serverOFFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverOFFButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("User yang terdaftar:");

        userList.setModel(model);
        userList.setToolTipText("");
        jScrollPane1.setViewportView(userList);

        chatStoryBoard.setEditable(false);
        chatStoryBoard.setColumns(20);
        chatStoryBoard.setRows(5);
        jScrollPane2.setViewportView(chatStoryBoard);

        chatInputTextField.setToolTipText("");

        sendButton.setText("Kirim");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Message log code :\n\n[01] notification\n[02] user joined\n[03] user left\n[04] delete all list\n[05] user change group\n[06] user broadcast chat\n[07] user private message\n");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel4.setText("(C) DPTSI ITS Surabaya");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(serverONButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serverOFFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatInputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ipAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(portInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(serverONButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serverOFFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(chatInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sendButton))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void portInputLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portInputLabelActionPerformed
        // Sementara dikosongkan dahulu
    }//GEN-LAST:event_portInputLabelActionPerformed

    // fungsi saat tombol hidupkan server ditekan
    private void serverONButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverONButtonActionPerformed
                                                                                // penyesuaian beberapa elemen GUI agar dapat digunakan
        this.portInputLabel.setEnabled(false);                                      // input port dimatikan
        this.serverONButton.setEnabled(false);                                      // tombol on dimatikan
        this.userList.setEnabled(true);                                             // list user dinyalakan
        this.chatInputTextField.setEnabled(true);                                   // forn input dinyalakan
        this.serverOFFButton.setEnabled(true);                                      // tombol off dinyalkaan
        this.portNumber = Integer.parseInt(this.portInputLabel.getText());      // pengambilan nilai port dari textfield port
        try {                                                                   // mencoba menghidupkan server (up server)
            serverSocket = new ServerSocket(portNumber);                        // membuat server socket dengan menggunakan portnumber yang diminta
        } catch (IOException ex) {
            this.chatStoryBoard.append("Port yang dimasukkan tidak dapat digunakan\n");
        }  
        this.serverONButton.setText("Online");                                  // beri feedback ke user
        this.chatStoryBoard.append("[01] Server telah hidup.\n");               // notifikasi
        
        try {                                                                   // mencoba menambahkan host & port pada title program
            setTitle("Server Frame <" + 
                    Inet4Address.getLocalHost().getHostAddress() + 
                    ": "+ this.portNumber + " >");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Welcomer welcomer = new Welcomer();                                     // membuat thread baru welcomer untuk menyambut user baru
        welcomer.start();                                                       // jalankan thread welcomer
    }//GEN-LAST:event_serverONButtonActionPerformed

    private void serverOFFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverOFFButtonActionPerformed
        System.exit(0);                                                         // jika tombol off ditekan, maka akan keluar
    }//GEN-LAST:event_serverOFFButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        serverInput = chatInputTextField.getText();                             // mengambil command yang diketikkan Administrator
        if(!serverInput.equals(null)){                                          // selama pesan tersebut tidak null
            if(serverInput.equals("QUIT")){                                     // jika Admin ingin menutup server
                chatStoryBoard.append(serverInput + "\n");
                serverOFFButtonActionPerformed(evt);                            // mencoba mematikan server dengan memanggil fungsi tombol Off
            }
            else if(serverInput.equals("list")){                                // jika ingin melihat list user
                for(int i = 0; i < maxClientsCount; i++){
                    if(threads[i] != null && threads[i].name != null && 
                            threads[i].groupName != null){
                        chatStoryBoard.append(i+1 + " " + threads[i].name + 
                                " ["+threads[i].groupName + "]\n");
                    }
                }
                chatStoryBoard.append(serverInput + "\n");
            }
            else if(serverInput.startsWith("kill")){                            // untuk kill user
                String killName = serverInput.substring(5);
                for (int i = 0; i < maxClientsCount; i++) {
                    if (threads[i] != null && threads[i].name.equals(killName)){
                        for (int j = 0; j < maxClientsCount; j++) {
                            if (threads[j] != null && i!=j) {
                                threads[j].os.println("*** User : "+ 
                                        threads[i].name + 
                                        " telah dikeluarkan oleh server ***");
                            }
                        }
                        threads[i].os.println("QUIT");
                        chatStoryBoard.append("[01] User : "+ threads[i].name + 
                                " telah dikeluarkan\n");                          // LOG SERVER
                        threads[i] = null;
                    }
                }
                chatStoryBoard.append(serverInput + "\n"); 
            }
            else{                                                               // jika tidak ada command yang benar
                chatStoryBoard.append("Input salah\n");
            }
        }
        serverInput = null;                                                     // setelah kirim, semua variable penting di reset ke null
        chatInputTextField.setText(null);
    }//GEN-LAST:event_sendButtonActionPerformed

    public static void main(String args[]) {                                    // fungsi main, untuk memanggil GUI
        try {                                                                   // Set ke tampilan Nimbus
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {                        // buat dan keluarkan GUI, kemudian masuk EDT
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }
    
    public class Welcomer extends Thread{                                       // class Welcomer untuk memberi pesan user yang baru saja masuk
        @Override                                                               // langsung override method run untuk kustomisasi
        public void run(){
            try{
                while(true){                                                    // secara terus menerus mencoba menerima user baru
                    clientSocket = serverSocket.accept();                       // mencoba untuk menerima user
                    for (int i = 0; i < maxClientsCount; i++) {                 // iterasi tempat yang kosong untuk menampung user
                        if(i == maxClientsCount -1){                            // jika server sibuk, maka semua penuh terisi user
                            PrintStream os = new PrintStream(
                                    clientSocket.getOutputStream());            // beritahu user bahwa server sibuk, kemudian tutup paksa
                            os.println("Server sedang sibuk. Cobalah beberapa saat lagi");
                            os.close();
                            clientSocket.close();
                        }
                        else if (threads[i] == null) {                          // jika masih ada tempat kosong di server
                            threads[i] = new clientThread(clientSocket, 
                                    threads);                                   // buatkan thread baru untuk menangani layanan chatting
                            threads[i].start();                                 // jalankan thread clientThread
                            break;
                        }
                    }
                }
            }
            catch(IOException e){
                chatStoryBoard.append("[01] Terdapat kesalahan pada Welcomer thread\n");
            }
        }
    }
    
    public class clientThread extends Thread{                                   // class clientThread untuk menangani layanan chatting untuk user
                                                                                // --------------------------- variable -------------------------------//
        private Socket clientSocket = null;                                     // membuat client socket
        private DataInputStream is = null;                                      // membuat input stream untuk membaca message dari client
        public PrintStream os = null;                                           // membuat outputstream (public) untuk mengirimkan pesan ke client
        private final clientThread[] threads;                                   // array of thread yang berisi jalur hubungan ke semua user yang terhubung
        private int maxClientsCount;                                            // variable penyimpan jumlah maksimal user
        public String name;                                                     // nama dari sebuah user
        public String groupName;                                                // nama grup yang sedang diikuti user
                                                                                
        public clientThread(Socket clientSocket, clientThread[] threads){       // ------------------------- konstruktor -----------------------------//
            this.clientSocket = clientSocket;                                   // clientsocket disamakan dengan clientsocket yang diparsing main
            this.threads = threads;                                             // samakan juga semuanya
            maxClientsCount = threads.length;
            this.groupName = "Grup Utama";                                      // secara default, user yang baru masuk diikutkan ke "Grup Utama"
            try{                                                                // mencoba untuk menstabilkan inputstream dan outputstream
                is = new DataInputStream(clientSocket.getInputStream());
                os = new PrintStream(clientSocket.getOutputStream());
            }
            catch(IOException e){
                chatStoryBoard.append("[01] Terdapat error saat menstabilkan I/O\n");
            } 
            this.asamakanListClient();                                          // menyamakan user list pada client
            this.asamakanListServer();                                          // menyamakan user list pada server
        }
                                                                                // -------------------------- fungsi umum ----------------------------//
        public void asamakanListClient(){                                       // menyamakan user list di client
            this.os.println("[04]");                                            // reset LIST CLIENT
            for (int i = 0; i < maxClientsCount; i++) {                         // samakan LIST CLIENT(sesuai grup yang sama)
                if (threads[i] != null && threads[i].name != null && 
                        threads[i].groupName.equals(this.groupName) ) {
                    this.os.println("[02] " + threads[i].name);
                }
            }
        }
        public void asamakanListServer(){                                       // menyamakan user list di server
            model.removeAllElements();                                          // reset LIST SERVER
            for (int i = 0; i < maxClientsCount; i++) {                         // samakan LIST SERVER
                if (threads[i] != null && threads[i].name != null) {            
                    model.addElement(threads[i].name);
                }
            }
        }
        public void awelcomeMessage(){                                          // memberi tahu ke semua user jika ada client baru masuk
            for (int i = 0; i < maxClientsCount; i++) {                         
                if (threads[i] != null && threads[i].name != null && 
                        threads[i].groupName.equals(this.groupName) 
                        && threads[i] != this) {                                // PENTING : semua user dengan grup yang sama diberitahu kecuali si User tersebut
                    threads[i].os.println("[02] " + this.name);                 
                    threads[i].os.println("*** User baru: " + this.name + 
                            " telah memasuki ruangan "+ this.groupName+" ***");
                }
            }
        }
        public void afarewellMessage(){                                         // memberitahukan bahwa "saya keluar dari grup ini"
            for (int i = 0; i < maxClientsCount; i++) {
                if(this.threads[i] != null && threads[i] == this){
                    threads[i].os.println("*** Anda meninggalkan grup ***");
                }
                else if (this.threads[i] != null && 
                        (threads[i].groupName.equals(this.groupName)) && 
                        !(threads[i].name.equals(this.name))) {
                    threads[i].os.println("[03] " + this.name);
                    threads[i].os.println("*** User : " + this.name+ 
                            " meninggalkan ruangan ***");
                }
            }
        }
        public void aChangeGroup(String groupName){                             // fungsi user untuk mengganti grup
            chatStoryBoard.append("[05] " + name + " berpindah " + this.groupName + 
                    " -> "+ groupName + "\n");                          // LOG SERVER
            this.afarewellMessage();                                            // melakukan pesan perpisahan
            this.groupName = groupName;                                         // ganti nama grup
            this.asamakanListClient();                                          // sinkronkan user ist yang baru sesuai grup
            this.awelcomeMessage();                                             // melakukan pesan pembuka
        }
        public void aBroadcastMessage(String message){                          // broadcast message ke semua user yang berada di grup yang sama
            for (int i = 0; i < maxClientsCount; i++) {
                if (threads[i] != null && threads[i].name != null && 
                        threads[i].groupName != null) {              
                    if(threads[i].groupName.equals((this.groupName)) ){
                        threads[i].os.println(name + " : " + message);
                    }
                }
            }
            chatStoryBoard.append("[06] " + name + " ["+ this.groupName + 
                    "] : " + message + "\n");                                   // LOG SERVER
        }
        public void asendPrivateMessage(String touserName, String toMessage){   // unicast message (private message) ke sebuah user yang valid
            int cek = 0;                                                        // variable penentu validitas
            for (int i = 0; i < maxClientsCount; i++) {
                if (threads[i] != null && threads[i].name != null && 
                        threads[i].name.equals(touserName)) {   
                    threads[i].os.println("[" + this.name + " -> " + 
                            touserName + "] : " + toMessage);
                    this.os.println("[" + this.name + " -> " + 
                            touserName + "] : " + toMessage);
                    chatStoryBoard.append("[07] " + name + " -> " + 
                            touserName + " : " + toMessage + "\n");             // LOG SERVER
                    cek = 1;                                                    // cek validitas ke 1
                }
            }
            if(cek == 0){
                this.os.println("[Error] Nama user tidak valid");
            }
        }
                                                                                // --------------------- run method ----------------------------------//
        @Override                                                               // override run method dari clientThread untuk keperluan layanan chatting
        public void run(){
            try{                                                                // mencoba melayani
                is = new DataInputStream(clientSocket.getInputStream());        // menstabilkan I/O Stream bagi thread pengurus client
                os = new PrintStream(clientSocket.getOutputStream());
                name = is.readLine().trim();                                    // mengambil nama user/ client
                chatStoryBoard.append("[02] User " + name + " telah terhubung\n");            // LOG SERVER
                os.println("Halo " + name + "! Selamat datang di " + 
                        this.groupName);                                        // beri pesan pembuka ke client
                os.println("[02] " + name);
                model.addElement(name);                                         // tambahkan client tersebut ke user list server
                this.awelcomeMessage();                                         // beri client pesan pembuka
                while(true){                                                    // masuk ke pelayanan utama chatting
                    String line = is.readLine();                                // string untuk menampung message dari client
                    
                    if(line.equals("/quit")){                                   // seleksi pesan dari client
                        this.os.println("QUIT");                                // jika ingin quit, maka masuk ke operasi penutupan
                        chatStoryBoard.append("[03] " + name + " left\n");
                        this.afarewellMessage();                                // bersihkan thread
                        for (int i = 0; i < maxClientsCount; i++) {
                            if (threads[i] == this) {
                                threads[i] = null;
                            }
                        }
                        this.asamakanListServer();                              // sinkron kan user list di server
                    }
                    else if(line.startsWith("@join")){                          // jika permintaan untuk mengganti grup
                        String toGroup = null;
                        if(line.contains("#")){
                            String container[];
                            container = line.split("#", 2);
                            String Name = container[1];
                            this.aChangeGroup(Name);                            // lakukan method ganti grup
                        }
                        else{
                            this.os.println("Command salah. Tekan /help untuk melihat list command.");
                        }
                    }
                    else if(line.startsWith("@")){                              // jika meminta unicast (private message) 
                        String toName = null, toMessage = null;                 // string untuk nampung yang perlu
                        if(line.contains(" ")){
                            String container[];
                            container = line.split(" ", 2);
                            toName = container[0].substring(1);
                            toMessage = container[1];
                        }
                        else{
                            toName = line.substring(1);
                            toMessage = "<Pesan Kosong>";
                        }
                        this.asendPrivateMessage(toName, toMessage);            // kirim private message
                    }
                    else{                                                       // sisanya, maka murni broadcast
                        this.aBroadcastMessage(line);
                    }
                }
            }
            catch(IOException e){
                chatStoryBoard.append("[01] Sebuah user baru saja terputus koneksi, thread user telah dihapus\n");
                for(int i = 0; i < maxClientsCount; i++){
                    if(threads[i] == this){
                        threads[i] = null;
                        this.asamakanListServer();
                    }
                }
            }  
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chatInputTextField;
    public javax.swing.JTextArea chatStoryBoard;
    private javax.swing.JTextField ipAddressLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField portInputLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton serverOFFButton;
    private javax.swing.JButton serverONButton;
    private javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables
}