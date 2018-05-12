/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import banking.MainWindow;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sikuli.script.Screen;
import org.junit.Assert;
import org.junit.BeforeClass;

import static org.sikuli.script.ImagePath.find;
import org.sikuli.script.Key;
import org.sikuli.script.*;
import static org.sikuli.script.Do.popup;
import org.sikuli.script.Region.*;

/**
 *
 * @author Dead Lock
 */
public class GuiTest {
    public static Screen s;
            String[] user = {"Mahmoud Ahmed khalil", "Mohamed Mostafa Amin","Aly Mohamed Aly","Yasin Ahmed Yasser","Wael Mohamed Ibrahim"};
           String[] telephone = {"01118402892","01114212319", "01115839284","01278429503","01039458602"};
           int[] day = {5,3,2,20,17};
           int[] month = {20,19, 7,5,3};
           int[] year = {1997,1994,1995,1992,1990};
           String[] balances = {"1700","15000" ,"50000" ,"25000", "10000"};
    public void GUIThread() {

    }
@BeforeClass
public static void setUpClass() {
             s = new Screen();
            MainWindow w = new MainWindow(0);
            w.setVisible(true);
}
    @Test   
    public void testClientAdding() {
        try {

          
           
            popup("Beginning testing",2);
            popup("Let's attempt to add 5 users first",2);
            for (int i = 0; i < 5; i++) {
                s.click("screenshots/addclientmain.png");

                s.type((user[i]) + Key.TAB + telephone[i] + Key.TAB + day[i]+ Key.TAB + month[i] + Key.TAB + year[i]);
                s.click("screenshots/malebutton.png");
                s.type(Key.TAB + balances[i]);
             
                s.click("screenshots/savebutton.PNG");
                  Assert.assertNotNull("Adding User Not successful", s.exists("screenshots/addingUserSuccessful.png"));
                  s.click("screenshots/ok.png");
                popup(5-(i+1)+" left",1);
            }
            
            
           
          
 
           
                    
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    
    @Test 
    public void testWithdraw()
    {
          try {
             popup("Testing Withdraw",2);
            s.click("screenshots/withdrawmain.png");
            Thread.sleep(1000);
            
            s.type("3000");
            s.click("screenshots/withdraw2.png");
             Assert.assertNotNull("Withdraw not successful", s.exists("screenshots/withdrawSuccessful.png"));
                  s.click("screenshots/ok.png");
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
            
             
        
    }
    
    @Test 
    public void testDeposit()
    {
          try {
                popup("Testing Deposit",2);
        
           
            s.click("screenshots/depositmain.png");
            
            s.type("2000"); 
            s.click("screenshots/deposit2.png");
            
            Assert.assertNotNull("Deposit not successful", s.exists("screenshots/depositMessageSuccessful.png"));
            s.click("screenshots/ok.png");
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
            
             
        
    }
    
    @Test 
    public void testTransfer()
    {
          try {
                popup("Testing Transfer",2);
        
           
            s.click("screenshots/transfer.png");
            
            s.click("screenshots/dropbox2.png");
            s.type("Mohamed");  
            s.type(Key.TAB);
            
            s.type("2000"); 
            s.click("screenshots/transfer2.png");
            
            Assert.assertNotNull("Transfer not successful", s.exists("screenshots/transferMessageSuccessful.png"));
            s.click("screenshots/ok.png");
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
            
        
    }
}
