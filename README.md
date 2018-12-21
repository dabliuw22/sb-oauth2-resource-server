# Oauth2 Resource Server

1. Requirements:

Java >= 1.8

2. Clone project:

```
git clone https://github.com/dabliuw22/sb-oauth2-resource-server.git
```

3. Download and run the `jdbc-client-jwt` branch of [auth-server](https://github.com/dabliuw22/sb-oauth2-auth-server).

4. Generate JWT access token:

```
curl -X POST -u clientapp:secret.clientapp\
  'http://localhost:9090/oauth/token?grant_type=password&username=user&password=user.password'
```

5. Running the project.

6. Test endpoints:

```
curl -X GET \
  http://localhost:8080/public/message
  
curl -X GET \
  http://localhost:8080/private/message \
  -H 'Authorization: Bearer {YOUR_ACCESS_TOKEN}'
  
curl -X GET \
  http://localhost:8080/private/user \
  -H 'Authorization: Bearer {YOUR_ACCESS_TOKEN}'
  
curl -X GET \
  http://localhost:8080/private/admin \
  -H 'Authorization: Bearer {YOUR_ACCESS_TOKEN}'
```