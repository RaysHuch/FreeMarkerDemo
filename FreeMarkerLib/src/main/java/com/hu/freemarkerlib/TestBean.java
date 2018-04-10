package com.hu.freemarkerlib;

public class TestBean {
    private Integer id;
    private String name;
    private String sex;
    private String clazzName;
    private String packageName;

    public String getClazzName() {
        return clazzName;
    }
    public void setClazzName(String className) {
        this.clazzName = className;
    }
    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String beanUrl) {
        this.packageName = beanUrl;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
