# **ÍNDICE**
- [**INTRODUCCIÓN**](#introducción)
- [**APLICACIÓN MOVIL**](#aplicación-movil)
  - [**LOGIN**](#login)
  - [**MANTENIMIENTO DE GUARDIAS**](#mantenimiento-de-guardias)
    - [**CREAR UNA NUEVA GUARDIA**](#crear-una-nueva-guardia)
      
    
# **INTRODUCCIÓN**

La aplicación trata de la administración de guardias por parte de los profesores.

Los usuarios profesores pueden acceder a la aplicacion

---

# **APLICACIÓN MOVIL**

## **LOGIN**

Al iniciar la aplicación, se encotrará con esta pantalla:

![login]

Aquí tendrá que proporcionar su `Nombre de ususario` y `Contraseña`

Si alguno de los campos no es correcto, saldrá un aviso diciendo que su usuario o contraseña no son correctos

puede intentarlo las veces que necesite

una vez iniciada la sesión no será necesario volver a introducir los datos hasta dentro de 90 dias o si cierra sesión

---

## **GUARDIAS**
Al iniciar sesion correctamente con su usuario, aparecerá la pantalla de los mantenimientos de guardias

Esta contiene todas las guardias que estan registradas en la base de datos de las guardias

Tambien dispone de una barra de buscador para filtrar las guardias por grupo aula o profesor ausente.

Dispone de tres pestañas:
`Guardias`, `Aceptadas` e `Historial`

En la pestaña guardias tienen guardias que estan disponibles para cubrir:

![Guardias]

Si toca en una de ellas puede aceptar la guardia:

![GuardiasaAc]

Al aceptar, aparecerá la guardia en la pestaña de aceptadas

![GuardiasAc]

Cuando esa guardia ya sea realizada, toque en la guardia en la pestaña de aceptadas y toque la opcion de `Realizada`

Tambien tiene la opción de `Anular`

![GuardiasRe]

Al estar realizada, Pasará a la pestaña de historial.

Tambien podrá ver el progreso de otras guardias para ver si han sido `Realizadas`, `Anuladas` o `Creadas`

![GuardiasHi]


### **CREAR UN NUEVO AVIOS**

Usted puede crear un nuevo aviso tocando el botón flotante **+**

![CrearGuardia]

Aquí podra rellenar los datos del aviso:

```markdown
    * Profesor ausente
    * Fecha de ausencia
    * Motivo de ausencia
    * Observaciones
````
Al rellenar todos los campos, toque el boton de enviar y ya tendrá creado el aviso y la guardia, la cual estará pendiente de aceptar


[login]: imagenesREADME/Login.png "Pantalla de Login"
[Guardias]: imagenesREADME/Guardias.png "Pestaña de guardias"
[GuardiasAc]: imagenesREADME/GuardiasAc.png "Pestaña de aceptadas"
[GuardiasaAc]: imagenesREADME/GuardiaAAcept.png "Pantalla para aceptar guardia"
[GuardiasRe]: imagenesREADME/GuardiaRealiz.png "Pantalla para marcar la guardia como realizada"
[GuardiasHi]: imagenesREADME/GuardiaHist.png "Pantalla de historial de guardias"

[CrearGuardia]: imagenesREADME/CrearGuardia.png "Pantalla creacion de guardias"

