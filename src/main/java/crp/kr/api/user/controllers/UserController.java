package crp.kr.api.user.controllers;

import crp.kr.api.auth.domains.Messenger;
import crp.kr.api.user.domains.UserDto;
import crp.kr.api.user.services.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import crp.kr.api.user.domains.User;
import org.apiguardian.api.API;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * packageName: crp.kr.api.controllers
 * fileName : UserController
 * author  : 권혜민
 * date   : 2022-05-03
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-03     권혜민       최초 생성
 */
//각각의 oop에 보안을건다
@CrossOrigin(origins = "*", allowedHeaders = "*")  // 나의 상대방에 있는 출처를 정의함 //origins 아마존에서 값을줌 발급되면 체인지
@Api(tags = "/users") //외부에서 users 라는 단어가 잇는것만 받는다
@RequiredArgsConstructor
@RestController//잇어야 DTO의 자식임을 알려줄수 있음
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final ModelMapper modelMapper;
//@ApiResponse(code =400, message = "Something Worng"),
//@ApiResponse(code =422, message = "유효하지 않는 아이디 / 비밀번호 ")
    @PostMapping("/login")
    @ApiOperation(value = "${UserController.login}")
    @ApiResponses(value = {
            @ApiResponse(code =400, message = "Something Worng"),
            @ApiResponse(code =422, message = "유효하지 않는 아이디 / 비밀번호 ")})
    public ResponseEntity<UserDto> login(@ApiParam("Login User")@RequestBody UserDto user) {


        return ResponseEntity.ok(service.login(modelMapper.map(user, UserDto.class)));//
    }
    @GetMapping("/logout")
    public  ResponseEntity<Messenger> logout() {
        return ResponseEntity.ok(service.logout());
    }

    @PutMapping("/update")
    public ResponseEntity<Messenger> update(@RequestBody User user) {
        return ResponseEntity.ok(service.update(user));

    }
    @PutMapping("/put")
    public ResponseEntity<Messenger> put(@RequestBody User user) {
        return ResponseEntity.ok(service.put(user));
    }

    // Embeded Methods
    @GetMapping("/findAll")
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<User> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<User> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> delete(@RequestBody User user) {
        return ResponseEntity.ok(service.delete(user));
    }


    @PostMapping("/join")
    @ApiOperation(value = "${UserController.join}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "Something Wrong"),
            @ApiResponse(code=403, message = "승인거절"),
            @ApiResponse(code=422, message = "중복된 ID")
    })
    public ResponseEntity<Messenger> save(@ApiParam("Join User") @RequestBody UserDto user) {
        System.out.println("회원가입 정보: "+user.toString());
        return ResponseEntity.ok(service.save(user));
    }


    @GetMapping("/findById/{userid}")
    public Optional<User> findById(@PathVariable String userid) {
        return service.findById(userid);
    }

    @GetMapping("/existsById/{userid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String userid) {
        return ResponseEntity.ok(service.existsById(userid));
    }


}
