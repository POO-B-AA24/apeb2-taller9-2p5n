import java.util.Scanner;
public class Problema_3_SistemasDeMensajes {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        SistemaMensajes sistemaMensajes = new SistemaMensajes();
        System.out.print("Ingrese el remitente: ");
        String remitente = tc.next();
        System.out.print("Ingrese el numero de telefono del remitente: ");
        String numMovil = tc.next();
        System.out.print("Ingrese el numero del destinario");
        String numDestinatario = tc.next();
        System.out.print("Ingrese el nombre del destinario");
        String destinario = tc.next();
        System.out.println("Que desea enviar: ");
        System.out.println("1) SMS");
        System.out.println("2) MMS");
        int opcion1 = tc.nextInt();
        switch (opcion1) {
            case 1:
                System.out.println("Ingrese el mensaje");
                String SMS = tc.next();
                sistemaMensajes.enviarMensaje(remitente, numMovil, SMS, numDestinatario, destinario, opcion1);
                System.out.println("Mensaje enviado (SMS) enviado a: " + destinario + " \nMensaje: " + SMS);
                break;
            case 2:
                System.out.println("Ingrese el mensaje");
                String MMS = tc.next();
                sistemaMensajes.enviarMensaje(remitente, numMovil, MMS, numDestinatario, destinario, opcion1);
                System.out.println("Mensaje enviado (MMS) enviado a: " + destinario + " \nMensaje: " + MMS);
                break;
            default:
                System.out.println("Error en el numero ");
                break;
        }
    }
}
class SistemaMensajes {
    public void enviarMensaje(String remitente, String numMovil, String datos, String numDestinatario, String destinario, int opcion1) {
        Mensaje mensaje = new Mensaje(remitente, destinario, numMovil, numDestinatario);
        String datosMensaje = mensaje.toString();
        if (opcion1 == 1) {
            SMS sms = new SMS(datos, datosMensaje);
        }
        if (opcion1 == 2) {
            MMS mms = new MMS(datos, datosMensaje);
        }
    }
    public String visualizarMensaje(String datosMensaje) {
        return datosMensaje;
    }
}
class Mensaje {
    public String remitente;
    public String destinario;
    public String numMovil;
    public String numDestinatario;
    public Mensaje(String remitente, String destinario, String numMovil, String numDestinatario) {
        this.remitente = remitente;
        this.destinario = destinario;
        this.numMovil = numMovil;
        this.numDestinatario = numDestinatario;
    }
    public Mensaje() {
    }
    @Override
    public String toString() {
        return "Mensaje{" + "reminente=" + remitente + ", destinario=" + destinario + ", numMovil=" + numMovil + ", numDestinatario=" + numDestinatario + '}';
    }
}
class SMS extends Mensaje {
    public String caracteres;
    public String datos;
    public SMS(String caracteres, String datos) {
        this.caracteres = caracteres;
        this.datos = datos;
    }
    @Override
    public String toString() {
        return super.toString() + " SMS{ " + datos + " caracteresMensaje=" + caracteres + "}\n";
    }
}
class MMS extends Mensaje {
    public String infoMMS;
    public String datos;
    public MMS(String infoMMS, String datos) {
        this.infoMMS = infoMMS;
        this.datos = datos;
    }
    @Override
    public String toString() {
        return super.toString() + " MMS{" + datos + "nombreFichero=" + infoMMS + "}\n";
    }
}