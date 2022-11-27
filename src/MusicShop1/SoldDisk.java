package MusicShop1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SoldDisk implements Serializable{
    private Disk disk;
    private int amount;
    private Customer customer;
    private Date dateOfSelling;

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public SoldDisk(Disk disk, int amount, Customer customer) {
        this.disk = disk;
        this.amount = amount;
        this.customer = customer;
        this.dateOfSelling = new Date();
    }

    public void print(){
        System.out.print("*****************************************************************************************\n");
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
        customer.print();
        System.out.printf("Количество дисков, проданных этому человеку = %d\n",amount);
        System.out.printf("Дата продажи = %s\n",formatter.format(dateOfSelling));
    }
}