package Model;

public class Book {
    private String nameBook;
    private String codeBook;
    private int amountCurrent;
    private int amountLand;
    private int totalAmount;

    public Book() {
    }

    public Book(String nameBook, String codeBook, int amountLand, int totalAmount) {
        this.nameBook = nameBook;
        this.codeBook = codeBook;
        this.amountCurrent = totalAmount;
        this.amountLand = amountLand;
        this.totalAmount = totalAmount;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public int getAmountCurrent() {
        return amountCurrent;
    }

    public void setAmountCurrent(int amountCurrent) {
        this.amountCurrent = amountCurrent;
    }

    public int getAmountLand() {
        return amountLand;
    }

    public void setAmountLand(int amountLand) {
        this.amountLand = amountLand;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "NameBook='" + nameBook + '\'' +
                ", Code Book='" + codeBook + '\'' +
                ", Amount current Book instock=" + amountCurrent +
                ", Amount Book Landed=" + amountLand +
                ", Total amount Book  =" + totalAmount +
                '}';
    }
}
