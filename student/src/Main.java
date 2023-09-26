import java.util.ArrayList;

public class Main {
    public static void main (String[]args) {

        ArrayList<Student> listaStudentow = new ArrayList<>();

        double[] oceny1 = {4.5, 3.2, 5.7};
        double[] oceny2 = {5.0, 5.0, 5.0};

        Student student1 = new Student("Mateusz", "Piela", oceny1, 'M', "Informatyk");
        Student student2 = new Student("Marek", "Genge", oceny2, 'M', "Programista");

        student1.WyswietlInformacje();
        student2.WyswietlInformacje();

        student1.UstawPlec('F');
        student2.UstawPlec('F');

        student1.ZmienKierunek("Matematyk");
        student2.ZmienKierunek("Matematyk");

        for (int i = 0; i < oceny2.length; i++) {
            student2.ZmienOcene(i, 1.0);
        }

        student1.ZmienImie("M");
        student2.ZmienNazwisko("G");

        student1.SprawdzZaliczenie();
        student2.SprawdzZaliczenie();

        listaStudentow.add(student1);
        listaStudentow.add(student2);

        String wybranyKierunek = "Matematyk";
        double sredniaOcenKierunku = WyswietlSredniaOcenaKierunku(wybranyKierunek, listaStudentow);
        System.out.println("\nSrednia ocen kierunku "+wybranyKierunek+" wynosi: "+sredniaOcenKierunku);
     }

    public static double WyswietlSredniaOcenaKierunku(String kierunek, ArrayList<Student> listaStudentow) {
        double suma = 0.0;
        int ilosc = 0;
        for (Student student : listaStudentow) {
            if (student.kierunek == kierunek) {
                suma += student.ObliczSredniaOcen();
                ilosc++;
            }
        }
        double srednia = suma / ilosc;
        return srednia;
    }
}
