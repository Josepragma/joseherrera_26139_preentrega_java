import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
         // condicional multiple: evaluar variable opcion con switch
         int opcion;
         do {
             System.out.println(" \n****************************************************************");
             System.out.println(" \nSistema de Gestion Pragmatech: ");
             System.out.println(" \nSeleccione una opcion: ");
             System.out.println("1. Ingrese un Articulo");
             System.out.println("2. Consultar articulos");
             System.out.println("3. Consultar un articulo");
             System.out.println("4. Modificar un articulo");
             System.out.println("5. Eliminar un articulo");
             System.out.println("0. Salir");
             System.out.println(" \n****************************************************************");
             opcion = sc.nextInt();
              switch (opcion) {
                 case 1:
                     System.out.println("Usted va a ingresar un articulo");
                     // esrta opcion va a llamar a un metodo para ingresar un articulo
                     // este metodo va a pedir al usuario que ingrese:
                     // - nombre del articulo (String)
                     // - precio del articulo (double)
                     // - Categoria del articulo (String)
                     // se guardara un codigo automatico para el articulo (int)
                     // ese metodo validara cada dato ingresado por el usuario, por ejemplo:
                     // - el nombre del articulo no puede estar vacio
                     // - el precio del articulo debe ser un numero positivo
                     // - la categoria del articulo no puede estar vacia
                     // en el caso de que el usuario ingrese un dato no valido, 
                     // se le mostrara un mensaje de error
                     // y se le pedira que ingrese el dato nuevamente hasta que sea valido
                     // este articulo sera un objeto nuevo del tipo Articulo, 
                     // el cual se guardara en una lista de articulos (ArrayList<Articulo>)

                     break;
                 case 2:
                     System.out.println("Usted va a consultar articulos");
                        // esta opcion va a llamar a un metodo para consultar articulos
                        // este metodo va a mostrar una lista de todos los articulos ingresados,
                        // mostrando su codigo, nombre, precio y categoria
                        // va a usar el metodo toString() de la clase Articulo para mostrar
                        // la informacion de cada articulo
                        // si no hay articulos ingresados, 
                        // se mostrara un mensaje indicando que no hay articulos disponibles
                     break;
                 case 3:
                     System.out.println("Usted va a consultar un articulo");
                        // esta opcion va a llamar a un metodo para consultar un articulo especifico
                        // este metodo le mostrara al usuario una lista de todos los articulos ingresados, mostrando su codigo, nombre, precio y categoria
                        // este metodo va a pedir al usuario que ingrese el codigo del articulo que desea consultar
                        // ese metodo va a buscar el articulo en la lista de articulos por codigo
                        // si el articulo existe, se mostrara la informacion del articulo al usuario tostring del objeto
                        // si el articulo no existe, se mostrara un mensaje indicando que el articulo no fue encontrado
                        // hasta que sea valido o el usuario decida salir de la consulta (while)
                     break;
                 case 4:
                     System.out.println("Usted va a modificar un articulo");
                     // esta opcion va a llamar a un metodo para modificar un articulo especifico
                     // este metodo le mostrara al usuario una lista de todos los articulos ingresados, mostrando su codigo, nombre, precio y categoria
                     // este metodo va a pedir al usuario que ingrese el codigo del articulo que desea modificar
                     // ese metodo va a buscar el articulo en la lista de articulos por codigo
                     // si el articulo existe, se le mostrara al usuario la informacion del articulo tostring del objeto
                     // este metodo va a pedir al usuario que ingrese la nueva informacion del articulo,
                     // - desea modificar el nombre del articulo? (si/no)
                     // - nuevo nombre del articulo (String)
                     // - desea modificar el precio del articulo? (si/no)
                     // - nuevo precio del articulo (double)
                     // - desea modificar la categoria del articulo? (si/no)
                     // - nueva categoria del articulo (String)
                     // ese metodo validara cada dato ingresado por el usuario, por ejemplo:
                     // - el nombre del articulo no puede estar vacio
                     // - el precio del articulo debe ser un numero positivo
                     // - la categoria del articulo no puede estar vacia
                     // en el caso de que el usuario ingrese un dato no valido,
                     // se le mostrara un mensaje de error
                     // y se le pedira que ingrese el dato nuevamente hasta que sea valido
                     // si el articulo no existe, se mostrara un mensaje indicando que el articulo no fue encontrado
                     // hasta que sea valido o el usuario decida salir de la modificacion (while)
                     // en el caso de que el articulo exista y se modifique correctamente, se mostrara un mensaje indicando que el articulo fue modificado exitosamente

                     break;
                 case 5:
                     System.out.println("Usted va a eliminar un articulo");
                     // esta opcion va a llamar a un metodo para eliminar un articulo especifico
                        // este metodo le mostrara al usuario una lista de todos los articulos ingresados, 
                        // mostrando su codigo, nombre, precio y categoria
                        // este metodo va a pedir al usuario que ingrese el codigo del articulo que desea eliminar
                        // ese metodo va a buscar el articulo en la lista de articulos por codigo
                        // si el articulo existe, se le mostrara al usuario la informacion del articulo tostring del objeto
                        // este metodo va a pedir al usuario que confirme si desea eliminar el articulo (S/N)
                        // si el usuario confirma que desea eliminar el articulo, se eliminara el articulo de la lista de articulos
                        // si el articulo no existe, se mostrara un mensaje indicando que el articulo no fue encontrado
                        // hasta que sea valido o el usuario decida salir de la eliminacion (while)
                        // en el caso de que el articulo exista y se elimine correctamente, se mostrara un mensaje 
                        // indicando que el articulo fue eliminado exitosamente


                     break;
                case 0:
                     System.out.println("Gracias por usar el sistema de gestion Pragmatech, hasta luego!");
                     // en esta opcion se mostrara un mensaje de despedida al usuario
                     // y se cerrara el scanner
                     sc.close();
                     break;
                 default:
                     System.out.println("Opcion no valida, por favor intente de nuevo.");
             }
         } while (opcion != 0);


         // motodos de clase que me permitan:
         // - ingresar un articulo
         // - consultar articulos
         // - consultar un articulo
         // - modificar un articulo
         // - eliminar un articulo
         // - motodo que valideNombre(String nombre): boolean
         // - motodo que validePrecio(double precio): boolean
         // - motodo que valideCategoria(String categoria): boolean

        
    }
}
