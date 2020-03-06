/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BP2_1821221009_Ali_Dereyurt_Odev1;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alid
 */
public class AnaEkran extends javax.swing.JFrame {

    static int idCounter = 0;
    static int listByIdCounter = 0;
    
    ArrayList<Urun> urunler = new ArrayList();
    DefaultTableModel dtm = new DefaultTableModel();
    
    String[] kolonIsimleri = {"ID", "Adi", "Adet", "Agirlik"};
    boolean tabloTemizMi = false;
    
    int idOlustur() { // id olusturur. 0'dan baslar bir artarak id verir.
        int exID = idCounter;
        idCounter++;
        return exID;
    }
    
    int arkaPlanaEkle() { // ekrandaki bilgilere gore arkaplanda urun olusturur.
        int id = idOlustur();
        Urun u1 = new Urun(id, ad_tf.getText(), Integer.valueOf(adet_tf.getText()), Integer.valueOf(agirlik_tf.getText()));
        urunler.add(u1);
        return id;
    }
    
    int arkaPlanaEkle(int id) { // yeni id olusturmadan veya custom id ile arkaplana ekleme yapilmasi icin.
        boolean idTekrarKontrol = true;
        for (int i = 0; i < urunler.size(); i++) { // verilen id ile urun var mi diye bakiyor. ayni id ile urun eklenemez.
            if (urunler.get(i).id == id) {
                idTekrarKontrol = false;
            }
        }
        if (idTekrarKontrol) {
            Urun u1 = new Urun(id, ad_tf.getText(), Integer.valueOf(adet_tf.getText()), Integer.valueOf(agirlik_tf.getText()));
            urunler.add(u1);
        }
        
        return 0;
    }
    
    void updateTableElement() {
        if (tablo.getSelectedRow() != -1) { //kullanici bir satir secmeden guncelleme yapmak isterse diye.
            int indexNumber = 0;
            for (int i = 0; i < urunler.size(); i++) {
                if (urunler.get(i).id == Integer.parseInt(id_tf.getText())) {
                    indexNumber = i;
                }
            }
            urunler.get(indexNumber).adet = Integer.parseInt(adet_tf.getText());
            urunler.get(indexNumber).agirlik = Integer.parseInt(agirlik_tf.getText());
            urunler.get(indexNumber).adi = ad_tf.getText();
            clearTable(); //tabloyu temizler.
            bringTable(); //arkaplani tabloya yansitir.
        } else {
            JOptionPane.showMessageDialog(rootPane, "Guncellemek istediginiz satiri seciniz");
        }
        
    }
    
