package org.bst.avito.service.handler.deprecated.impl;

import org.bst.avito.dto.AvitoChatDTO;
import org.bst.avito.dto.UserDetails;
import org.bst.avito.mapper.AvitoChatDtoMapper;
import org.bst.avito.service.handler.deprecated.AvitoActionHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Deprecated
@Component
public class AvitoChatActionHandler implements AvitoActionHandler<AvitoChatDTO> {

    private final AvitoChatDtoMapper avitoChatDtoMapper;

    public AvitoChatActionHandler(AvitoChatDtoMapper avitoChatDtoMapper) {
        this.avitoChatDtoMapper = avitoChatDtoMapper;
    }

    @Override
    public List<UserDetails> toUserDetails(List<AvitoChatDTO> actionList) {
        return actionList.stream().map(avitoChatDtoMapper::toUserDetails).toList();
    }
}
