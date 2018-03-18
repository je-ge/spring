cmd
mvn jetty:run

http://localhost:8080/user?id=1&name=xyz&password=je-ge
输出：User [id=1, name=xyz, password=je-ge]

http://localhost:8080/user2?user.id=1&user.name=xyz&user.password=je-ge
输出：User [id=1, name=xyz, password=je-ge]