package be.ucll.ip.tasks.service;

import be.ucll.ip.tasks.dto.CreateUserDTO;
import be.ucll.ip.tasks.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(CreateUserDTO userDTO);
}
