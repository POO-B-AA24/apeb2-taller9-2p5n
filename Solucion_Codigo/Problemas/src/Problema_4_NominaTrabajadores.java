import java.util.ArrayList;
public class Problema_4_NominaTrabajadores {
    public static void main(String[] args) {
        Gerente g1 = new Gerente("Jesus", "La tebaida", "12");
        Gerente g2 = new Gerente("Juan", "Av. Urdaneta", "09");
        EmpleadoMensual em1 = new EmpleadoMensual(g1, "Gabriela", "Los proceres", "01");
        EmpleadoComision ec1 = new EmpleadoComision(g2, 29, "Alfredo", "Belensate", "29");
        EmpleadoPorHoras eh1 = new EmpleadoPorHoras(g1, 12, "Pedro", "Amable maria", "30");
        RegistroPersonal registro = new RegistroPersonal();
        registro.agregarEmpleado(g1);
        registro.agregarEmpleado(g2);
        registro.agregarEmpleado(em1);
        registro.agregarEmpleado(ec1);
        registro.agregarEmpleado(eh1);
        registro.calcularSalarios();
        registro.eliminarEmpleado("01");
        System.out.println(registro.imprimir());
    }
}
class RegistroPersonal {
    public ArrayList<Empleado> empleados = new ArrayList<>();
    
    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }   
    public void eliminarEmpleado(String id) {
        int indiceEliminar = -1;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId().equalsIgnoreCase(id)) {
                indiceEliminar = i;
                break;
            }
        }
        if (indiceEliminar != -1) {
            empleados.remove(indiceEliminar);
        }
    }
    public void calcularSalarios() {
        for (Empleado e : empleados) {
            e.calcularSalario();
        }
    }
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Personal:\n");
        for (Empleado e : empleados) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }
}
class Empleado {
    public String nombre, direccion, id;
    public double salario;   
    public Empleado(String nombre, String direccion, String id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.id = id;
    }
    public void calcularSalario() {}
    public String getNombre() {
        return nombre;
    }
    public String getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Dirección: " + direccion + ", ID: " + id + ", Salario: " + salario;
    }
}
class EmpleadoMensual extends Empleado {
    public Gerente gerente;   
    public EmpleadoMensual(Gerente gerente, String nombre, String direccion, String id) {
        super(nombre, direccion, id);
        this.gerente = gerente;
    }
    @Override
    public void calcularSalario() {
        salario = 1000; // Salario mensual para empleados mensuales
    }
    @Override
    public String toString() {
        return super.toString() + ", Gerente: " + gerente.getNombre();
    }
}
class EmpleadoComision extends Empleado {
    public Gerente gerente;
    public int ventas;
    public EmpleadoComision(Gerente gerente, int ventas, String nombre, String direccion, String id) {
        super(nombre, direccion, id);
        this.gerente = gerente;
        this.ventas = ventas;
    }
    @Override
    public void calcularSalario() {
        salario = ventas * 100 * 0.25; // Salario basado en comisión
    }
    @Override
    public String toString() {
        return super.toString() + ", Gerente: " + gerente.getNombre() + ", Ventas: " + ventas;
    }
}
class EmpleadoPorHoras extends Empleado {
    public Gerente gerente;
    public int horasTrabajadas;
    public EmpleadoPorHoras(Gerente gerente, int horasTrabajadas, String nombre, String direccion, String id) {
        super(nombre, direccion, id);
        this.gerente = gerente;
        this.horasTrabajadas = horasTrabajadas;
    }
    @Override
    public void calcularSalario() {
        salario = horasTrabajadas * 20; // Salario por horas trabajadas
    }
    @Override
    public String toString() {
        return super.toString() + ", Gerente: " + gerente.getNombre() + ", Horas Trabajadas: " + horasTrabajadas;
    }
}
class Gerente extends Empleado {
    public Gerente(String nombre, String direccion, String id) {
        super(nombre, direccion, id);
    }   
    @Override
    public void calcularSalario() {
        salario = 3000; // Salario base para gerentes
    }
}