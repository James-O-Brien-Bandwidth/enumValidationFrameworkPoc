package com.baeldung.hibernate.pojo;

public enum DidGroupProviderStatusType {

    AVAILABLE(1),
    UNAVAILABLE(2);

    private final Integer id;

    DidGroupProviderStatusType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public static DidGroupProviderStatusType getValueOf(Integer id) {
        switch (id) {
            case 1:
                return AVAILABLE;
            case 2:
                return UNAVAILABLE;
            default:
                return null;
        }
    }
}
