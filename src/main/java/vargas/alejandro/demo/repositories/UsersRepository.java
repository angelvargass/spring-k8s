package vargas.alejandro.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vargas.alejandro.demo.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
