package data;
public abstract class User implements DataEntity{
    protected int id;
    protected String username, password, fullname, email;
    
    public User() {}
    public User(int id) {
        this.id = id;
        load();
    }
    public User(String fullname, String username, String password, String email) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        store();
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        load();
        return username;
    }
    public String getPassword() {
        load();
        return password;
    }
    public String getFullname() {
        load();
        return fullname;
    }
    public String getEmail() {
        load();
        return email;
    }
    public void setId(int id) {
        this.id = id;
        update();
    }
    public void setUsername(String username) {
        this.username = username;
        update();
    }
    public void setPassword(String password) {
        this.password = password;
        update();
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
        update();
    }
    public void setEmail(String email) {
        this.email = email;
        update();
    }
}
