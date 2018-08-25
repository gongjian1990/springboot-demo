package com.gongj.springbootrediscache.repository;

import com.gongj.springbootrediscache.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User,Integer> {
}
