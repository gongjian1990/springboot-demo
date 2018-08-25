package com.gongj.springbootjpa.repository;

import com.gongj.springbootjpa.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User,Integer> {
}
