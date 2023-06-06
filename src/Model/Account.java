package Model;

public class Account {
    private int type;
    public static final int typeAdmin=1;
    public static final int typeLibrarian=2;
    public static final int typeStudent=3;
    private String email;
    private String password;
    private boolean isLock;

    public Account() {
    }

    public Account(String email,String password,boolean isLock,int type){
        this.email=email;
        this.password=password;
        this.isLock=isLock;
        this.type=type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "type=" + type +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isLock=" + isLock +
                '}';
    }
}
