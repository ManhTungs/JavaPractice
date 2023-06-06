package UX;

import Model.Account;

public interface InteractAdmin {
    void changePass();
    void addAccount(int type);
    void showListAccount();
    void resetPassWord();
    void lockAccount();
    void unLockAccount();


}
