package cn.geekchu.hgschool.scoremanagement.common.realm;

import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.service.PermissionService;
import cn.geekchu.hgschool.scoremanagement.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    // 简单重写获取授权信息方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前用户的所有权限
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> permissions = permissionService.listPermissionURLsByUser(username);

        // 将权限放入授权信息中
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        s.setStringPermissions(permissions);
        return s;
    }

    // 获取认证信息，即根据 token 中的用户名从数据库中获取密码、盐等并返回
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        User user = userService.getByUserName(userName);
        String passwordInDB;
        String salt;
        if(null==user){
            return null;
        } else{
            passwordInDB = user.getPassword();
            salt = user.getMobile();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }
}
