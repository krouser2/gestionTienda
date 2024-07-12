public class ProductoPerecedero extends Producto {

    private double porcentajeDescuentoPorVencimiento;
    private int diasParaVencimiento;

    public ProductoPerecedero(String nombre, int id, double precioBase,
            int diasParaVencimiento) {
        super(nombre, id, precioBase);
        this.diasParaVencimiento = diasParaVencimiento;
    }

    public int getDiasParaVencimiento() {
        return diasParaVencimiento;
    }

    public void setDiasParaVencimiento(int diasParaVencimiento) {
        this.diasParaVencimiento = diasParaVencimiento;
    }

    @Override

    public double calculaPrecioFinal() {
        if (diasParaVencimiento >= 0) {
            return precioBase - calcularDescuento();
        } else {
            return 0.0;
        }
    }

    @Override
    public double calcularDescuento() {
        if (diasParaVencimiento < 3 && diasParaVencimiento >= 0) {
            porcentajeDescuentoPorVencimiento = precioBase * 0.2;
        } else {
            if (diasParaVencimiento >= 3) {
                porcentajeDescuentoPorVencimiento = precioBase * 0.1;
            }
        }

        return porcentajeDescuentoPorVencimiento;
    }

    @Override

    public String toString() {
        return super.toString() + "Precio Final: " + calculaPrecioFinal() + "\n" +
                "Dias para el vencimiento:" + diasParaVencimiento + "\n"
                + "Descuento:" + calcularDescuento() + "\n";

    }
}
