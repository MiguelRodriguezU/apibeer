# ApiBeer
Api para consultar información de cerveza, guardará un log de consulta en una base de datos en memoria.
Cada vez que se hace una consulta al api, este se conectará al API punkapi (https://api.punkapi.com/) para obtener información,
una vez obtenido la respuesta, se guardará información del instante de la consulta a manera de auditoria (log) en una base de
datos h2.

# EndPoints
Consultar todas las cervezas
- http://localhost:8081/apibeer/beers

Consultar todas las cervezas que coincidan por un nombre
- http://localhost:8081/apibeer/beers?beer_name=BrewDog

Consultar una cerveza random
- http://localhost:8081/apibeer/beers/random

Panel de consulta de la base de datos (h2)
- http://localhost:8081/h2-ui


