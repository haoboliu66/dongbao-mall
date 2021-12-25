# 介绍了项目框架


# maven加速

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->

<!--
 | This is the configuration file for Maven. It can be specified at two levels:
 |
 |  1. User Level. This settings.xml file provides configuration for a single user,
 |                 and is normally provided in ${user.home}/.m2/settings.xml.
 |
 |                 NOTE: This location can be overridden with the CLI option:
 |
 |                 -s /path/to/user/settings.xml
 |
 |  2. Global Level. This settings.xml file provides configuration for all Maven
 |                 users on a machine (assuming they're all using the same Maven
 |                 installation). It's normally provided in
 |                 ${maven.conf}/settings.xml.
 |
 |                 NOTE: This location can be overridden with the CLI option:
 |
 |                 -gs /path/to/global/settings.xml
 |
 | The sections in this sample file are intended to give you a running start at
 | getting the most out of your Maven installation. Where appropriate, the default
 | values (values used when the setting is not specified) are provided.
 |
 |-->
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <!-- localRepository
   | The path to the local repository maven will use to store artifacts.
   |
   | Default: ${user.home}/.m2/repository
  <localRepository>/path/to/local/repo</localRepository>
  -->
  <localRepository>D:\repository</localRepository>

  <!-- interactiveMode
   | This will determine whether maven prompts you when it needs input. If set to false,
   | maven will use a sensible default value, perhaps based on some other setting, for
   | the parameter in question.
   |
   | Default: true
  <interactiveMode>true</interactiveMode>
  -->

  <!-- offline
   | Determines whether maven should attempt to connect to the network when executing a build.
   | This will have an effect on artifact downloads, artifact deployment, and others.
   |
   | Default: false
  <offline>false</offline>
  -->

  <!-- pluginGroups
   | This is a list of additional group identifiers that will be searched when resolving plugins by their prefix, i.e.
   | when invoking a command line like "mvn prefix:goal". Maven will automatically add the group identifiers
   | "org.apache.maven.plugins" and "org.codehaus.mojo" if these are not already contained in the list.
   |-->
  <pluginGroups>
    <!-- pluginGroup
     | Specifies a further group identifier to use for plugin lookup.
    <pluginGroup>com.your.plugins</pluginGroup>
    -->
  </pluginGroups>

  <!-- proxies
   | This is a list of proxies which can be used on this machine to connect to the network.
   | Unless otherwise specified (by system property or command-line switch), the first proxy
   | specification in this list marked as active will be used.
   |-->
  <proxies>
    <!-- proxy
     | Specification for one proxy, to be used in connecting to the network.
     |
    <proxy>
      <id>optional</id>
      <active>true</active>
      <protocol>http</protocol>
      <username>proxyuser</username>
      <password>proxypass</password>
      <host>proxy.host.net</host>
      <port>80</port>
      <nonProxyHosts>local.net|some.host.com</nonProxyHosts>
    </proxy>
    -->
  </proxies>

  <!-- servers
   | This is a list of authentication profiles, keyed by the server-id used within the system.
   | Authentication profiles can be used whenever maven must make a connection to a remote server.
   |-->
  <servers>
    <!-- server
     | Specifies the authentication information to use when connecting to a particular server, identified by
     | a unique name within the system (referred to by the 'id' attribute below).
     |
     | NOTE: You should either specify username/password OR privateKey/passphrase, since these pairings are
     |       used together.
     |
    <server>
      <id>deploymentRepo</id>
      <username>repouser</username>
      <password>repopwd</password>
    </server>
    -->

    <!-- Another sample, using keys to authenticate.
    <server>
      <id>siteServer</id>
      <privateKey>/path/to/private/key</privateKey>
      <passphrase>optional; leave empty if not used.</passphrase>
    </server>
    -->
  </servers>

  <!-- mirrors
   | This is a list of mirrors to be used in downloading artifacts from remote repositories.
   |
   | It works like this: a POM may declare a repository to use in resolving certain artifacts.
   | However, this repository may have problems with heavy traffic at times, so people have mirrored
   | it to several places.
   |
   | That repository definition will have a unique id, so we can create a mirror reference for that
   | repository, to be used as an alternate download site. The mirror site will be the preferred
   | server for that repository.
   |-->
  <mirrors>
    <!-- mirror
     | Specifies a repository mirror site to use instead of a given repository. The repository that
     | this mirror serves has an ID that matches the mirrorOf element of this mirror. IDs are used
     | for inheritance and direct lookup purposes, and must be unique across the set of mirrors.
     |
    <mirror>
      <id>mirrorId</id>
      <mirrorOf>repositoryId</mirrorOf>
      <name>Human Readable Name for this Mirror.</name>
      <url>http://my.repository.com/repo/path</url>
    </mirror>
     -->
	<mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云公共仓库</name>
     <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
     <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云谷歌仓库</name>
     <url>https://maven.aliyun.com/repository/google</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云阿帕奇仓库</name>
     <url>https://maven.aliyun.com/repository/apache-snapshots</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云spring仓库</name>
     <url>https://maven.aliyun.com/repository/spring</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云spring插件仓库</name>
     <url>https://maven.aliyun.com/repository/spring-plugin</url>
    </mirror>
  </mirrors>

  <!-- profiles
   | This is a list of profiles which can be activated in a variety of ways, and which can modify
   | the build process. Profiles provided in the settings.xml are intended to provide local machine-
   | specific paths and repository locations which allow the build to work in the local environment.
   |
   | For example, if you have an integration testing plugin - like cactus - that needs to know where
   | your Tomcat instance is installed, you can provide a variable here such that the variable is
   | dereferenced during the build process to configure the cactus plugin.
   |
   | As noted above, profiles can be activated in a variety of ways. One way - the activeProfiles
   | section of this document (settings.xml) - will be discussed later. Another way essentially
   | relies on the detection of a system property, either matching a particular value for the property,
   | or merely testing its existence. Profiles can also be activated by JDK version prefix, where a
   | value of '1.4' might activate a profile when the build is executed on a JDK version of '1.4.2_07'.
   | Finally, the list of active profiles can be specified directly from the command line.
   |
   | NOTE: For profiles defined in the settings.xml, you are restricted to specifying only artifact
   |       repositories, plugin repositories, and free-form properties to be used as configuration
   |       variables for plugins in the POM.
   |
   |-->
  <profiles>
    <!-- profile
     | Specifies a set of introductions to the build process, to be activated using one or more of the
     | mechanisms described above. For inheritance purposes, and to activate profiles via <activatedProfiles/>
     | or the command line, profiles have to have an ID that is unique.
     |
     | An encouraged best practice for profile identification is to use a consistent naming convention
     | for profiles, such as 'env-dev', 'env-test', 'env-production', 'user-jdcasey', 'user-brett', etc.
     | This will make it more intuitive to understand what the set of introduced profiles is attempting
     | to accomplish, particularly when you only have a list of profile id's for debug.
     |
     | This profile example uses the JDK version to trigger activation, and provides a JDK-specific repo.
    <profile>
      <id>jdk-1.4</id>

      <activation>
        <jdk>1.4</jdk>
      </activation>

      <repositories>
        <repository>
          <id>jdk14</id>
          <name>Repository for JDK 1.4 builds</name>
          <url>http://www.myhost.com/maven/jdk14</url>
          <layout>default</layout>
          <snapshotPolicy>always</snapshotPolicy>
        </repository>
      </repositories>
    </profile>
    -->

    <!--
     | Here is another profile, activated by the system property 'target-env' with a value of 'dev',
     | which provides a specific path to the Tomcat instance. To use this, your plugin configuration
     | might hypothetically look like:
     |
     | ...
     | <plugin>
     |   <groupId>org.myco.myplugins</groupId>
     |   <artifactId>myplugin</artifactId>
     |
     |   <configuration>
     |     <tomcatLocation>${tomcatPath}</tomcatLocation>
     |   </configuration>
     | </plugin>
     | ...
     |
     | NOTE: If you just wanted to inject this configuration whenever someone set 'target-env' to
     |       anything, you could just leave off the <value/> inside the activation-property.
     |
    <profile>
      <id>env-dev</id>

      <activation>
        <property>
          <name>target-env</name>
          <value>dev</value>
        </property>
      </activation>

      <properties>
        <tomcatPath>/path/to/tomcat/instance</tomcatPath>
      </properties>
    </profile>
    -->
  </profiles>

  <!-- activeProfiles
   | List of profiles that are active for all builds.
   |
  <activeProfiles>
    <activeProfile>alwaysActiveProfile</activeProfile>
    <activeProfile>anotherAlwaysActiveProfile</activeProfile>
  </activeProfiles>
  -->
