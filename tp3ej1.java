import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tp3ej1 extends JFrame {

    @SuppressWarnings("FieldMayBeFinal")
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    @SuppressWarnings("FieldMayBeFinal")
    private JButton btnIngresar;
    private JButton btnVer;

    @SuppressWarnings("Convert2Lambda")
    public tp3ej1() {
        setTitle("Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblEmail = new JLabel("Usuario:");
        JLabel lblPassword = new JLabel("Contraseña:");

        txtEmail = new JTextField();
        txtPassword = new JPasswordField();

        btnIngresar = new JButton("Ingresar");
        btnVer = new JButton("Ver");

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });

        btnVer.addActionListener(new ActionListener() {
            private boolean mostrando = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mostrando) {
                    txtPassword.setEchoChar('•');
                    btnVer.setText("Ver");
                    mostrando = false;
                } else {
                    txtPassword.setEchoChar((char) 0);
                    btnVer.setText("Ocultar");
                    mostrando = true;
                }
            }
        });

        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnIngresar);
        panel.add(btnVer);

        add(panel);
    }
     private void validarLogin() {
        String email = txtEmail.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        if (email.equals("alumno@ulp.edu.ar") && password.equals("12345678")) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + email);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos");
        }
    }

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new tp3ej1().setVisible(true);
            }
        });
    }
}