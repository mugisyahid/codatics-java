package com.codatics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.codatics.entity.UserEntity;
import com.codatics.projectionDTO.UserDTO;

@RepositoryRestResource(excerptProjection = UserDTO.class)
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	UserEntity getById(@Param("id") int id);

	UserEntity getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

	List<UserEntity> getByEmail(@Param("email") String email);

	@Transactional
	int deleteById(@Param("id") int id);

}
