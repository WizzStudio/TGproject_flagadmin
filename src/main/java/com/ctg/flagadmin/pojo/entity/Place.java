package com.ctg.flagadmin.pojo.entity;

import javax.persistence.*;

@Entity
@Table(name = "place", schema = "flag")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer kind;

    private String name;

    private Integer count;

    private Integer adminKind;

    private String description;

    private Integer aid;  // 记录是哪个管理员提交的场地

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAdminKind() {
        return adminKind;
    }

    public void setAdminKind(Integer adminKind) {
        this.adminKind = adminKind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}