</settings>

```



# git客户端工具

sourcetree

安装



创建accounts.json

```json
[
  {
    "$id": "1",
    "$type": "SourceTree.Api.Host.Identity.Model.IdentityAccount, SourceTree.Api.Host.Identity",
    "Authenticate": true,
    "HostInstance": {
      "$id": "2",
      "$type": "SourceTree.Host.Atlassianaccount.AtlassianAccountInstance, SourceTree.Host.AtlassianAccount",
      "Host": {
        "$id": "3",
        "$type": "SourceTree.Host.Atlassianaccount.AtlassianAccountHost, SourceTree.Host.AtlassianAccount",
        "Id": "atlassian account"
      },
      "BaseUrl": "https://id.atlassian.com/"
    },
    "Credentials": {
      "$id": "4",
      "$type": "SourceTree.Model.BasicAuthCredentials, SourceTree.Api.Account",
      "Username": "",
      "Email": null
    },
    "IsDefault": false
  }
]
```



# 安装数据库 - Docker

1. 安装docker。参考我的docker安装文档。

2. 拉取镜像。

   ```sh
   拉取镜像：
   docker pull mysql:5.7
   ```

3. 在本地创建目录（存放数据库文件）

   容器中的文件，映射到宿主机。

   ```sh
   mkdir -p /root/mysql/data /root/mysql/logs /root/mysql/conf
   ```

4. 创建*.cnf

   ```sh
   在/root/mysql/conf中创建 *.cnf 文件(叫什么都行)
   touch my.cnf
   ```

5. 启动docker

   ```sh
   docker run -p 3306:3306 --name mysql -v /root/mysql/conf:/etc/mysql/conf.d -v /root/mysql/logs:/logs -v /root/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
   ```

   

   数据库就创建好了。后续。

   ```sh
   docker start mysql
   ```

   

   PS:大公司，数据库不用你管。ip，用户名。

   PS：开发要懂：运维，测试，DBA。

# 创建数据库

```sql
CREATE TABLE `ums_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_name` (`username`) USING BTREE COMMENT '用户名唯一'
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='后台用户表';


```



引入依赖

```xml
 <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>


        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.0.5</version>
        </dependency>

        <dependency>
            <groupId>org.apache.velocity</groupId>
            <artifactId>velocity-engine-core</artifactId>
            <version>2.0</version>
        </dependency>


        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

    </dependencies>
