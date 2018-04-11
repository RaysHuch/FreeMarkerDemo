package com.hu.freemarkerlib.bean

class PluginBean {
    private Integer id = 23;
    private String name = 'Jeck';
    private String sex = 'man';
    private String clazzName = 'defaultClassName';
    private String packageName = 'defaultPackage';
    private String outDirFile = 'defaultDir';

    Integer getId() {
        return id
    }
    void setId(Integer id) {
        this.id = id
    }
    String getName() {
        return name
    }
    void setName(String name) {
        this.name = name
    }
    String getSex() {
        return sex
    }
    void setSex(String sex) {
        this.sex = sex
    }
    String getClazzName() {
        return clazzName
    }
    void setClazzName(String clazzName) {
        this.clazzName = clazzName
    }
    String getPackageName() {
        return packageName
    }
    void setPackageName(String packageName) {
        this.packageName = packageName
    }
    String getOutDirFile() {
        return outDirFile
    }
    void setOutDirFile(String outDirFile) {
        this.outDirFile = outDirFile
    }

    @Override
    public String toString() {
        return "PluginBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", clazzName='" + clazzName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", outDirFile='" + outDirFile + '\'' +
                '}';
    }
}