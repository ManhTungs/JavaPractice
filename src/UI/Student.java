package UI;

import UX.InteractStudent;

import java.util.Scanner;

public class Student {
    Scanner scan=new Scanner(System.in);
    InteractStudent interactStudent;

    public Student(InteractStudent interactStudent) {
        this.interactStudent = interactStudent;
    }

    public void Menu() {
        loop:
        while (true) {
            System.out.println("__________Student__________\n" +
                    "|\t 1. Đổi mật khẩu\n" +
                    "|\t 2. Danh sách sách trong kho\n" +
                    "|\t 3. Mượn sách\n" +
                    "|\t 4. Trả sách\n" +
                    "|\t 5. Danh sách sách đang mượn\n" +
                    "|\t 6. Đổi tài khoản\n" +
                    "|\t 7. Thoát Chương trình\n" +
                    "|____________________________");
            int n = scan.nextInt();
            switch (n) {
                case 1:
                    interactStudent.changePass();
                    break;
                case 2:
                    interactStudent.showListBook();
                    break;
                case 3:
                    interactStudent.BorrowBook();
                    break;
                case 4:
                    interactStudent.returnBook();
                    break;
                case 5:
                    interactStudent.showYourBorrowBook();
                    break;
                case 6:
                    break loop;
                case 7:
                    System.exit(0);
            }
        }
    }
}
