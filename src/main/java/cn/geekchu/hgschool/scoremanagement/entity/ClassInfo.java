package cn.geekchu.hgschool.scoremanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schinfo_class")
@Data
public class ClassInfo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String school;
    private String grade;
    private String classname;
    private Integer subject;
    private Boolean deleted;
}
