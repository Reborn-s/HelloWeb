package test;

/**
 * Created by Reborn。 on 2017/5/31.
 */
@Table("t_user")
public class User {
    @ID("uid")
    private String uid;

    @Column("uname")
    private String username;

    @Column("pword")
    private String password;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
