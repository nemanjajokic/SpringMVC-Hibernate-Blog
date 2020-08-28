# SpringMVC-Hibernate-Blog
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This is my learning project used to explore features of Spring and Hibernate as well as their configurations.

Username and password auth with Spring Security, registered user can perform CRUD operations on blog posts, users can also search for particular posts by title.

<img src="https://github.com/nemanjajokic/SpringMVC-Hibernate-Blog/blob/master/preview/img1.png">

## Requirements
* JDK 8
* MySQL(but any other RDBMS should work with minor changes)
* Maven
* Apache Tomcat(probably works on other web servers too, maybe requires minor modifications)

## Development
1. Get the project files(`git clone https://github.com/nemanjajokic/SpringMVC-Hibernate-Blog.git` or download and extract zip archive)
2. Download all dependencies
3. Open the project in STS or in other IDE
4. Configure Hibernate src/main/java/hibernate.cfg.xml according to your settings.
5. Run application

* File to modify **hibernate.cfg.xml** (in `src\main\java`) contain database configuration: database driver, url, name, username/password...
<pre>
&lt;property name="hibernate.connection.driver_class"&gt;<b>com.mysql.jdbc.Driver</b>&lt;/property&gt;
&lt;property name="hibernate.connection.password"&gt;<b>panzer</b>&lt;/property&gt;
&lt;property name="hibernate.connection.url"&gt;<b>jdbc:mysql://localhost:3306/blog</b>&lt;/property&gt;
&lt;property name="hibernate.connection.username"&gt;<b>root</b>&lt;/property&gt;
&lt;property name="hibernate.dialect"&gt;<b>org.hibernate.dialect.MySQLDialect</b>&lt;/property&gt;
&lt;property name="hbm2ddl.auto"&gt;update&lt;/property&gt;
&lt;property name="show_sql"&gt;true&lt;/property&gt;
&lt;property name="format_sql"&gt;true&lt;/property&gt;
</pre>
## Some other images
#### [Create new post](preview/img2.png)
#### [Home page](preview/img3.png)
#### [My Posts page](preview/img4.png)
