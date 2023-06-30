import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ventanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JTextField cuadroNombre, cuadroNumero;
    private JLabel numero, nombre;
    private JButton botonCrear, botonBuscar, botonActualizar, botonEliminar;
    private JTextArea cuadroTexto;

    public ventanaPrincipal() {
        inicio();
        setTitle("Actividad 6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nombre = new JLabel("Nombre:");
        nombre.setBounds(20, 20, 50, 30);
        cuadroNombre = new JTextField();
        cuadroNombre.setBounds(90, 23, 135, 23);

        numero = new JLabel("Numero:");
        numero.setBounds(20, 50, 50, 30);
        cuadroNumero = new JTextField();
        cuadroNumero.setBounds(90, 53, 135, 23);

        botonCrear = new JButton();
        botonCrear.setText("Crear");
        botonCrear.setBounds(30, 90, 90, 23);

        botonBuscar = new JButton();
        botonBuscar.setText("Buscar");
        botonBuscar.setBounds(130, 90, 90, 23);

        botonActualizar = new JButton();
        botonActualizar.setText("Actualizar");
        botonActualizar.setBounds(230, 90, 90, 23);

        botonEliminar = new JButton();
        botonEliminar.setText("Eliminar");
        botonEliminar.setBounds(330, 90, 90, 23);

        cuadroTexto = new JTextArea();
        cuadroTexto.setBounds(20, 130, 400, 200);
        cuadroTexto.setEditable(false);

        contenedor.add(nombre);
        contenedor.add(cuadroNombre);
        contenedor.add(numero);
        contenedor.add(cuadroNumero);
        contenedor.add(botonCrear);
        contenedor.add(botonBuscar);
        contenedor.add(botonActualizar);
        contenedor.add(botonEliminar);
        contenedor.add(cuadroTexto);

        botonCrear.addActionListener(this);
        botonBuscar.addActionListener(this);
        botonActualizar.addActionListener(this);
        botonEliminar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCrear) {
            String name = cuadroNombre.getText();
            String number = cuadroNumero.getText();
            Crear.crearRegistro(name, number);
            mostrarRegistros();
        } else if (e.getSource() == botonBuscar) {
            String name = cuadroNombre.getText();
            Buscar.buscarRegistro(name);
        } else if (e.getSource() == botonActualizar) {
            String name = cuadroNombre.getText();
            String number = cuadroNumero.getText();
            Actualizar.actualizarRegistro(name, number);
            mostrarRegistros();
        } else if (e.getSource() == botonEliminar) {
            String name = cuadroNombre.getText();
            String number = cuadroNumero.getText();
            Eliminar.eliminarRegistro(name, number);
            mostrarRegistros();
        }
    }

    private void mostrarRegistros() {
        cuadroTexto.setText("");
        String[][] registros = baseDeDatos.getRegistros();
        for (String[] registro : registros) {
            cuadroTexto.append("Nombre: " + registro[0] + "\n");
            cuadroTexto.append("Número: " + registro[1] + "\n\n");
        }
    }
}


