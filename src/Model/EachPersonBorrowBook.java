package Model;

import java.time.LocalDateTime;

public class EachPersonBorrowBook {
    private String codeBook;
    private String nameBook;
    private LocalDateTime timeBorrow;
    private int amount;

    public EachPersonBorrowBook() {
    }

    public EachPersonBorrowBook(String codeBook, String nameBook, LocalDateTime timeBorrow, int amount) {
        this.codeBook = codeBook;
        this.nameBook = nameBook;
        this.timeBorrow = timeBorrow;
        this.amount = amount;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public LocalDateTime getTimeBorrow() {
        return timeBorrow;
    }

    public void setTimeBorrow(LocalDateTime timeBorrow) {
        this.timeBorrow = timeBorrow;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "{" +
                "codeBook='" + codeBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", amount=" + amount +
                "}\n";
    }
}
