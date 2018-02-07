import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;

public class ValidationTest {
public static void main(String[] args) {
    Member member = new Member().setEmail("sattlub123@gmail.com")
            .setName("최민규").setPassword("tnwls1135@").setPasswordCheck("tnwls1135@");
    System.out.println(validation(member));
}

public static int validation (Member member) {
        Pattern emailPattern =
                Pattern.compile("^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$"); // 이메일 밸리데이션 체크.
        Pattern namePattern =
                Pattern.compile("^[\\wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$"); // 이름 밸리데이션 체크.
        Pattern pwdPattern =
                Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$"); // 비밀번호 밸리데이션 체크.

        Matcher m = emailPattern.matcher(member.getEmail());
        if (!m.find()) {
            return -1;
        }

        m = namePattern.matcher(member.getName());
        if (!m.find()) {
            return -2;
        }

        m = pwdPattern.matcher(member.getPassword());
        if (!m.find()) {
            return -3;
        }

        System.out.println((member.getPassword() == member.getPasswordCheck()) ? 1 : 0);

        return 1;
    }
}

class Member {
    private String email;
    private String name;
    private String password;
    private String passwordCheck;
    private Date createDate;

    public String getEmail() {
        return email;
    }

    public Member setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Member setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Member setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public Member setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
        return this;
    }
}


