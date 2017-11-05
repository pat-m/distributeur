package Controller;

import Dao.AccountDao;
import Dao.CustomerDao;
import View.AddMoneyView;
import View.BalanceView;
import View.HomeView;
import View.RemoveMoneyView;

import javax.swing.*;


public class AppController {

   private HomeView homeView;
   private AddMoneyView addMoneyView;
   private RemoveMoneyView removeMoneyView;
   private BalanceView balanceView;
   private CustomerDao customerDao;
   private boolean state;

   public AppController(boolean state) {
      this.homeView = new HomeView(state);
   }

   public void addMoneyView(int cptNum) {

      this.addMoneyView = new AddMoneyView(cptNum);
   }

   public void removeMoneyView(int cptNum) {
      this.removeMoneyView = new RemoveMoneyView(cptNum);
   }

   public void balanceView(int cptNum) {

      this.balanceView = new BalanceView(cptNum);
   }

   public void ReturnHome(int cptNum) {

   }
}
