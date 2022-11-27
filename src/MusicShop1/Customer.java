package MusicShop1;

import java.io.Serializable;

public class Customer implements Serializable {
    private String surname;
    private String name;
    private String lastname;
    private String address;
    private String phoneNumber;

    public Customer(String surname, String name, String lastname, String address, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void print(){
        System.out.printf("ФИО = %s %s %s\nАдресс = %s\nНомер телефона = %s\n",
                surname,name,lastname,address,phoneNumber);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
