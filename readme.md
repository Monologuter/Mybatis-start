![XHCvL7-2020-10-09-16-39-04](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/XHCvL7-2020-10-09-16-39-04)





# 一、环境说明

#### ①、jdk mysql maven idea

#### ②、学习前需要掌握

​	JDBC Mysql java基础知识 Maven Junit

# 二、什么是Mybatis

#### 学前导言

```tex
MyBatis 是一款优秀的持久层框架

MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集的过程

MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 实体类 【Plain Old Java Objects,普通的 Java对象】映射成数据库中的记录。

MyBatis 本是apache的一个开源项目ibatis, 2010年这个项目由apache 迁移到了google code，并且改名为MyBatis 。

2013年11月迁移到Github .

Mybatis官方文档 : http://www.mybatis.org/mybatis-3/zh/index.html

GitHub : https://github.com/mybatis/mybatis-3
```



#### 持久化是什么？

```tex
持久化是将程序数据在持久状态和瞬时状态间转换的机制。

即把数据（如内存中的对象）保存到可永久保存的存储设备中（如磁盘）。持久化的主要应用是将内存中的对象存储在数据库中，或者存储在磁盘文件中、XML数据文件中等等。

JDBC就是一种持久化机制。文件IO也是一种持久化机制。

在生活中 : 将鲜肉冷藏，吃的时候再解冻的方法也是。将水果做成罐头的方法也是。

为什么需要持久化服务呢？那是由于内存本身的缺陷引起的

内存断电后数据会丢失，但有一些对象是无论如何都不能丢失的，比如银行账号等，遗憾的是，人们还无法保证内存永不掉电。

内存过于昂贵，与硬盘、光盘等外存相比，内存的价格要高2~3个数量级，而且维持成本也高，至少需要一直供电吧。所以即使对象不需要永久保存，也会因为内存的容量限制不能一直呆在内存中，需要持久化来缓存到外存。


```

#### 持久层是什么

```txt
完成持久化工作的代码块 .  ---->  dao层 【DAO (Data Access Object)  数据访问对象】

大多数情况下特别是企业级应用，数据持久化往往也就意味着将内存中的数据保存到磁盘上加以固化，而持久化的实现过程则大多通过各种关系数据库来完成。

不过这里有一个字需要特别强调，也就是所谓的“层”。对于应用系统而言，数据持久功能大多是必不可少的组成部分。也就是说，我们的系统中，已经天然的具备了“持久层”概念？也许是，但也许实际情况并非如此。之所以要独立出一个“持久层”的概念,而不是“持久模块”，“持久单元”，也就意味着，我们的系统架构中，应该有一个相对独立的逻辑层面，专注于数据持久化逻辑的实现.

与系统其他部分相对而言，这个层面应该具有一个较为清晰和严格的逻辑边界。【说白了就是用来操作数据库存在的！】
```



#### 我们为什么要学习Mybatis

```txt
Mybatis就是帮助程序猿将数据存入数据库中 , 和从数据库中取数据 .

传统的jdbc操作 , 有很多重复代码块 .比如 : 数据取出时的封装 , 数据库的建立连接等等... , 通过框架可以减少重复代码,提高开发效率 .

MyBatis 是一个半自动化的ORM框架 (Object Relationship Mapping) -->对象关系映射

所有的事情，不用Mybatis依旧可以做到，只是用了它，所有实现会更加简单！技术没有高低之分，只有使用这个技术的人有高低之别

MyBatis的优点

简单易学：本身就很小且简单。没有任何第三方依赖，最简单安装只要两个jar文件+配置几个sql映射文件就可以了，易于学习，易于使用，通过文档和源代码，可以比较完全的掌握它的设计思路和实现。

灵活：mybatis不会对应用程序或者数据库的现有设计强加任何影响。sql写在xml里，便于统一管理和优化。通过sql语句可以满足操作数据库的所有需求。

解除sql与程序代码的耦合：通过提供DAO层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易单元测试。sql和代码的分离，提高了可维护性。

提供xml标签，支持编写动态sql。

.......

最重要的一点，使用的人多！公司需要！
```



# 三、Mybatis的第一个程序

####  ①、搭建数据库

