package randp.form;

import javax.validation.constraints.NotNull;

/**
 * Created by dyh on 2018/4/10.
 */
public class LoginForm {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String verifyCode;

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

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
