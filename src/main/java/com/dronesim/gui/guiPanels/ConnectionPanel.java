package com.dronesim.gui.guiPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.List;

import com.dronesim.api.ApiClient;
import com.dronesim.api.ApiConfig;


public class ConnectionPanel extends JPanel {

    private final JLabel tokenLabel;
    private final JLabel urlLabel;

    private final JTextField tokenTxt;
    private final JTextField urlTxt;

    private final JButton connectBtn;

    private static final String CONFIG_FILE = "config.properties";
    private final Runnable onConnectSuccess;

    public ConnectionPanel(Runnable onConnectSuccess) {
        this.onConnectSuccess = onConnectSuccess;
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        tokenLabel = new JLabel("Token:");
        urlLabel = new JLabel("API Url:");
        tokenTxt = new JTextField(20);
        urlTxt = new JTextField(20);
        connectBtn = new JButton("Connect");

        loadProperties();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(tokenLabel, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(tokenTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(urlLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(urlTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(connectBtn, gbc);
    
        connectBtn.addActionListener((ActionEvent e) -> {
            
                String url = getUrl().trim();
                String token = getToken().trim();

                saveProperties(url, token);

                if(testConnection()) {
                    JOptionPane.showMessageDialog(this, 
                    "Verbindung erfolgreich!", 
                    "Erfolg", 
                    JOptionPane.INFORMATION_MESSAGE);
                    onConnectSuccess.run();
                } else {
                    JOptionPane.showMessageDialog(this, 
                    "Verbindung fehlgeschlagen. Prüfe URL oder Token.", 
                    "Fehler", 
                    JOptionPane.ERROR_MESSAGE);
                }
            
        });
    
    }

    private boolean testConnection() {
        try {
            String url = getUrl().trim();
            String token = getToken().trim();

            ApiConfig cfg = new ApiConfig(url, token);
            ApiClient api = new ApiClient(cfg);
            List<Drone> page = api.getDronesPage(1);
            return page != null && !page.isEmpty();
        } catch (Exception e) {
            System.err.println("API Fehler: " + e.getMessage());
            return false;
        }
    }

    private void loadProperties() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)){
            props.load(fis);
            urlTxt.setText(props.getProperty("api.baseUrl", ""));
            tokenTxt.setText(props.getProperty("api.token", ""));
        } catch (IOException e) {
            System.out.println("Keine bestehende config.properties gefunden - wird erstellt.");
        }
    }

    private void saveProperties(String url, String token) {
        Properties props = new Properties();
        props.setProperty("api.baseUrl", url);
        props.setProperty("api.token", token);
        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            props.store(fos, "API Configuration");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
            "Fehler beim Speichern der config.properties", 
            "Fehler", 
            JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getToken(){
        return tokenTxt.getText();
    }
    public String getUrl() {
        return urlTxt.getText();
    }
    public JButton getConnectBtn() {
        return connectBtn;
    }
}
