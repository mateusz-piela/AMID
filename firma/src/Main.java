import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
class Pracownik{
    String imie, nazwisko, stanowisko, pensja;
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getStanowisko() {
        return stanowisko;
    }
    public String getPensja() {
        return pensja;
    }
    public Pracownik(String imie, String nazwisko, String stanowisko, String pensja){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.pensja = pensja;
    }
}

public class Main {
    private List<Pracownik> pracownicy;
    public Main() {
        pracownicy = new ArrayList<>();
    }
    public void nowy(Pracownik p) {
        pracownicy.add(p);
    }
    public void wyswietl() {
        for(Pracownik p : pracownicy) {
            System.out.println(p.getImie());
            System.out.println(p.getNazwisko());
            System.out.println(p.getStanowisko());
            System.out.println(p.getPensja());
            System.out.println();
        }
    }
    public void stanowisko(String stanowisko) {
        for(Pracownik p : pracownicy) {
            if(p.getStanowisko().equals(stanowisko)) {
                System.out.println("Imię: "+p.getImie());
                System.out.println("Nazwisko: "+p.getNazwisko());
                System.out.println("Stanowisko: "+p.getStanowisko());
                System.out.println("Pensja: "+p.getPensja());
                System.out.println();
            }
        }
    }
    public void pensja(String imie, String nazwisko, String pensja) {
        for(Pracownik p : pracownicy) {
            if(p.imie.equals(imie) && p.nazwisko.equals(nazwisko)) {
                p.pensja = pensja;
            }
        }
    }
    public static void main(String[] args) {

        Main m = new Main();
        Scanner scan = new Scanner(System.in);
        boolean loop = true;

        while(loop) {

            System.out.println("Co chcesz zrobić? Wpisz odpowiedni symbol.");
            System.out.println("1 - dodawanie pracowników");
            System.out.println("2 - wyświetlanie informacji o wszystkich pracownikach firmy");
            System.out.println("3 - wyświetlanie pracowników z danego stanowiska");
            System.out.println("4 - zmiana pensji pracownika");
            System.out.println("5 - wyjście z programu");

            String opcja = scan.nextLine();
            System.out.println();

            switch(opcja) {

                case "1":
                    System.out.println("Wypełnij dane nowego pracownika:");
                    System.out.println("Imię:");
                    String imie = scan.nextLine();
                    System.out.println("Nazwisko:");
                    String nazwisko = scan.nextLine();
                    System.out.println("Stanowisko:");
                    String stanowisko = scan.nextLine();
                    System.out.println("Pensja:");
                    String pensja = scan.nextLine();
                    Pracownik p = new Pracownik(imie, nazwisko, stanowisko, pensja);
                    m.nowy(p);
                    System.out.println();
                    break;

                case "2":
                    m.wyswietl();
                    break;

                case "3":
                    System.out.println("Wybierz stanowisko:");
                    String st = scan.nextLine();
                    m.stanowisko(st);
                    break;

                case "4":
                    System.out.println("Wpisz imię pracownika:");
                    String im = scan.nextLine();
                    System.out.println("Wpisz nazwisko pracownika:");
                    String nz = scan.nextLine();
                    System.out.println("Wpisz nową pensję pracownika:");
                    String np = scan.nextLine();
                    m.pensja(im, nz, np);
                    break;

                case "5":
                    loop = false;
                    break;

                default:
                    System.out.println("Błąd.");
                    System.out.println();
                    break;
            }
        }
    }
}