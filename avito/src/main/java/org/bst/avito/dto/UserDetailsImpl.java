package org.bst.avito.dto;


import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {
    private String name;

    private String phoneNumber;

    private String advertsName;

    private String chatId;

    private Long id;

    private Boolean isNew;
}
