package MusicShop1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        MusicShop musicShop = new MusicShop();
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("/Users/kulichok/IdeaProjects/kurs/src/MusicShop1/MusicShop.dat"))) {
            musicShop = (MusicShop) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Scanner scannerIn = new Scanner(System.in);
        int menu;
        while (true) {
            System.out.print("1 - Добавить музыкальный диск\n");
            System.out.print("2 - Показать информацию обо всех дисках\n");
            System.out.print("3 - Умный поиск\n");
            System.out.print("4 - Подменю «Продажа»\n");
            System.out.print("5 - Подменю «Аренда»\n");
            System.out.print("6 - Изменить информацию о диске\n");
            System.out.print("8 - Создать резервную копию\n");
            System.out.print("9 - Загрузить из резервной копии\n");
            System.out.print("0 - Выход\n");
            System.out.print("Enter : ");
            while (!scannerIn.hasNextInt()) {
                System.out.println("Неправильный ввод!");
                scannerIn.next();
            }
            menu = scannerIn.nextInt();
            switch (menu) {
                case 1: {
                    System.out.print("Какой тип диска вы хотите добавить?\n");
                    System.out.print("1 - CD-диск\n");
                    System.out.print("2 - DVD-диск\n");
                    System.out.print("3 - Виниловый диск\n");
                    int typeOfDisk;
                    do {
                        System.out.print("Ввод: ");
                        while (!scannerIn.hasNextInt()) {
                            System.out.println("Неправильный ввод!");
                            scannerIn.next();
                        }
                        typeOfDisk = scannerIn.nextInt();
                    } while (typeOfDisk < 1 || typeOfDisk > 3);
                    scannerIn.nextLine(); // to consume \n leftover
                    System.out.print("Введите название диска:");
                    String nameOfCD = scannerIn.nextLine();
                    System.out.print("Введите автора или группу:");
                    String author = scannerIn.nextLine();
                    System.out.print("Введите жанр:");
                    String genre = scannerIn.nextLine();
                    System.out.print("Введите цену:");
                    double price = -1; // float compare initialization
                    while (price <= 0) {
                        while (!scannerIn.hasNextDouble()) {
                            System.out.println("Неправильный ввод!");
                            scannerIn.next();
                        }
                        price = scannerIn.nextDouble();
                    }
                    System.out.print("Введите год публикации:");
                    while (!scannerIn.hasNextInt()) {
                        System.out.println("Неправильный ввод!!");
                        scannerIn.next();
                    }
                    int yearOfPublication = scannerIn.nextInt();
                    int amount = 0;
                    while (amount <= 0) {
                        System.out.print("Введите количество:");
                        while (!scannerIn.hasNextInt()) {
                            System.out.println("Неправильный ввод!");
                            scannerIn.next();
                        }
                        amount = scannerIn.nextInt();
                    }
                    switch (typeOfDisk) {
                        case 1: {
                            System.out.print("Можно ли перезаписывать CD-диск? Введите true или false :");
                            while (!scannerIn.hasNextBoolean()) {
                                System.out.println("Неправильный ввод!");
                                scannerIn.next();
                            }
                            boolean isRewritable = scannerIn.nextBoolean();
                            System.out.print("Двусторонний ли CD-диск? Введите true или false :");
                            while (!scannerIn.hasNextBoolean()) {
                                System.out.println("Неправильный ввод!");
                                scannerIn.next();
                            }
                            boolean isDoubleSided = scannerIn.nextBoolean();
                            musicShop.addCD(price, yearOfPublication, nameOfCD, author, amount, genre
                                    , isRewritable, isDoubleSided);
                            break;
                        }
                        case 2: {
                            System.out.print("DVD имеет объемный звук? Введите true или false :");
                            while (!scannerIn.hasNextBoolean()) {
                                System.out.println("Неправильный ввод!");
                                scannerIn.next();
                            }
                            boolean surroundSound = scannerIn.nextBoolean();
                            System.out.print("Введите частоту дискретизации :");
                            while (!scannerIn.hasNextDouble()) {
                                System.out.println("Неправильный ввод!");
                                scannerIn.next();
                            }
                            double samplingFrequency = scannerIn.nextDouble();
                            scannerIn.nextLine(); // to consume \n leftover
                            System.out.print("Enter codec :");
                            String codec = scannerIn.nextLine();
                            musicShop.addDVD(price, yearOfPublication, nameOfCD, author, amount, genre
                                    , surroundSound, samplingFrequency, codec);
                            break;
                        }
                        case 3: {
                            System.out.print("Есть ли у винила стереофонический звук? Введите true или false :");
                            while (!scannerIn.hasNextBoolean()) {
                                System.out.println("Неправильный ввод!");
                                scannerIn.next();
                            }
                            boolean isStereophonic = scannerIn.nextBoolean();
                            System.out.print("Является ли винил гибким? Введите  true или false :");
                            while (!scannerIn.hasNextBoolean()) {
                                System.out.println("Неправильный ввод!");
                                scannerIn.next();
                            }
                            boolean isFlexible = scannerIn.nextBoolean();
                            System.out.print("Введите диаметр:");
                            while (!scannerIn.hasNextInt()) {
                                System.out.println("Неправильный ввод!");
                                scannerIn.next();
                            }
                            int diameter = scannerIn.nextInt();
                            musicShop.addVinyl(price, yearOfPublication, nameOfCD, author, amount, genre,
                                    isStereophonic, isFlexible, diameter);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    musicShop.printAllDisks();
                    break;
                }
                case 3: {
                    System.out.print("1 - Поиск по названию диска, автору или жанру\n");
                    System.out.print("2 - Показать просроченные арендованные диски\n");
                    System.out.print("3 - Введите дату и найдите, кому нужно вернуть диск до этой датыe\n");
                    int innerMenu = scannerIn.nextInt();
                    switch (innerMenu) {
                        case 1: {
                            System.out.print("Введите название диска, автора или жанр: ");
                            scannerIn.nextLine(); // to consume \n leftover
                            String find = scannerIn.nextLine();
                            musicShop.printSmartFind(find);
                            break;
                        }
                        case 2: {
                            musicShop.printOverdueRentedDisks();
                            break;
                        }
                        case 3: {
                            System.out.print("Введите срок возврата в формате dd-MM-yyyy: ");
                            scannerIn.nextLine(); // to consume \n leftover
                            String date = scannerIn.nextLine();
                            try {
                                Date dueDateOfReturn = formatter.parse(date);
                                musicShop.printReturnUntilDate(dueDateOfReturn);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        default: {
                            System.out.print("Неверный выбор, попробуйте еще раз!\n");
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.print("1 - Продать диск\n");
                    System.out.print("2 - Показать информацию обо всех проданных дисках\n");
                    System.out.print("Введите : ");
                    int innerMenu = scannerIn.nextInt();
                    switch (innerMenu) {
                        case 1: {
                            musicShop.sellDisk();
                            break;
                        }
                        case 2: {
                            musicShop.printSoldDisks();
                            break;
                        }
                        default: {
                            System.out.print("Неверный выбор, попробуйте еще раз!\n");
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.print("1 - отдать диск в аренду\n");
                    System.out.print("2 - Показать информацию обо всех арендованных дисках\n");
                    System.out.print("3 - Вернуть арендованный диск\n");
                    System.out.print("Введите : ");
                    int innerMenu = scannerIn.nextInt();
                    switch (innerMenu) {
                        case 1: {
                            try {
                                musicShop.rentDisk();
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 2: {
                            musicShop.printRentedDisks();
                            break;
                        }
                        case 3: {
                            musicShop.returnDisk();
                            break;
                        }
                        default: {
                            System.out.print("Неизвестный ввод!\n");
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    musicShop.changeInfoAboutDisk();
                    break;
                }
                case 8: {
                    try (ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream("/Users/kulichok/IdeaProjects/kurs/src/MusicShop1/MusicShop__reserv.dat"))) {
                        oos.writeObject(musicShop);
                        System.out.println("Файл был записан");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 9: {
                    try (ObjectInputStream ois = new ObjectInputStream(
                            new FileInputStream("/Users/kulichok/IdeaProjects/kurs/src/MusicShop1/MusicShop__reserv.dat"))) {
                        musicShop = (MusicShop) ois.readObject();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 0: {
                    try (ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream("/Users/kulichok/IdeaProjects/kurs/src/MusicShop1/MusicShop.dat"))) {
                        oos.writeObject(musicShop);
                        System.out.println("Файл был записан");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    return;
                }
                default: {
                    System.out.print("Неверный выбор, попробуйте еще раз!\n");
                    break;
                }
            }
        }
    }
}