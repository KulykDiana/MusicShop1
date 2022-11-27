package MusicShop1;

public class CD extends Disk{
    private boolean isRewritable;
    private boolean isDoubleSided;

    public CD(double price, int yearOfPublication, String nameOfCD, String author, int amount, int article, String genre,
              boolean isRewritable, boolean isDoubleSided) {
        super(price, yearOfPublication, nameOfCD, author, amount, article, genre );
        this.isRewritable = isRewritable;
        this.isDoubleSided = isDoubleSided;
    }

    @Override
    public void print() {
        System.out.print("*****************************************************************************************\n");
        System.out.printf("Название = \"%s\" , Автор = %s ,Год = %d\nКоличество = %d ,Цена = %.2f $\n",
                getNameOfCD(), getAuthor(), getYearOfPublication(), getAmount(), getPrice());
        System.out.printf("Артикль = %d\n",getArticle());
        System.out.print("Тип диска = CD disk\n");
        if(isRewritable){
            System.out.print("Перезаписываемый, ");
        } else {
            System.out.print("Не перезаписываемый, ");
        }
        if(isDoubleSided){
            System.out.print("Двусторонний\n");
        } else {
            System.out.print("Односторонний\n");
        }
    }
}
