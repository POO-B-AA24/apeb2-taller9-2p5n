import java.util.Scanner;
public class Problema_6_Banco {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        System.out.println("Ingrese el numero de cuenta: ");
        String numCuenta = tc.next();
        System.out.println("Ingrese su nombre: ");
        String nombre = tc.next();
        System.out.println("Tipo de cuenta: ");
        System.out.println("1) Ahorro");
        System.out.println("2) Cheque");
        System.out.println("3) Platino");
        int opcion = tc.nextInt();
        switch (opcion) {
            case 1:
                Ahorro cuentaAhorro = new Ahorro(numCuenta, nombre, 0);
                System.out.println("1) Deposito");
                System.out.println("2) Retirar");
                System.out.println("3) Balance");
                int opcion1 = tc.nextInt();
                switch (opcion1) {
                    case 1:
                        System.out.print("Inserte la cantidad a ingresar: ");
                        double dinero = tc.nextDouble();
                        cuentaAhorro.depositarDinero(dinero);
                        System.out.println("Se ha depositado en su cuenta " + numCuenta + " el monto de: " + dinero);
                        System.out.println("Su cuenta tiene un balance de: " + cuentaAhorro.obtenerBalance() + " con intereses de: " + cuentaAhorro.calcularInteres());
                        break;
                    case 2:
                        System.out.print("Inserte la cantidad a retirar: ");
                        double retiro = tc.nextDouble();
                        cuentaAhorro.retirarDinero(retiro);
                        System.out.println("Se ha retirado el monto de: " + retiro + " de su cuenta " + numCuenta);
                        System.out.println("Su cuenta tiene un balance de: " + cuentaAhorro.obtenerBalance() + " con intereses de: " + cuentaAhorro.calcularInteres());
                    case 3:
                        System.out.println("Balance de su cuenta " + numCuenta + " tiene: " + cuentaAhorro.balance + " con intereses: " + cuentaAhorro.calcularInteres());
                    default:
                        System.out.println("Numero erroneo. Saliendo...");
                }
                break;
            case 2:
                Cheque cuentaCheque = new Cheque(numCuenta, nombre, 0);
                System.out.println("1) Deposito");
                System.out.println("2) Retirar");
                System.out.println("3) Balance");
                int opcion2 = tc.nextInt();
                                switch (opcion2) {
                    case 1:
                        System.out.print("Inserte la cantidad a ingresar: ");
                        double dinero = tc.nextDouble();
                        cuentaCheque.depositarDinero(dinero);
                        System.out.println("Se ha depositado en su cuenta " + numCuenta + " el monto de: " + dinero);
                        System.out.println("Su cuenta tiene un balance de: " + cuentaCheque.obtenerBalance());
                        break;
                    case 2:
                        System.out.print("Inserte la cantidad a retirar: ");
                        double retiro = tc.nextDouble();
                        cuentaCheque.retirarDinero(retiro);
                        System.out.println("Se ha retirado el monto de: " + retiro + " de su cuenta " + numCuenta);
                        System.out.println("Su cuenta tiene un balance de: " + cuentaCheque.obtenerBalance());
                    case 3:
                        System.out.println("Balance de su cuenta " + numCuenta + " tiene: " + cuentaCheque.balance);
                    default:
                        System.out.println("Numero erroneo. Saliendo...");
                }
                break;
            case 3:
                Platino cuentaPlatino = new Platino(numCuenta, nombre, 0);
                                System.out.println("1) Deposito");
                System.out.println("2) Retirar");
                System.out.println("3) Balance");
                int opcion3 = tc.nextInt();
                switch (opcion3) {
                    case 1:
                        System.out.print("Inserte la cantidad a ingresar: ");
                        double dinero = tc.nextDouble();
                        cuentaPlatino.depositarDinero(dinero);
                        System.out.println("Se ha depositado en su cuenta " + numCuenta + " el monto de: " + dinero);
                        System.out.println("Su cuenta tiene un balance de: " + cuentaPlatino.obtenerBalance() + " con intereses de: " + cuentaPlatino.calcularInteres());
                        break;
                    case 2:
                        System.out.print("Inserte la cantidad a retirar: ");
                        double retiro = tc.nextDouble();
                        cuentaPlatino.retirarDinero(retiro);
                        System.out.println("Se ha retirado el monto de: " + retiro + " de su cuenta " + numCuenta);
                        System.out.println("Su cuenta tiene un balance de: " + cuentaPlatino.obtenerBalance() + " con intereses de: " + cuentaPlatino.calcularInteres());
                    case 3:
                        System.out.println("Balance de su cuenta " + numCuenta + " tiene: " + cuentaPlatino.balance + " con intereses: " + cuentaPlatino.calcularInteres());
                    default:
                        System.out.println("Numero erroneo. Saliendo...");
                }
                break;
            default:
                System.out.println("Numero incorrecto. Saliendo...");
                break;
        }
    }
}

class Cuenta {

    public String numCuenta;
    public String nombreCliente;
    public double balance;

    public Cuenta(String numCuenta, String nombreCliente, double balance) {
        this.numCuenta = numCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = balance;
    }

    public void depositarDinero(double deposito) {
        this.balance += deposito;
    }

    public void retirarDinero(double retiro) {
        this.balance -= retiro;
    }

    public double obtenerBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", nombreCliente=" + nombreCliente + ", balance=" + balance + '}';
    }

}

class Ahorro extends Cuenta {

    public double interes;
    public double balanceInteres;

    public Ahorro(String numCuenta, String nombreCliente, double balance) {
        super(numCuenta, nombreCliente, balance);
    }

    public double calcularInteres() {
        this.interes = this.balance * 0.05;
        return this.balanceInteres = this.balance + this.interes;
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo de cuenta: Ahorro{" + "interes=" + interes + ", balanceInteres=" + balanceInteres + '}';
    }
}

class Cheque extends Cuenta {

    public Cheque(String numCuenta, String nombreCliente, double balance) {
        super(numCuenta, nombreCliente, balance);
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo de cuenta: Cheque";
    }
}

class Platino extends Cuenta {

    public double interes;
    public double balanceInteres;

    public Platino(String numCuenta, String nombreCliente, double balance) {
        super(numCuenta, nombreCliente, balance);
    }

    public double calcularInteres() {
        this.interes = this.balance * 0.10;
        return this.balanceInteres = this.balance + this.interes;
    }

    @Override
    public String toString() {
        return super.toString() + "Platino{" + "interes=" + interes + ", balanceInteres=" + balanceInteres + '}';
    }

}
