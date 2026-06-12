package org.Kardex.jF.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.Kardex.jF.bean.entity.Cliente;
import org.Kardex.jF.model.ClienteModel;

public class ModificarClienteView extends JDialog implements Serializable {

	private static final long serialVersionUID = 1L;
	private JTextField Nombre;
	private JTextField Apellido;
	private JTextField Telefono;
	private JTextField Correo;
	private JTextField Ruc;
	private JTextField Direccion;
	private JTextField codigo;
	private JTextField TipoCliente;
	private ClienteModel dao = new ClienteModel();
	private String idCliente = null;
	
	
	public ModificarClienteView(JFrame parent) {
    	super(parent, "Modificar Clientes", true);
    	setTitle("Registro de Clientes");
        setSize(380, 420);
        setLayout(new BorderLayout());

        add(crearPanelCampos(), BorderLayout.CENTER);
        add(crearPanelBotones(), BorderLayout.SOUTH);
	}
	
	private JPanel crearPanelCampos() {
    	JPanel panel = new JPanel(new GridLayout(8,2,10,10));
    	panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
    	
        codigo = new JTextField();
        Nombre    = new JTextField();
        Apellido  = new JTextField();
        Telefono  = new JTextField();
        Correo    = new JTextField();
        Ruc       = new JTextField();
        Direccion = new JTextField();
        TipoCliente = new JTextField();
        
        // Panel botón buscar
        JPanel panelCodigo = new JPanel(new BorderLayout(5, 0));
        JButton btnBuscar = new JButton("Buscar");
        panelCodigo.add(codigo, BorderLayout.CENTER);
        panelCodigo.add(btnBuscar, BorderLayout.EAST);
        

        
        panel.add(new JLabel("Codigo: "));
        panel.add(panelCodigo);
        panel.add(new JLabel("Nombres: "));
        panel.add(Nombre);
        panel.add(new JLabel("Apellidos: "));
        panel.add(Apellido);
        panel.add(new JLabel("Telefono: "));
        panel.add(Telefono);
        panel.add(new JLabel("Correo: "));
        panel.add(Correo);
        panel.add(new JLabel("RUC: "));
        panel.add(Ruc);
        panel.add(new JLabel("Direccion: "));
        panel.add(Direccion);
        panel.add(new JLabel("Tipo de cliente: "));
        panel.add(TipoCliente);
        
        btnBuscar.addActionListener(e -> buscarCliente());
    	
    	return panel;
    }
	
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 8, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnGuardar  = new JButton("Guardar");

        panel.add(btnCancelar);
        panel.add(btnGuardar);
		btnGuardar.addActionListener(e -> guardar());
		btnCancelar.addActionListener(e -> limpiar());

        return panel;
    }
    
	private void buscarCliente() {
		Cliente c = dao.buscarPorCodigo(codigo.getText().trim());
		if (c == null) {
			JOptionPane.showMessageDialog(this, "Cliente no encontrado");
			return;
		}
		idCliente = c.getId();
		codigo.setText(c.getCodigo());
		Nombre.setText(c.getNombre());
		Apellido.setText(c.getApellido());

		Telefono.setText(String.valueOf(c.getTelefono()));
		Correo.setText(c.getCorreo());

		Direccion.setText(c.getDireccion());
		TipoCliente.setText(c.getTipoCliente());

		Ruc.setText(String.valueOf(c.getRUC()));
	}
	
	private void guardar() {
		if (idCliente == null) {
			JOptionPane.showMessageDialog(this, "Primero debe buscar un cliente");
			return;
		}
		Cliente c = new Cliente();

		c.setId(idCliente);
		c.setCodigo(codigo.getText().trim());

		c.setNombre(Nombre.getText().trim());
		c.setApellido(Apellido.getText().trim());

		if (!Telefono.getText().trim().isEmpty()) {
		    c.setTelefono(Integer.parseInt(Telefono.getText().trim()));
		}

		c.setCorreo(Correo.getText().trim());
		c.setDireccion(Direccion.getText().trim());
		c.setTipoCliente(TipoCliente.getText().trim());

		if (!Ruc.getText().trim().isEmpty()) {
		    c.setRUC(Integer.parseInt(Ruc.getText().trim()));
		}

		if (dao.actualizar(c)) {
		    JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente");
		    limpiar();
		} else {
		    JOptionPane.showMessageDialog(this, "Error al actualizar cliente");
		}
	}
	
	private void limpiar() {
		idCliente = null;

		codigo.setText("");
		Nombre.setText("");
		Apellido.setText("");
		Telefono.setText("");
		Correo.setText("");
		Direccion.setText("");
		TipoCliente.setText("");
		Ruc.setText("");

		codigo.requestFocus();
	}
    
    
	
}
