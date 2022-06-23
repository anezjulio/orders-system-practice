# orders-system-practice

Suponiendo que la tabla Pedidos tiene muchos registros y columnas (algunas de ellas
nullable, algunas BLOB / "binary-large-object"), que consideraciones se deberían tener en
cuenta para realizar desde un sitio web consultas a la base de datos de manera
eficiente? Discuta performance a nivel motor de base de datos, networking, capa
aplicativa desde donde se realizan las solicitudes, entre otros aspectos que considere
relevantes.


- Tener bien normalizada la tabla Pedido, de manera que solo se utilize los campos necesarios.
- Tener indexado los registros para facilitar las consultas.
- No almacenar imagenes, ni archivos pesados o multimedia.
- Eliminar tablas y campos que no se utilicen.
- Para las consultas concurrentes, es bueno crear una lista de pedidos cacheada, que se actualize cada 6 horas y se disponibilize en la aplicacion para su consulta, esto reduciria un poco las consultas, y en caso de ver el detalle, consultar toda la info.
- Es recomendable utilizar bases de datos no relacionales como MongoDb, es mucho mas perfonmante que las relacionales a nivel de consulta y manejo de la data.


- Recomendaria utilizar una arquitectura serverless con los productos de AWS, los cuales pueden ser el uso de:
Lambdas para la logica de negocio, 
Api Gateway para balancear la carga de trafico.
S3 para todo el contenido estatico como las paginas html, imagenes, recursos.
RDS para bases de datos relacionales.
IAM y Amazon Cognito para la seguridad y manejo de credenciales en la aplicacion.



