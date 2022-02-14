package com.pluhi.springpostgreSQLslovakia.model;

import javax.persistence.*;

@Entity
@Table(name = "village")
public class Village {

    @Id
    @Column(name = "id_village")
    private Long id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "zip")
    private String zip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
