package com.gorea.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.gorea.dto_member.Gorea_UserTO;
import com.gorea.dto_member.Gorea_JoinTO;

@Mapper
public interface UserMapper {
	
	// 회원가입
	@Insert("insert into user (username, password, go_user_lastname, go_user_firstname, go_user_nickname, go_user_point, go_user_mail, go_user_nation, go_user_rating) " +
	        "values (#{username}, #{password}, #{go_user_lastname}, #{go_user_firstname}, #{go_user_nickname}, #{go_user_point}, #{go_user_mail}, #{go_user_nation}, #{go_user_rating})")
	@Options(useGeneratedKeys = true, keyProperty = "go_user_seq")
	int join(Gorea_JoinTO gorea_JoinTO);
	
	// 로그인
	@Select("select "+
			"go_user_seq,"+
			  "username,"+
			  "password,"+
			  "go_user_lastname,"+
			  "go_user_firstname,"+
			  "go_user_nickname,"+
			  "go_user_mail,"+
			  "go_user_nation,"+
			  "go_user_joindate,"+
			  "go_user_point,"+
			  "go_user_rating,"+
			  "go_user_role "+
			"FROM user " +
			"WHERE username = #{username}")
	Gorea_UserTO login(String username);
}


//@Insert("INSERT INTO BM_USER (USERNAME, PASSWORD, EMAIL, NICKNAME, PHONE) " +
//"VALUES (#{username}, #{password}, #{email}, #{nickname}, #{phone})")
//@Options(useGeneratedKeys = true, keyProperty = "id")
//int join(Gorea_JoinTO join);

//@Insert("INSERT INTO BM_USER (USERNAME, PASSWORD, EMAIL, NICKNAME, PHONE, ROLE) " +
//"VALUES (#{username}, #{password}, #{email}, #{nickname}, #{phone}, #{admin})")
//@Options(useGeneratedKeys = true, keyProperty = "id")
//int adminjoin(Join join);

//@Select("SELECT " +
//"U.ID, " +
//"U.USERNAME, " +
//"U.PASSWORD, " +
//"U.EMAIL, " +
//"U.NICKNAME, " +
//"U.PHONE, " +
//"U.RATING, " +
//"U.ROLE, " +
//"P.POINT " +
//"FROM " +
//"BM_USER U " +
//"LEFT JOIN " +
//"(SELECT USER_ID, SUM(POINT) POINT FROM BM_POINT GROUP BY USER_ID) P " +
//"ON " +
//"U.ID = P.USER_ID " +
//"WHERE U.USERNAME = #{username}")
//Gorea_UserTO login(String username);