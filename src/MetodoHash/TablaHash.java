package MetodoHash;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author benja
 */
public class TablaHash {

    int dato,precio;
    String Nombre;
    public int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado
    
    public static int funcion(int n, int m) {
        return (n)%(m -1);
    }
    static int aux=0;
    public static void insertaHash(TablaHash[] h, int m, int n,String nombre,int precio) {
        int j= funcion(n, m);
        boolean i=false;
        do{
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].dato = n;
                h[j].Nombre=nombre;
                h[j].precio=precio;
                h[j].estado = 2;
                aux++;
                if(aux>m){
                JOptionPane.showMessageDialog(null, "¡Tabla llena!");
                i=true;
                }else{
                i=true;
                JOptionPane.showMessageDialog(null, "¡Elemento insertado con éxito!");
                }
            }else{
                j++;
            }
            if(j==m)
                j=0;
        }while(j<m && i!=true);
    }

    public static int buscaHash(TablaHash[] h, int m, int n) {
        int a=h.length;
        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) {
                return -1;
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return -1;
                } else {
                    return j;
                }
            } else {
                j++;
            }
        }
        return -1;
    }

    public static int eliminaHash(TablaHash[] h, int m, int n) {
        int i = buscaHash(h, m, n);
        if (i == -1) {
            return -1;
        } else {
            h[i].estado = 1;
            h[i].dato=0;
            h[i].Nombre="";
            h[i].precio=0;
            return 1;
        }
    }
    public static void Mostrar(TablaHash[] h){
        System.out.println("Inventario\n");
        System.out.println("[codigo]\t[Nombre   ]\t\t[Precio]");
        for(int i=0;i<h.length;i++){
            System.out.println("|"+h[i].dato+"|\t\t|"+h[i].Nombre+"|\t\t\t|"+h[i].precio+"|");
        }
    }
}
