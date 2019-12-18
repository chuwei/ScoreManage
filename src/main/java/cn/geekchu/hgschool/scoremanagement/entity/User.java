package cn.geekchu.hgschool.scoremanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Table(name = "base_user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String username;
    private String nickname;
    private String password;
    private String mobile;
    private String email;
    private String weixinOpenid;
    @Transient
    private Boolean rememberme;
    private Boolean status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleted;
}