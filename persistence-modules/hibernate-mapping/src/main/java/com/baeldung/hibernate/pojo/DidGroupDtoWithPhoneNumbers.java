package com.baeldung.hibernate.pojo;

import com.baeldung.hibernate.entities.Did;

import java.util.Arrays;
import java.util.List;

public class DidGroupDtoWithPhoneNumbers {

    //didGroupId
    //e164

    public DidGroupDtoWithPhoneNumbers(Integer didGroupId, String e164) {
        this.didGroupId = didGroupId;
        this.e164 = e164;
    }

    private Integer didGroupId;
    private String e164;
    private String countryCodeA3;
    private Integer stateId;
    private DidType didType;
    private String cityName;
    private String areaCode;
    private String rateCenter;
    private String tierLevel;
    private InfoTemplateType infoTemplateType;
    private DidGroupProviderStatusType providerStatusType;
    private List<PhoneNumberDto> phoneNumbers;

    public List<Did> getDids() {
        return dids;
    }

    public void setDids(List<Did> dids) {
        this.dids = dids;
    }

    private List<Did> dids;

    public Integer getDidGroupId() {
        return didGroupId;
    }

    public void setDidGroupId(Integer didGroupId) {
        this.didGroupId = didGroupId;
    }

    public String getCountryCodeA3() {
        return countryCodeA3;
    }

    public void setCountryCodeA3(String countryCodeA3) {
        this.countryCodeA3 = countryCodeA3;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public DidType getDidType() {
        return didType;
    }

    public void setDidType(DidType didType) {
        this.didType = didType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getRateCenter() {
        return rateCenter;
    }

    public void setRateCenter(String rateCenter) {
        this.rateCenter = rateCenter;
    }

    public String getTierLevel() {
        return tierLevel;
    }

    public void setTierLevel(String tierLevel) {
        this.tierLevel = tierLevel;
    }

    public InfoTemplateType getInfoTemplateType() {
        return infoTemplateType;
    }

    public void setInfoTemplateType(InfoTemplateType infoTemplateType) {
        this.infoTemplateType = infoTemplateType;
    }

    public DidGroupProviderStatusType getProviderStatusType() {
        return providerStatusType;
    }

    public void setProviderStatusType(DidGroupProviderStatusType providerStatusType) {
        this.providerStatusType = providerStatusType;
    }

    public List<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberDto> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumber) {
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setPhoneNumber(phoneNumber);
        phoneNumbers.add(phoneNumberDto);
        this.phoneNumbers = phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumber) {
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        String stringNumber = Arrays.toString(phoneNumber);
        phoneNumberDto.setPhoneNumber(stringNumber);
        phoneNumbers.add(phoneNumberDto);
        this.phoneNumbers = phoneNumbers;
    }


    public String getE164() {
        return e164;
    }

    public void setE164(String e164) {
        this.e164 = e164;
    }

}