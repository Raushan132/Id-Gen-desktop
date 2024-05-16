package org.cobra;


import java.awt.EventQueue;

import javax.swing.UIManager;


import org.cobra.ui.FormUi;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {

       

        
        
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
			        for (UIManager.LookAndFeelInfo look : looks) {
			            System.out.println(look.getClassName());
			        }
			        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					FormUi window = new FormUi();
					window.getFormUiFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        

    }




}
