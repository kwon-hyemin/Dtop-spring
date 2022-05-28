package crp.kr.api.user.services;


import crp.kr.api.auth.configs.AuthProvider;
import crp.kr.api.auth.domains.Messenger;
import crp.kr.api.auth.exception.SecurityRuntimeException;
import crp.kr.api.user.domains.Role;
import crp.kr.api.user.domains.UserDto;
import crp.kr.api.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import crp.kr.api.user.domains.User;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static crp.kr.api.common.lambdas.Lambda.*;

/**
 * packageName: crp.kr.api.services
 * fileName : Usererviceimpl
 * author  : 권혜민
 * date   : 2022-05-03
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-03     권혜민       최초 생성
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final AuthProvider provider; //이것들의 기능을 가지는 교차 엔티티==UserServiceImpl
    private final ModelMapper modelMapper;


    @Override
    public UserDto login(UserDto paramUser) {
        try {
            UserDto returnUser = new UserDto();
            String username = paramUser.getUsername();
            User findUser = repository.findByUsername(username).orElse(null);
            if (findUser != null) {
                boolean checkPassword = encoder.matches(paramUser.getPassword(), findUser.getPassword());
                if (checkPassword) {
                    returnUser = modelMapper.map(findUser, UserDto.class); //  userDTO 를 보내야함 userDB허용하면 큰일남 //dto 는 외부에서 노출되어있지 않음
                    String token = checkPassword ? provider.createToken(username, returnUser.getRoles()) : "Wrong Password";  //이걸 인지하고 있어야함 고객한테 알려줘야해서 에러가 낫는데 비밀번호가 틀렸어요 해야함
                    returnUser.setToken(token);
                } else {
                    String token = "FAILURE";
                    returnUser.setToken(token);
                }
            }
            return returnUser;
        }catch (Exception e){
            throw new SecurityRuntimeException("유효하지 않은 아이디/비밀번호", HttpStatus.UNPROCESSABLE_ENTITY); // 회사에 따라서 여러가지 인셉션을 걸수잇음
        }//문제가 생기면 처리하는 코드
//        String pw = repository.findByUsername(user.getUsername()).get().getPassword();
//
//
//        String username = user.getUsername(); // 사람이 인지하는 아이디
//        List<Role> roles = findUser.getRoles();
//
//        userDTO.setToken(token);// dto의 임시박스
//        return userDTO;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Messenger count () {

        return Messenger.builder().message(string(repository.count())).build();
    } // 애매한 리턴값은 다 messenger에 담는다

    @Override
    public Messenger update(User user) {
        return Messenger.builder().build();
    }

    @Override
    public Messenger delete(User user) {
        repository.delete(user);
        return Messenger.builder().build();
    }


    @Override
    public Messenger save(UserDto user) {
        System.out.println("서비스로 전달된 회원가입 정보: "+user.toString());
        String result = "";
        if(repository.findByUsername(user.getUsername()).isEmpty()){
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            repository.save(User.builder()
                    .username(user.getUsername())
                    .name(user.getName())
                    .regDate(user.getRegDate())
                    .email(user.getEmail())
                    .password(encoder.encode(user.getPassword()))
                    .roles(list).build());
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        return Messenger.builder().message(result).build();
    }


    @Override
    public Optional<User> findById(String userid) {
        return repository.findById(0L);
    }

    @Override
    public Messenger existsById(String userid) {
        return repository.existsById(longParse(userid))
                ? Messenger.builder().message("EXIST").build()
                : Messenger.builder().message("NOT_EXIST").build(); // userid 타입이 다름
    }


    @Override
    public List<User> findByUserName(String name) {
        return null;
    }

    @Override
    public Messenger put(User user) {
        return null;
    }

    @Override
    public Messenger logout() {
        return null;
    }
}