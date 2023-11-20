public class Todo {
     String nazwa;
     String opis;
     int numer;
     char stan;
    public String getNazwa() {
        return nazwa;
    }
    public String getOpis() {
        return opis;
    }
    public int getNumer() {
        return numer;
    }
    public char getStan() {
        return stan;
    }
    public Todo(String nazwa, String opis, int numer, char stan) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.numer = numer;
        this.stan = stan;
    }
}
