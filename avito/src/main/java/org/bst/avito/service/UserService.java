package org.bst.avito.service;

import org.bst.avito.dto.AvitoCallDTO;
import org.bst.avito.dto.AvitoChatDTO;
import org.bst.avito.dto.AvitoUserDTO;
import org.bst.avito.entity.EmployeeEntity;
import org.bst.avito.entity.UserCallEntity;
import org.bst.avito.entity.UserChatEntity;
import org.bst.avito.entity.UserEntity;
import org.bst.avito.repo.AvitoCallRepository;
import org.bst.avito.repo.AvitoChatRepository;
import org.bst.avito.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final AvitoCallRepository avitoCallRepository;
    private final UserRepository userRepository;

    private final AvitoChatRepository avitoChatRepository;

    public UserService(AvitoCallRepository avitoCallRepository, UserRepository userRepository, AvitoChatRepository avitoChatRepository) {
        this.avitoCallRepository = avitoCallRepository;
        this.userRepository = userRepository;
        this.avitoChatRepository = avitoChatRepository;
    }

    public UserEntity saveUser(AvitoUserDTO avitoUserDTO, EmployeeEntity entity) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(avitoUserDTO.getName());
        userEntity.setId(avitoUserDTO.getId());
        userEntity.setEmployee(entity);

        return userRepository.save(userEntity);
    }

    public UserEntity getUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    public UserCallEntity saveCall(AvitoCallDTO avitoCallDTO, EmployeeEntity entity, String advertName) {
        UserCallEntity userCallEntity = new UserCallEntity();
        userCallEntity.setPhoneNumber(avitoCallDTO.getBuyerPhone());
        userCallEntity.setAdvertName(advertName);
        userCallEntity.setEmployee(entity);

        return userCallEntity;
    }

    public UserChatEntity saveChat(AvitoChatDTO avitoChatDTO, UserEntity userEntity) {
        UserChatEntity userChatEntity = new UserChatEntity();
        userChatEntity.setId(avitoChatDTO.getId());
        userChatEntity.setUser(userEntity);
        userChatEntity.setAdvertName(avitoChatDTO.getContext().getValue().getTitle());

        return avitoChatRepository.save(userChatEntity);
    }

    public Boolean existsCall(String phoneNumber) {
        return avitoCallRepository.exists(phoneNumber);
    }

    public Boolean exists(Long userId) {
        return userRepository.exists(userId);
    }

    public Boolean existsChat(String chatId) {
        return avitoChatRepository.exists(chatId);
    }
}
