package ru.denisa.app.mobile.ws.mobileappws.exceptions;

import java.util.Date;

public class ErrorMessage {

    private Date timestamp;
    private String messsage;





    public ErrorMessage(Date timestamp, String messsage){
        this.timestamp=timestamp;
        this.messsage=messsage;
     }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }


}
