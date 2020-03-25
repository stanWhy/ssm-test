#mybatis练习二
##setp1 编写database.properties
```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
user=root
password=wanghongyu
```

##setp2 编写mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<!--配置核心配置文件-->
<configuration>
<!--    引入外部配置-->
    <properties resource="database.properties"/>
    
<!--    给实体类设置别名-->
    <typeAliases>
        <package name="com.why.start.mybatis.pojo"/>
    </typeAliases>
    
    <environments default="dev">
        <environment id="dev">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver"     value="${driver}"/>
                <property name="url"        value="${url}"/>
                <property name="username"   value="${user}"/>
                <property name="password"   value="${password}"/>
            </dataSource>
        </environment>
    </environments>
    
    <mappers>
        <mapper resource="com/why/start/mybatis/mapper/UserMapper.xml"/>
    </mappers>
</configuration>
```
##step3:编写User
```java
package com.why.start.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String pwd;
}

```
##step4:编写UserMapper
```java
package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insertUser(User user);

    int deleteUserById(@Param("id") int id);

    int updateUser(User user);

    List<User> selectAll();

    User selectUserById(@Param("id") int id);

}

```
##step5:编写UserMapper.xml
```xml
<?xml version="1.0" encoding="UTF8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--namespace 绑定一个对应的mapper接口-->
<mapper namespace="com.why.start.mybatis.mapper.UserMapper">

    <sql id="key">
        id,`name`,pwd
    </sql>

    <insert id="insertUser" parameterType="User">
        insert into user(<include refid="key"/>)
        values(#{id},#{name},#{pwd})
    </insert>

    <delete id="deleteUserById">
        delete from user where id = #{id}
    </delete>

    <update id="updateUser" parameterType="User">
        update user set `name` = #{name},pwd = #{pwd}
        where id = #{id}
    </update>

    <select id="selectAll" resultType="User">
        select <include refid="key"/>
        from user;
    </select>

    <select id="selectUserById" resultType="User">
        select <include refid="key"/>
        from user
        where id = #{id}
    </select>
</mapper>
```
注意：由于mybatis-config.xml中已经设置给实体类设置别名，则resultType和parameterType直接指向对应的实体即可


##step6:编写Mybatis工具类
```java
package com.why.start.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory --> sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了SqlSessionFactory，顾名思义，我们就可以从中获得SQLSession的实例了。
    //SQLSession完全包含了面向数据库执行SQL命令所需的所有方法
    public static SqlSession getSqlSession(){
        return sessionFactory.openSession();
    }
}

```
##step7：编写测试类
```java
package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import com.why.start.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void insertUser() {
        User user = new User(11,"USER-A","7896321");
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.insertUser(user);
            if (i == 1) {
                System.out.println("插入成功");
            }
            sqlSession.commit();
        }
    }

    @Test
    public void deleteUserById() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.deleteUserById(10);
            if (i == 1) {
                System.out.println("删除成功");
            }
            sqlSession.commit();
        }
        selectAll();
    }

    @Test
    public void updateUser() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.updateUser(new User(10, "USER-UPDATE-A", "14785236"));
            if (i == 1) {
                System.out.println("修改成功");
            }
            sqlSession.commit();
            selectAll();
        }
    }

    @Test
    public void selectAll() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final List<User> users = mapper.selectAll();
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void selectUserById() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final User user = mapper.selectUserById(1);
            System.out.println(user);
        }
    }
}

```
注意：
    1.SqlSession用完要关闭
    2.增删改要提交事务