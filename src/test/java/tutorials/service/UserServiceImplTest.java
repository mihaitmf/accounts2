package tutorials.service;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import tutorials.model.User;
import tutorials.model.vo.UserCreateRequestVO;
import tutorials.model.vo.UserResponseVO;
import tutorials.repository.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final String EMAIL = "blabla@gmail.com";
    private static final String PASSWORD = "pass12345";
    private static final String NAME = "mihai t";
    private static final String ADDRESS = "street address no 12";
    private static final DateTime CREATE_DATE = DateTimeFormat.forPattern("yy-MM-dd HH:mm:ss").parseDateTime("2015-06-01 19:01:30");

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void shouldCreateAndSaveUserEntityFromRequest() {

        final UserCreateRequestVO requestVO = new UserCreateRequestVO.Builder()
                .withEmail(EMAIL)
                .withPassword(PASSWORD)
                .withName(NAME)
                .withAddress(ADDRESS)
                .build();

        final User userEntity = new User.Builder()
                .withEmail(EMAIL)
                .withPassword(PASSWORD)
                .withName(NAME)
                .withAddress(ADDRESS)
                .build();

        final User savedUserEntity = new User.Builder()
                .withEmail(EMAIL)
                .withPassword(PASSWORD)
                .withName(NAME)
                .withAddress(ADDRESS)
                .withCreateDate(CREATE_DATE)
                .build();

        final UserResponseVO expectedResponseVO = new UserResponseVO.Builder()
                .withEmail(EMAIL)
                .withPassword(PASSWORD)
                .withName(NAME)
                .withAddress(ADDRESS)
                .withCreateDate(CREATE_DATE)
                .build();

        when(userRepository.save(any(User.class))).thenReturn(savedUserEntity);

        final UserResponseVO responseVO = userService.create(requestVO);

        verify(userRepository, times(1)).save(userEntity);
        assertEquals("", expectedResponseVO, responseVO);
    }

}
