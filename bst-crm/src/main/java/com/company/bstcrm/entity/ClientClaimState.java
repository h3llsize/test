package com.company.bstcrm.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum ClientClaimState implements EnumClass<String> {

    NEW("NEW"),
    IN_PROCESS("IN_PROCESS"),
    CANCELED("CANCELED"),
    PAYED("PAYED"),
    THINKING("THINKING");

    private final String id;

    ClientClaimState(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ClientClaimState fromId(String id) {
        for (ClientClaimState at : ClientClaimState.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}