```sql
CREATE DATABASE `mybatis`;

USE `mybatis`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
`id` int(20) NOT NULL,
`name` varchar(30) DEFAULT NULL,
`pwd` varchar(30) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `user`(`id`,`name`,`pwd`) values (1,'狂神','123456'),(2,'张三','abcdef'),(3,'李四','987654');
```

#### ②、导入Mybatis相关的jar包

```xml
安利一个找依赖的网址：https://mvnrepository.com/
```

```xml
<dependency>
   <groupId>org.mybatis</groupId>
   <artifactId>mybatis</artifactId>
   <version>3.5.2</version>
</dependency>
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <version>5.1.47</version>
</dependency>
```

#### ③、编写Mybatis的核心配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
       PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
       "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
   <environments default="development">
       <environment id="development">
           <transactionManager type="JDBC"/>
           <dataSource type="POOLED">
               <property name="driver" value="com.mysql.jdbc.Driver"/>
               <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
               <property name="username" value="root"/>
               <property name="password" value="123456"/>
           </dataSource>
       </environment>
   </environments>
   <mappers>
       <mapper resource="com/kuang/dao/userMapper.xml"/>
   </mappers>
</configuration>
```



#### ④、编写Mybatis工具类

```java
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

   private static SqlSessionFactory sqlSessionFactory;

   static {
       try {
           String resource = "mybatis-config.xml";
           InputStream inputStream = Resources.getResourceAsStream(resource);
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (IOException e) {
           e.printStackTrace();
      }
  }

   //获取SqlSession连接
   public static SqlSession getSession(){
       return sqlSessionFactory.openSession();
  }

}
```



#### ⑤、创建实体类

```java
public class User {
   
   private int id;  //id
   private String name;   //姓名
   private String pwd;   //密码
   
   //构造,有参,无参
   //set/get
   //toString()
   
}
```



#### ⑥、编写Mapper接口类

```java
import com.kuang.pojo.User;
import java.util.List;

public interface UserMapper {
   List<User> selectUser();
}
```



#### ⑦、编写Mapper.xml配置文件

namespace很重要 不要写错了 

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
       PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
       "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.kuang.dao.UserMapper">
 <select id="selectUser" resultType="com.kuang.pojo.User">
  select * from user
 </select>
</mapper>
```

⑧、编写测试类

```java
public class MyTest {
   @Test
   public void selectUser() {
       SqlSession session = MybatisUtils.getSession();
       //方法一:
       //List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
       //方法二:
       UserMapper mapper = session.getMapper(UserMapper.class);
       List<User> users = mapper.selectUser();

       for (User user: users){
           System.out.println(user);
      }
       session.close();
  }
}
```

#### ⑨、测试

![SFQgOh-2020-10-09-16-55-59](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/SFQgOh-2020-10-09-16-55-59)

#### ⑩、注意事项

第一、如果出现静态资源过滤的问题 可以考虑在pom.xml文件中加上以下

第二、配置文件中namespace中的名称为对应Mapper接口或者Dao接口的完整包名,必须一致！

```xml
<resources>
   <resource>
       <directory>src/main/java</directory>
       <includes>
           <include>**/*.properties</include>
           <include>**/*.xml</include>
       </includes>
       <filtering>false</filtering>
   </resource>
   <resource>
       <directory>src/main/resources</directory>
       <includes>
           <include>**/*.properties</include>
           <include>**/*.xml</include>
       </includes>
       <filtering>false</filtering>
   </resource>
</resources>
```



# 四、CRUD操作

### A、select

```txt
select标签是mybatis中最常用的标签之一

select语句有很多属性可以详细配置每一条SQL语句

SQL语句返回值类型。【完整的类名或者别名】

传入SQL语句的参数类型 。【万能的Map，可以多尝试使用】

命名空间中唯一的标识符

接口中的方法名与映射文件中的SQL语句ID 一一对应

id

parameterType

resultType
```



__需求：根据id查询用户：__

#### ①、在UserMapper中添加对应的方法

```java
public interface UserMapper {
   //查询全部用户
   List<User> selectUser();
   //根据id查询用户
   User selectUserById(int id);
}
```

#### ②、在UserMapper.xml中添加select语句

```xml
<select id="selectUserById" resultType="com.kuang.pojo.User">
select * from user where id = #{id}
</select>
```

