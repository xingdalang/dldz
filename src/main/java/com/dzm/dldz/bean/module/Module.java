package com.dzm.dldz.bean.module;

public class Module {
    private Long moduleid;

    private String modulename;

    public Long getModuleid() {
        return moduleid;
    }

    public void setModuleid(Long moduleid) {
        this.moduleid = moduleid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }
}