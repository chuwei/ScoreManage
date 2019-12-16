package cn.geekchu.hgschool.scoremanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "exer_exercise")
@Data
public class Exercise implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Id;
    @Column(nullable = false, unique = true)
    private String name;//名称
    private LocalDate date;//考试日期
    private Integer subject;//考试科目
    private Boolean deleted;
}
