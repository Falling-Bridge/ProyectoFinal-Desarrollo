Integrantes del grupo:

-Lucas Morales
-Pablo Villagran


Nustro proyecto sobre una pagina de compra de pasajes de autobuses cuenta con un sistema lineal de compra, que funciona gracias a la activación y desactivación de paneles, con el fin de hacerlos visibles o no dependiendo de la etapa de la compra en la que se encuentre, gracias al funcionamiento de la clase Cambiodeescena, la cual hace invisible el panel en el q se estaba, y hace visible al panel al que se quiere ir.

En un principio el comprador tiene la posibilidad de ir a comprar pasajes o ir a ver los pasaje que tiene ya comprados en inicios anteriores, y eliminar estos.

![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/087b9142-1473-4346-9980-9fc64bbdd531)


Luego, si el cliente presiona Comprar, se le enviara a un panel donde debe seleccionar la marca de bus a la que quiere subirse, ya sea TurBus, EME, o Las Galaxias; esto lo planteamos así ya que al uno comprar pasajes debe ingresar a las pagina de los buses de manera directa, y nosotros lo asimilamos a que al apretar el boton te lleva a la siguente elección, que es la de los datos del boleto.

Botoón ver asiento bloqueado
![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/27a2cd39-451d-4038-a4f2-424a730000b6)

Botón ver asiento desbloqueado
![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/751439ab-e7ca-434a-98dd-da0ad88c2019)

En este panel uno debe seleccionar el destino, entre Santiago, Talca y Chillan, si el pasaje va ser solo de Ida, o está contemplado para un pasaje de Ida y Vuelta,
la hora de salida del bus, que puede ser a las 7, a las 12 o a las 17, y la fecha del viaje, que está contemplado para el día actual 
y los dos días siguentes, que se calcula gracias a las clase ObtenerFecha. con esto el bus se decora segun las elecciones y luego se debe apretar el botón 
ver asiento(botón que está bloquedo hasta haber selecionado todos los datos), el cual te lleva al panel para elegir tu asiento.

![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/e9e554c2-e724-49dc-ba15-45954d31f104)

En el panel de los asientos hay dos pisos de asientos, para los cuales hay q hacer doble click por seguridad al cambiar, 
y se puede seleccionar el tipo de asientos y cuantos se quiere comprar, para luego cambiar al panel donde se realiza la compra.
En el panel hay asientos en blanco y que no son seleccionables, los cuales son asientos que viene comprados de antes, y no se pueden volver a comprar.
Tambien hay un JLabel, el cual entrega la información de de los asientos que se estan comprando.
Y al igual que en el panel anterior, si uno no selecciona ningun asiento no puede pasar al sieguente panel

Panel asientos sin asientos seleccionados y boton de ir a pagar bloqueado
![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/790e77ee-6bc2-4cfd-967e-1006daad2e2f)

Panel con asientos seleccionados y botón de ir a pagar activado
![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/b27be5e7-0ed0-4d76-b42f-ffa0993b99ee)

Luego de seleccionar los asientos y de presionar el botón ir a pagar se abre el panel de pagar, donde está toda la información del pasaje, y se puede comprar o ir a selecionar otros pasajes.

![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/d19922a9-2c70-44c0-8f6e-93eb5b44fc7a)

Luego de apretar el botón comprar se activa el panel de etapa final, donde se puede ir a ver los pasajes que se tiene comprado
o se puede ir al menú para comprar más pasajes

![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/fcce011f-67f6-4a8f-a359-8973dc871391)

Y por último, si se presiona el botón de Mis Pasajes ya sea desde panel menú o desde panel etapa final, se activa el panel MisPasaje, y se puede ver todos los pasajes q hay comprados, y se pueden eliminar los tikets si la persona lo quiere

Panel con los tikets aún

![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/ec83ef99-6da1-44ab-8ca4-c4353bd18ef7)

Panel con los tikets eliminados

![image](https://github.com/Falling-Bridge/ProyectoFinal-Desarrollo/assets/133477645/a3569265-5173-4d73-8dfc-840d77daf4e1)


**PATRONES DE DISEÑO IMPLEMENTADOS**

El patron de diseño que decidimos implementar para la parte logica de la tarea es el de decorador, ya que nos permite hacer una especie de 
multiherencia en los asientos y buses, de tal forma que se pueda cambiar la descripcion y el precio de los asientos y lo mismo para los buses.
Este patron es sumamente util para esta tarea, porque facilita el poder añadir caracteristicas distintas a los buses y asientos, por ejemplo el que 
un asiento esté en la ventana o el pasillo y sea de algun tipo como cama, semi cama o vip, y en el caso de los buses que se le apliquen los distintos 
decoradores dependiendo de las cosas q se selecionen en panel destino.

