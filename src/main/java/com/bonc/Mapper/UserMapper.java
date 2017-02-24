package com.bonc.Mapper;

import com.bonc.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by ZK on 2017/2/23.
 * 与用户表有关的数据库操作
 */
@Mapper
public interface UserMapper {

    //在用户表中插入用户记录，isUsed表示账户状态，初始值0表示未激活。
    @Insert("INSERT INTO TAB_USER " +
            "(userId,userName,passWord,realName,realId,phoneNum,mailAddr,proId,areaId,isUsed)" +
            "VALUES (SEQ_USER_ID.NEXTVAL,#{userName},#{passWord},#{realName},#{realId}," +
            "#{phoneNum},#{mailAddr},#{proId,jdbcType=VARCHAR},#{areaId,jdbcType=VARCHAR},0)")
    int insert(User user);

    //更新用户表中的记录
    @Update("UPDATE TAB_USER SET " +
            "userName=#{userName},passWord=#{passWord},realName=#{realName},realId=#{realId}," +
            "phoneNum=#{phoneNum},mailAddr=#{mailAddr},proId=#{proId,jdbcType=VARCHAR}," +
            "areaId=#{areaId,jdbcType=VARCHAR},isUsed=#{isUsed} WHERE userId=#{userId}")
    int update(User user);

    //通过账户id查询用户
    @Select("SELECT * FROM TAB_USER WHERE userId=#{userId}")
    User findByUserId(Long userId);

    //通过用户名查询用户
    @Select("SELECT * FROM TAB_USER WHERE userName=#{userName,jdbcType=VARCHAR}")
    User findByName(String userName);

    //通过用户身份证号查询用户
    @Select("SELECT * FROM TAB_USER WHERE realId=#{realId}")
    User findByRealId(String realId);

    @Select("SELECT * FROM TAB_USER WHERE phoneNum=#{phoneNum}")
    User findByPhoneNum(String phoneNum);

    @Select("SELECT * FROM TAB_USER WHERE mailAddr=#{mailAddr}")
    User findByMail(String mailAddr);

}
