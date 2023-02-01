package com.baeldung.hibernate.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Did extends BaseEntity<Integer> {

    public Did(String did, String e164, DidGroup didGroup) {
        this.did = did;
        this.e164 = e164;
        this.didGroup = didGroup;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            length = 11,
            name = "dids_id",
            nullable = false
    )
//    @Access(AccessType.PROPERTY)
    private Integer id;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "didgroup_id",
            nullable = false
    )
    private DidGroup didGroup;

    private String did;

    private String e164;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }
}