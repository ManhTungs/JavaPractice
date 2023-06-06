package UX;

import Model.Account;
import Model.Book;
import Model.EachPersonBorrowBook;
import Model.GeneralBorrowBook;
import UI.Admin;
import UI.Librarian;
import UI.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager implements InteractAdmin, InteractLibrarian, InteractStudent {
    Scanner scan = new Scanner(System.in);
    private List<Account> listAccount = new ArrayList<>();
    private List<Book> listBook = new ArrayList<>();
    private List<EachPersonBorrowBook> eachPersonBorrowBooks = new ArrayList<>();
    private List<GeneralBorrowBook> generalBorrowBooks = new ArrayList<>();
    private Account currentAccount;
    //    ____________________________Overide___________________________
    private InteractAdmin interactAdmin = new InteractAdmin() {
        @Override
        public void changePass() {
            Manager.this.changePass();
        }

        @Override
        public void addAccount(int type) {
            Manager.this.addAccount(type);
        }

        @Override
        public void showListAccount() {
            Manager.this.showListAccount();
        }

        @Override
        public void lockAccount() {
            Manager.this.lockAccount();
        }

        @Override
        public void resetPassWord() {
            Manager.this.resetPassWord();
        }

        public void unLockAccount() {
            Manager.this.unLockAccount();
        }
    };
//    ___________________________________________________________________

    //__________________________Librarian____________________________________
    private InteractLibrarian interactLibrarian = new InteractLibrarian() {
        @Override
        public void changePass() {
            Manager.this.changePass();
        }

        @Override
        public void addBook() {
            Manager.this.addBook();
        }

        @Override
        public void showListBook() {
            Manager.this.showListBook();
        }

        @Override
        public void showListPersonBorrow() {
            Manager.this.showListPersonBorrow();
        }
    };
    //    _____________________________________________________________________
//    ___________________________Student__________________________________
    private InteractStudent interactStudent = new InteractStudent() {
        @Override
        public void changePass() {
            Manager.this.changePass();
        }

        @Override
        public void showListBook() {
            Manager.this.showListBook();
        }

        @Override
        public void BorrowBook() {
            Manager.this.BorrowBook();
        }

        @Override
        public void returnBook() {
            Manager.this.returnBook();
        }

        @Override
        public void showYourBorrowBook() {
            Manager.this.showYourBorrowBook();
        }
    };

    //    ______________________________________________________________________
    public Manager() {
        addDefaultBook();
        addDefaultAccount();
    }

    public void addDefaultAccount() {
        Account a = new Account("tungvip77540", "anhtung123", false, Account.typeAdmin);
        Account b = new Account("sonden", "sonden123", false, Account.typeLibrarian);
        Account c = new Account("hieucan", "hieucan123", false, Account.typeStudent);
        listAccount.add(a);
        listAccount.add(b);
        listAccount.add(c);
    }

    public void addDefaultBook() {
        Book a = new Book("Lập trình C++", "10001", 0, 10);
        Book b = new Book("SQL Sever", "10002", 0, 14);
        Book c = new Book("Lập trình Java", "10003", 0, 10);
        Book d = new Book("Dạy trồng cây", "10004", 0, 3);
        Book e = new Book("Dạy nấu ăn", "10005", 0, 16);
        listBook.add(a);
        listBook.add(b);
        listBook.add(c);
        listBook.add(d);
        listBook.add(e);

    }

    public void logIn() {
        while (true) {
            System.out.println("tài khoản:");
            String a = scan.nextLine();
            System.out.println("mật khẩu:");
            String b = scan.nextLine();
            Account signal = null;
            for (Account c : listAccount) {
                if (c.getEmail().equals(a) && c.getPassword().equals(b)) {
                    signal = c;
                    break;
                }
            }
            if (signal != null) {
                if (signal.isLock()) {
                    System.out.println("tài khoản này đã bị khóa,xin vui lòng nhập tài khoản khác");
                } else {
                    currentAccount = signal;
                    if (signal.getType() == Account.typeAdmin) {
                        Admin admin = new Admin(interactAdmin);
                        admin.Menu();
                    } else if (signal.getType() == Account.typeLibrarian) {
                        Librarian librarian = new Librarian(interactLibrarian);
                        librarian.Menu();

                    } else if (signal.getType() == Account.typeStudent) {
                        Student student = new Student(interactStudent);
                        student.Menu();
                    }
                }
            } else {
                System.out.println("tài khoản không tồn tại hoặc mật khẩu không đúng,vui lòng đăng nhập lại");
            }
        }
    }

    //    _______________________________Feature General___________________________________
    @Override
    public void changePass() {
        System.out.println("Nhập mật khẩu cũ");
        String currentPassWord = scan.nextLine();
        if (currentAccount.getPassword().equals(currentPassWord)) {
            System.out.println("Nhập mật khẩu mới của bạn:");
            String newPassword = scan.nextLine();
            System.out.println("Xác nhận mật khẩu mới:");
            String confirmPassWord = scan.nextLine();
            if (newPassword.equals(confirmPassWord)) {
                currentAccount.setPassword(newPassword);
                System.out.println("Bạn đã đổi mật khẩu thành công");
            } else {
                System.out.println("Xác nhận mật khẩu không trùng hợp. Đổi mật khẩu thất bại");
            }
        } else {
            System.out.println("mật khẩu không trùng hợp. Đổi mật khẩu thất bại");
        }
    }

    //_______________________________________________________________________________________
    @Override
//    _______________________________Feature Admin______________________________________________-
    public void addAccount(int type) {
        System.out.println("Mhâp email:");
        String email = scan.nextLine();
        System.out.println("Nhập PassWord:");
        String passWord = scan.nextLine();
        System.out.println("Để xác nhận tạo thêm tài khoản này xin vui lòng chọn 1, hủy chọn 0:");
        String confirm = scan.nextLine();
        int confirmParse = Integer.parseInt(confirm);
        if (confirmParse == 1) {
            listAccount.add(new Account(email, passWord, false, type));
            System.out.println("Bạn đã tạo tài khoản thành công");
        } else if (confirmParse == 0) {
            System.out.println("Bạn đã hủy tạo tài khoản thành công");
        } else {
            System.out.println("Sai thao tác, tạo tài khoản thất bại");
        }
    }

    @Override
    public void showListAccount() {
        for (Account a : listAccount) {
            System.out.println(a.toString());
        }
    }

    @Override
    public void lockAccount() {
        System.out.println("Nhập email:");
        String email = scan.nextLine();
        Account signal = null;
        for (Account a : listAccount) {
            if (a.getEmail().equals(email)) {
                signal = a;
                break;
            }
        }
        if (signal != null) {
            if (signal.isLock()) {
                System.out.println("Tài khoản này đã Lock từ trước đó rồi");
            } else {
                System.out.println("Chọn 1 để xác nhận lock, 0 để hủy");
                String confirm = scan.nextLine();
                int confirmParse = Integer.parseInt(confirm);
                if (confirmParse == 1) {
                    signal.setLock(true);
                    System.out.println("bạn đã Lcck tài khoản" + signal.toString());
                } else if (confirmParse == 0) {
                    System.out.println("bạn đã hủy Lock email");
                } else {
                    System.out.println("sai cú pháp, Lock thất bại");
                }
            }
        } else {
            System.out.println("Email không tồn tại, Lock email thất bại");
        }
    }

    @Override
    public void resetPassWord() {
        System.out.println("Nhập email:");
        String email = scan.nextLine();
        Account signal = null;
        for (Account a : listAccount) {
            if (a.getEmail().equals(email)) {
                signal = a;
                break;
            }
        }
        if (signal != null) {
            System.out.println("Nhập mật khẩu mới:");
            String newPassWord = scan.nextLine();
            System.out.println("Chọn 1 để xác nhận reset PassWord, 0 để hủy");
            String confirm = scan.nextLine();
            int confirmParse = Integer.parseInt(confirm);
            if (confirmParse == 1) {
                signal.setPassword(newPassWord);
                System.out.println("bạn đã reset Password thành công \n" + signal.toString());
            } else if (confirmParse == 0) {
                System.out.println("bạn đã hủy reset Password email");
            } else {
                System.out.println("sai cú pháp, reset PassWord thất bại");
            }
        } else {
            System.out.println("Tài khoản không tồn tại, reset PassWord false");
        }
    }

    @Override
    public void unLockAccount() {
        System.out.println("Nhập email:");
        String email = scan.nextLine();
        Account signal = null;
        for (Account a : listAccount) {
            if (a.getEmail().equals(email)) {
                signal = a;
                break;
            }
        }
        if (signal != null) {
            if (!signal.isLock()) {
                System.out.println("Tài khoản này không bị Lock, UnLock False");
            } else {
                System.out.println("Chọn 1 để xác nhận Unlock, 0 để hủy");
                String confirm = scan.nextLine();
                int confirmParse = Integer.parseInt(confirm);
                if (confirmParse == 1) {
                    signal.setLock(false);
                    System.out.println("bạn đã UnLcck tài khoản" + signal.toString());
                } else if (confirmParse == 0) {
                    System.out.println("bạn đã hủy UnLock email");
                } else {
                    System.out.println("sai cú pháp, UnLock thất bại");
                }
            }
        } else {
            System.out.println("Email không tồn tại, UnLock email thất bại");
        }
    }

    //_________________________________________________________________________________________
//   ________________________________Feature Librarian_____________________________________-
    public void addBook() {
        System.out.println("Nhập mã sách:");
        String codeBook = scan.nextLine();
        Book signal = null;
        for (Book a : listBook) {
            if (a.getCodeBook().equals(codeBook)) {
                signal = a;
                break;
            }

        }
        if (signal == null) {
            System.out.println("Có phải bạn muốn thêm sách mới (1 YES/0 NO)");
            String confirm = scan.nextLine();
            int confirmParse = Integer.parseInt(confirm);
            if (confirmParse == 1) {
                System.out.println("Nhập tên sách mới:");
                String nameBook = scan.nextLine();
                System.out.println("Nhập số lượng sách muốn thêm vào kho:");
                String totalAmount = scan.nextLine();
                int totalAmountParse = Integer.parseInt(totalAmount);
                listBook.add(new Book(codeBook, nameBook, 0, totalAmountParse));
                System.out.println("Thêm sách mới thành công");
            } else if (confirmParse == 0) {
                System.out.println("Thêm sách thất bại");
            } else {
                System.out.println("Sai cú pháp, thêm sách thất bại");
            }
        } else {
            System.out.println("Nhập số lượng sách muốn thêm:");
            String Amount = scan.nextLine();
            int PlusAmountParse = Integer.parseInt(Amount);
            signal.setTotalAmount(signal.getTotalAmount() + PlusAmountParse);
            System.out.println("Thêm sách thành công");
        }
    }

    @Override
    public void showListBook() {
        for (Book a : listBook) {
            System.out.println(a.toString());
        }
    }

    @Override
    public void showListPersonBorrow() {
        for (GeneralBorrowBook a : generalBorrowBooks) {
            System.out.println(a.toString());
        }

    }
//    ____________________________________________________________________________________


    //    _______________________________Feature Student_____________________________________-
    @Override
    public void BorrowBook() {
        System.out.println("Nhập mã sách");
        String codeBook = scan.nextLine();
        Book signalBook = null;
        Account signalAccount = null;
        for (Book a : listBook) {
            if (a.getCodeBook().equals(codeBook)) {
                signalBook = a;
                break;
            }
        }
        if (signalBook != null) {
            System.out.println("nhập số lượng bạn muốn mượn");
            String amount = scan.nextLine();
            int amountBorrow = Integer.parseInt(amount);
            if (amountBorrow <= signalBook.getAmountCurrent()) {
                signalBook.setAmountCurrent(signalBook.getAmountCurrent() - amountBorrow);
                signalBook.setAmountLand(signalBook.getAmountLand() + amountBorrow);
                for (GeneralBorrowBook a : generalBorrowBooks) {
                    if (currentAccount == a.getAccount()) {
                        if (a.getNamePerson() == null) {
                            System.out.println("Nhập tên của bạn:");
                            String namePerson = scan.nextLine();
                            a.setNamePerson(namePerson);
                        }
                        eachPersonBorrowBooks.add(new EachPersonBorrowBook(codeBook, signalBook.getNameBook(), LocalDateTime.now(), amountBorrow));
                        a.setEachPersonBorrowBooks(eachPersonBorrowBooks);
                        System.out.println("Bạn đã mượn sách thành công - Số lượng: " + amountBorrow);
                        break;
                    }
                }
            } else {
                System.out.println("Số lượng sách trong kho không đủ, mượn sách thất bại");
            }
        } else {
            System.out.println("Mã sách không tồn tại, mượn sách thất bại");
        }
    }

    @Override
    public void returnBook() {
        System.out.println("Nhập mã sách bạn muốn trả:");
        String codeBook= scan.nextLine();
        for (GeneralBorrowBook a: generalBorrowBooks) {
            if (a.getAccount()==currentAccount){
                for (EachPersonBorrowBook b:a.getEachPersonBorrowBooks()) {

                }
            }
        }

    }

    @Override
    public void showYourBorrowBook() {
        for (GeneralBorrowBook a : generalBorrowBooks) {
            System.out.println(a.toString());
        }
    }
//    ____________________________________________________________________________________
}