```



# lombok

需要IDEA安装插件：lombok

引入jar包：参考代码仓库中的xml

代码仓库：

```xml
https://gitee.com/cpf100/msb-dongbao-mall
```





# mybatis-plus地址

```text
https://baomidou.com/guide/generator.html
```





# 代码生成完成



# 测试用例

测试代码生成器，生成的代码，是否运行正确。



-----------------

框架搭建

单元测试







部署工具, 修改代码后可以自动重启服务, 不用手动重启

热部署Hot Deployment:  IDEA配置

1.引入devTools依赖

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210418120947.png)

2.配置

1)添加额外属性

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210418121006.png)

2)找到registry, 勾选

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210418121117.png)

3.设置IDEA自动编译

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210418121103.png)





# 第四节 



## @Mapper, @MapperScan, @SpringBootApplication

@Mapper

将对象交给Spring容器管理, 标记单一Mapper接口, 可以为@Autowired的对象生成相应的实现类



@MapperScan

集中扫描所有Mapper接口, 相当于给每个Mapper接口标注@Mapper, 生成对应接口的实现类; 添加在SpringBoot启动类上, 可以同时扫描多个包;





@SpringBootApplication(scanBasePackages = {"com.msb"})

等同于 @ComponentScan({"com.msb"})



## 配置mybatis-plus.mapper-locations

```xml
mybatis-plus.mapper-locations=classpath*:/com/msb/dongbao/ums/mapper/*.xml
```

1.如果Mapper接口文件 和 *Mapper.xml文件的路径相同, 如下所示: com/msb/dongbao/ums/mapper/

无需配置 mybatis-plus.mapper-locations

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210414230516.png)



![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210414230602.png)

2.如果二者路径不相同

那么需要在配置文件中(e.g. application.properties)中声明 *Mapper.xml文件的路径

例如:

```xml
mybatis-plus.mapper-locations=classpath*:/mapper/*.xml
```

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210414230857.png)



在resources目录下创建目录时需注意:   **与在java目录下创建package完全不同**

不能用dot作为父子目录的分隔符, 如下, 如果试图使用dot分隔, 创建出来的是一个文件夹, 而非多级的文件夹; 

在配置文件中设置mapper.xml的路径后就会导致运行时, 无法获取xml文件的内容, 导致报错

org.apache.ibatis.binding.BindingException:Invalid bound statement (not found):

所以创建形式必须为: com/msb/dongbao/ums/mapper

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210414231209.png)



mybatis-plus.mapper-locations配置生效后, 对于当前的module可用, 对于其他依赖这个*Mapper.xml的module依然可用



## 用户模块

注册，登录，修改信息

bcrypt

JWT



## 密码加密

密码加密 - MD5  

password - not stored as plain texts -> MD5 (1-way function) -> cannot be decryted

- MD5 - 输入参数一定, 输出情况确定 => rainbow table attack

Rainbow Table: a precomputed dictionary of plaintext passwords and their corresponding hash values to find out what plain text produces a particular hash.



bcrypt - 避免 rainbow table attack

引入依赖:

```xml
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-crypto</artifactId>
    <version>5.3.2.RELEASE</version>
  	<scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-crypto</artifactId>
    <version>5.3.2.RELEASE</version>
    <scope>compile</scope>
</dependency>
```

```java
// 直接注入相应的类
	@Autowired
  PasswordEncoder passwordEncoder;
------------------------------------------------
@Bean
public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}
```

可以自己实现PasswordEncoder接口, 并注入到IOC容器中





# 第5节

## 统一返回值

后端接口一般:

{

​	"code": 状态码

​	"msg": 信息提示

​	"data": T

}

data是object 或者 list





用DTO - Data Transfer Object 进行service之间的数据交互

VO - 后端返给前端展示的

DO - 数据库映射



Lombok - @Data注解, 省去写getter和setter

可以使用Enum来定义返回值的状态信息 StateCodeEnum



Lombok - @Builder注解, 实现Builder模式, 链式调用

返回值ResultWrapper对象





BeanUtils.copyProperties 可以直接将属性赋值

```java
@Override
public ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
   
    UmsMember umsMember = new UmsMember();
    BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);

    String password = umsMemberRegisterParamDTO.getPassword();
    String encodedPassword = passwordEncoder.encode(password);
    umsMember.setPassword(encodedPassword);

    return ResultWrapper.getSucessBuilder().data(null).build();
}
```







## 参数校验

spring-boot-start-verification

可能会跨过前端, 直接调用后端接口, 所以对于一个规则, 即使前端可以进行校验, 后端依然要进行一次逻辑验证



引入参数验证的jar包

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```



@NotEmpty

```java
/**
 * The annotated element must not be {@code null} nor empty.

 * Supported types are:
 * <li>{@code CharSequence} (length of character sequence is evaluated)</li>
 * <li>{@code Collection} (collection size is evaluated)</li>
 * <li>{@code Map} (map size is evaluated)</li>
 * <li>Array (array length is evaluated)</li>
 */
```



在需要进行参数校验的POJO类的属性上使用对应的Annotation

```java
@Data
public class UmsMemberRegisterParamDTO {

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @Size(min = 9, message = "Password length must not be less than 9")
    private String password;

    @Email(message = "Invalid Email")
    private String email;
}
```

需要添加@Valid注解, 才能使POJO类内部属性的校验规则生效

```java
@PostMapping("/register")
public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
    return umsMemberService.register(umsMemberRegisterParamDTO);
}
```



> 当你有拷贝的想法时，就得考虑是不是做错了，是不是有更好的方法。





## 统一异常处理

@ControllerAdvice

@RestControllerAdvice == @ControllerAdvice + @ResponseBody

@@RestControllerAdvice可以设置basePackages, 指定某些包下的controller, 对它们的异常进行处理

  在web项目下新建advice包, 用于存放统一处理异常的类ValidateHandler



可以根据不同的Exception类型, 在一个类中进行统一的异常处理

添加在方法上的注解@ExceptionHandler, 处理对应类型的异常

```java
// 由于HTTP请求先进行参数绑定, 所以进行的是@Valid的验证, 进入ValidateHandler类的校验, 
// 然后再进入到register方法体中, 才能捕获除0异常
@PostMapping("/register")
public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        int i = 1 / 0;
        return umsMemberService.register(umsMemberRegisterParamDTO);
}
----------------------------------------------------------------
  
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    public ResultWrapper handle(){
        System.out.println("Arithmetic Exception");
        return ResultWrapper.builder().code(301).data("hello handler").msg("Arithmetic exception").build();
    }
}
```





# 第6节

用户登录后, 在接下来的请求中, 不需要重复输入用户名和密码



老模式: 

用户登录成功后, 服务器内存保存一个sessionID 对应一个用户, 并把sessionID返回给前端用户

用户以后每次请求都带着跟他匹配的一个sessionID



一旦后端服务因为HA 搭建了集群, 前端用户的请求不一定打到哪个服务器, 所以后端服务集群需要进行sessionID的共享, 需要引入第三方来保存sessionID



老模式的session存储方法占用内存空间



使用session的方法, 请求是有状态的, 会导致一种情况: 如果用户第一次登录在服务器A, 状态被保存在服务器A, 但是下一次请求因为负载均衡原因打到了服务器B, 但是服务器B没有保存该用户的状态



如果使用无状态的请求, 便于scale out(水平扩张), 可以扩大集群规模, 不论用户请求打到哪个服务器, 都一视同仁

 

## JWT

用户登录成功后, 服务器返回给前端用户一个token, 后端什么都不存

token是自解释的, 后端可以识别用户是谁



JWTs make the server stateless



**引入jar包**

maven repo search => jjwt      [JSON Web Token Support For The JVM](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt)

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210411120728.png)

 ```xml