#### ③、在测试类中进行测试

```java
@Test
public void tsetSelectUserById() {
   SqlSession session = MybatisUtils.getSession();  //获取SqlSession连接
   UserMapper mapper = session.getMapper(UserMapper.class);
   User user = mapper.selectUserById(1);
   System.out.println(user);
   session.close();
}
```

![eWaGV4-2020-10-09-17-33-01](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/eWaGV4-2020-10-09-17-33-01)



__需求2：根据密码和名字查询用户：__

思路一：直接在方法中传递参数

​		在接口的方法的采纳数前面加上@Param属性

​		Sql语句编写的时候直接取@Param中设置的值就好了 不需要单独设置参数类型

```xml
//通过密码和名字查询用户
User selectUserByNP(@Param("username") String username,@Param("pwd") String pwd);

/*
   <select id="selectUserByNP" resultType="com.kuang.pojo.User">
     select * from user where name = #{username} and pwd = #{pwd}
   </select>
*/
```

思路二：

在接口方法中 参数直接传递Map

```xml
User selectUserByNP2(Map<String,Object> map);
```

编写sql语句的时候 需要传递参数类型  类型为map

```xml
<select id="selectUserByNP2" parameterType="map" resultType="com.kuang.pojo.User">
select * from user where name = #{username} and pwd = #{pwd}
</select>
```

在使用方法的时候 Map的key为sql中的取值即可 没有顺序要求

```java
Map<String, Object> map = new HashMap<String, Object>();
map.put("username","小明");
map.put("pwd","123456");
User user = mapper.selectUserByNP2(map);
```

__总结：如果参数很多的话 我们可以直接考虑使用Map实现 如果参数比较少的话我们可以直接传递参数就好了__





### B、Insert

__需求：给数据库中添加一个用户：__

#### ①、在UserMapper接口中添加对应的方法

```java
//添加一个用户
int addUser(User user);
```

#### ②、在UserMapper.xml中添加insert语句

```xml
<insert id="addUser" parameterType="com.kuang.pojo.User">
    insert into user (id,name,pwd) values (#{id},#{name},#{pwd})
</insert>
```

#### ③、测试

```java
@Test
public void testUpdateUser() {
   SqlSession session = MybatisUtils.getSession();
   UserMapper mapper = session.getMapper(UserMapper.class);
   User user = mapper.selectUserById(1);
   user.setPwd("asdfgh");
   int i = mapper.updateUser(user);
   System.out.println(i);
   session.commit(); //提交事务,重点!不写的话不会提交到数据库
   session.close();
}
```

![SHOfgC-2020-10-09-17-34-32](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/SHOfgC-2020-10-09-17-34-32)





### C、Delete

__需求：根据id删除用户：__

#### ①、在UserMapper借了中添加对应的方法

```java
//根据id删除用户
int deleteUser(int id);
```



#### ②、在UserMapper.xml中添加sqlyuju

```xml
<delete id="deleteUser" parameterType="int">
  delete from user where id = #{id}
</delete>
```

#### ③、测试

```java
@Test
public void testDeleteUser() {
   SqlSession session = MybatisUtils.getSession();
   UserMapper mapper = session.getMapper(UserMapper.class);
   int i = mapper.deleteUser(5);
   System.out.println(i);
   session.commit(); //提交事务,重点!不写的话不会提交到数据库
   session.close();
}
```

![SHOfgC-2020-10-09-17-34-32](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/SHOfgC-2020-10-09-17-34-32)

### D、update

__**需求：修改用户的信息**__

#### ①、在UserMapper中添加对应的方法

```java
//修改一个用户
int updateUser(User user);
```



#### ②、在UserMapper.xml中添加相应的sql语句

```xml
<update id="updateUser" parameterType="com.kuang.pojo.User">
  update user set name=#{name},pwd=#{pwd} where id = #{id}
</update>
```

#### ③、测试

```java
@Test
public void testUpdateUser() {
   SqlSession session = MybatisUtils.getSession();
   UserMapper mapper = session.getMapper(UserMapper.class);
   User user = mapper.selectUserById(1);
   user.setPwd("asdfgh");
   int i = mapper.updateUser(user);
   System.out.println(i);
   session.commit(); //提交事务,重点!不写的话不会提交到数据库
   session.close();
}
```



