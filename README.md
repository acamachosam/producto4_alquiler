# Pasos a Seguir 📝

## Los pasos a seguir para llevar a cabo el producto son:

1. **Leer detenidamente estas instrucciones** e identificar los requerimientos de la actividad.

2. **Revisar detenidamente la rúbrica de evaluación.**

3. **Consultar los recursos necesarios** facilitados en el aula.

4. **Modificar nuestro diagrama E/R** para la incorporación de usuarios a nuestra aplicación, considerando:
   - **Securización:** Añadir autenticación y autorización.
   - **Lógica de la aplicación:** Ajustar relaciones entre entidades.

5. **Incorporar Spring Security** dentro de la aplicación:
   - Modificar las configuraciones del proyecto para integrar **Spring Security**.
   - Incorporar un formulario de **login** y **registro de usuario**.

6. **Modificar las relaciones** en al menos una de las entidades propuestas, ya que los usuarios interactúan con el resto de entidades:
   - En el caso de la aplicación de **Alquiler de Vehículos**, los usuarios no solo inician sesión, sino que pueden realizar alquileres.
   - Realizar los siguientes cambios en la aplicación:
     - Añadir los **modelos necesarios nuevos**.
     - Modificar los modelos existentes con las **anotaciones necesarias**.
     - Ajustar las **vistas y controladores** correspondientes.

7. **Añadir una gestión por roles** en las diferentes partes de la aplicación:
   - Crear una ruta **`/admin/*`** accesible solo para el rol `ADMIN`:
     - Aquí se manejarán todas las acciones de creación, modificación o eliminación de datos en los modelos.
   - Crear una ruta **`/user/*`** para que los usuarios puedan interactuar con las partes designadas de la aplicación.

8. **Realizar las modificaciones oportunas** en el contenedor **Docker** para reflejar los cambios realizados.

---
