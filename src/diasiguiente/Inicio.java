package diasiguiente;

import java.util.Scanner;

/**
 * Clase Main del proyecto.
 *
 * @author Atanas Todorov Todorov
 */
public class Inicio {

    /**
     * Pide fechas al usaurio y deveelve la fecha siguiente o muestra un error
     * correspondiente a la fecha introducida. Hace uso del objeto
     * {@link DiaSiguiente}.
     */
    public static void main(String[] args) {
        int dd;
        int mm;
        int aa;
        int resu = 0;
        DiaSiguiente fecha;
        fecha = new DiaSiguiente();
        Scanner sc = new Scanner(System.in);

        while (true) {
            //Pide al usuario una fecha.
            System.out.println("\nEscriba Dia 0, Mes 0, Año 0 para salir\n");
            System.out.print("Introduzca Día: ");
            dd = sc.nextInt();
            System.out.print("Introduzca Mes: ");
            mm = sc.nextInt();
            System.out.print("Introduzca Año: ");
            aa = sc.nextInt();

            //Si la fecha introducida es  0/0/0 sale del bucle.
            if ((dd == 0) && (mm == 0) && (aa == 0)) {
                return;
            }

            //Asicgna la fecha al objeto DiaSiguiente y comprueba el dd siguiente.
            fecha.asigna(dd, mm, aa);
            resu = fecha.comprueba();
            switch (resu) {
                case 0:
                    fecha.calcula();
                    System.out.print("Dia: " + fecha.dds);
                    System.out.print("  Mes: " + fecha.mms);
                    System.out.print("  Año: " + fecha.aas);
                    break;
                case 1:
                    System.out.print("Error en el día");
                    break;
                case 2:
                    System.out.print("Error en el mes");
                    break;
                case 3:
                    System.out.print("Error en el año");
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }

}
