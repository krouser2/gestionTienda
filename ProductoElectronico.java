public class ProductoElectronico extends Producto{
    private int garantia;

    public ProductoElectronico(String nombre, int id, double precioBase, int garantia) {
        super(nombre, id, precioBase);
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    @Override
    public double calculaPrecioFinal() {
        double pf = 0.0;
        if(garantia > 12){
            pf = (precioBase-calcularDescuento())* 1.10;
        }else{
            pf=(precioBase-calcularDescuento())*1.15;
        }
        return pf;
    }

    @Override
    public double calcularDescuento() {
        return precioBase * 0.2;
    }

    @Override
    public String toString() {
        return super.toString() + "Precio Final: " + calculaPrecioFinal() + "\n"
        + "Descuento: " + calcularDescuento() + "\n"
        + "Garantia: " + garantia +" meses"+"\n";
    }

    
}
