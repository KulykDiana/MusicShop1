package MusicShop1;
/*
Частота дискретизации поддерживаемая MusicShop1.DVD диском
    44,1 кГц	48 кГц	88,2 кГц	96 кГц	176,4 кГц	192 кГц
Кодеки
    В MusicShop1.DVD-Audio используется система компрессии данных без потерь (MLP)
    Помимо стереофонограммы высокого разрешения без сжатия (LPCM) или со сжатием без потерь (MLP)
    звуковой материал той же программы может быть представлен в компрессированном виде с потерями,
    в форматах пространственного звучания Dolby Digital или DTS
 */

public class DVD extends Disk {
    private boolean surroundSound; // if supports 5.1 sound
    private double samplingFrequency; // частота дискретизации
    private String codec;

    public DVD(double price, int yearOfPublication, String nameOfCD, String author, int amount, int article,String genre,
               boolean surroundSound, double samplingFrequency, String codec) {
        super(price, yearOfPublication, nameOfCD, author, amount, article,genre );
        this.surroundSound = surroundSound;
        this.samplingFrequency = samplingFrequency;
        this.codec = codec;
    }

    @Override
    public void print() {
        System.out.print("*****************************************************************************************\n");
        System.out.printf("Название = \"%s\" , Автор = %s ,Год = %d\nКоличество = %d ,Цена = %.2f $\n",
                getNameOfCD(), getAuthor(), getYearOfPublication(), getAmount(), getPrice());
        System.out.printf("Артикль = %d\n",getArticle());
        System.out.print("Тип диска = DVD disk\n");
        if(surroundSound){
            System.out.print("Поддерживает звук 5.1., ");
        } else {
            System.out.print("Не поддерживает звук 5.1., ");
        }
        System.out.printf("Частота дискретизации = %.2f, Codec = %s\n",samplingFrequency,codec);
    }

    public boolean isSurroundSound() {return surroundSound;}

    public void setSurroundSound(boolean surroundSound) {this.surroundSound = surroundSound;}

    public double getSamplingFrequency() {return samplingFrequency;}

    public void setSamplingFrequency(double samplingFrequency) {this.samplingFrequency = samplingFrequency;}

    public String getCodec() {return codec;}

    public void setCodec(String codec) {this.codec = codec;}
}
