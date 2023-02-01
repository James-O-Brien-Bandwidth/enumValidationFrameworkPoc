package com.baeldung.hibernate.entities;

import com.baeldung.hibernate.pojo.DidType;
import com.baeldung.hibernate.pojo.InfoTemplateType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class DidGroup extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            length = 11,
            name = "didgroup_id",
            nullable = false
    )
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Type(
            parameters = {@Parameter(
                    name = "enumClass",
                    value = "com.bandwidth.numbers.inventory.intl.entities.enums.DidType"
            )},
            type = "com.voxbone.persistence.common.hibernate.type.GenericEnumUserType"
    )
    @Column(
            length = 11,
            name = "did_type"
    )
    private DidType didType;


    @Type(
            parameters = {@Parameter(
                    name = "enumClass",
                    value = "com.bandwidth.numbers.inventory.intl.entities.enums.InfoTemplateType"
            )},
            type = "com.voxbone.persistence.common.hibernate.type.GenericEnumUserType"
    )
    @Column(
            name = "info_template_id"
    )
    private InfoTemplateType infoTemplate;

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

    @Basic
    @Column(length = 1, name = "is_trunkable", nullable = false)
    private Boolean trunkable;

    /**
     * If this Didgroup is hidden in the system
     */
    @Basic
    @Column(insertable = false, length = 1, name = "hidden", nullable = false)
    private Boolean hidden;

    @Basic
    @Column(name = "routing_code")
    private String routingCode;

    @Basic
    @Column(
            length = 6,
            name = "tier_level"
    )
    private String tierLevel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "didGroup")
    private List<Did> dids;

    public DidGroup(String tierLevel) {
        this.tierLevel = tierLevel;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public DidType getDidType() {
        return didType;
    }

    public void setDidType(DidType didType) {
        this.didType = didType;
    }

    public InfoTemplateType getInfoTemplate() {
        return infoTemplate;
    }

    public void setInfoTemplate(InfoTemplateType infoTemplate) {
        this.infoTemplate = infoTemplate;
    }

    public String getTierLevel() {
        return tierLevel;
    }

    public void setTierLevel(String tierLevel) {
        this.tierLevel = tierLevel;
    }

    public List<Did> getDids() {
        return dids;
    }

    public void setDids(List<Did> dids) {
        this.dids = dids;
    }


    public Integer getLata() {
        return lata;
    }

    public void setLata(Integer lata) {
        this.lata = lata;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public Boolean getTrunkable() {
        return trunkable;
    }

    public void setTrunkable(Boolean trunkable) {
        this.trunkable = trunkable;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }
}
