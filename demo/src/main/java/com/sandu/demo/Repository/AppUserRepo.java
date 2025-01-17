package com.sandu.demo.Repository;

import com.sandu.demo.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsernameAndPassword(String username, String password);
    AppUser findByUsername(String username);
}