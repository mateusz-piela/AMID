import java.util.ArrayList;
public class Student {
    String imie;
    String nazwisko;
    double[] oceny;
    char plec;
    String kierunek;

    public Student(String imie, String nazwisko, double[] oceny, char plec, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.oceny = oceny;
        this.plec = plec;
        this.kierunek = kierunek;
    }
    public void WyswietlInformacje() {
        System.out.println("Informacje studenta:");
        System.out.println(imie);
        System.out.println(nazwisko);
        for (double ocena : oceny) {
            System.out.println(ocena);
        }
        System.out.println(plec);
        System.out.println(kierunek);
        System.out.println();
    }

    public void ZmienKierunek(String nowyKierunek) {
        this.kierunek = nowyKierunek;
        WyswietlInformacje();
    }

    public void ZmienOcene(int indeks, double nowaOcena) {
        if (indeks >= 0 && indeks < oceny.length) {
            this.oceny[indeks] = nowaOcena;
        }
        WyswietlInformacje();
    }

    public void ZmienImie(String noweImie) {
        this.imie = noweImie;
    }

    public void ZmienNazwisko(String noweNazwisko) {
        this.nazwisko = noweNazwisko;
    }

    public void UstawPlec(char nowaPlec) {
        this.plec = nowaPlec;
    }

    public double ObliczSredniaOcen() {
        double suma = 0.0;
        for (double ocena : oceny) {
            suma += ocena;
        }
        double srednia = suma / oceny.length;
        return srednia;
    }

    public void SprawdzZaliczenie() {
        double srednia = ObliczSredniaOcen();
        if (srednia > 1.75) {
            System.out.println("Student "+imie+" "+nazwisko+" zdał. Średnia wynosi: "+srednia);
        } else {
            System.out.println("Student "+imie+" "+nazwisko+" nie zdał. Średnia wynosi: "+srednia);
        }
    }
}