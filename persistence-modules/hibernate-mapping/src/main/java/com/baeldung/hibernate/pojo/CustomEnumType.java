package com.baeldung.hibernate.pojo;

import java.io.Serializable;

public interface CustomEnumType  <PK extends Serializable> {
    PK getId();
    String getName();
    String getDescription();
}
