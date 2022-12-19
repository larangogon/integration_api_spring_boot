# integration_api_spring_boot

### Descripcion:
- Utilizando JAVA spring boot y MYSQL
- Realizar un consumo para llenar nuestra base de datos con la informacion que se disponibiliza en el api    https://www.themoviedb.org/documentation/api

### Detalle

1. Consumo de los servicios provee la api de The Movie database. 
2. Crear Endpoints donde exponga la data ya procesada (Incluir métodos POST, PUT, DELETE, UPDATE).
3. Las respuestas de los endpoints deben estar estandarizadas para una mayor legibilidad.
4. No mostrar más 20 películas en la carga inicial, Construir un paginador para controlar la cantidad de data
proveniente de la API (GET)
5. Construir endpoint de detalle de cada película usando toda la información que ofrece la Api (GET por ID).

## Intalacion
Para su uso ejecute lo siguiente

### Api Externa:

1. GET: http://127.0.0.1:8080/api/movies/create/list : consuma este endpoint para que su base de datos cuente con la tada necesaria para disponibilizarla.

2.  GET: http://127.0.0.1:8080/api/movies/list : consuma este endpoint para ver la lista te peliculas disponible desde la api themoviedb.

3.  GET: http://127.0.0.1:8080/api/movies/show/{id}: esta api de levolvera la informacion sobre una pelicula disponible desde la api themoviedb

________________________________________________________________________________________________________

### Api:

4.  GET: http://127.0.0.1:8080/api/movies/index: lista las peliculas que tenemos en nuestra base de datos
5.  GET: http://127.0.0.1:8080/api/movies/4: ver el detalle de un modelo
6.  POST: http://127.0.0.1:8080/api/movies/create : en el body enviaremos la data para crear una nueva pelicula en nuestra base de datos
7.  PUT: http://127.0.0.1:8080/api/movies/create : en el body enviaremos la data para actualizar una nueva pelicula en nuestra base de datos
8.  DELETE: http://127.0.0.1:8080/api/movies/4: elimina modelo del nuestra base de datos

### Web: 

1. GET: http://127.0.0.1:8080/movies/: lista las peliculas que tenemos en nuestra base de datos
2. GET: http://127.0.0.1:8080/movies/show/1: ver el detalle de un modelo

### Uso de Swagger.

http://localhost:8080/swagger-ui/index.html

/v2/api-docs

