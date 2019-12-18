package cn.geekchu.hgschool.scoremanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "base_role_permission")
@Data
public class RolePermission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer roleid;
    private Integer permissionid;
}
