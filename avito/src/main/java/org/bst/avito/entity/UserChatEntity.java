package org.bst.avito.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_chat")
@Getter
@Setter
public class UserChatEntity {

    @Id
    private String id;

    @Column(name = "created_date", nullable = false)
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private String advertName;

}
