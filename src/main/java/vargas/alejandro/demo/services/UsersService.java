package vargas.alejandro.demo.services;

import org.springframework.stereotype.Service;
import vargas.alejandro.demo.entities.User;
import vargas.alejandro.demo.repositories.UsersRepository;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User create(User user) {
        return usersRepository.save(user);
    }
}
