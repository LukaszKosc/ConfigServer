Sources:

https://www.baeldung.com/spring-cloud-config-without-git

https://www.baeldung.com/spring-cloud-configuration

https://www.baeldung.com/jce-enable-unlimited-strength

https://stackoverflow.com/questions/65063402/why-bootstrap-properties-is-ignored-by-spring-cloud-starter-config

Configuration stored as files in git repository in path:

D:/Project/configrepo/
files:

config-client-development.properties:
````
user.role=Developer
some.other.value=123
user.password={cipher}44405462eff0ece3dd7d43869e11831a13271126ca3c2d1133d49adc10b4084d
password=toor
````

config-client-production.properties:
````
user.role=User
````

Call ConfigServer to get configuration stored in git:


Get config #1:

````
curl -s http://localhost:8888/master/config-client-development.yml
````

Expected output:
````
user:
  role: Developer
  password: hello
some:
  other:
    value: '123'
password: toor
````

Get config #2:

````
curl -s http://localhost:8888/config-client/development/master
````

Expected output:
````
{"name":"config-client","profiles":["development"],"label":"master","version":"b645e54068dbd383fad54ab9eaf61bb7c4fa57f4","state":null,"propertySources":[{"name":"file://D:/Projects/configrepo/config-client-development.properties","source":{"user.role":"Developer","some.other.value":"123","password":"toor","user.password":"hello"}}]}
````

Get config #3:

````
curl -s http://localhost:8888/master/config-client-development.properties
````
Expected output:
````
user.role: Developer
some.other.value: 123
password: toor
user.password: hello
````

Encrypt string:
````
curl -s http://localhost:8888/encrypt -d hello
````

Expected output(e.g.):
````
3863c57e7b591fb0c84b656a774d671ea5c13f0f680899737412e7ae0b02dcb6
````

Decrypt encrypted string:

````
curl -s http://localhost:8888/decrypt -d 3863c57e7b591fb0c84b656a774d671ea5c13f0f680899737412e7ae0b02dcb6
````

Expected output:
````
hello
````
