package algorithms;

public class Card {

    private String type;
    private String getal;

    public Card(String type, String getal) {
        this.type = type;
        this.getal = getal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGetal() {
        return getal;
    }

    public void setGetal(String getal) {
        this.getal = getal;
    }

    public String toString() {
        return type + " " + getal;
    }

    public int getValue() {
        //Set player one value
        int value = 0;

        if (getal.equals("Aas")) {
            value = 14;
        } else if (getal.equals("Boer")) {
            value = 11;
        } else if (getal.equals("Koningin")) {
            value = 12;
        } else if (getal.equals("Koning")) {
            value = 13;
        } else {
            value = Integer.parseInt(getal);
        }
        return value;
    }

}
