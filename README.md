# jwt-token-based-auth
Handles user registration, login, and secure profile access using JWT tokens in a Spring Boot application. Ensures password encryption and token-based authentication for protected endpoints.

Curls 

1. New register
curl -X POST http://localhost:8080/register -H "Content-Type: application/json" -d '{"username":"john","password":"pass123","email":"john@example.com"}'

2. New register with same username
curl -X POST http://localhost:8080/register -H "Content-Type: application/json" -d '{"username":"john","password":"newpass","email":"john2@example.com"}'

3. New register with same email
curl -X POST http://localhost:8080/register -H "Content-Type: application/json" -d '{"username":"john2","password":"pass123","email":"john@example.com"}'

4. Login with correct username but wrong password
curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"username":"john","password":"wrongpass"}'

5. Login with incorrect username but correct password
curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"username":"wronguser","password":"pass123"}'

6. Profile call with invalid token
curl -X GET http://localhost:8080/profile -H "Authorization: Bearer invalidtoken"

7. Login with both correct (will give token)
curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"username":"john","password":"pass123"}'

8. Profile call with correct token
curl -X GET http://localhost:8080/profile -H "Authorization: Bearer <token>"

9. Profile call with correct token but after 20 seconds (token expires after 20 secs)
sleep 20 && curl -X GET http://localhost:8080/profile -H "Authorization: Bearer <token>"

