package UI;

import Model.Account;
import UX.InteractAdmin;
import java.util.Scanner;
public class Admin {
    Scanner scan =new Scanner(System.in);


    private InteractAdmin interactAdmin;
    private Account account;

    public Admin(InteractAdmin interactAdmin) {
        this.interactAdmin=interactAdmin;
    }

    public void Menu(){
        loop:while(true){
            System.out.println("__________Admin_____________\n" +
                    "|\t 1. Đổi Mật khẩu\n" +
                    "|\t 2. Tạo tài khoản thủ thư\n" +
                    "|\t 3. Tạo tài khoản sinh viên\n" +
                    "|\t 4. Danh sách tài khoản\n" +
                    "|\t 5. Reset mật khẩu\n" +
                    "|\t 6. Lock tài khoản\n" +
                    "|\t 7. Un-Lock tài khoản\n" +
                    "|\t 8. Đổi tài khoản\n" +
                    "|\t 9. Thoát Chương trình\n" +
                    "|____________________________");
            int n=scan.nextInt();
            switch (n){
                case 1:
                    interactAdmin.changePass();
                    break;
                case 2:
                    interactAdmin.addAccount(2);
                    break;
                case 3:
                    interactAdmin.addAccount(3);
                    break;
                case 4:
                    interactAdmin.showListAccount();
                    break;
                case 5:
                    interactAdmin.resetPassWord();
                    break;
                case 6:
                    interactAdmin.lockAccount();
                    break;
                case 7:
                    interactAdmin.unLockAccount();
                    break;
                case 8:
                    break loop;
                case 9:
                    System.exit(0);
            }
        }
    }

}
