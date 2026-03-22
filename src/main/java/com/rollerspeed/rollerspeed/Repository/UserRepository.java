package com.rollerspeed.rollerspeed.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rollerspeed.rollerspeed.Model.UserModel;

@Repository
public interface UserRepository  extends JpaRepository<UserModel, Long>{

} 
