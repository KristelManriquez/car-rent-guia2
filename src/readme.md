DONE
✓ a) Obtener monto a pagar: Este método calcula y entrega el monto del arriendo instanciado multiplicando el número de
días por el precio diario. Este precio lo indica el usuario una vez que se ingresa un arriendo al sistema
(clase Arriendo - JOACO)

✓ b) Evaluar arriendo: Operación que se ejecuta antes de guardar el arriendo al sistema y valida que el cliente del arriendo
esté vigente y que el vehículo de este mismo arriendo tenga condición D (disponible). El método retorna un true (si
está ok) o false (si no es posible arrendar). (clase Arriendo - JOACO)

✓ Después que el usuario agrega un cliente debe agregarlo al arraylist y archivo correspondiente y retornar a la interfaz de
Arriendo con Cuotas (Interacción con Interfaz Clientes - Kristel)

TODO
c) Generar cuotas del arriendo: operación que se ejecuta al guardar un arriendo exitoso al sistema, que recibe el precio
por día del arriendo y crea las cuotas según la siguiente especificación:
- El número de cada cuota es un correlativo que comienza en 1 y se aumenta en uno para las cuotas siguientes.
- El valor de cada cuota es la división entre monto a pagar y cantidad de cuotas.
- Todas las cuotas deben quedar inicialmente con pagada igual a False.
- Este método debe retornar la lista (ArrayList) de cuotas generada para que sea asignada (o referenciada) al
  arriendo respectivo.
  (clase ArriendoCuota - KAT)

d) Ingresar arriendo con cuotas: Este método evalúa los datos del arriendo instanciado (invocando la función
evaluarArriendo) retornando true si la operación fue exitosa y false si no lo fue. En el caso de que la operación sea
exitosa, este método automáticamente dejará el vehículo arrendado con condición A y para aplicar correctamente la
relación compuesta entre los objetos arriendo y cuotas, asignará las cuotas respectivas del arriendo invocando la
función definida en c)
(clase ArriendoCuota - KAT)

e) Pagar cuota: operación que recibe la cuota a pagar y busca la cuota en la lista respectiva. Si la encuentra, el método
actualiza el atributo pagada con True y retorna un true, en caso contrario, retorna un false. (clase CuotaArriendo - JOACO)

-------- Se requiere que su implementación considere lo siguiente:  ---------
a) Las validaciones de los atributos que se implementan en los mutadores, se deben programar usando métodos públicos
en la clase respectiva. Estas validaciones se ejecutan en el momento de actualizar (setear) el objeto, por lo tanto,
debe considerar, además, que los datos ingresados por el usuario (en el caso que corresponda) y que son ocupados
para instanciar los objetos, podrán ser validados usando estos mismas métodos. (Todas las clases - KENNY)
Agregar validaciones de Setters, en clase Cliente, se debe agregar validación de cedula (KENNY - ver en trabajo anterior)

b) Para que los objetos del sistema entreguen al usuario los diversos mensajes generados por el sistema, programar en
cada clase un método que reciba el string con el mensaje, el tipo de mensaje y genere la salida. (todas las clases - KENNY)

La interfaz principal no se representa en el diagrama, por lo tanto, usted debe diseñarla y programarla considerando al
menos lo siguiente:
- Barra de menús con las opciones que el usuario puede operar (Arrendar con cuotas y pagar cuota). Implementar dichas
  opciones con controladores de los eventos generados por el usuario.
- Título e imagen ad hoc para el sistema de arriendo de vehículos.
- Que cargue los datos de los archivos clientes, vehículos y arriendos con cuota en los arrayList respectivos. Use POO.
El método main debe invocar interfaz principal del sistema (la diseñada por usted) para empezar a operar el sistema con las
condiciones especificadas en este documento. (Interfaz principal - CARLOS)























