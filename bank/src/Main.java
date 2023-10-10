class Klient {
    private String nazwa;
    private int id;
    private String adres;
    public String getNazwa(){
        return nazwa;
    }
    public int getId(){
        return id;
    }
    public String getAdres(){
        return adres;
    }
    public Klient(String nazwa, int id, String adres){
        this.nazwa = nazwa;
        this.id = id;
        this.adres = adres;
    }
}
class KontoBankowe{
    private int numerKonta;
    private double saldo;
    private Klient klient;
    public int getNumerKonta(){
        return numerKonta;
    }
    public double getSaldo(){
        return saldo;
    }
    public Klient getKlient(){
        return klient;
    }
    public void wplacanie(float ilosc){
        System.out.println("Wplacanie ilosci: "+ilosc);
        this.saldo += ilosc;
        wyswietlanieSalda();
    }
    public void wyplacanie(float ilosc){
        System.out.println("Wyplacanie ilosc: "+ilosc);
        this.saldo -= ilosc;
        wyswietlanieSalda();
    }
    public void wyswietlanieSalda(){
        System.out.println("Saldo: "+getSaldo());
    }
    public void wyswietlanieKlienta(){
        getKlient();
        System.out.println("ID: "+klient.getId());
        System.out.println("Nazwa: "+klient.getNazwa());
        System.out.println("Adres: "+klient.getAdres());
    }
    public void wyswietlanieKonta(){
        System.out.println("Numer konta: "+getNumerKonta());
        wyswietlanieSalda();
    }
    public KontoBankowe(int numerKonta, double saldo, Klient klient){
        this.numerKonta = numerKonta;
        this.saldo = saldo;
        this.klient = klient;
    }
}
public class Main {
    public static void main(String[] args) {

        Klient pierwszy = new Klient("Mateusz", 1, "Dąbrowskiego");
        KontoBankowe pierwsze = new KontoBankowe(1, 5555, pierwszy);
        pierwsze.wyswietlanieKlienta();
        pierwsze.wyswietlanieKonta();
        pierwsze.wplacanie(222);
        pierwsze.wyplacanie(1300);

        Klient drugi = new Klient("Jezus", 2, "Czereśniowa");
        KontoBankowe drugie = new KontoBankowe(2, 234, drugi);
        drugie.wyswietlanieKlienta();
        drugie.wyswietlanieKonta();
        drugie.wplacanie(500);
        drugie.wyplacanie(1000);
    }
}