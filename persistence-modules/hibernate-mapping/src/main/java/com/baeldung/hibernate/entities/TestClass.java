package com.baeldung.hibernate.entities;

import com.baeldung.hibernate.pojo.DidType;
import com.baeldung.hibernate.pojo.InfoTemplateType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TestClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "didGroup")
//    private List<Did> dids;

    @OneToMany(mappedBy="department")
    private List<DeptEmployee> employees;

    public TestClass(String name) {
        this.name = name;
    }


//    @Type(
//            parameters = {@Parameter(
//                    name = "enumClass",
//                    value = "com.bandwidth.numbers.inventory.intl.entities.enums.DidType"
//            )},
//            type = "com.voxbone.persistence.common.hibernate.type.GenericEnumUserType"
//    )
    @Column(
            length = 11,
            name = "did_type"
    )
    private DidType didType;


//    @Type(
//            parameters = {@Parameter(
//                    name = "enumClass",
//                    value = "com.bandwidth.numbers.inventory.intl.entities.enums.InfoTemplateType"
//            )},
//            type = "com.voxbone.persistence.common.hibernate.type.GenericEnumUserType"
//    )
    @Column(
            name = "info_template_id"
    )
    private InfoTemplateType infoTemplate;
//
    /**
     * Local access and transport area (LATA) represents a geographical area of the United States.
     * Is used for U.S. telecommunications regulation.
     */
    @Basic
    @Column(length = 10, name = "lata")
    private Integer lata;

    @Basic
    @Column(length = 11, name = "minimum_stock")
    private Integer minimumStock;
//
//    @Basic
//    @Column(length = 1, name = "is_trunkable", nullable = false)
//    private Boolean trunkable;
//
//    /**
//     * If this Didgroup is hidden in the system
//     */
//    @Basic
//    @Column(insertable = false, length = 1, name = "hidden", nullable = false)
//    private Boolean hidden;
//
//    @Basic
//    @Column(name = "routing_code")
//    private String routingCode;
//
//    @Basic
    @Column(
            length = 6,
            name = "tier_level"
    )
    private String tierLevel;
//
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeptEmployee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<DeptEmployee> employees) {
        this.employees = employees;
    }

}
