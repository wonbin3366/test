package shop.mtcoding.test.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 * 회원가입, 로그인, 회원탈퇴, 회원수정
 */
@Mapper
public interface UserRepository { // CRUD로 만들기
        public int insert(@Param("username") String username, @Param("password") String password,
                        @Param("email") String email);

        public List<User> findAll();

        public User findById(int id);

        public int updateById(@Param("id") int id, @Param("password") String password);

        public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

        public int updateByPasswordEmail(@Param("password") String password,
                        @Param("email") String email, @Param("id") int id);
}
