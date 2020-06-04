package com.LINK.Repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.LINK.Entity.Image;
@Component
public interface IImageRepository extends CrudRepository<Image, Long>{
	Collection<Image>findByuserName(@Param("userName")String userName);
}


//public interface IUserRepository extends CrudRepository<User, Long> {
//	Optional<User> findByUser(String email);
//}
//
//public interface IImageRepository extends CrudRepository<Imagen, Long>{
//	@Query(value = "SELECT i FROM image i WHERE i.userName=userName")
//	Collection<Imagen>findImages(@Param("userName")String userName);
//	
//	@Query(value = "SELECT i FROM image i")
//	Collection<Imagen>findImages();
//}