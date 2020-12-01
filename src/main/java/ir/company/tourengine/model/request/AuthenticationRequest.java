package ir.company.tourengine.model.request;

import ir.company.tourengine.dao.model.User;

public class AuthenticationRequest extends BaseRequest {
    private String vCode;
    private String password;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }
}
