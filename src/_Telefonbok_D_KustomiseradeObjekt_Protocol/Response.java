package _Telefonbok_D_KustomiseradeObjekt_Protocol;

import java.io.Serializable;

public class Response implements Serializable {

    private boolean success;
    private TCP_Object person;

    public Response(){

    }

    public Response(boolean success) {

    }

    public Response(boolean success, TCP_Object person){
        this.success = success;
        this.person = person;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public TCP_Object getPerson() {
        return person;
    }

    public void setPerson(TCP_Object person) {
        this.person = person;
    }
}
