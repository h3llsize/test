package org.bst.avito.mapper;

import org.bst.avito.dto.AvitoChatDTO;
import org.bst.avito.dto.AvitoUserDTO;
import org.bst.avito.dto.UserDetails;
import org.bst.avito.dto.UserDetailsImpl;
import org.springframework.stereotype.Component;

@Component
public class AvitoChatDtoMapper {
    public UserDetails toUserDetails(AvitoChatDTO avitoChatDTO) {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setChatId(avitoChatDTO.getId());

        AvitoUserDTO avitoUserDTO = avitoChatDTO.getUsers().get(0);

        userDetails.setId(avitoUserDTO.getId());
        userDetails.setName(avitoUserDTO.getName());
        userDetails.setIsNew(false);
        userDetails.setPhoneNumber(null);
        userDetails.setAdvertsName(avitoChatDTO.getContext().getValue().getTitle());

        return userDetails;
    }
}
