package com.igeek.ch03.mapper;

import com.igeek.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Mapper接口与Mapper映射文件遵循规范，才可以为Mapper接口生成代理对象
 * 1.Mapper接口与Mapper映射文件，同名且在同包下
 * 2.Mapper映射文件中namespace的属性，必须是Mapper接口的全类名
 * 3.Mapper接口中的方法名必须与Mapper映射文件中的statement语句的id一致
 * 4.Mapper接口中的方法的形式参数类型必须与Mapper映射文件中的statement语句的parameterType指定的类型一致
 * 5.Mapper接口中的方法的返回值类型必须与Mapper映射文件中的statement语句的resultType指定的类型一致
 * 6.在mybatis的核心配置文件中，加载Mapper映射文件
 */
public interface UserMapper {

    //通过id查询用户信息
    public User findOne(Integer id);

    //根据用户名进行模糊查询用户信息
    public List<User> findByName(String username);

    //插入用户信息
    public void insert(User user);

    //删除
    @Delete("delete from user where id=#{id}")
    public int delUserByid(Integer id);

    //修改
    @Update("update user set username=#{user.username},sex=#{user.sex},birthday=#{user.birthday},address=#{user.address} where id=#{user.id}")
    public void editUser(@Param("user")User user);

    public User selectList(User user);
}
