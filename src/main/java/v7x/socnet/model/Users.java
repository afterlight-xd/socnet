package v7x.socnet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "soc_net")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_user_seq")
    @SequenceGenerator(name="id_user_seq", schema = "soc_net", sequenceName="id_user_seq", allocationSize = 1)
    @Column(name = "id_user")
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "at_username")
    private String atUsername;
    @Column(name = "user_firstname")
    private String userFirstname;
    @Column(name = "user_secondname")
    private String userSecondname;
    @Column(name = "email")
    private String email;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public Users() { }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
        this.status = Status.ACTIVE;
        this.role = Role.USER;
    }

    public Users(String login, String password, String userFirstname, String userSecondname, String email) {
        this.login = login;
        this.password = password;
        this.userFirstname = userFirstname;
        this.userSecondname = userSecondname;
        this.email = email;
        this.status = Status.ACTIVE;
        this.role = Role.USER;
    }
}