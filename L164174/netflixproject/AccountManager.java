/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixproject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Munam Malik
 */
public class AccountManager {

    static AccountManager accountManager;
    Database db = Database.getInstance();

    private AccountManager() {

    }

    public static AccountManager getInstance() {
        if (accountManager == null) {
            accountManager = new AccountManager();
        }
        return accountManager;
    }

    public User updateInfo(String name, String email, String password, String account) {
        if (db.isExistingAccount(account)) {
            if (db.updateInfo(email, account, name, password)) {
                return makeUser(email);
            }
            return makeUser(email);
        }
        return new User();
    }

    public Boolean checkPassword(String email, String password) {
        if (db.checkPassword(email, password)) {
            return true;
        }
        return false;
    }

    public User register(String email, String account, String name, String password, int plan) {
        if (db.registerUser(name, account, email, password, plan) == 0) {
            return makeUser(email);
        }

        return new User();
    }

    public User login(String email, String password) {
        if (db.authenticateUser(email, password) != -1) {
            return makeUser(email);
        }

        return new User();
    }


    public User updateSubscription(String email, int plan) {
        if (db.updatePlan(email, plan)) {
            return makeUser(email);
        }

        return new User();
    }

    public User cancelSubscription(String email) {
        if (db.removePlan(email)) {
            return makeUser(email);
        }
        return new User();
    }

    private User makeUser(String email) {
        return new User(db.getName(email), email, db.getPassword(email), db.getAccount(email), db.getPlan(email), db.getTermination(email));
    }
    
    public boolean isValidEmailAddress(String email) {
           String ePattern = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
           Pattern p = java.util.regex.Pattern.compile(ePattern);
           Matcher m = p.matcher(email);
           return m.matches();
    }
}
