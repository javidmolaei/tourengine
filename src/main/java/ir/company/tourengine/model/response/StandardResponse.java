package ir.company.tourengine.model.response;

import java.io.Serializable;

public class StandardResponse<T> implements Serializable {
    private int resultCode = 1;
    private String resultMessage = "OK";
    private T response;

    public StandardResponse() {
    }

    public static StandardResponse getNOKExceptions(String exceptionMessage) {
        StandardResponse response = new StandardResponse();
        response.setResultCode(-1);
        response.setResultMessage(exceptionMessage);
        return response;
    }

    public static StandardResponse getNOKExceptions(Exception ex) {
        return getNOKExceptions(ex.getMessage());
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getResponse() {
        return this.response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("StandardResponse{");
        sb.append("resultCode=").append(this.resultCode);
        sb.append(", resultMessage='").append(this.resultMessage).append('\'');
        sb.append(", response=").append(this.response);
        sb.append('}');
        return sb.toString();
    }
}
