package tutorials.service;

import tutorials.model.vo.UserCreateRequestVO;
import tutorials.model.vo.UserResponseVO;

import java.util.List;

public interface UserService {

    UserResponseVO create(UserCreateRequestVO user);

    List<UserResponseVO> getAll();

    UserResponseVO getUserByEmail(String email);

    UserResponseVO update(UserResponseVO user);

    boolean delete(String email);
}
