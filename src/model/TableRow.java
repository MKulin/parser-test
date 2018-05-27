package model;

public class TableRow {

    private int number;
    private String name;
    private String href;

    public TableRow(int number, String name, String href){
        this.number = number;
        this.name = name;
        this.href = href;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }
}
