# Erudio API OAUTH2

[![Build Status](https://travis-ci.org/leandrocgsi/erudio-api-oauth2.svg?branch=master)](https://travis-ci.org/leandrocgsi/erudio-api-oauth2)
[![GitHub Release](https://img.shields.io/badge/release-1.0-blue.svg?maxAge=3600)](https://github.com/leandrocgsi/erudio-api-oauth2/releases/latest)
[![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?maxAge=2592000)](https://github.com/leandrocgsi/erudio-api-oauth2/blob/master/LICENSE.txt)

This is a simple REST service that provides some RESTful endpoints protected by OAuth 2. Adictionally we document all endpoints with Swagger and implements HATEOAS concepts. The REST service is based on the [Spring REST Service OAuth - by Roy Clarkson](https://github.com/royclarkson/spring-rest-service-oauth) and in another projects mine like [Erudio API With Groovy](https://github.com/leandrocgsi/erudio-api-with-groovy), [Semeru JSF Groovy Maven](https://github.com/leandrocgsi/semeru_jsf_groovy_maven) and [Erudio Client WS Exporter](https://github.com/leandrocgsi/erudio-client-ws-exporter). This project incorporates the new Java-based configuration support, now available in Spring Security OAuth 2.0. Please log any issues or feature requests to the [Spring Security OAuth project](https://github.com/spring-projects/spring-security-oauth/issues).

# Open Source Projects Used

The following Open Source projects are used in this sample app:

* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)
* [Spring Security](http://projects.spring.io/spring-security/)
* [Spring Security OAuth](http://projects.spring.io/spring-security-oauth/)
* [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* [Swagger](http://swagger.io/) see more [here](http://jakubstas.com/spring-jersey-swagger-create-documentation/) and [here](http://jakubstas.com/spring-jersey-swagger-exposing-documentation/)
* [Groovy](http://www.groovy-lang.org/)
* [Jasper Reports](http://community.jaspersoft.com/)
* [Open CSV](http://opencsv.sourceforge.net/)
* [Apache POI](https://poi.apache.org/)
* [Orika Mapper](http://orika-mapper.github.io/orika-docs/converters.html)
* [Hibernate](http://hibernate.org/)
* [X-Stream](http://x-stream.github.io/)
* [Travis CI](https://travis-ci.org/)
* [Flyway](https://flywaydb.org/)

# Architectural Style

* [RESTful](http://docs.oracle.com/javaee/6/tutorial/doc/gijqy.html)
* [HATEOAS](http://timelessrepo.com/haters-gonna-hateoas)
* [Microservices Concepts](http://martinfowler.com/articles/microservices.html)
* [SOA Concepts](http://www.ibm.com/developerworks/webservices/tutorials/ws-soa-ibmcertified/ws-soa-ibmcertified.html)

# Em português

*Sobre REST*

* [Web Services](http://www.semeru.com.br/blog/web-services/)
* [RESTful Web Services](http://www.semeru.com.br/blog/restful-web-services/)
* [HTTP Status Codes](http://www.semeru.com.br/blog/http-status-codes-em-servicos-rest/)
* [Do zero ao REST em 5 minutos com SpringBoot](http://www.semeru.com.br/blog/do-zero-ao-rest-em-5-minutos-com-springboot/)
* [Criando o primeiro endpoint REST com SpringBoot](http://www.semeru.com.br/blog/criando-o-primeiro-endpoint-rest-com-springboot/)
* [Documentando aplicações REST com SpringBoot e Swagger](http://www.semeru.com.br/blog/documentando-aplicacoes-restfull-com-springboot-e-swagger/)
* [Entendendo HATEOAS](http://www.semeru.com.br/blog/entendendo_hateoas/)
* [Aplicações RESTful HATEOAS com SpringBoot](http://www.semeru.com.br/blog/aplicacoes-restfull-hateoas-com-springboot/)

*Sobre Groovy e Java na mesma aplicação*

* [Usando código Groovy (o Java com esteróides) juntamente com código Java](http://www.semeru.com.br/blog/usando-codigo-groovy-o-java-com-esteroides-juntamente-com-codigo-java/)
* [Usando código Groovy (o Java com esteróides) juntamente com código Java em um projeto com Spring Boot](http://www.semeru.com.br/blog/usando-codigo-groovy-o-java-com-esteroides-juntamente-com-codigo-java-em-um-projeto-com-spring-boot/)

*Sobre Groovy*

* [Curso Básico de Grails](https://www.youtube.com/playlist?list=PL18bbNo7xuh_dvHiIjegSsbwRq9JPmZL2)

*Se especialize*

[<img src="https://github.com/leandrocgsi/SpringBootPlayground/blob/master/Images/banner_blog_udemy_course_sring_boot.jpg?raw=true">](https://www.udemy.com/restful-apis-do-0-a-nuvem-com-springboot-e-docker/?couponCode=GTHB_REPOS_SALE2019)

# How to get this project

You can execute following command or as you prefer [download zip here](https://github.com/leandrocgsi/erudio-api-oauth2/archive/master.zip) and import in your favourite IDE.

```sh
git clone https://github.com/leandrocgsi/erudio-api-oauth2.git
```


# How to restore database

You just need create an empty database in MySQL with name "_erudio_api_db_", check if your credentials are "root" and "root" and execute following command in pom.xml folder.

```sh
mvn flyway:migrate
```

# Build and Run

Use Maven:

```sh
mvn clean package spring-boot:run
```

# Usage

Test the `city` endpoint:

```sh
curl http://localhost:8080/api/v1/city/findAll
```

You receive the following JSON response, which indicates you are not authorized to access the resource:

```json
{
  "error": "unauthorized",
  "error_description": "An Authentication object was not found in the SecurityContext"
}
```

In order to access the protected resource, you must first request an access token via the OAuth handshake. Request OAuth authorization:

```sh
curl -X POST -vu clientapp:123456 http://localhost:8080/oauth/token -H "Accept: application/json" -d "password=spring&username=roy&grant_type=password&scope=read%20write&client_secret=123456&client_id=clientapp"
```

A successful authorization results in the following JSON response:

```json
{
  "access_token": "ff16372e-38a7-4e29-88c2-1fb92897f558",
  "token_type": "bearer",
  "refresh_token": "f554d386-0b0a-461b-bdb2-292831cecd57",
  "expires_in": 43199,
  "scope": "read write"
}
```

Use the `access_token` returned in the previous request to make the authorized request to the protected endpoint:

```sh
curl http://localhost:8080/api/v1/city/findAll -H "Authorization: Bearer ff16372e-38a7-4e29-88c2-1fb92897f558"
```

If the request is successful, you will see the following JSON response:

```json
{
  "id": 1,
  "content": "Hello, Roy!"
}
```

After the specified time period, the `access_token` will expire. Use the `refresh_token` that was returned in the original OAuth authorization to retrieve a new `access_token`:

```sh
curl -X POST -vu clientapp:123456 http://localhost:8080/oauth/token -H "Accept: application/json" -d "grant_type=refresh_token&refresh_token=f554d386-0b0a-461b-bdb2-292831cecd57&client_secret=123456&client_id=clientapp"
```


# SSL

To configure the project to run on HTTPS as shown in [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/), enable the `https` profile. You can do this by uncommenting the appropriate line in the application.properties file of this project. This will change the server port to `8443`. Modify the previous requests as in the following command.

```sh
curl -X POST -k -vu clientapp:123456 https://localhost:8443/oauth/token -H "Accept: application/json" -d "password=spring&username=roy&grant_type=password&scope=read%20write&client_secret=123456&client_id=clientapp"
```

The `-k` parameter is necessary to allow connections to SSL sites without valid certificates or the self signed certificate which is created for this project.


# HATEOAS

[HATEOAS (Hypermedia as the Engine of Application State)](https://spring.io/understanding/HATEOAS) is a constraint of the REST application architecture. A hypermedia-driven site provides information to navigate the site's REST interfaces dynamically by including hypermedia links with the responses. This capability differs from that of SOA-based systems and WSDL-driven interfaces. With SOA, servers and clients usually must access a fixed specification that might be staged somewhere else on the website, on another website, or perhaps distributed by email. According with [Richardson maturity model](http://martinfowler.com/articles/richardsonMaturityModel.html) [HATEOAS](https://spring.io/understanding/HATEOAS) is final level of REST. One API is really [RESTful](https://en.wikipedia.org/wiki/Representational_state_transfer) when implements this standart. As you can see our app have HATEOAS support.

```sh
curl http://localhost:8080/api/v1/city/findAll -H "Authorization: Bearer ff16372e-38a7-4e29-88c2-1fb92897f558"
```

As return, we have something like that:

```json
[
  {
    "insertDate": 1461812400000,
    "updatedDate": 1461812400000,
    "idUserInsert": 0,
    "idUserUpdate": null,
    "active": null,
    "idCity": 1,
    "name": "UBERLANDIA",
    "links": [
      {
        "rel": "self",
        "href": "http://localhost:8080/api/v1/city/1"
      }
    ]
  },
  {
    "insertDate": 1461812400000,
    "updatedDate": 1461812400000,
    "idUserInsert": 0,
    "idUserUpdate": null,
    "active": null,
    "idCity": 2,
    "name": "PATOS DE MINAS",
    "links": [
      {
        "rel": "self",
        "href": "http://localhost:8080/api/v1/city/2"
      }
    ]
  }
]
```

# Swagger API documentation 

Swagger is a simple but powerful representation of your RESTful API. With the largest ecosystem of API tooling on the planet, thousands of developers are supporting Swagger in almost every modern programming language and deployment environment. In January 1st 2016 the [Swagger Specification](http://swagger.io/) has been donated to the [Open API Initiative (OAI)](https://openapis.org/) and has been renamed to the [OpenAPI Specification](https://openapis.org/). With a Swagger-enabled API, you get interactive documentation, client SDK generation and discoverability. In this example you can see the documentation API in localhost adress:

```sh
http://localhost:8080/sdoc.jsp
```

As you can see Swagger provide a simple way to document US API's.

![Example Page](https://github.com/leandrocgsi/erudio-api-oauth2/blob/master/img/SwaggerDocumentation.png?raw=true)

# How to import this project

Now we just see how to import this project in Eclipse. Go to menu File >> Import >> Maven >> Existing Maven Projects >> Next.

![Importing1](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/9-Importing.png?raw=true)

As on image bellow type your Root Directory (where we found your code) and click in Browse >> Finish.

![Importing2](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/10-Importing.png?raw=true)

Probably you see the following errors, dont be worry just click in Finish again.

![Importing3](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/11-Importing.png?raw=true)

Now we dont see our Groovy code this is because these code is out of default Maven lifecycle. To fix this we just need click with right button over our project and select New >> Source Folder.

![CreatingSourceFolders1](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/12-CreatingSourceFolders.png?raw=true)

In next window in Folder Name type *src/main/groovy*, repeat this proccess with *src/test/groovy* and *src/test_components/java*

![CreatingSourceFolders2](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/13-CreatingSourceFolders-CreatingSourceFolders.png?raw=true)

Now we have one structure similar to image bellow. As you can see, on *Markers tab*, we have some erros but dont be worry just click with right button and delete they.

![Final](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/14-Final.png?raw=true)

# Erudio RESTful API Archetype

Based on this project we build a Maven Archetype that can give you power to create a simple REST API in minutes. To access this Archetype and build your API based in this project pease access [Erudio RESTful API Archetype](https://github.com/leandrocgsi/erudio-rest-api-archetype) and folow the steps.
