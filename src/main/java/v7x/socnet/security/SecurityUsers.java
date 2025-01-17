package v7x.socnet.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import v7x.socnet.model.Status;
import v7x.socnet.model.Users;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUsers implements UserDetails {

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public SecurityUsers(String username, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(Users users){
        return new User(
                users.getLogin(),
                users.getPassword(),
                users.getStatus().equals(Status.ACTIVE),
                users.getStatus().equals(Status.ACTIVE),
                users.getStatus().equals(Status.ACTIVE),
                users.getStatus().equals(Status.ACTIVE),
                users.getRole().getAuthorities()
        );
    }
}
