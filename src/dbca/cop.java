/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbca;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author ETPL_CH_01
 */
public class cop extends javax.swing.JFrame {
static ArrayList al=nextwindow.al;
static ArrayList al1=nextwindow.al1;
Statement st,st1,st2,st3,st4;
     Connection con;
     String woord,woord1;
//   static   int vr1=split.vr1; 
   static   int vr1=100;
   
    /**
     * Creates new form cop
     */
    public cop() {
        initComponents();
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbca", "root", "");
            st = con.createStatement();
            st1 = con.createStatement();
            st2=con.createStatement();
            st3=con.createStatement();
            st4=con.createStatement();
        st.executeUpdate("truncate table aca");
        st.executeUpdate("truncate table  sorting");
        st.executeUpdate("truncate table aca2");
        st.executeUpdate("truncate table sorting1");
        st.executeUpdate("truncate table batchaca");
        st.executeUpdate("truncate table batchaca2");
        
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("ACA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Frequentlist");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  try
  {
      int j=1;
      for(int i=3;i<(vr1/10);)
      {
      ResultSet rs1=st1.executeQuery("select distinct word from words where batch='"+"batch"+i +"'");
//      jTextArea1.append("Batch "+i +" \n ____________________\n");
      while(rs1.next())
      {
          String word=rs1.getString(1);
          System.out.println(word);
          System.out.println("select max(count) from words where word= '"+word+"' \t AND batch ='batch" +i +"'");
      ResultSet rs=st.executeQuery("select max(count) from words where word= '"+word+"' \t AND batch ='batch" +i +"'");
//              +"ORDER BY count asc");
      
          while(rs.next())
          {
              String count=rs.getString(1);
              System.out.println(count);
              st3.executeUpdate("insert into sorting values('"+word + "',' " +count + " ','batch"+i+"')");
                
          }
      }
           i+=2;
      }
           ResultSet rs3=st4.executeQuery("select * from  sorting order by batch,count asc  ");
                 while(rs3.next())
                 {
                     String word2=rs3.getString(1);
                     String count2=rs3.getString(2);
                      String batch=rs3.getString(3);
              int k=j++;
              jTextArea1.append(word2+"->"+ count2 +"->" +(k)  + batch +"\n");
              st2.executeUpdate("insert into aca  values ('" +word2 +"','"+count2 +"','" + k + "','"+batch +"')");
                 }
      
      
      
      jTextArea1.append("------------------------\n");
     
      
//      int f=1;
//      ResultSet rs2=st1.executeQuery("select distinct word from words2 ");
//      jTextArea1.append("Batch4 \n ____________________\n");
//      while(rs2.next())
//      {
//          String word=rs2.getString(1);
//      ResultSet rs=st.executeQuery("select max(count) from words2 where word= '"+word+"'");
////      +"ORDER BY count asc");
//      
//          while(rs.next())
//          {
//             String count=rs.getString(1);
//              st3.executeUpdate("insert into sorting1 values('"+word + "',' " +count +"')");
//                 
//          }
//      }
//      ResultSet rs=st4.executeQuery("select * from  sorting1 order by count asc ");
//                 while(rs.next())
//                 {
//                     String word2=rs.getString(1);
//                     String count2=rs.getString(2);
//              int k=j++;
//              jTextArea1.append(word2+"->"+ count2 +"->" +(k) +"\n");
//              st2.executeUpdate("insert into aca2  values ('" +word2 +"','"+count2 +"','" + k +"')");
//                 }
//      
//      jTextArea1.append("------------------------\n");
      JOptionPane.showMessageDialog(null," ACA computed");
  }
  catch(SQLException | HeadlessException e)
  {
    System.out.println(e.getMessage());  
  }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     try
     {
         int hj=0;
         String correct="";
         
         for(int i=3;i<(vr1/10); )
         {
          jTextArea1.append("Batch"+i+"\n---------------\n ");       
         ResultSet rs1=st.executeQuery("select word,min(count) from sorting where batch='batch"+i+"'");
         while(rs1.next())
         {
           woord=rs1.getString(1);
           System.out.println(woord);
         }
         ResultSet rs=st2.executeQuery("Select * from batch"+i);
//         System.out.println("enter");
         while(rs.next())
         {
//             System.out.println("value");
             correct="";
             hj=0;
             String word=rs.getString(2);
             System.out.println("input line "+word);
             StringTokenizer str=new StringTokenizer(word,"#");
             while(str.hasMoreTokens())
             {
                 String token=str.nextToken();
                 if(token.equals(woord))
                 {
                     String wood=" ";
                 }
                 else
                 {
                     if(hj>0){
                        correct+= "#"+token; 
                     }else{
                         correct+= token; 
                     }
                     hj++;
                 }
                 
             }
             System.out.println("j =      "+correct);
             jTextArea1.append(correct+"\n");
             st1.executeUpdate("insert into batchfinal values('" + correct+"')"  );
             
         }
             i+=2;
         }
//         jTextArea1.append("Batch4\n---------------\n");
//          ResultSet rs2=st.executeQuery("select word,min(count) from sorting1 ");
//         while(rs2.next())
//         {
//           woord1=rs2.getString(1);
//           System.out.println(woord1);
//         }
//         ResultSet rs4=st2.executeQuery("Select * from batch4");
////         System.out.println("enter");
//         while(rs4.next())
//         {
////             System.out.println("value");
//             correct="";
//             hj=0;
//             String word=rs4.getString(1);
//             System.out.println("input line "+word);
//             StringTokenizer str=new StringTokenizer(word,"#");
//             while(str.hasMoreTokens())
//             {
//                 String token=str.nextToken();
//                 if(token.equals(woord1))
//                 {
//                     String wood=" ";
//                 }
//                 else
//                 {
//                     if(hj>0){
//                        correct+= "#"+token; 
//                     }else{
//                         correct+= token; 
//                     }
//                     hj++;
//                 }
//                 
//             }
//             System.out.println("j =      "+correct);
//             jTextArea1.append(correct +"\n");
////             System.out.println("insert into batchaca2 values('" + correct+ "')");
//             st1.executeUpdate("insert into batchaca2 values('" + correct+ "')"  );
//     }
         JOptionPane.showMessageDialog(null,"ACA operation perfomed ");
     }
     catch(SQLException | HeadlessException e)
     {
         System.out.println(e.getMessage());
     }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      new MainFrame().setVisible(true);
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
            java.util.logging.Logger.getLogger(cop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cop().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
