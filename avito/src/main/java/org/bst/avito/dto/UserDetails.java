package org.bst.avito.dto;

public interface UserDetails {
    String getName();

    String getPhoneNumber();

    String getAdvertsName();

    String getChatId();

    Long getId();

    Boolean getIsNew();

    void setIsNew(Boolean isNew);

}
