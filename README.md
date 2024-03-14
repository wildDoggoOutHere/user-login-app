
# User Login App (DXC)

Unfortunately, I am unable to connect to my postgres database and due to time shortage, am unable to troubleshoot the problem and create a frontend webpage. Therefore, I am going to explain the features of my application here.

The backend is created using springboot, with PostgreSQL as the database. 




## Features

- User registration and login with JWT authentication
- Password encryption using BCrypt
- Role-based authorization with Spring Security
- Logout mechanism (TBC)


## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

- JDK 17+
- Maven 3+

To build and run the project, follow these steps:
- Clone Repository
- Add database "jwt_security" to postgres
- Build the project: mvn clean install
- Run the project: mvn spring-boot:run

The application should be running on: localhost:8080

Since there is no frontend webpage, ideally you can test the APIs by using Postman.

For example, to register a user, you can send a GET request to http://localhost:8080/api/v1/register with the body:

{
    "firstname": "user1",
    "lastname": "user",
    "email": "test@gmail.com",
    "password": 1234
}

Ideally, the response should return a JWT token. Once you have the token, you can send a GET request to http://localhost:8080/api/v1/demo-controller and set Authorization -> Bearer Token to the token you just received. The response should be "Hello from a secured endpoint!"

I understand that this does not make me pass the assessment since there is not concrete application, but I hope I have demostrated the java backend knowledge.


The second assessment - encoder decoder is included both in rar file and inside the folder EncoderDecoder. 
## References

 - I referred a lot to online tutorials, especially from Amigoscode.

