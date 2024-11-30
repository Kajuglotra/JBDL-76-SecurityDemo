package org.gfg.security_demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String username);
}
