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
        for (int nCliente = 0; nCliente < clientes.length; nCliente++) {

            cif = Utilidad.pedirString("Dime el CIF: ");
            nombre = Utilidad.pedirString("Dime el nombre: ");
            diasVencimiento = (int) Utilidad.pedirNumeroEntero("Dias de vencimirnto", 0);
            fecha = Utilidad.pedirFecha("Fecha:");
            importe = Utilidad.pedirNumeroReal("Dime el importe de la factura: ", 0f);
            clientes[nCliente] = new Cliente(cif, nombre, fecha, diasVencimiento, importe);

        }
    }

    public void informe() {

         Fecha fhoy = new Fecha();
        float descuento;
        float importeNeto;
        int pos;
        int annoSig=fhoy.getAnno();
        int mesSig=fhoy.getMes()+1;
        
        if(mesSig>11){
            annoSig++;
            mesSig=0;//ENERO
        }
        
        System.out.println("\t\t\t\tINFORME DE FACTURAS");
        System.out.println("Fecha:" + fhoy.fechaMesLetra());
        System.out.println("CIF \t NOMBRE\t FECHA FACTURA\t"
                + " IMPORTE BRUTO \t FECHA VENCIMIENTO\t IMPORTE NETO");
        
        for (int ncli = 0; ncli < clientes.length; ncli++) {
            pos = (int) busqueda(clientes[ncli].getDiasVencimiento());
            if (pos == -1) {
                descuento = 0;
            } else {
                descuento = clientes[ncli].getImporte()
                        * descuentos[pos].getDescuento();
            }
            importeNeto=clientes[ncli].getImporte()-descuento;
            Fecha vencimiento = new Fecha(
                    clientes[ncli].getFechaFactura().getDia(),
                    clientes[ncli].getFechaFactura().getMes(),
                    clientes[ncli].getFechaFactura().getAnno());

            vencimiento.calcularVencimiento(clientes[ncli].getDiasVencimiento());
            
            if(importeNeto>10000 && vencimiento.getMes()==mesSig && vencimiento.getAnno()==annoSig){//No entiendo lo de =
                
            System.out.print(clientes[ncli].getCIF());
            System.out.print("\t" + clientes[ncli].getNombre());
            System.out.print("\t"
                    + clientes[ncli].getFechaFactura().fechaComepleta());

            System.out.print("\t" + clientes[ncli].getImporte());
            System.out.print("\t\t" + vencimiento.fechaComepleta());
            System.out.println("\t"+ importeNeto);
            }
            
            else{
                System.out.println("FACTURAS NO CUMPLEN LOS REQUISITOS (10000€)");
            }
        }
    }
    /**
     * Metodo de busqueda.
     *
     * @param valor Del elemento a buscar
     * @return posicion del valor en contrado -1 en el caso de no encontrarlo
     */
    public float busqueda(int valor) {
        int pos = 0;
        boolean encontrado = true;
        while (!encontrado && pos < descuentos.length) {//&& pos < descuentos.length-->NO HARIA FALTA PORQUE SIEMPRE LOVA A ENCONTRAR
            if (valor > descuentos[pos].getLimite()) {
                pos++;
            } else {
                encontrado = true;
            }
            if (!encontrado) {//NO HARIA FALTA PORQUE SIEMPRE LOVA A ENCONTRAR
                pos = -1;
            }
        }
        return pos;
    }

}
