package MusicShop1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentedDisk implements Serializable {
    Disk disk;
    private Customer customer;
    private Date dateOfRent;
    private Date dueDateOfReturn; // when person should return disk
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private double advanceFee;
    private int articleRented;

    public RentedDisk(Disk disk, Customer customer, Date dueDateOfReturn, double advanceFee, int articleRented) {
        this.disk = disk;
        this.customer = customer;
        this.dateOfRent = new Date();
        this.dueDateOfReturn = dueDateOfReturn;
        this.advanceFee = advanceFee;
        this.articleRented = articleRented;
    }

    public void print(){
        System.out.print("*****************************************************************************************\n");
        System.out.print("MusicShop1.Disk информация :\n");
        if (disk instanceof CD) {
            CD cd = (CD) disk;
            cd.print();
        } else if (disk instanceof DVD) {
            DVD dvd = (DVD) disk;
            dvd.print();
        } else if (disk instanceof Vinyl) {
            Vinyl vinyl = (Vinyl) disk;
            vinyl.print();
        } else {
            disk.print();
        }
        System.out.print("Информация о человеке :\n");
        customer.print();
        System.out.print("Информация об аренде :\n");
        System.out.printf("Артикул арендованного диска = %d\n",articleRented);
        System.out.printf("Дата аренды = %s\n",formatter.format(dateOfRent));
        System.out.printf("Дата возврата = %s\n",formatter.format(dueDateOfReturn));
    }

    // check if any field in classes contains this String (except date)
    public boolean isContainsString(String find){
        return getDisk().getAuthor().contains(find) || getDisk().getNameOfCD().contains(find)
                || getDisk().getGenre().contains(find) || getPerson().getAddress().contains(find) ||
                getPerson().getName().contains(find) || getPerson().getSurname().contains(find) ||
                getPerson().getLastname().contains(find) || getPerson().getPhoneNumber().contains(find);
    }

    public Disk getDisk() {
        return disk;
    }

    public Customer getPerson() {
        return customer;
    }

    public Date getDueDateOfReturn() {
        return dueDateOfReturn;
    }

    public boolean isPastDueDate(Date now){
        return now.after(dueDateOfReturn);
    }
}