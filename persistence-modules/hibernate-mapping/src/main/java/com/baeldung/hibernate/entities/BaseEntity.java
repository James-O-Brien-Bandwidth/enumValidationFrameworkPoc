package com.baeldung.hibernate.entities;

import java.io.Serializable;

public abstract class BaseEntity<PK extends Serializable> implements Serializable {
    public BaseEntity() {
    }

    public abstract PK getId();

    public abstract void setId(PK id);
}
