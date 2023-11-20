import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private List<Todo> lista;
    public ToDoList() {
        lista = new ArrayList<>();
    }
    public void dodaj(Todo t) {
        lista.add(t);
    }
    public void wyswietl() {
        for (Todo t : lista) {
            System.out.println(t.getNumer()+". ["+t.getStan()+"] "+t.getNazwa()+": "+t.getOpis());
        }
        System.out.println();
    }
    public void zakoncz(int n){
        for (Todo t : lista) {
            if (n == t.getNumer()) {
                t.stan = 'x';
            }
        }
    }
    public void usun(int n){ /*
        for (Todo t : lista) {
            if (n == t.getNumer()) {
                lista.remove(t);
            }
     } */
        Iterator<Todo> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getNumer() == n) {
                iterator.remove();
                System.out.println("Zadanie o numerze "+n+" zostało usunięte.");
            }
        }
    }
    public static void main(String[] args) {

        ToDoList t = new ToDoList();
        int i = 1;
        Boolean loop = true;

        while(loop) {

            Scanner scan = new Scanner(System.in);

            System.out.println("1. Dodaj nowe zadanie");
            System.out.println("2. Oznacz zadanie jako zakończone");
            System.out.println("3. Usuń zadanie");
            System.out.println("4. Wyświetl listę zadań");
            System.out.println("5. Wyjście");
            System.out.println();

            System.out.println("Wybierz opcję (1/2/3/4/5): ");
            String input = scan.nextLine();

            switch (input) {

                case "1":
                    System.out.println("Podaj nazwę zadania: ");
                    String nazwa = scan.nextLine();
                    System.out.println("Podaj opis zadania: ");
                    String opis = scan.nextLine();
                    System.out.println("Zadanie "+nazwa+" zostało dodane do listy.");
                    Todo nowy = new Todo(nazwa, opis, i++, ' ');
                    t.dodaj(nowy);
                    System.out.println();
                    break;

                case "2":
                    System.out.println("Podaj numer zadania do oznaczenia jako zakończone: ");
                    int numer = scan.nextInt();
                    t.zakoncz(numer);
                    System.out.println();
                    break;

                case "3":
                    System.out.println("Podaj numer zadania do usunięcia: ");
                    int n = scan.nextInt();
                    t.usun(n);
                    System.out.println();
                    break;

                case "4":
                    System.out.println("Lista zadań:");
                    t.wyswietl();
                    System.out.println();
                    break;

                case "5":
                    loop = false;
                    System.out.println("Koniec programu.");
                    break;

                default:
                    System.out.println("Proszę wpisać poprawną wartość.");
                    System.out.println();
                    break;
            }
        }
    }
}