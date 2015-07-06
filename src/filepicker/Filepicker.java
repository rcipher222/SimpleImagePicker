/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filepicker;

/**
 *
 * @author rb
 */
 

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.Spring.width;
import static javax.swing.SpringLayout.HEIGHT;
import static javax.swing.SpringLayout.WIDTH;
 
public class Filepicker {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel lbl;
  JButton openButton = new JButton("Open");
   public Filepicker(){
       
      prepareGUI();
   }

   public static void main(String[] args){
      Filepicker  swingControlDemo = new Filepicker();      
      swingControlDemo.showFileChooserDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Display Pic");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new FlowLayout());
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
    //  headerLabel = new JLabel("",JLabel.CENTER);        
    //  statusLabel = new JLabel("",JLabel.CENTER);    
      lbl=new JLabel("",JLabel.CENTER);
      lbl.setSize(300,300);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      
  //    mainFrame.add(headerLabel,"North");
      mainFrame.add(controlPanel,"Center");
   //   mainFrame.add(statusLabel,"North");      
      mainFrame.add(lbl,"Center");
      mainFrame.setVisible(true);  
   }

   private void showFileChooserDemo(){
    //  headerLabel.setText("Control in action: JFileChooser"); 

      final JFileChooser  fileDialog = new JFileChooser();
      JButton showFileDialogButton = new JButton("open");
      showFileDialogButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             
            int returnVal = fileDialog.showOpenDialog(mainFrame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               java.io.File file = fileDialog.getSelectedFile();
                try {
                    DisplayImage(file.getAbsolutePath());
                } catch (IOException ex) {
                    Logger.getLogger(Filepicker.class.getName()).log(Level.SEVERE, null, ex);
                }
          //     headerLabel.setText("File Selected :"+ file.getName());
               
            }
            else{
          //     headerLabel.setText("Open command cancelled by user." );           
            }      
         }
      });
      
      controlPanel.add(showFileDialogButton);
      mainFrame.setVisible(true);  
   }
   public void DisplayImage(String s) throws IOException
    {
        BufferedImage img=ImageIO.read(new File(s));
      //  int x=Integer.parseInt(WIDTH);
    //    int y= Integer.parseInt(HEIGHT);
        ImageIcon icon=new ImageIcon(img.getScaledInstance(this.mainFrame.getWidth(),this.mainFrame.getHeight(), Image.SCALE_SMOOTH)); 
    /*
         Graphics2D graphics2D = img.createGraphics();
         graphics2D.drawImage( img , 0 , 0 , this.mainFrame.getWidth(), this.mainFrame.getHeight(), null );
         graphics2D.dispose();
      */ 
        lbl.setIcon(icon);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}