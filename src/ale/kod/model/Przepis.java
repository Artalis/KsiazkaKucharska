package ale.kod.model;

import java.net.URL;

public class Przepis {

    private String name;
    private String rodzaj;
    private String url;
    private String tresc;
    private int czas;
    private int ID;


    public Przepis() {
    }

    public Przepis(String name, String rodzaj, String url, String tresc, int czas,int ID) {
        this.name = name;
        this.rodzaj = rodzaj;
        this.url = url;
        this.tresc = tresc;
        this.czas = czas;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean trescPrzekraczaZakres(){
        if(tresc.length()>700) return true;
        else return false;
    }

    public boolean haveAll(){
        if(this.czas!=0 && this.tresc!=null && this.name!=null && this.rodzaj!=null && this.url!=null){
            return true;
        }else {
            return false;
        }
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }
}
