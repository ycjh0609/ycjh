package com.ycjh.tmp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test", schema = "ycjh")
public class tmpDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tmp")
    private String tmp;


    public tmpDTO() {
    }

    public tmpDTO(String tmp) {
        this.tmp = tmp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }
}
