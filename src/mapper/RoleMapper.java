package mapper;

import org.apache.ibatis.annotations.Param;
import params.RoleParam;
import po.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    public Role getRole(Long id);

    public int deleteRole(Long id);

    public Role findRole(String roleName);

    public List<Role> findRoleByMap(Map<String, String> params);

    public int insertRole(Role role);

    public Role findRoles(String roleName);

    public Role findRoles1(Role role);

    public Role findRoles2(String rolename);

    public Role findRoles3(String rolename);

    public List<Role> getRoleTest();

    public List<Role> findRoles4(@Param("roleName")String roleName,@Param("note")String note);

    public int updateRole1(Role role);

    public List<Role> findRoleByParams(RoleParam param);

}