    void deleteTableElement() { // id'si verilen urunu arkaplandan bulup siliyor.
        if (tablo.getSelectedRow() != -1 && !(id_tf.getText().equals(""))) { //kullanici bir satir secmeden silmek isterse diye.
            for (int i = 0; i < urunler.size(); i++) {
                if (urunler.get(i).id == Integer.valueOf(id_tf.getText())) {
                    urunler.remove(i);
                    break;
                }
                
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Silmek istediginiz satiri seciniz veya eklemediyseniz urun ekleyiniz.");
        }
        
    }
    
    void clearTable() { // tabloyu temizler.
        int a = dtm.getRowCount();
        for (int i = 0; i < a; i++) {
            dtm.removeRow(0);
        }
        tabloTemizMi = true;
    }
    
    void bringTable() {
        if (tabloTemizMi) {
            listTableById();
            tabloTemizMi = false;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Once tabloyu temizleyiniz.");
        }
        
    }
    
    void listTableById() { //arka plandaki urunleri tabloya listeler.
        /*if (urunler.size() >= listByIdCounter) {

            for (int i = 0; i < urunler.size(); i++) { // once arka plandaki urunlere tek tek bakiyor.

                if (urunler.get(i).id == (listByIdCounter + 1)) { // id 'si en kucuk olani buluyor. onu tabloya yansitiyor.
                    // sonra donguyu bitiriyor ve id'si bir buyuk olani 
                    //bulmak uzere fonksiyonu tekrar cagiriyor.
                    System.out.println("girdi :  " + listByIdCounter);
                    Object[] tabloSatir = {urunler.get(i).id, urunler.get(i).adi, urunler.get(i).adet, urunler.get(i).agirlik};
                    if (rootPaneCheckingEnabled) {
                        
                    }
                    dtm.insertRow(listByIdCounter, tabloSatir);
                    break;
                    
                }

            }
            listByIdCounter++;  // bir sonraki id yi aramak icin sayaci artiriyor.
            listTableById(); // bir sonraki id yi aramak icin bastan basliyor.
        } else { // listeleme tamamlandiginda sayaci sifirliyor. yani pilini pirtini toplayip gidiyor.
            listByIdCounter = 0;
        }
         */
        for (int i = 0; i < urunler.size(); i++) {
            Object[] tabloSatir = {urunler.get(i).id, urunler.get(i).adi, urunler.get(i).adet, urunler.get(i).agirlik};
            dtm.addRow(tabloSatir);
        }
        
    }
    
    public AnaEkran() {
        initComponents();
        tablo.setModel(dtm);
        dtm.setColumnIdentifiers(kolonIsimleri);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();
        guncelle_buton = new javax.swing.JButton();
        sil_buton = new javax.swing.JButton();
        ekle_btn = new javax.swing.JButton();
        ad_tf = new javax.swing.JTextField();
        adet_tf = new javax.swing.JTextField();
        agirlik_tf = new javax.swing.JTextField();
        temizle_btn = new javax.swing.JButton();
        kayitGetir_btn = new javax.swing.JButton();
        id_tf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo);

        guncelle_buton.setText("Guncelle");
        guncelle_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelle_butonActionPerformed(evt);
            }
        });

        sil_buton.setText("Sil");
        sil_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sil_butonActionPerformed(evt);
            }
        });

        ekle_btn.setText("Ekle");
        ekle_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekle_btnActionPerformed(evt);
            }
        });

        ad_tf.setText("Urun Adi");
        ad_tf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ad_tfMouseClicked(evt);
            }
        });

        adet_tf.setText("Urun Adeti");
        adet_tf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adet_tfMouseClicked(evt);
            }
        });

        agirlik_tf.setText("Urun Agirligi (gr)");
        agirlik_tf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agirlik_tfMouseClicked(evt);
            }
        });

        temizle_btn.setText("Tabloyu Temizle");
        temizle_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizle_btnActionPerformed(evt);
            }
        });

        kayitGetir_btn.setText("Kayitlari Getir");
        kayitGetir_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kayitGetir_btnActionPerformed(evt);
            }
        });

        id_tf.setEditable(false);

        jLabel1.setText("ID:");

        jButton1.setText("Stok Azalt");

        jButton2.setText("Stok Artir");

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(temizle_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kayitGetir_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ekle_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(guncelle_buton)
                                .addGap(18, 18, 18)
                                .addComponent(sil_buton, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                            .addComponent(ad_tf)
                            .addComponent(adet_tf)
                            .addComponent(agirlik_tf)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guncelle_buton)
                            .addComponent(sil_buton)
                            .addComponent(ekle_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ad_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adet_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agirlik_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temizle_btn)
                    .addComponent(kayitGetir_btn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ekle_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekle_btnActionPerformed
        
        try {
            int id = arkaPlanaEkle(); //girilen bilgilere gore arka plana urun ekler ve id'sini dondurur.
            id_tf.setText(Integer.toString(id)); //olusturulan id'yi kullanıcıya da gosterir.
            clearTable(); //tabloyu temizler.
            bringTable(); //arka plani tabloya yansitir.
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(rootPane, "Urun adeti ve agirligi sayi girilmelidir.");
        }
        

    }//GEN-LAST:event_ekle_btnActionPerformed

    private void ad_tfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ad_tfMouseClicked
        ad_tf.setText("");
    }//GEN-LAST:event_ad_tfMouseClicked

    private void adet_tfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adet_tfMouseClicked
        adet_tf.setText("");
    }//GEN-LAST:event_adet_tfMouseClicked

    private void agirlik_tfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agirlik_tfMouseClicked
        agirlik_tf.setText("");
    }//GEN-LAST:event_agirlik_tfMouseClicked

    private void temizle_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizle_btnActionPerformed
        
        clearTable();
    }//GEN-LAST:event_temizle_btnActionPerformed

    private void tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabloMouseClicked
        id_tf.setText(dtm.getValueAt(tablo.getSelectedRow(), 0).toString());
        ad_tf.setText(dtm.getValueAt(tablo.getSelectedRow(), 1).toString());
        adet_tf.setText(dtm.getValueAt(tablo.getSelectedRow(), 2).toString());
        agirlik_tf.setText(dtm.getValueAt(tablo.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tabloMouseClicked

    private void kayitGetir_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayitGetir_btnActionPerformed
        bringTable();

    }//GEN-LAST:event_kayitGetir_btnActionPerformed

    private void guncelle_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelle_butonActionPerformed
        updateTableElement();

    }//GEN-LAST:event_guncelle_butonActionPerformed

    private void sil_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sil_butonActionPerformed
        deleteTableElement();
        clearTable(); //tabloyu temizler.
        bringTable(); //arka plani tabloya yansitir.
    }//GEN-LAST:event_sil_butonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad_tf;
    private javax.swing.JTextField adet_tf;
    private javax.swing.JTextField agirlik_tf;
    private javax.swing.JButton ekle_btn;
    private javax.swing.JButton guncelle_buton;
    private javax.swing.JTextField id_tf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kayitGetir_btn;
    private javax.swing.JButton sil_buton;
    private javax.swing.JTable tablo;
    private javax.swing.JButton temizle_btn;
    // End of variables declaration//GEN-END:variables
}
