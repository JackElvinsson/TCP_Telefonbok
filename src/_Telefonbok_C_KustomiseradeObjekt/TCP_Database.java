package _Telefonbok_C_KustomiseradeObjekt;

import java.util.List;

public class TCP_Database {

    TCP_Object person1 = new TCP_Object("Bob bobsson", "20 years old", "Bobvägen 12", "070-1233322");
    TCP_Object person2 = new TCP_Object("Ben Bensson", "20 years old", "Benvägen 12", "070-1234567");
    TCP_Object person3 = new TCP_Object("Bo Bosson", "20 years old", "Bovägen 12", "070-2345678");
    TCP_Object person4 = new TCP_Object("Bobby Bobbysson", "20 years old", "Bobbyvägen 12", "070-3456789");
    TCP_Object person5 = new TCP_Object("Bonnie Bonniesson", "20 years old", "Bonnievägen 12", "076-2345678");

    List<TCP_Object> phoneBook = List.of(person1, person2, person3, person4, person5);

    public TCP_Database() {

    }

    public TCP_Object search(String name) {
        for (TCP_Object tcp_object : phoneBook) {
            if (name.equalsIgnoreCase(tcp_object.getName())) {
                return tcp_object;
            }
        }
        return null;
    }

    public String allData(TCP_Object name){
        return name.name+ ", " + name.age + ", " + "phone number: "+ name.number + ", " + "Adress: " + name.adress;
    }
}
