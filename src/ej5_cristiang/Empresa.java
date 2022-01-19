package ej5_cristiang;

import fecha.Fecha;
import textoandnumeros.Utilidad;

/**
 *
 * @author dam
 */
public class Empresa {

    Cliente[] clientes;
    Descuento[] descuentos;

    public Empresa(int nClientes) {
        clientes = new Cliente[nClientes];
        descuentos = new Descuento[]{
            new Descuento(30, 0.1f),
            new Descuento(90, 0.07f),
            new Descuento(120, 0.05f),
            new Descuento(180, 0.02f),
            new Descuento(Integer.MAX_VALUE, 0f)
        };

    }

    public void pedirClientes() {
        String cif;
        String nombre;
        float importe;
        int diasVencimiento;
        Fecha fecha;
        for (int nCliente = 0; nCliente < clientes.length;nCliente++) {
            
            cif=Utilidad.pedirString("Dime el CIF: ");
            nombre=Utilidad.pedirString("Dime el nombre: ");
            diasVencimiento=(int) Utilidad.pedirNumeroEntero("Dias de vencimirnto",0);
            fecha =Utilidad.pedirFecha("Fecha:");
            importe=Utilidad.pedirNumeroReal("Dime el importe de la factura: ", 0f);
            clientes[nCliente] = new Cliente (cif, nombre, fecha, diasVencimiento, importe); 
            
        }
    }
    public void informe(){
        Fecha fhoy=new Fecha();
        System.out.println("\t\t\t INFORME DE FACTURA:");
        System.out.println("Fecha: "+fhoy.fechaMesLetra());
        System.out.println("CIF \t NOMBRE \t FECHA FACTURA \t IMPORTE BRUTO \t FECHA VENCIMEIENTO \t IMPORTE NETO");
        for (int ncli=0;ncli<clientes.length;ncli++){
            Fecha vencimiento= new Fecha(clientes[ncli].getFechaFactura().getDia(),
                                         clientes[ncli].getFechaFactura().getMes(),
                                         clientes[ncli].getFechaFactura().getAnno());
            vencimiento.calcularVencimiento(clientes[ncli].getDiasVencimiento());
            System.out.println("\t"+clientes[ncli].getCIF());
            System.out.println("\t"+clientes[ncli].getNombre());
            System.out.println("\t"+clientes[ncli].getFechaFactura().fechaMesLetra());
            System.out.println("\t"+clientes[ncli].getImporte());
            System.out.println("\t"+vencimiento.fechaMesLetra());
        }
    }

}
