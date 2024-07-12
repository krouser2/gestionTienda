import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        //Se declara el scanner
        Scanner sc = new Scanner(System.in);
        //contador
        int count = 0;
        //Listas
        String reporteGeneral = "Todos los productos: \n";
        String reporteElectronico = "Productos Electronicos: \n";
        String reportePerecedero = "Productos Perecederos \n";
        String reportePapeleria = "Productos de Papeleria \n";
        String reporteCaducados = "Productos Caducados \n";
        //sumatorias
        double[] sumatorias = new double[8];
       
        //arreglo de productos
        Producto[] productos = new Producto[1];
        //LLenar el arreglo de productos
        do{
            System.out.println("Ingrese el tipo de Producto: "
            + "\n" + "1)Electronico"+ "\n" + "2)Perecedero"+ "\n" + "3)Papeleria"
            + "\n" + "4)Salir"+ "\n");
            int tipo = sc.nextInt();
            if(tipo == 4){
                break;
            }
            System.out.println("Ingresa el nombre del productoo:");
            String nombre = sc.next();
            System.out.println();
            System.out.println("Ingresa el precio del producto");
            double precio = sc.nextDouble();
            sc.nextLine();
            System.out.println();
            System.out.println("Ingresa el id del producto");
            int id = sc.nextInt();
            System.out.println();

        
            switch (tipo) {
                case 1:
                    System.out.println("Meses de garantia: ");
                    ProductoElectronico pe = new ProductoElectronico(nombre, id, precio, sc.nextInt());
                    productos[count]=pe;
                    System.out.println();

                    break;
                case 2:
                    System.out.println("En cuantos dias vence el producto: ");
                    ProductoPerecedero pp = new ProductoPerecedero(nombre, id, precio, sc.nextInt());
                    productos[count]=pp;
                    System.out.println();

                    break;
                case 3:
                    ProductoPapeleria ppa = new ProductoPapeleria(nombre, id, precio);
                    productos[count] = ppa;
                    System.out.println();

                    break;
                default:
                    System.out.println("Tipo de producto invalido");
                    System.out.println();
                    continue;
            }
            
            count++;
        }while(count < productos.length);

        //Recorrer el arreglo
        for(Producto pr : productos){
            if(pr != null){
                reporteGeneral += pr + "\n";
                //el indice 0 es para guardar la sumatoria total
                sumatorias[0] += pr.calculaPrecioFinal();
                //El indice 1 es para el descuento total
                sumatorias[1] += pr.calcularDescuento();
            }
        }

        //tipo de producto en especifico
        for(Producto pr : productos){
            if(pr != null){
                if(pr instanceof ProductoElectronico){
                    //indice 2 es para la sumatoria total electronico
                    sumatorias[2]+= pr.calculaPrecioFinal();
                    //indice 3 es para la sumatoria descuento electronico
                    sumatorias[3]+= pr.calcularDescuento();
                    //Reporte 
                    reporteElectronico += pr + "\n";
                }
                if(pr instanceof ProductoPerecedero){
                    //indice 4 es para la sumatoria total electronico
                    sumatorias[4]+= pr.calculaPrecioFinal();
                    //indice 5 es para la sumatoria descuento electronico
                    sumatorias[5]+= pr.calcularDescuento();
                    //Reporte
                    if(pr.calculaPrecioFinal() != 0){
                        reportePerecedero += pr + "\n";
                    }else{
                        reporteCaducados += pr + "\n";
                    }
                }
                if(pr instanceof ProductoPapeleria){
                    //indice 6 es para la sumatoria total electronico
                    sumatorias[6]+= pr.calculaPrecioFinal();
                    //indice 7  es para la sumatoria descuento electronico
                    sumatorias[7]+= pr.calcularDescuento();
                    //Reporte
                    reportePapeleria += pr + "\n";
                }
            }
        }

        System.out.println("Precio total de todos los productos: " + sumatorias[0]+"\n");
        System.out.println("Descuento total de todos los productos: " +sumatorias[1]+"\n");
        System.out.println("Precio total de los productos Electronicos: " + sumatorias[2]+"\n");
        System.out.println("Descuento total de los productos Electronicos: " +sumatorias[3]+"\n");
        System.out.println("Precio total de los productos Perecederos: " + sumatorias[4]+"\n");
        System.out.println("Descuento total de los productos Perecederos: " +sumatorias[5]+"\n");
        System.out.println("Precio total de los productos de papelerias: " + sumatorias[6]+"\n");
        System.out.println("Descuento total de los productos de Papeleria: " +sumatorias[7]+"\n");

        //Reportes
        System.out.println(reporteGeneral);
        System.out.println(reporteElectronico);
        System.out.println(reportePerecedero);
        System.out.println(reporteCaducados);
        System.out.println(reportePapeleria);



    }
}