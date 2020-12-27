package v7x.socnet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import v7x.socnet.model.Users;
import v7x.socnet.repository.UsersRepository;


@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserDetailsServiceImpl(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Users users = usersRepository.findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("user doesn't exist"));
        return SecurityUsers.fromUser(users);
    }
}