package NguyenNhatKhang.bai36.services;

import NguyenNhatKhang.bai36.entity.User;
import NguyenNhatKhang.bai36.repository.IUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public void save(@Valid User user) {
        userRepository.save(user);

    }
}
