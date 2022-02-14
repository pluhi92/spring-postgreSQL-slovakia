package com.pluhi.springpostgreSQLslovakia.model;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {

    @Id
    @Column(name = "id_district")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "veh_reg_num")
    private String vehRegNum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehRegNum() {
        return vehRegNum;
    }

    public void setVehRegNum(String vehRegNum) {
        this.vehRegNum = vehRegNum;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vehRegNum='" + vehRegNum + '\'' +
                '}';
    }
}
