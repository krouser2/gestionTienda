public class ProductoPapeleria extends Producto{
    private double iva;

    public ProductoPapeleria(String nombre, int id, double precioBase) {
        super(nombre, id, precioBase);
        this.iva = 1.16;
    }

    public double getIva() {
        return iva;
    }

    @Override
    public double calculaPrecioFinal() {
        return (precioBase - calcularDescuento())*iva;
    }

    @Override
    public double calcularDescuento() {
        return precioBase * 0.10;
    }

    @Override 
    public String toString(){
        return super.toString() + "precio final" + calculaPrecioFinal() + "\n"
        + "Descuento: " + calcularDescuento() + "\n";
    }
    

    
}
