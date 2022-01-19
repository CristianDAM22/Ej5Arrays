/*5.- Una empresa dedicada al sector informático va a realizar un programa para 
gestionar mejor los datos de las facturas de los clientes.*/
package ej5_cristiang;

import textoandnumeros.Utilidad;

/**
 *
 * @author dam
 */
public class Ej5_CristianG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa miEmpresa;
        int nClientes;
        nClientes=(int) Utilidad.pedirNumeroEntero("Introduce el numero de clientes: ",1 );
        miEmpresa=new Empresa(nClientes);
        miEmpresa.pedirClientes();
        
    }
    
}
