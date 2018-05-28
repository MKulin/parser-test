package model;

/**
 * Модель приложения
 */
public class TableRow {

    /**
     * Номер ряда в таблице ссылок
     */
    private int number;
    /**
     * Имя ссылки
     */
    private String name;
    /**
     * Адрес ссылки
     */
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
