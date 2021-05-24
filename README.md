## JSP Project


### Participants

🙋‍♂️❗️김민규
🙋‍♂️❗️양서린
🙋‍♂️❗️이찬호
🙋‍♂️❗️오영준

### Tools

tomcat server -> 8.5

Jdk -> 11 ver.



#### 📌  Server Page 수정사항 !! 항상 확인하기
``` xml
<!-- MentoringDB : DBCP2-->
<Resource
    name = "jdbc/mentoringdb"
    auth = "Container"
    type = "javax.sql.DataSource"
    maxTotal = "8"
    maxIdle = "30"
    maxWaitMillis = "-1"
    username = "root"
    password = "qwer1234"
    driverClassName = "com.mysql.cj.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1/mentoringDB?serverTimezone=Asia/Seoul&amp;characterEncoding=utf8&amp;useSSL=false"
>

</Resource>
```
