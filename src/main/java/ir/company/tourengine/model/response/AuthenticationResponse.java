package ir.company.tourengine.model.response;


import ir.company.tourengine.dao.model.Agency;
import ir.company.tourengine.dao.model.Tour;
import ir.company.tourengine.dao.model.User;

import java.util.List;

public class AuthenticationResponse {
    private boolean isRegister;
    private User user;
    private List<Agency> agencies;

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isRegister() {
        return isRegister;
    }

    public void setRegister(boolean register) {
        isRegister = register;
    }
}