<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.7.0</version>
</dependency>
 ```



### Token的组成和原理

根据一个subject, 可以生成一个token, 此过程是可逆的, 所以如果中间人截取了token, 可以反向解析出subject的内容

 

base64 是一种编码方式, 不是加密算法, 可以把任何数据编成64个字符的编码, 可以反向解码

> MD5是加密算法, 不可逆, 只能通过彩虹表暴力破解

 

散列算法: md5, sha系列算法

对称加密: 双方使用同一个秘钥, 加密解密用同一个秘钥, 秘钥也要在网络上传输 DES, 3DES, AES

非对称加密: 秘钥对. 公加私解, 私加公解



**token**:  header + payload + signature(Message Authentication Code)

header和payload是通过base64编码形成的

在header里指定了一个算法, 用这个算法对payload + secret进行处理, 就生成了signature

- secret是只存储在server本地的, 别人无法访问

即使header或payload被篡改, 在server 验证时, 使用payload和secret生成signature, 会和之前的token内容不一致; 如果第三部分被篡改了, 那么再用payload生成的token值也会不一样





### Token的过期时间

可以为token设置一个过期时间, 在过期时间之前, 客户端如果请求了别的接口, 那么就重新生成一个token并返回给客户端, 问题是: 老的token在过期时间之前依旧可以使用, 可以通过server端的token验证;   

- 此方案牺牲了及时性, 省了存储空间; 

另一种设计是, 把token存入Redis, 如果客户端在过期时间之前请求了别的接口, 直接到Redis重置key的有效期即可

- 此方案保证了及时性, 但是需要额外的存储空间



可以使用AOP去处理token的生成和校验, 拦截器, 过滤器也可行



Controller一般只做**参数校验**、**数据返回**, 尽量不掺杂业务逻辑



切换网络之后, token失效的实现？

- 在HTTP请求中带着IP地址, 切换网络会导致IP地址发生改变, 监测到IP地址变化后, 直接清除token



# 第7节

代码对比工具 Beyond Compare



## 实现拦截器、AOP处理token

HTTP请求  => 自定义拦截器(验证token) => 业务方法 



### 自定义注解

如果在公司内, 基础架构组或中间件组, 需要开发一些通用的jar包, 供其他组调用, 那么最方便的调用方法就是: 只使用一个注解, 把jar包引入, 注解写到方法上即可



token放在请求的header里, 字段是token或authorization

### 自定义Interceptor

通过 **实现HandlerInterceptor接口** 自定义拦截器, 解析自定义的注解, 如果有注解的存在, 就执行检验token的逻辑, token验证通过, 返回true; 

> 拦截器只能对发向controller的请求进行拦截，对其他的一些比如直接访问静态资源的请求则没办法进行拦截处理。

其他异常情况可以使用自定义的GlobalExceptionHandler进行统一异常处理

1.创建拦截器, implements HandlerInterceptor

2.创建InterceptorConfig类 extends WebMvcConfigurer

3.通过addInterceptors方法添加自己定义的拦截器

4.通过addPathPatterns("/**") 和 excludePathPatterns("/ums-member/login")指定拦截的url



#### 解析token的逻辑

```java
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(TOKEN);
        // if token is empty
        if (StringUtils.isBlank(token)) {
            throw new TokenException("Token is Empty");
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(TokenCheck.class)) {
            TokenCheck check = method.getAnnotation(TokenCheck.class);
            if (!check.required()) {
                return true;
            }
            // token check required
            try {
                JWTUtils.parseToken(token);
            } catch (Exception e) {
                throw new TokenException("Token Error");
            }
        }

        // No TokenCheck annotated => no check
        return true;
    }
```



由于token由三部分组成, 所以有2个dot作为delimeter, 因此在parseToken的逻辑中, 会首先判断, 如果delimeter数量不等于2, 直接报错MalformedJwtException

```java
// source code
			if (delimiterCount != 2) {
            String msg = "JWT strings must contain exactly 2 period characters. Found: " + delimiterCount;
            throw new MalformedJwtException(msg);
        }
```

**如果token被篡改**, 解析的结果会不匹配, 直接报错SignatureException, 所以在拦截器中直接使用parse的逻辑即可 (token是自解释的)

```java
// source code
if (!validator.isValid(jwtWithoutSignature, base64UrlEncodedDigest)) {
    String msg = "JWT signature does not match locally computed signature. JWT validity cannot be " +  "asserted and should not be trusted.";
    throw new SignatureException(msg);
}
```

测试代码

```java
public static void main(String[] args) {
    String token = createToken("abcde");
    String sub = parseToken(token + "xx");
    System.out.println(sub);
}
------------------篡改token, 会报错------------------------
```

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210415111120.png)



#### 更新token

如果想要在拦截器中通过设置HttpServletResponse的header来更新token, 那么此方法应该在preHandle中进行, 在postHandle和afterCompletion中进行是无效的





### @Bean

使用@Bean注入IOC容器时, method name即为bean name, 除非设置@Bean的value或name参数; 设置value或name之后, 方法名不再作为有效的bean name

```java
    @Bean(name = "hahaha")
    public ArrayList abcde(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("hellow");
       return list;
    }
