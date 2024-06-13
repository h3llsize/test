package org.bst.avito.service.handler.deprecated.impl;

import org.bst.avito.dto.AvitoCallDTO;
import org.bst.avito.dto.UserDetails;
import org.bst.avito.service.handler.deprecated.AvitoActionHandler;
import org.springframework.stereotype.Component;

import java.util.List;
@Deprecated
@Component
public class AvitoCallActionHandler implements AvitoActionHandler<AvitoCallDTO> {
    @Override
    public List<UserDetails> toUserDetails(List<AvitoCallDTO> actionList) {
        return null;
    }

}
