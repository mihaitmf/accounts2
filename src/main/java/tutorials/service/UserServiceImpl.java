package tutorials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorials.model.User;
import tutorials.model.vo.UserCreateRequestVO;
import tutorials.model.vo.UserResponseVO;
import tutorials.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserResponseVO create(UserCreateRequestVO requestVO) {

        User user = createUserEntityFromUserCreateRequest(requestVO);

        User savedUser = userRepository.save(user);

        if (savedUser == null) {
            throw new RuntimeException("Could not save user in repository");
        }

        return createUserVOFromEntity(savedUser);
    }

    @Override
    public List<UserResponseVO> getAll() {
        return null;
    }

    @Override
    public UserResponseVO getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserResponseVO update(UserResponseVO user) {
        return null;
    }

    @Override
    public boolean delete(String email) {
        return false;
    }

    private User createUserEntityFromUserCreateRequest(UserCreateRequestVO requestVO) {
        return new User.Builder()
                .withEmail(requestVO.getEmail())
                .withPassword(requestVO.getPassword())
                .withName(requestVO.getName())
                .withAddress(requestVO.getAddress())
                .build();
    }

    private UserResponseVO createUserVOFromEntity(User user) {
        return new UserResponseVO.Builder()
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
                .withName(user.getName())
                .withAddress(user.getAddress())
                .withCreateDate(user.getCreateDate())
                .build();
    }

}
