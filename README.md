He creado esta API siguiendo la estructura de código siguiente:
- Dentro de model irían las clases con las que identifico los objetos con sus getters y setters. En este caso, he creado la clase Country que es la que me piden. Si necesitaramos más informacion, se me ha ocurrido crear tambien una clase name, viendo como está 
montada la informacion que devuelve https://restcountries.com/v3.1/all
- CountryController como su nombre bien dice es el controlador que define las propias acciones de la API.
- La interface CountryRepository la creo para acceder a la base de datos y realizar operaciones sobre Country.
-  CountryService sería lo que teoricamente se dice la capa de negocio, en este caos obtenemos los datos de https://restcountries.com/v3.1/all y los guarda en la base de datos. También está definido el método que extrae toda la informacion.
   Esta clase interactua con CountryRepository.

   

