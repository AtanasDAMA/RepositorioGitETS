package diasiguiente;

/**
 * Objeto DiaSiguiente que almacena una fecha y calcula la siguiente.
 *
 * @author Atanas Todorov Todorov
 */
public class DiaSiguiente {

    /**
     * Numero entero del dd introducido por el usuario.
     */
    public int dd;
    /**
     * Numero entero del mes introducido por el usuario.
     */
    public int mm;
    /**
     * Numero entero del año introducido por el usuario.
     */
    public int aa;
    /**
     * Numero entero del calculo del dd siguiente introducido por el usuario.
     */
    public int dds;
    /**
     * Numero entero del calculo del dd siguiente introducido por el usuario.
     */
    public int mms;
    /**
     * Numero entero del calculo del dd siguiente introducido por el usuario.
     */
    public int aas;
    /**
     * Numero entero del numero de dias que tiene el mes introducido por el
     * usuario.
     */
    int dias;

    /**
     * Constructor de la clase DiaSiguiente que establece todos los atributos a
     * 0.
     */
    public DiaSiguiente() {
        dd = 0;
        mm = 0;
        aa = 0;
        dds = 0;
        mms = 0;
        aas = 0;
        dias = 0;
    }

    /**
     * Inserta una fecha en la clase DiaSiguiente.
     *
     * @param d Numero entero del dd a insertar.
     * @param m Numero entero del mes a insertar.
     * @param a Numero entero del año a insertar.
     */
    public void asigna(int d, int m, int a) {
        dd = d;
        mm = m;
        aa = a;
    }

    /**
     * Calcula la fecha siguiente de la fecha introducida mediante el metodo
     * {@link #asigna(int, int, int)} haciendo uso del metodo
     * {@link #bisiesto()} para comprobar si el año es bisiesto.
     */
    public void calcula() {
        dds = dd + 1;
        mms = mm;
        aas = aa;
        switch (mm) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dias = 31;
                break;
            case 2:
                if (bisiesto()) {
                    dias = 29;
                } else {
                    dias = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dias = 30;
                break;
        }

        //Si el dd es superior al maximo de dias en el mes cambia de mes y de año si es necesario.
        if (dds > dias) {
            dds = 1;
            if (mms == 12) {
                mms = 1;
                aas++;
            } else {
                mms++;
            }
        }
    }

    /**
     * Calcula si el año introducido mediante {@link #asigna(int, int, int)} es
     * bisiesto o no y devuelve un booleano.
     *
     * @return Devuelve un booleano true si el año es bisiesto y false si no.
     */
    public Boolean bisiesto() {
        if ((aa % 4 == 0) && (aa % 100 != 0) || (aa % 400 == 0)) {
            return (true);
        } else {
            return (false);
        }
    }

    /**
     * Comprueba que la fecha introducida mediante
     * {@link #asigna(int, int, int)} es una fecha valida, haciendo uso del
     * metodo {@link #bisiesto()} para comprobar si el año es bisiesto.
     *
     * @return Devuelve un entero: 0- Si la fecha es correcta, 1- Si el dd
 introduciodo es incorrecto, 2- Si el mes introducido es incorrecto, 3- Si
 el año introducido es inferior a 1900 o superior a 2100.
     */
    public int comprueba() {
        int valor = 0;
        int ddmax = 0;
        switch (mm) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                ddmax = 31;
                break;
            case 2:
                if (bisiesto()) {
                    ddmax = 29;
                } else {
                    ddmax = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                ddmax = 30;
                break;
            default:
                valor = 2;
                return (valor);
        }
        if (dd < 1 || dd > ddmax) {
            valor = 1;
        }
        if (aa < 1900 || aa > 2100) {
            valor = 3;
        }
        return (valor);
    }

}
