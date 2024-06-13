package com.company.bstcrm.service;

import com.company.bstcrm.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    private final CurrentUserSubstitution currentUserSubstitution;

    private final DataManager dataManager;

    public UserService(CurrentUserSubstitution currentUserSubstitution, DataManager dataManager) {
        this.currentUserSubstitution = currentUserSubstitution;
        this.dataManager = dataManager;
    }

    public User currentUser() {
        return dataManager.load(User.class).query("select u from User u where u.username like :username")
                .parameter("username", currentUserSubstitution.getAuthenticatedUser().getUsername()).one();
    }
}
