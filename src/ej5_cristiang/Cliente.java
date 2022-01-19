
package ej5_cristiang;

import fecha.Fecha;//-->CLASE FECHA DE UTILIDAD

/**
 *
 * @author dam
 */
public class Cliente {
    private String CIF;
    private String nombre;
    private Fecha fechaFactura;//import fecha.Fecha;
    private int diasVencimiento;
    private float Importe;

    public Cliente(String CIF, String nombre, Fecha fechaFactura, int diasVencimiento, float Importe) {//NO CREAS EL  CLIENTE HASTA QUE LO TIENES TODO
        this.CIF = CIF;
        this.nombre = nombre;
        this.fechaFactura = fechaFactura;
        this.diasVencimiento = diasVencimiento;
        this.Importe = Importe;
    }
    /*ES LO MISMO QUE LO DE ARRIBA:PRIMERO CREAS Y LUEGO CARGAS LOS DATOS
    public Clinte()
       
    }
    public void Grabar(String CIF, String nombre, Fecha fechaFactura, int diasVencimiento, float Importe)
     this.CIF = CIF;
        this.nombre = nombre;
        this.fechaFactura = fechaFactura;
        this.diasVencimiento = diasVencimiento;
        this.Importe = Importe;
    */
    

    public String getCIF() {
        return CIF;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaFactura() {
        return fechaFactura;
    }

    public int getDiasVencimiento() {
        return diasVencimiento;
    }

    public float getImporte() {
        return Importe;
    }
    
}
