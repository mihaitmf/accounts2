package tutorials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tutorials.model.vo.UserCreateRequestVO;
import tutorials.model.vo.UserResponseVO;
import tutorials.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserResponseVO createUser(@RequestBody UserCreateRequestVO user) {
        return userService.create(user);
    }

}
