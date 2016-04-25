Luego de revisar el codigo se ha encontrado posibles mejoras las cuales identifico a continuación:

* Los nombres de métodos getters empiezan con get. No se respeta que los nombres de los métodos sean en castellano
* Se pueden unir las clases Periodico y Revista ya que utilizan los mismos metodos y atributos.
* Faltan generar más Test según las clases. No se contempla todo el código
* Se observa mal identación en la Clase libreria (Demasiado espacio entre lineas, que no ocurre en las otras clases implementadas).
* No cumple el 100% de la cobertura.
* Hay varios Assert en el mismo método Test.
* Nombre de Test demasiados largos.

Por lo que se implementará:

* Modificar aquellos nombres los cuales empiezan con get por la palabra obtener. El cual podra identificarse correctamente para aquellos metodos que retornen algun valor específico.
* Se unen las clases Periodico y Revista en una clase unica que se llama RevistaOPeriodico la cual contiene los mismos metodos y atributos que las clases eliminadas.
* Se agregan los Test necesarios (La mayoria corresponde a las Clases Libreria y Cliente).
* Se corrigen los errores de identacion en la clase Libreria.
* Al agregar los Test de las Clases LibreriaTest y ClienteTest se contempla que la cobertura sea del 100% por lo que se asegura que todos los test pasan por las lineas de código.
* Se modifican los Assert que actúan en el mismo método de las clases Test (específicamente en la clase SuscripcionTest). Por ello se generan nuevos métodos de Test para contemplar todos los Asserts.
* Se modifican aquellos nombres de métodos de Test para que sean cortos en su descripcion.
