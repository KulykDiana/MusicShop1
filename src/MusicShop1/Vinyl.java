package MusicShop1;/*
Три основных типоразмера (по диаметру) пластинок:
        12″ (300 мм) — «гигант»
        10″ (250 мм) — «гранд»
        7″ (175 мм) — «миньон».
*/

public class Vinyl extends Disk{
    private boolean isStereophonic; // if false,then it's monophonic
    private boolean isFlexible; // if false,then it's solid
    private int diameter;

    public Vinyl(double price, int yearOfPublication, String nameOfCD, String author, int amount, int article,String genre,
                 boolean isStereophonic, boolean isFlexible, int diameter) {
        super(price, yearOfPublication, nameOfCD, author, amount, article,genre);
        this.isStereophonic = isStereophonic;
        this.isFlexible = isFlexible;
        this.diameter = diameter;
    }

    @Override
    public void print() {
        System.out.print("*****************************************************************************************\n");
        System.out.printf("Название = \"%s\" , Автор = %s ,Год = %d\nКоличество = %d ,Цена = %.2f $\n",
                getNameOfCD(), getAuthor(), getYearOfPublication(), getAmount(), getPrice());
        System.out.printf("Артикль = %d\n",getArticle());
        System.out.print("Тип диска =  Виниловая пластинка\n");
        if(isStereophonic){
            System.out.print("Стереофонический, ");
        } else {
            System.out.print("Однотонный, ");
        }
        if(isFlexible){
            System.out.print("Гибкий\n");
        } else {
            System.out.print("Твердый\n");
        }
        System.out.printf("Диаметр = %d″,Тип винила = %s\n",diameter,getTypeOfDisk());
    }

    private String getTypeOfDisk(){
        if(diameter == 12){
            return "Гигант";
        } else if(diameter == 10){
            return "Гранд";
        } else if (diameter == 7){
            return "Миньон";
        } else {
            return "Не указано";
        }
    }
}
