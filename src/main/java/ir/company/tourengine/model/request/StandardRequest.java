package ir.company.tourengine.model.request;

import java.io.Serializable;

public class StandardRequest implements Serializable {
    private String token;
    private String data;

    public StandardRequest() {
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return "EncryptedRequest{token='" + this.token + '\'' + ", data='" + this.data + '\'' + '}';
    }
}
