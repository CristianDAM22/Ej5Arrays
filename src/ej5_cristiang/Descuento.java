
package ej5_cristiang;

/**
 *
 * @author dam
 */
public class Descuento {
    private int limite;
    private float descuento;

    public Descuento(int limite, float descuento) {
        this.limite = limite;
        this.descuento = descuento;
    }

    public int getLimite() {
        return limite;
    }

    public float getDescuento() {
        return descuento;
    }
    
}
