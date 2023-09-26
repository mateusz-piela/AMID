import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SymulatorTermostatu {
    public static void main(String[] args) throws InterruptedException {

        Termostat termostat = new Termostat(); //tworzenie termostatu
        termostat.aktualnaTemperatura = 20; //inicjalizacja wartości domyślnych
        termostat.ustawionaTemperatura = 22;

        boolean loop = true; //zmienna do kontrolowania pętli "panelu sterowania"
        while (loop) { //"panel sterowania"

            System.out.println("Wybierz opcję:");
            System.out.println("1 - Sprawdź aktualną i ustawioną temperaturę.");
            System.out.println("2 - Ustaw temperaturę.");
            System.out.println("3 - Wyjdź z programu.");
            Scanner scan = new Scanner(System.in);
            String opt = scan.nextLine();
            System.out.println();

            switch (opt) {

                case "1":
                    System.out.println("Aktualna temperatura: "+termostat.aktualnaTemperatura); //wyświetla aktualną temperaturę
                    System.out.println("Ustawiona temperatura: "+termostat.ustawionaTemperatura); //wyświetla ustawioną temperaturę
                    System.out.println();
                    termostat.sprawdzTemperature(termostat.aktualnaTemperatura, termostat.ustawionaTemperatura); //aktywowanie termostatu
                    System.out.println();
                    break;

                case "2":
                    System.out.println("Ustaw temperaturę (5-35):");
                    termostat.ustawionaTemperatura = scan.nextInt();
                    System.out.println();
                    termostat.sprawdzTemperature(termostat.aktualnaTemperatura, termostat.ustawionaTemperatura); //aktywowanie termostatu po ustawieniu nowej temperatury
                    System.out.println();
                    break;

                case "3":
                    loop = false; //program się kończy
                    break;

                default:
                    System.out.println("Proszę wprowadzić poprawną wartość.");
                    System.out.println();
            }
        }
    }
}

class Termostat {
    int aktualnaTemperatura;
    int ustawionaTemperatura;

    public void wlaczOgrzewanie() throws InterruptedException { //gdy aktualna temp jest różna od ustawionej, powiększ aktualną o 1
        System.out.println("Włączono ogrzewanie.");
        while (aktualnaTemperatura != ustawionaTemperatura) {
            aktualnaTemperatura+=1;
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Aktualna temperatura: "+aktualnaTemperatura);
        }
        wylaczOgrzewanie();
    }

    public void wylaczOgrzewanie() {
        System.out.println("Wyłączono ogrzewanie.");
    }

    public void wlaczChlodzenie() throws InterruptedException { //gdy aktualna temp jest różna od ustawionej, pomniejsz aktualną o 1
        System.out.println("Włączono chłodzenie.");
        while (aktualnaTemperatura != ustawionaTemperatura) {
            aktualnaTemperatura-=1;
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Aktualna temperatura: "+aktualnaTemperatura);
        }
        wylaczChlodzenie();
    }

    public void wylaczChlodzenie() {
        System.out.println("Wyłączono chłodzenie.");
    }

    public void sprawdzTemperature(int aktualnaTemperatura, int ustawionaTemperatura) throws InterruptedException {
        if (ustawionaTemperatura >= 5 && ustawionaTemperatura <= 35) { //sprawdza czy wartosc ustawionej temperatury jest poprawna
            if (aktualnaTemperatura < ustawionaTemperatura) { //sprawdza czy wlaczyc ogrzewanie czy chlodzenie
                wlaczOgrzewanie();
            } else if (aktualnaTemperatura > ustawionaTemperatura) {
                wlaczChlodzenie();
            } else {
                wylaczOgrzewanie();
                wylaczChlodzenie();
            }
        } else {
            System.out.println("Proszę wprowadzić poprawną wartość.");
        }
    }
}