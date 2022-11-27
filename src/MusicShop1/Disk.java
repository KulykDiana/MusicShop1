package MusicShop1;

import java.io.Serializable;

public class Disk implements Serializable {
    private int article;

    private String genre;
    private double price;
    private int yearOfPublication;
    private String nameOfCD;
    private String author;
    private int amount;

    Disk(double price, int yearOfPublication, String nameOfCD, String author, int amount, int article, String genre) {
        this.price = price;
        this.yearOfPublication = yearOfPublication;
        this.nameOfCD = nameOfCD;
        this.author = author;
        this.amount = amount;
        this.article = article;
        this.genre = genre;
    }

    public void print(){
        System.out.print("*******************************************************************************\n");
        System.out.printf("Название = \"%s\" , Автор = %s ,Год = %d\nКоличество = %d ,Цена = %.2f $\n",
                getNameOfCD(), getAuthor(), getYearOfPublication(), getAmount(), getPrice());
    }

    public double getPrice() {
        return price;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String getNameOfCD() {
        return nameOfCD;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getAmount() {
        return amount;
    }

    public int getArticle() {
        return article;
    }

    public void setGenre(String genre) {this.genre = genre;}

    public void setPrice(double price) {this.price = price;}

    public void setYearOfPublication(int yearOfPublication) {this.yearOfPublication = yearOfPublication;}

    public void setNameOfCD(String nameOfCD){ this.nameOfCD = nameOfCD;}

    public void setAuthor(String author) {this.author = author;}

    public void setAmount(int amount) {this.amount = amount;}
}
