package com.dotin.interview.transaction.processing.enums;

public enum UserStatusEnum {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private final String userStatus;

    UserStatusEnum(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserStatus() {
        return userStatus;
    }
}
