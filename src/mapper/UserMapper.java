package mapper;

import po.User;

import java.util.List;

public interface UserMapper {
    public List<User> findUserBySex(List sexList);

    public User getUser(Long id);

    public int insertUser(User user);
}
