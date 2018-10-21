package com.springboot.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.crud.dto.EmpEntity;
@Repository
public interface CrudRepository extends JpaRepository<EmpEntity, String>{

}
