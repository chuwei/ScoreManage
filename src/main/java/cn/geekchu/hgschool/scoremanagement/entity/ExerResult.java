package cn.geekchu.hgschool.scoremanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exer_result")
@Data
public class ExerResult implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer id;
    private Integer studentid;
    private String studentname;
    private Integer exerciseid;
    private String exername;
    private double score;
    private Boolean deleted;
}
