package v7x.socnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v7x.socnet.model.Users;
import v7x.socnet.repository.UsersRepository;
import java.util.List;

@Service
public class UsersService {
    final
    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findById(long id){
        return usersRepository.getOne(id);
    }

    public List<Users> findAll(){
        return usersRepository.findAll();
    }
    public Users saveUsers(Users users){
        return usersRepository.save(users);
    }

    public void deleteById(long id){
        usersRepository.deleteById(id);
    }
}
