package cn.geekchu.hgschool.scoremanagement.entity;

import cn.geekchu.hgschool.scoremanagement.utils.Dictionary;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schinfo_student")
@Data
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private String name;
    @Dictionary(
            id = "cn.geekchu.hgschool.scoremanagement.dictionary.gender"
    )
    private Integer gender;
    private Integer status;
    private Integer classid;
    private String classname;
    private Boolean deleted;
}
