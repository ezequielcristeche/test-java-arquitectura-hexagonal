# test-java-arquitectura-hexagonal

El proyecto esta realizado con arquitectura hexagonal con enfoque Domain Driven Design el cual pone todo el foco del proyecto en el nucleo y la logica del dominio. El mismo esta compuesto por multi modulos POM, el cual contiene 3 modulos:

### Modulo Core
1. Domain (Contiene toda la logica empresarial correspondiente al negocio)
2. Value Objects (Objetos que le dan valor al contexto. No siempre suelen tener unicamente el identificador del dominio)
3. Services 
4. Este modulo no debe tener ninguna dependencia propia al framework que se este utilizando, ni libreria que nos facilite el desarollo. En este caso no tiene depedencia con Spring Framework, ni con lombook.

### Modulo Infra
1. Entities (Representan la tablas de la BD)
2. Mapper (Clase encargada de transformar los objetos domain a entity y viceversa)
3. Puerto de salida (Encargada de comunicarse con la capa core)
4. Adapter (Contiene la implementacion que necesitemos realizar para conectarnos con la BD. En este caso utilizado JPA, pero podria haber sido Mongo, etc)


### Modulo Web
1. Controller
2. Configuraciones 
   * Swagger (Interface grafica para poder consumir el servicio api/hexagonal/prices)
   * CORS (En caso de que nuestro backend se tenga que integrar con un Front End, y tenga que resolver las policies CORS)
3. Controller (Expone la logica para crear el servicio que luego va a ser consumido por Postman / Swagger)
4. DTO (Objeto que tiene los datos de entrada enviada por el servico, y el response que contiene los datos devueltos por la BD)
5. Mapper (Objeto que va a transformar un domain a DTO)
6. Input Port (Puerto de entrada que se va a comunicar con el modulo Core)
7. Este modulo presenta depedencias con Spring Framework y con la libreria Lombook.
***

## Tecnologias

1. Spring Framework 
2. Java 8
3. Base de datos: H2
4. JPA
***

## Uso

Para poder correr el proyecto se puede utilizar el siguiente comando de maven:

```mvn
mvn spring-boot:run -pl web
```





