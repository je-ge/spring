cmd
mvn jetty:run

前台提交json字符串自动转换为后台模型对象
http://localhost:8080/jsonRequest1
User [id=11111, name=11111]
User [id=100, name=je_ge]
[User [id=100, name=je_ge1], User [id=200, name=je_ge2]]

直接输出各种json字符串
http://localhost:8080/jsonResponse1
http://localhost:8080/jsonResponse2
http://localhost:8080/jsonResponse3
http://localhost:8080/jsonResponse4