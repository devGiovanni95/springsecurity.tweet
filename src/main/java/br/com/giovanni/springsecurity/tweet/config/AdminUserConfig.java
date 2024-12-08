package br.com.giovanni.springsecurity.tweet.config;

import br.com.giovanni.springsecurity.tweet.entities.Role;
import br.com.giovanni.springsecurity.tweet.entities.User;
import br.com.giovanni.springsecurity.tweet.repositories.RoleRepository;
import br.com.giovanni.springsecurity.tweet.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {//comandline pra rodar quando for iniciado o projeto

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception{

        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name()); //pegando a role

        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("Adimin já existe");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
                }
        );
    }
}
