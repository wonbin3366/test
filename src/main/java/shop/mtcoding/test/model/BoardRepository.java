package shop.mtcoding.test.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {
    public int insert(@Param("id") int id, @Param("title") String title, @Param("userId") int userId);

    public List<Board> findAll();

    public List<Board> findById(int id);

    public int updateByUsernamePasswordEmail(@Param("id") int id, @Param("username") String username,
            @Param("password") String password, @Param("email") String email);

    public int updateById(@Param("id") int id, @Param("title") String title, @Param("userId") int userId);

    public int deleteById(int id);

}
