### Mail Application

- Requirements
```
- Java-8
- Mysql -> Create mail-app schema in Mysql
```

- Build project
```
mvn install
```

- Run Project
```
sh run.sh
```

- User Create Request
```
POST http://localhost8585/api/v1/users
    {
    	"firstName": "Betül",
    	"lastName": "Tatay",
    	"email": "betultty@gmail.com"
    }
```

- Second user
```
POST http://localhost8585/api/v1/users
    {
    	"firstName": "Tugba",
    	"lastName": "Çetinbaş",
    	"email": "tugba@gmail.com"
    }
```


- Get All Users
```
GET http://localhost:8585/api/v1/users
```

- Mail Create Request
```
POST http://localhost:8585/api/v1/mails
    {
        "senderUser": "betultty@gmail.com",
        "replyToUsers": ["tugba@gmail.com"],
        "subject": "Demo Test Mail Subject",
        "body": "Demo Test Mail Body"
    }
```

- Postman Collection

```
https://www.getpostman.com/collections/05d727444f5e5f8531b2
```
