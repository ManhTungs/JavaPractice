package Model;

import java.util.List;

public class GeneralBorrowBook {
    public String namePerson;
    private List<EachPersonBorrowBook> eachPersonBorrowBooks;
    private Account account;
    public GeneralBorrowBook() {
    }

    public GeneralBorrowBook(Account account) {
        this.account = account;
    }

    public GeneralBorrowBook(Account account, String namePerson, List<EachPersonBorrowBook> eachPersonBorrowBooks) {
        this.namePerson = namePerson;
        this.account=account;
        this.eachPersonBorrowBooks = eachPersonBorrowBooks;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public List<EachPersonBorrowBook> getEachPersonBorrowBooks() {
        return eachPersonBorrowBooks;
    }

    public void setEachPersonBorrowBooks(List<EachPersonBorrowBook> eachPersonBorrowBooks) {
        this.eachPersonBorrowBooks = eachPersonBorrowBooks;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "{" +
                "namePerson='" + namePerson + '\'' +
                ", eachPersonBorrowBooks=" + eachPersonBorrowBooks.toString() +
                '}';
    }
}
