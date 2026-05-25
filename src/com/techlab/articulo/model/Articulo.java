package com.techlab.articulo.model;


/*
 * CLASE ARTICULO
 * -----------------------------
 * Esta clase representa un artículo en el sistema
 **/

public class Articulo {

    // Atributo que representa el código del artículo.
    private int codigo;

    // Atributo que representa el nombre del artículo.
    private String nombre;

    // Atributo que representa el precio del artículo.
    private double precio;

/* Constructor
* --------------------------------------
* El Constructor sirve para crear objetos ya inicializados
*
* Cuando hacemos new Articulo(1, "Lapiz", 10.0), se llama a este constructor para crear un nuevo artículo con el código 1, nombre "Lapiz" y precio 10.0
*
* Estamos creando un objeto con estos 3 datos cargados
*/
    public Articulo() {
        // Constructor vacío, permite crear un artículo sin inicializar sus atributos.
    }
    public Articulo(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    /* Getter de código
     * --------------------------------------
     * Permite obtener el valor del atributo código.
     */
    public int getCodigo() {
        return codigo;
    }

    /* Setter de código
     * --------------------------------------
     * Permite establecer el valor del atributo código.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /* Getter de nombre
     * --------------------------------------
     * Permite obtener el valor del atributo nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /* Setter de nombre
     * --------------------------------------
     * Permite establecer el valor del atributo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* Getter de precio
     * --------------------------------------
     * Permite obtener el valor del atributo precio.
     */
    public double getPrecio() {
        return precio;
    }

    /* Setter de precio
     * --------------------------------------
     * Permite establecer el valor del atributo precio.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /* Método toString
     * --------------------------------------
     * Este metodo permite definir cómo se representa el objeto Articulo como una cadena de texto.
     * 
     * Si no lo sobrescribimos, Java mostrara algo poco legible como:
     * com.techlab.articulo.model.Articulo@15db9742
     * 
     * En cambio, con toString() podemos mostrar la información real del objeto.
     *   @override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
     */
    @Override
    public String toString() {
        return this.codigo + " - " + this.nombre + " - $" + this.precio;
    }


}