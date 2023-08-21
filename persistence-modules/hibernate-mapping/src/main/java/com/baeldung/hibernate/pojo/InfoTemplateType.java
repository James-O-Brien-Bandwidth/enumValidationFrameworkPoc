package com.baeldung.hibernate.pojo;

public enum InfoTemplateType {

    GERMANY_PLANINTERNET(1),
    WORLDWIDE_ADDRESS_PROOF_REQUIRED(2),
    LOCAL_ADDRESS_PROOF_REQUIRED(3),
    NATIONAL_ADDRESS_PROOF_NOT_REQUIRED(4),
    LOCAL_ADDRESS_PROOF_NOT_REQUIRED(5),
    NATIONAL_ADDRESS_PROOF_REQUIRED(6),
    WORLDWIDE_ADDRESS_PROOF_NOT_REQUIRED(7),
    WORLDWIDE_ADDRESS_AND_ID_PROOF_REQUIRED(8),
    LOCAL_ADDRESS_PROOF_OF_ID_AND_ADDRESS_REQUIRED(9),
    WORLDWIDE_ADDRESS_AND_ID_PROOF_DIFFERENT_DESTINATION_COUNTRY_REQUIRED(10),
    NATIONAL_ADDRESS_PROOF_NOT_REQUIRED_AND_ID_PROOF_REQUIRED(11),
    WORLDWIDE_ADDRESS_PROOF_NOT_REQUIRED_AND_ID_PROOF_REQUIRED(12),
    NATIONAL_ADDRESS_PROOF_OF_ID_AND_ADDRESS_REQUIRED(13);

    private final Integer id;

    InfoTemplateType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public static InfoTemplateType getValueOf(Integer id) {
        switch (id) {
            case 1:
                return GERMANY_PLANINTERNET;
            case 2:
                return WORLDWIDE_ADDRESS_PROOF_REQUIRED;
            case 3:
                return LOCAL_ADDRESS_PROOF_REQUIRED;
            case 4:
                return NATIONAL_ADDRESS_PROOF_NOT_REQUIRED;
            case 5:
                return LOCAL_ADDRESS_PROOF_NOT_REQUIRED;
            case 6:
                return NATIONAL_ADDRESS_PROOF_REQUIRED;
            case 7:
                return WORLDWIDE_ADDRESS_PROOF_NOT_REQUIRED;
            case 8:
                return WORLDWIDE_ADDRESS_AND_ID_PROOF_REQUIRED;
            case 9:
                return LOCAL_ADDRESS_PROOF_OF_ID_AND_ADDRESS_REQUIRED;
            case 10:
                return WORLDWIDE_ADDRESS_AND_ID_PROOF_DIFFERENT_DESTINATION_COUNTRY_REQUIRED;
            case 11:
                return NATIONAL_ADDRESS_PROOF_NOT_REQUIRED_AND_ID_PROOF_REQUIRED;
            case 12:
                return WORLDWIDE_ADDRESS_PROOF_NOT_REQUIRED_AND_ID_PROOF_REQUIRED;
            case 13:
                return NATIONAL_ADDRESS_PROOF_OF_ID_AND_ADDRESS_REQUIRED;
            default:
                throw new IllegalStateException();
        }
    }
}
