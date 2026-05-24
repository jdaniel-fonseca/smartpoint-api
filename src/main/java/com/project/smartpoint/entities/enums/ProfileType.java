package com.project.smartpoint.entities.enums;

public enum ProfileType {

    ADMIN(1),
    WORKER_MANAGER(2),
    WORKER_EMPLOYEE(3);

    private int code;

    private ProfileType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProfileType valueOf(int code) {
        for (ProfileType p : ProfileType.values()) {
            if (code == p.getCode()) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid profile type.");
    }
}
