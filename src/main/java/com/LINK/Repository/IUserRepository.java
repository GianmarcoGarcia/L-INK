package com.LINK.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.LINK.Entity.User;
@Component
public interface IUserRepository extends CrudRepository<User, Long> {
	Optional<User> findByuserName(@Param("iduser") String iduser);
}

//public interface IUserRepository extends CrudRepository<User, Long>  {
//	@Query(value = "SELECT user_name FROM user u WHERE u.user_name=userName")
//	Optional<User> findUser( @Param("userName")String userName);
//}


