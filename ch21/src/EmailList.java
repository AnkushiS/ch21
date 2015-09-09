

import model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import customTools.UserDB;

@ManagedBean
@SessionScoped
public class EmailList {
    private UserCh user;
    private String message;
    
    public EmailList() {
    }
    
    @PostConstruct
    public void init() {
        user = new UserCh();
    }
    
    public String addToEmailList() {
        if (UserDB.emailExists(user.getEmail())) {
            message = "This email address already exists. " +
                    "Please enter another email address";
            return "index";
        } else {
            UserDB.insert(user);
            return "thanks";
        }
    }

    public UserCh getUser() {
        return user;
    }

    public void setUser(UserCh user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }
}