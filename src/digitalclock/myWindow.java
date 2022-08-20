package digitalclock;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class myWindow extends JFrame {
  private JLabel heading;

  private JLabel clockLabel;

  private Font font = new Font("", Font.BOLD, 35);
  myWindow(){
    super.setTitle("My Clock");
    super.setSize(400, 400);
    super.setLocation(300, 50);
    this.createGUI();
    this.startClock();
    super.setVisible(true);
  }
 
  public void createGUI(){
    //GUI

    heading = new JLabel("MY Clock");
    clockLabel = new JLabel("clock");

    heading.setFont(font);
    clockLabel.setFont(font);

    this.setLayout(new GridLayout(2,1));
    this.add(heading);
    this.add(clockLabel);
  }
  private void startClock() {
    Timer timer = new Timer(1000,new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
      //  String dateTime= new Date().toLocaleString();
      Date d=new Date();
      SimpleDateFormat sfd= new SimpleDateFormat("hh : mm : ss a");
      String dateTime=sfd.format(d);
       clockLabel.setText(dateTime); 
      }
    });
    timer.start();
    /*
     *  With the help of Thread
     * Thread t = new Thread(){
        * public void run()
        * {
            * try 
              * {
              * while(true)
                * {
                * Date d = new Date();
                * SimpleDateFormat sfd= new SimpleDateFormat("hh : mm : ss a");
                  String dateTime=sfd.format(d);
                  clockLabel.setText(dateTime); 
                  Thred.currentThread().sleep();
                * }
            *  }
        * }
     * }
     */
  }
}
