package com.baeldung.hibernate.pojo;

public class Result {

    private long didGroupId;
    private String employeeName;

    private String departmentName;

    public Result(long didGroupId, String employeeName, String departmentName) {
        this.didGroupId = didGroupId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }

    public Result(String employeeName, String departmentName) {
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }

    public Result() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
