package com.rollerspeed.rollerspeed.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.rollerspeed.Model.UserModel;
import com.rollerspeed.rollerspeed.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel saveUser(UserModel user) throws Exception {
        try{
            validateUser(user);
            return userRepository.save(user);
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public UserModel updateUser(Long id, UserModel userDetails) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
        validateUser(userDetails);
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado con id: " + id);
        }
        userRepository.deleteById(id);
    }

    private void validateUser(UserModel user) {
        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico es obligatorio");
        }
        if(user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }
    }
}
