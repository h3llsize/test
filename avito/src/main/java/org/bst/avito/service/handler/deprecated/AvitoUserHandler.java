package org.bst.avito.service.handler.deprecated;

import org.bst.avito.dto.UserDetails;
import org.bst.avito.service.UserService;
import org.springframework.stereotype.Component;

@Deprecated
@Component
public class AvitoUserHandler {
    private final UserService userService;

    public AvitoUserHandler(UserService userService) {
        this.userService = userService;
    }

    public void handle(UserDetails userDetails) {
//        if(userDetails.getId() != null) {
//            userService.exists()
//        }
    }
}
