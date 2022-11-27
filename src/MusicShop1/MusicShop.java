package MusicShop1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MusicShop implements Serializable {
    private static final long serialVersionUID = 111423L;

    private ArrayList<Disk> diskArrayList = new ArrayList<>(100);// storage of disks
    private ArrayList<RentedDisk> rentedDisks = new ArrayList<>(10);// rented disks
    private ArrayList<SoldDisk> soldDisks = new ArrayList<>(10);// sold disks
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public void addVinyl(double price, int yearOfPublication, String nameOfCD, String author,
                         int amount, String genre , boolean isStereophonic, boolean isFlexible, int diameter) {
        diskArrayList.add(new Vinyl(price, yearOfPublication, nameOfCD, author
                , amount, diskArrayList.size(), genre ,isStereophonic,isFlexible,diameter));
    }

    public void addCD(double price, int yearOfPublication, String nameOfCD, String author,
                      int amount, String genre ,boolean isRewritable, boolean isDoubleSided) {
        diskArrayList.add(new CD(price, yearOfPublication, nameOfCD, author
                , amount, diskArrayList.size(), genre , isRewritable, isDoubleSided));
    }

    public void addDVD(double price, int yearOfPublication, String nameOfCD, String author,
                       int amount, String genre, boolean surroundSound, double samplingFrequency, String codec) {
        diskArrayList.add(new DVD(price, yearOfPublication, nameOfCD, author
                , amount, diskArrayList.size(), genre ,surroundSound, samplingFrequency, codec));
    }

    public void printAllDisks() {
        for (Disk e : diskArrayList
        ) {
            if (e instanceof CD) {
                CD cd = (CD) e;
                cd.print();
            } else if (e instanceof DVD) {
                DVD dvd = (DVD) e;
                dvd.print();
            } else if (e instanceof Vinyl) {
                Vinyl vinyl = (Vinyl) e;
                vinyl.print();
            } else {
                e.print();
            }
        }
    }

    public void printSoldDisks(){
        for (SoldDisk e: soldDisks
        ) {
            e.print();
        }
    }

    public void sellDisk(){
        Scanner scannerIn = new Scanner(System.in);
        while(true){
            System.out.print("Введите название диска, автора или жанр: ");
            String find = scannerIn.nextLine();
            printSmartFind(find);
            System.out.print("Артикуль диска или введите -1, если не найдено, чтобы вернуться в меню: ");
            while (!scannerIn.hasNextInt()) {
                System.out.println("Неправильный ввод!");
                scannerIn.next();
            }
            int index = scannerIn.nextInt();
            if(index == -1){
                return;
            } else if (index >= 0 && index < diskArrayList.size()) {
                Customer customer = createPerson();
                int amount;
                do {
                    System.out.print("Введите количество дисков, которые вы хотите продать: ");
                    while (!scannerIn.hasNextInt()) {
                        System.out.println("Неправильный ввод!");
                        scannerIn.next();
                    }
                    amount = scannerIn.nextInt();
                } while (amount < 0 || amount > diskArrayList.get(index).getAmount());
                soldDisks.add(new SoldDisk(diskArrayList.get(index),amount, customer));
                diskArrayList.get(index).setAmount(diskArrayList.get(index).getAmount() - amount);
                return;
            }
        }
    }

    public void printRentedDisks(){
        for (RentedDisk e: rentedDisks
        ) {
            e.print();
        }
    }

    public void changeInfoAboutDisk(){
        Scanner scannerIn = new Scanner(System.in);
        while(true){
            System.out.print("Введите название диска, автора или жанр: ");
            String find = scannerIn.nextLine();
            printSmartFind(find);
            System.out.print("Артикул диска или введите -1, если не найдено, чтобы вернуться в меню: ");
            while (!scannerIn.hasNextInt()) {
                System.out.println("Неправильный ввод!");
                scannerIn.next();
            }
            int index = scannerIn.nextInt();
            if(index == -1){
                return;
            } else if (index >= 0 && index < diskArrayList.size()) {
                Disk foundDisk = diskArrayList.get(index);
                scannerIn.nextLine(); // to consume \n leftover
                System.out.print("Введите имя диска:");
                String nameOfCD = scannerIn.nextLine();
                foundDisk.setNameOfCD(nameOfCD);
                System.out.print("Введите автора или группу:");
                String author = scannerIn.nextLine();
                foundDisk.setAuthor(author);
                System.out.print("Введите жанры:");
                String genre = scannerIn.nextLine();
                foundDisk.setGenre(genre);
                System.out.print("Введите цену:");
                double price = -1; // float compare initialization
                while (price <= 0){
                    while (!scannerIn.hasNextDouble()) {
                        System.out.println("Неправильный ввод!");
                        scannerIn.next();
                    }
                    price = scannerIn.nextDouble();
                }
                foundDisk.setPrice(price);
                System.out.print("Введите год публикации:");
                while (!scannerIn.hasNextInt()) {
                    System.out.println("Неправильный ввод!");
                    scannerIn.next();
                }
                int yearOfPublication = scannerIn.nextInt();
                foundDisk.setYearOfPublication(yearOfPublication);
                System.out.print("Введите количество:");
                int amount = 0;
                while (amount <= 0){
                    System.out.print("Введите количество:");
                    while (!scannerIn.hasNextInt()) {
                        System.out.println("Неправильный ввод!");
                        scannerIn.next();
                    }
                    amount = scannerIn.nextInt();
                }
                foundDisk.setAmount(amount);
                return;
            }
        }
    }

    public void rentDisk() throws ParseException {
        Scanner scannerIn = new Scanner(System.in);
        while(true){
            System.out.print("Введите название диска, автора или жанр: ");
            String find = scannerIn.nextLine();
            printSmartFind(find);
            System.out.print("Артикул диска или введите -1, если не найдено, чтобы вернуться в меню: ");
            while (!scannerIn.hasNextInt()) {
                System.out.println("Неправильный ввод!");
                scannerIn.next();
            }
            int index = scannerIn.nextInt();
            if(index == -1){
                return;
            } else if (index >= 0 && index < diskArrayList.size() && diskArrayList.get(index).getAmount() > 0) {
                Customer customer = createPerson();
                System.out.print("Введите срок возврата в формате dd-MM-yyyy : ");
                scannerIn.nextLine(); // to consume \n leftover
                String date = scannerIn.nextLine();
                Date dueDateOfReturn = formatter.parse(date);
                System.out.print("Введите аванс : ");
                while (!scannerIn.hasNextDouble()) {
                    System.out.println("Неправильный ввод!");
                    scannerIn.next();
                }
                double advanceFee = scannerIn.nextDouble();
                rentedDisks.add(new RentedDisk(diskArrayList.get(index), customer,dueDateOfReturn,advanceFee,rentedDisks.size() ));
                diskArrayList.get(index).setAmount(diskArrayList.get(index).getAmount() - 1);
                return;
            }
        }
    }

    public void returnDisk() {
        Scanner scannerIn = new Scanner(System.in);
        while(true){
            System.out.print("Введите имя диска, автора, жанр или информацию о человеке: ");
            String find = scannerIn.nextLine();
            for (RentedDisk e : rentedDisks
            ) {
                if (e.isContainsString(find)){
                    e.print();
                }
            }
            System.out.print("Введите артикул арендованного диска или введите -1, если он не найден, чтобы вернуться в меню: ");
            while (!scannerIn.hasNextInt()) {
                System.out.println("Неправильный ввод!");
                scannerIn.next();
            }
            int article = scannerIn.nextInt();
            if(article == -1){
                return;
            } else if (article >= 0 && article < rentedDisks.size()) {
                if(rentedDisks.get(article).isPastDueDate(new Date())){
                    System.out.print("Этот человек просрочил аренду диска, вы должны попросить его заплатить штраф\n");
                    System.out.printf("Ориентировочная стоимость штрафа  = %f",
                            (rentedDisks.get(article).getDisk().getPrice()) / 2);
                }
                // save article from disk to increase it count after returning from rent
                int index = rentedDisks.get(article).getDisk().getArticle();
                rentedDisks.remove(article);
                diskArrayList.get(index).setAmount(diskArrayList.get(index).getAmount() + 1);
                return;
            }
        }
    }

    public void printOverdueRentedDisks(){
        Date now = new Date();
        for (RentedDisk e: rentedDisks
        ) {
            if(now.after(e.getDueDateOfReturn())){
                e.print();
            }
        }
    }

    public void printReturnUntilDate(Date date){
        for (RentedDisk e: rentedDisks
        ) {
            if(date.after(e.getDueDateOfReturn())){
                e.print();
            }
        }
    }

    public void printSmartFind(String find) {
        for (Disk e : diskArrayList
        ) {
            if (e.getAuthor().contains(find) || e.getNameOfCD().contains(find) || e.getGenre().contains(find)){
                if (e instanceof CD) {
                    CD cd = (CD) e;
                    cd.print();
                } else if (e instanceof DVD) {
                    DVD dvd = (DVD) e;
                    dvd.print();
                } else if (e instanceof Vinyl) {
                    Vinyl vinyl = (Vinyl) e;
                    vinyl.print();
                } else {
                    e.print();
                }
            }
        }
    }

    public Customer createPerson(){
        Scanner scannerIn = new Scanner(System.in);
        System.out.print("Введите фамилию : ");
        String surname = scannerIn.nextLine();
        System.out.print("Введите имя : ");
        String name = scannerIn.nextLine();
        System.out.print("Введите отчество : ");
        String lastname = scannerIn.nextLine();
        System.out.print("Введите адресс : ");
        String address = scannerIn.nextLine();
        System.out.print("Введите номер телефона : ");
        String phoneNumber = scannerIn.nextLine();
        return new Customer(surname,name,lastname,address,phoneNumber);
    }
}