![r5xMEK-2020-10-09-17-37-18](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/r5xMEK-2020-10-09-17-37-18)

![IK3OPx-2020-10-09-17-37-48](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/IK3OPx-2020-10-09-17-37-48)



__UserMapper.java:__

![E7Xnvd-2020-10-09-17-21-31](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/E7Xnvd-2020-10-09-17-21-31)



__UserMapper.xml:__

![2Ik7bV-2020-10-09-17-22-09](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/2Ik7bV-2020-10-09-17-22-09)





__Test.java:__

![qoUHw9-2020-10-09-17-23-22](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/qoUHw9-2020-10-09-17-23-22)

![zitvre-2020-10-09-17-23-37](https://cyymacbookpro.oss-cn-shanghai.aliyuncs.com/Macbookpro/zitvre-2020-10-09-17-23-37)

__注意事项：__

- 所有的增删改操作都需要提交事务！
- 接口所有的普通参数，尽量都写上@Param参数，尤其是多个参数时，必须写上！
- 有时候根据业务的需求，可以考虑使用map传递参数！
- 为了规范操作，在SQL的配置文件中，我们尽量将Parameter参数和resultType都写上！





__思考：**模糊查询like语句该怎么写?**__	

​		第1种：在Java代码中添加sql通配符

```xml
string wildcardname = “%smi%”;
list<name> names = mapper.selectlike(wildcardname);

<select id=”selectlike”>
select * from foo where bar like #{value}
</select>

```

​	第2种：在sql语句中拼接通配符，会引起sql注入

```xml
string wildcardname = “smi”;
list<name> names = mapper.selectlike(wildcardname);

<select id=”selectlike”>
    select * from foo where bar like "%"#{value}"%"
</select>
```



# 五、配置解析

### A、核心配置文件

- mybatis-config.xml 系统核心配置文件

- MyBatis 的配置文件包含了会深深影响 MyBatis 行为的设置和属性信息。

- 能配置的内容如下：

  ```xml
  configuration（配置）
  properties（属性）
  settings（设置）
  typeAliases（类型别名）
  typeHandlers（类型处理器）
  objectFactory（对象工厂）
  plugins（插件）
  environments（环境配置）
  environment（环境变量）
  transactionManager（事务管理器）
  dataSource（数据源）
  databaseIdProvider（数据库厂商标识）
  mappers（映射器）
  <!-- 注意元素节点的顺序！顺序不对会报错 -->
  ```

  我们可以阅读 mybatis-config.xml 上面的dtd的头文件！

- environments元素

  ```xml
  <environments default="development">
   <environment id="development">
     <transactionManager type="JDBC">
       <property name="..." value="..."/>
     </transactionManager>
     <dataSource type="POOLED">
       <property name="driver" value="${driver}"/>
       <property name="url" value="${url}"/>
       <property name="username" value="${username}"/>
       <property name="password" value="${password}"/>
     </dataSource>
   </environment>
  </environments>
  ```

  

```te
配置MyBatis的多套运行环境，将SQL映射到多个不同的数据库上，必须指定其中一个为默认运行环境（通过default指定）

子元素节点：environment

dataSource 元素使用标准的 JDBC 数据源接口来配置 JDBC 连接对象的资源。

数据源是必须配置的。

有三种内建的数据源类型

type="[UNPOOLED|POOLED|JNDI]"）
unpooled：这个数据源的实现只是每次被请求时打开和关闭连接。

pooled：这种数据源的实现利用“池”的概念将 JDBC 连接对象组织起来 , 这是一种使得并发 Web 应用快速响应请求的流行处理方式。

jndi：这个数据源的实现是为了能在如 Spring 或应用服务器这类容器中使用，容器可以集中或在外部配置数据源，然后放置一个 JNDI 上下文的引用。

数据源也有很多第三方的实现，比如dbcp，c3p0，druid等等....



详情：点击查看官方文档

这两种事务管理器类型都不需要设置任何属性。

具体的一套环境，通过设置id进行区别，id保证唯一！

子元素节点：transactionManager - [ 事务管理器 ]

<!-- 语法 -->
<transactionManager type="[ JDBC | MANAGED ]"/>
子元素节点：数据源（dataSource）
```

