package org.bst.avito.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_call")
@Getter
@Setter
public class UserCallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime callTime = LocalDateTime.now();
    @Column
    private String advertName;

    @Column
    private String phoneNumber;

    @ManyToOne
    private EmployeeEntity employee;
}
