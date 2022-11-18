package _Telefonbok_B_Serialisering;

import java.io.Serializable;

public class TCP_Object implements Serializable {

    protected String name;
    protected String age;
    protected String adress;
    protected String number;

    public TCP_Object(String name, String age, String adress, String number) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
