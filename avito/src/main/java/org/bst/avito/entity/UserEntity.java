package org.bst.avito.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
public class UserEntity {

    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<UserChatEntity> chats;

    @ManyToOne
    private EmployeeEntity employee;
}
