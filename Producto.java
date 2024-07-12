public abstract class Producto {
    protected String nombre;
    protected int id;
    protected double precioBase;
    public Producto(String nombre, int id, double precioBase) {
        this.nombre = nombre;
        this.id = id;
        this.precioBase = precioBase;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double calculaPrecioFinal();
    public abstract double calcularDescuento();

    @Override
    public String toString(){
        return "Nombre: " + nombre +"\n"
        + "Precio Base: " + precioBase + "\n"
        + "id: " + id +"\n";
    }
}
