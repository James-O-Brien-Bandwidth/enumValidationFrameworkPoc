package com.baeldung.hibernate.pojo;

public enum DidType implements CustomEnumType<Integer>{

    GEOGRAPHIC(1, "Geographic"),
    SHARED_COST(2, "Shared Cost"),
    TOLL_FREE(3, "Toll-free"),
    NATIONAL(4, "National"),
    SPECIAL(5, "Special"),
    MOBILE(7, "Mobile"),
    INUM(8, "iNum");

    DidType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private final Integer id;
    private final String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return getName();
    }


    public static DidType getValueOf(Integer id) {
        switch (id) {
            case 1:
                return GEOGRAPHIC;
            case 2:
                return SHARED_COST;
            case 3:
                return TOLL_FREE;
            case 4:
                return NATIONAL;
            case 5:
                return SPECIAL;
            case 6:
            default:
                return null;
            case 7:
                return MOBILE;
            case 8:
                return INUM;
        }
    }
}
