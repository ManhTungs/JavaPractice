package UI;

import UX.InteractLibrarian;

import java.util.Scanner;

public class Librarian {
    Scanner scan=new Scanner(System.in);
    InteractLibrarian interactLibrarian;

    public Librarian(InteractLibrarian interactLibrarian) {
        this.interactLibrarian = interactLibrarian;
    }

    public void Menu() {
        loop:
        while (true) {
            System.out.println("__________Librarian__________\n" +
                    "|\t 1. Đổi mật khẩu\n" +
                    "|\t 2. Thêm sách\n" +
                    "|\t 3. Danh sách sách trong kho\n" +
                    "|\t 4. Danh sách sách đang được mượn\n" +
                    "|\t 5. Đổi tài khoản\n" +
                    "|\t 6. Thoát Chương trình\n" +
                    "|____________________________");
            int n = scan.nextInt();
            switch (n) {
                case 1:
                    interactLibrarian.changePass();
                    break;
                case 2:
                    interactLibrarian.addBook();
                    break;
                case 3:
                    interactLibrarian.showListBook();
                    break;
                case 4:
                    interactLibrarian.showListPersonBorrow();
                    break;
                case 5:
                    break loop;
                case 6:
                    System.exit(0);
            }

        }
    }
}