```







## 单点登录 SSO

Single-Sign-On 单点登录概念: 在一个服务器上登录之后, 请求打到另一个服务器上时就无需再登录了

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210412170823.png)

当用户在Server1上登录成功并获得返回的token, 再次请求打到Server2上时, 无需再次登录, token是self-explained, 只要保证Server1生成token的secret key可以共享给Server2即可, 可使用Redis进行存储并获取



关于token有效期更新问题

第二种解决方案: 

有一种情况是, 如果用户一直处在登录状态, 正在浏览网页, token过期, 用户被迫下线; 

解决方案: 需要返回给用户两种token

access_token

fresh_token

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210412182058.png)

第三种解决方案: 

只是用access_token, 新老token共存



**单点登录的另一种解释**: 只能允许在一个设备上登录, 如果已经在移动设备A上登录了, 再导移动设备B上登录的话, 就要把移动设备A的登录踢掉







### 鉴权模块

当微服务系统过大时, 不可能在每个服务中都copy一份拦截器, 所以需要额外的鉴权模块



# 第8, 9节

## 验证码

CAPTCHA - Completely Automated Public Turing test to tell Computers and Humans Apart

验证码是为了区分human和计算机 - 防刷



## 图形数字验证码









## 破解图形数字验证码







前端用js调后端接口, 后端将验证码图片返回前端, 可以使用base64编码成String返回给前端

 

### 编解码网站

[急速数据](https://tool.jisuapi.com/)





## 验证码框架

JCaptcha

HappyCaptcha

EasyCaptcha



设置背景

设置字

设置字的形状、颜色





## 多个机器的验证码校验

使用Redis存储验证码, key使用uuid, 将验证码使用base64编码后的值和uuid的值存入map, 返回给前端







美团地图实时显示外卖小哥位置的实现？

- Netty, 实时将外卖小哥的位置推送给用户





java.lang.NoSuchMethodError

一般都是jar包冲突导致

排查办法: Maven - Show dependencies 看是否有红线提示 





# 第10节

KCaptcha

在校验的时候指定验证码的有效期, 生成时间为生成时的当前系统时间, 校验时可以指定多久过期, 也是使用当期系统时间 减去 上一次生成时的系统时间, 判断是否超过我们指定的有效期

 

中间件思维: 将验证码的有效期设置 交给调用方指定, 后方程序可以有较好的扩展性



可以直接复制源码 并自己添加把验证码加入Redis的逻辑







## 图形验证码

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210418190611.png)



可以验证移动的距离

也可以再加上鼠标的抖动情况

  



商用验证码: 腾讯天御、网易网盾、顶象



# 第11节

## 项目结构梳理



密码错误多次惩罚、验证码错误多次惩罚:

- redis incr 账号输入次数的计数器、设置过期时间

 

多设备登录的识别:

- 请求的header里加上client_type, 特殊标识某种设备, PC, Android, iOS



第三方登录:





Maven:

继承  & 依赖传递



A => Parent

A里面的jar包可以被Parent引用



![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210427230602.png)

这种情况下, 最顶层的项目依赖的是1.0 jar



![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210427230750.png)

P此时依赖取决于A和B的依赖声明顺序

 





# 第12节

maven仓库优先级别: 本地仓库 => 配置文件中指定的仓库 => (需要提前配置) 镜像仓库 (eg.阿里云) => 中央仓库 

maven工程类型: pom, jar, war

pom: 逻辑工程, 主要起管理作用, pom工程里不能写代码, 用在父工程或聚合工程中, 在父工程内定义通用jar包



## maven打包

parent: clean package

web: clean package



启动web项目  java -jar

比如jenkins打包: 只package web项目, 不用操作全部parent





每次打包都得运行一遍，非常耗费时间。可以预见的是测试方法越多，耗费时间越多。所以这里有必要屏蔽一下测试类。

在项目的pom.xml的properties标签里加入

```java
<maven.test.skip>true</maven.test.skip>
```





**遇到的问题**

无法编译web项目, mvn package报错, Error显示找不到很多pom中依赖的jar包(找不到的都是自己的项目模块)

但是可以通过编译整个父项目, 然后找到web项目的jar包进行启动

**解决方案**: 在显示找不到jar包的项目中, 进行mvn install操作 => 把该项目编译并打包到本地仓库, 供其他项目调用



额外知识点: 普通jar包 vs 可执行jar包





## 电商的业务流程梳理

调度中心可以作为仓储中心和物流中心的管理者

拆单:

2个北京发货

8个杭州发货

然后到各自的仓储中心, 进行订单出库





购物车在电商刚开始发展的阶段时是放在cookie里, 只保存在浏览器内

现在是放在数据库里, 因为可能放了很久才买



服务小到一定程度是不需要进行数据库表关联操作的



# 第13节

## 安全校验逻辑



防止别人看到



防止别人篡改



### https原理

https = 非对称加密传输秘钥 + 对称加密传输后续数据



# 第14节

Https验证实战



jdk自带命令 - keytool



keystore



```bash
keytool -genkeypair -alias dongbao-alias -keypass 123456 -keyalg RSA -keysize 1024 -validity 365 -keystore ./dongbao-alias.keystore -storepass 123456
```



把自定义的证书装入浏览器, 如果没有指定域名, 浏览器依旧无法认证localhost



生成带域名的证书

```bash
keytool -genkeypair -alias dongbao-alias -keypass 123456 -keyalg RSA -keysize 1024 -validity 365 -keystore ./dongbao-alias.keystore -storepass 123456 -ext san=dns:localhost
```





# 第15节

小白相关面试题:

http - hyper text transfer protocol

什么是超文本:  包括文字，图片，音频，视频等

传输: 客户端和服务端的数据传输

协议: 怎么传, 错误处理



域名解析过程 - DNS

1. 浏览器缓存
2. 操作系统缓存 （hosts文件, 有可能被篡改)
3. LDNS - 本地DNS
4. Root NS
5. TLD ns
6. Auth ns





## 数据安全 - 参数防篡改1



### 如何设计好的接口？



看优秀的设计、借鉴

**标准: 文档给对方，对方无需找你确认。** 站在对方的角度, 看你的输出



### Restful

Resource Representational state transfer

资源: 超文本

表现层: json, xml, 二进制

状态转移: 修改数据



delete /order



#### URL如何设计?

xxxxx/子功能/v1/



#### 动作

get 查询, 单条记录 / 列表记录

post 新建资源 - e.g. 新增订单

put 更新 (全量更新)

patch: 更新 (局部更新)

delete: 删除





### 参数防篡改

接口api 最开始只有公司用

当公司发展到一定规模, 这个api其他公司也会调用



设计开放平台 - openAPI



公司提供网约车服务, 阿里飞猪要合作, 需要在西湖景区范围内接送客, 需要调用我们的接口进行派单

appID + appKey/appSecret

给某家公司某个指定应用分配的ID, 拿着这个ID可以调用我们的api

appID是一个应用的identifier

appKey, 我分配给你了, 你不要在网络中传输

  

appID和appSecret一一对应



问题？

在验证某个请求时, 可以取到请求中携带的appID, 那么生产中如何保存appID和appSecret的映射关系 ???



#### 开放平台接口调用设计

需要提供2个参数:

appId( 给某家公司的某个应用分配的id, 阿里飞猪, xx部门 ),  appKey(appSecret, 不在网络中传输)

**服务提供方 将这两个参数下发给** 调用方   => 默认值就是你当前公司的, 如果不传就是默认值

e.g. 如果我要使用微信的api, 到微信注册后, 微信会下发这两个参数给我, 以后调用微信的api都需要带上这两个参数



实现思路:

用户参数, 用户的签名

sign1 = MD5/SHA256(age=10name=张三appSecret=xxxx)     => 必须要用不可逆的算法

传给后端的参数形式: name=张三&age=10&sign=xxxxxxxx

- sign如何生成: 来自前端使用加密算法对参数进行处理, 前后端必须约定使用同一种加密算法



如果参数传输过程中被篡改了name=李四&age=10&sign1=xxxxxxxx



**后端拿到参数后进行验证** => sign2 = MD5/SHA256(age=10name=李四appSecret=xxxx)

- 按照接收到参数key的字典序进行参数排列  =>  **注意**: 如果是大写字母作为key是会排到小写字母前面的

- 转格式 - 自定义格式
- 组装secret, 在参数的后面 添加secret

sign2和传过来的参数sign1不符, 认为是非法请求



如果用户加密时使用不正确的appSecret进行签名, 后端验证时, 也是无法通过的, 因为后端验证是用的正确的appSecret





! 代码实现接口安全测试 !





# 第16节

内容:

- 请求参数不要写死, 要从get和post中获取

- get和post区别

- 过期时间

- 统一过滤器使用





## 数据安全 - 参数防篡改2

MD5 vs SHA256

都是加密不可逆的散列算法

可加密的参数是任意长度的, 所以用byte数组为输入参数

**SHA256的哈希碰撞几率远远小于MD5, 更安全**



### 防止重复请求

由于我们设置了sign进行请求数据的校验, 别人拿到了请求, 无法达到修改参数的目的

但是: 

假设当前请求url的目的是扣1号用户10块钱, 如果别人拿到了请求, 不修改参数, 直接发起请求, 如何防止这种情况？

从接口的完整性考虑, 还要加上timestamp, 判断timestamp是否在规定的有效期内





加时间戳 - 2min比较常见

如果要严格限制恶意的不间断请求, 需要把请求过的url, 做了md5之后, 放到redis, 做一个有时长限制的黑名单



动态获取HttpServletRequest请求中的参数, 并加入Map后再处理





## Get和Post区别

没有url的长度限制, 长度的限制是由浏览器决定的

其实没有长度限制

其实参数位置一样

GET和POST没有谁更安全的说法, 只要是http, 都不安全



get /uri http/1.1

post /uri http/1.1

其实两者只有方法标识不一样

Get传参方法也可以放在Body里



**Controller一般不使用Map进行参数接收**, 因为Map可以接收任意多个参数，对接口的参数没有约束性





## 过滤器进行参数检验

获取url中的参数 -> QueryString



url是无法显示中文字符的, 会被替代成各种编码, 所以需要对url进行解码





# 第17节

参数防篡改续: 在过滤器中获取请求中的参数

获取body中的参数 -> 是InputStream的形式

把InputStream转成JSON String, 然后再转成Map





## 签名的统一用法

**习惯用法**:

用get就写到url中

用post就写到body中



**实际中**:

也有很多公司, 为了方便, get和post都放在body中

也可以把获取url和body的参数方法做成互斥的, 只从一个里面取参数



本质上HTTP请求的各种方法除了Method, 其他都是一样的, 参数放在哪里都可以



如果**在Filter中读取请求的body, 是以流的形式读取, 读完了之后, 后续请求不会再继续到达controller了**

解决方案: 复制一份流数据





### 如何复制流数据

流数据只能读取一次, 所以如果在要拦截器和过滤器中进行流的处理, 需要克隆一份流

BodyReaderHttpServletRequestWrapper





# 第18节 

订单业务相关



方法论: 先确保满足需求, 简单可用, 再考虑通用性和复用性

我们做的大部分都是针对某个公司业务写出的专用系统

追求完美, 作为一个程序员, 是人格缺陷



不要实现所有的需求



技术债务



维护流程的畅通: 开发, 测试, 运维

提交git之前, 确保一切都可以正常运行 



## 商品中心

揪头发 -> 把自己拔高, 提高一次层次看宏观



淘宝 vs 京东

spu和sku的重视程度不同?

淘宝/天猫 - spu

京东 - sku



商品中心两部分: 买家功能 + 商家功能

买家: 多样化展示; 管理端; 方便管理, 或者流转



### 基本概念

#### SKU vs SPU

SKU: Stock Keeping Unit - 库存保存单元。 库存控制的最小可用单位

e.g. 库存里有10个IPhone, 不够精确, 不能作为sku; 正确的应该是, 库存里有10个IPhone12, 金色, 内存256G, 可以作为一个sku



SPU: Standard Product Unit - 标准化产品单元

e.g. IPhone12 (苹果)



如果使用IPhone12作为SKU, 可能会导致发货错误



简单理解可以是: SPU > SKU



sku能对应几个spu?

一条白色花边xxxxx裤子=sku 可以对应2个spu: 1.七分裤夏季薄款运动休闲 2.男士大码小脚潮



#### 淘宝 vs 京东

淘宝使用SPU, 然后不同specification的商品可以**共用商品详情页**

大规模的电商可能会涉及到多级缓存, 由于商品详情页是一个访问量特别大的页面

这种共用详情页的设计可以**减少CDN的存储**

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210613235733.png)







京东 - SKU



![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210613235800.png)





为什么要这么设计?

- 淘宝的商品量级: 亿级	ioe  IBM, Oracle, EMC

- 京东的商品量级: 百万/千万级  更精细化管理, 用户体验号, 便于物流管理





| 商品       | 订单数量 | sku  | 组合sku             | sku明细            |
| ---------- | -------- | ---- | ------------------- | ------------------ |
| 确定的桌子 | 1        | sku1 |                     | 1*sku1             |
| 确定的凳子 | 1        | sku2 |                     | 1*sku2             |
| 一套饭桌   | 1        | sku3 | 1 * sku1 + 4 * sku2 | 1 * sku1 + 4 * sku |
|            |          |      |                     |                    |

**拆单**

sku3真实的库存是不存在的, 是由其他sku组合起来的



做项目的时候, 做了商品的**合单**和**拆单**

发货距离等等考量因素



### 类目



实际的电商系统中, 后台和前台类目是不同的



10个分类: 



#### 后台类目:

基础数据: 让系统看的

sku必须绑定后台类目, 因为这是底层的管理单元



后台类目差不多固定, 国家有相应的标准

层次不要太深, 一般三层, 最多四层。 对技术和管理都是好的

叶子类目: 商品必须挂载叶子类目下。





#### 前台类目:

让消费者看的



前台需要做成, 便于用户查看和搜索的类目



pc, h5, app端 展示的类目是不一样的。 (数据库设计需要 - **请求的来源**)



前后台类目 确定映射关系:  1:1, 1:n, m:n都可以



头纱/公主风   +   饰品/白色   都对应后台的一个头纱  这是多对1 







# 第19节

类目: 是为了管理商品的, 管理的是sku, 类目就是sku所属的分类



店铺类目: 某一家店铺的自定义类目



后台类目: 服务->女装->连衣裙; 前台类目: 女装->连衣裙

前台: 夏季热卖



## 类目设计

数据结构 + 操作

- 数据存什么, 怎么存 + 基于这些数据有什么操作(操作字段)  e.g 删除需要删除标记,  排序需要排序字段

> 一般的删除操作都不是真的删除数据, 是逻辑删除



属性 是属于某一个类目的 -> 类目的继承



管理类目, 管理商品, 添加商品

属性和类目相关: 发布一个商品: 选择商品所属类目 => 填写手机相关的属性



管理类目(删除, 属性和商品), 管理商品(添加商品, 增删改查)



类目的结构: 

- 树形结构(父子结构)  父类目ID, 一般不要超过3级, 4级

叶子类目 - 商品只存在于叶子类目下  涉及属性: 是否叶子节点



前后台类目对应表关系

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210614215322.png)



## 类目操作

查询: 

1. 前台 -> 用户端, 一般静态化处理, 直接使用静态页面, e.g. 使用CDN缓存
2. 后台: 属性结构。延迟加载 -> 更低层次的类目, 只有在用户请求时, 才去数据库进行请求并加载
   - 后台管理类目的时候, 都用动态



新增

修改



删除:

逻辑删除, 对于类目来说, 有子类目节点或子类目节点下有商品节点, 不能删除



搜索词 对应到 前台类目, 然后再找到对应的后台类目



### 品牌

品牌的字段

品牌和类目的对应关系, 多对多

雀巢: 咖啡, 奶粉, 饮料 



### 属性

服装-> 女装 -> 属性A

通讯-> 手机 -> 属性B



作业:

crud, 代码生成器



# 第20节

powerdesign 进行数据库设计

可以使用powerdesign进行异构数据源表结构迁移



## brand表

logo图片: 存图片的url, 图片传到存储上, 存图片的url

 

## 属性

> 属性和类目的区别

03年, 只有类目; 06年, 淘宝引入属性

属性 也是为了给商品分类的



创建商品时, 赋予的属性

属性和类目的关联 => 属性是挂在类目下面的

某个类目下一定会有固定的某些属性

### 属性的分类

#### 关键属性

用于确认spu -> 就是找到一个产品

手机: 品牌、型号 可以确定一个SPU



再往细了走, 才是找sku

#### 销售属性/ 库存管理属性

用于确认sku

手机: 颜色、内存   基于spu的基础, 再加上销售属性, 就可以确定sku了



影响下单 和 库存管理

#### 导购属性

手机: 新旧程度、保修方式



#### 非关键属性

手机: 摄像头、接口类型



### 属性的用途

搜索、筛选  => 可以知道在哪个字段上加index

e.g. 想知道1号到3号期间有多少个新商品上架 => 日期加index

为什么这么做？ 用途，场景，你怎么做的(技术选型)？ 背后相应的原理

  



属性是一个 key-value pair, 如图  属性名 <=> 属性值

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210623211625.png)

 和类目做关联 (归属于类目)

是否必填

属性类型: 单选、多选、自定义



### 设计属性表  

commodity_property



属性需要进行分组

### 设计属性分组表



假设: 

某个商品有10个属性

一级类目: 数码  => weight

二级类目: 手机通讯 => 网络制式

三级类目: 手机 => CPU

商品: iphone 10个属性, 如何分配给不同类目级别



**类目有属性的继承关系**

商品挂在叶子类目下, 叶子类目的独有属性可能不多, 但是叶子类目会把上级的所有属性都继承下来





### 属性库 

对属性的管理

原来不卖手机, 现在加入了手机, 类目新加了, 类目下应该有的属性也要新增



大型电商的项目 商品表 里是不会存 具体的商品属性信息的



商品表单可以设计成: 

名称: xxxxx

价格: xxxxx

屏幕尺寸: xxxxx

内存: xxxxx

但是如上的table只能给手机用, 如果商品是衣服呢, 就要再加上size字段

最后显露出的问题就是: 这样设计商品表格**无法兼容所有商品需要的属性**



属性库 - 后台管理系统可维护



重点: 灵活设计使**商品属性高扩展**





# 第21节 - 商品中心设计1



属性分组 和 类目 强关联

某个类目下, 才有一些特定的属性, 所以属性分组表中才会有类目ID



SPU + 特定的属性 ==> SKU



## 商品设计

如果你觉得, 某个功能, 以后可以做成独立的服务, 那么将数据提前剥离

e.g. 商品详情 

e.g. 商品图片 -> 单独放一张表, 可以未来在CDN做缓存

因为一个商品的详情中会有很多图片, 所以把图片单独放一个表, 并标记序号, 表明哪个图片放在前



某类数据 特性很多, 可以进行分组时, 可以独立一张表



1. 商品基础信息表. 共有的属性(商品名称，长、宽、高、包装清单)
2. 商品详情表
3. 商品详情图片表
4. 商品图片
5. 商品sku信息
6. 商品sku的属性信息



小项目时, 可以只用一张表, 但是随着规模扩大, 用户数量增多, 查询会遇到瓶颈, 就要想着拆分, 大系统拆分成多个小系统

如果接口请求响应很慢

先加机器 -> 如果加机器也不行, 就拆分数据库表



sku: 1.全球统一;  2.商家自定义



运费模板: 每个商品只能对应一种运费模板





**表结构设计小技巧**: 

一个基础信息表 -> 若干个扩展表

- 类似抽象的父类和多个子类的关系

表的名字也很重要, 前缀尽量相同, 增加可读性 e.g.  products,  products_description





### 图片存储方面的DB设计

设计方案一: 图片独立存储服务 OSS

- 云存储 => 分配一个图片访问的url, 数据库中存储访问图片的url

优点: 便于管理, 不增加存储压力和访问压力;  避免法律风险: 涉及政治敏感, 违法校验, 交给第三方可以不用自己实现

缺点: url的权限不好控制, 需要额外开发对url的权限控制



设计方案二: 数据库里直接存图片

缺点: 存储空间占用大, 对查询性能有影响

关系型数据库, 数据查询不会基于图片搜索









## 商品和属性怎么关联

### 数据库表设计思路 



属性的两大类: 

1. property和category挂载

商品id => 类目属性关系表的id

- 一个product, 对应一个类目属性关系表的id, 通过这个id, 找到对应的property_id, 然后就可以填对应的value
  - products表 => category_property_relationship表 => property_id (commodity_property表)



2. property和property_group归类, 属性分组和类目挂载

- 一个product, 对应一个属性分组关系表的id, 通过这个id, 找到对应的property_id, 就可以填对应的value
  - products表=> property_group_relationship表 => property_id (commodity_property表)

![](https://raw.githubusercontent.com/haoboliu66/PicBed/master/img/20210724211746.png)



# 第22节

假设自己是一个后台录入人员

在售商品, 待售商品



新建商品

- 商品名称 (用户手填)

- 品牌    (系统内置选项, 要售卖的brand会提前录入系统， 用爬虫爬品牌数据,  形成自己的品牌库)
- sku_code  (国家标准 或者 自定义, 自定义的不能重复)



商品 和 类目的 对应关系

一个商品属于一个类目, 一个类目下有多个商品



新建商品 -> 详情 -> 详情图片



商品表也加个库存字段?

- 库存是受采购和客户共同影响的, 如果一方修改了数据, 表会加锁, 另一方不能操作





# 第23节 - 商品中心设计2

## 促销系统 - Promotion

目的: 

1. 拉新 - 拉拢新customer;  简历中体现你的个人职责中的价值
2. 去库存; 库存也是成本, 减少公司库存成本
3. 扩大系统品牌的知名度;
4. 新app上限
5. 常态，竞争
6. 提高销量，客单量，客单价。 (你用xxx技术，实现了xxx业务，给公司带来了xxx销量，提高了xxx订单量，提高了xxx客单价)



长时间周期中, 想测试哪个活动策略最优  => A/B测试(灰度发布，金丝雀发布)

>  A/B测试: 把用户分成2类, 一个显示该信息, 一类不显示该信息, 然后看发布的运行效果



e.g. 10亿用户, 1.5亿 (在北京  35%做测试), 8.5亿(在杭州)



## 促销类型

满减促销:

1. 阶梯满减: 满100减10, 满300减50
2. 每满减: 每满100减10

单品促销: 某个商品打N折

套装促销: A商品10, B商品10, C商品10, A+B+C = 25

赠品促销: 买主商品, 送N个赠品

满赠促销: 

1. 满100送东西A
2. 满100, 加10块, 送东西B
3. 满100送自拍杆, 满200送充电宝, 满500送手机

多买优惠促销: 

1. M元买N件
2. M件打N折

定金促销:

1. 提前交100块订金, 享受1000元购买2000元东西
2. 提前交10块, 顶100元





促销活动:

活动名称: 618大促活动，活动规则: 单品促销。 时间段 (开始时间, 结束时间)



## 表结构设计

**当数据量的增加, 影响到表结构的时候, 说明设计错了**

e.g. 学生表: 当有1名学生, 表结构不动, 有100个学生, 也还是相同的表结构



1台服务器: 靠单台的硬件升级是有天花板的, 成本也会急剧增加

拆机器 + 拆服务



每个活动必须id唯一

细化: 1个活动对应1个规则

每个规则对应一个表



### 促销规则如何设置

活动规则用json表示

e.g.

规则1: { "满": 100, "减": 10  }

规则2: {"discount": 0.5}

规则3:{"money": 100, "good_num": 10}   10件100

使用json存规则的缺点:

不好查询



**列式数据库 或者用sql的行转列**



## 分析角色

活动、规则、商品  => 活动和商品关联表(关联id, 类目, 属性, 价格)

分析, 抽象出在一个业务逻辑中的涉及的角色, 谁调用我, 我调用谁







# 第24节 - 商品中心设计3

活动表的操作

新建: insert，审核(活动状态 => 已发布，未发布)

编辑:

- 已发布的活动 - 满足条件: 审核人员想进行修改点的对比
- 未发布的活动

修改活动, 存两条记录。修改多次，对应多条记录 => 活动修改记录表

删除: 逻辑删除  标记flag (保存6个月)   除非用户注销, 才可以真的删除他的记录

复制活动: 



活动关联的商品信息 - sku-id





## 订单计算

购物车、下订单

最优原则



## 优惠券

时间周期 => 特定时间段内、或者指定商品、满足特定金额

作用: 当钱使用



商品: 有的商品富裕的人卖1W, 穷一些的卖9K



### 优惠券类型

门槛: 现金券、满减券、折扣券

范围: 单品券、品类券、品牌券

发放的主体: 平台优惠券(注册送、积分兑换、消费累积)、 店铺优惠券



### 优惠券信息

名称、面值、使用条件、使用平台、有效期(固定有效期、相对有效期 - 领券之日起x天内有效  )、发行量



## 优惠券表

使用角色: 平台、使用者

已领(个人)优惠券表




# 第25节 - 商品中心设计4









