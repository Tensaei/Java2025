package com.dronesim.gui.guiPanels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.util.List;

import com.dronesim.api.model.*;

public class DashboardPanel extends JPanel {
    private final JTextField searchField;
    private final JPanel droneGridPanel;
    private final JPanel chartPanel;

    public DashboardPanel() {
        setLayout(new BorderLayout(15,15));
        setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        setupTopBar();
        setupMainArea();

    }

    private void setupTopBar() {
        JPanel topPanel = new JPanel(new BorderLayout());
        searchField = new JTextField("Search...");
        topPanel.add(searchField, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

    }

    private void setupMainArea() {
        droneGridPanel = new JPanel(new GridLayout(0, 3, 15, 15));
        JScrollPane scrollPane = new JScrollPane(droneGridPanel);
        scrollPane.setBorder(null);

        chartPanel = new JPanel();
        chartPanel.setPreferredSize(new Dimension(200, 200));
        chartPanel.setBorder(BorderFactory.createTitledBorder("Drone Status"));

        JPanel centerPanel = new JPanel(new BorderLayout(15, 15));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(chartPanel, BorderLayout.WEST);

        add(centerPanel, BorderLayout.CENTER);

    }

    public void updateDashboard(List<Drone> drones) {
        droneGridPanel.removeAll();

        for (Drone drone : drones) {
            JPanel card = createDroneCard(drone);
            droneGridPanel.add(card);
        }

        droneGridPanel.revalidate();
        droneGridPanel.repaint();
    }

    private JPanel createDroneCard(Drone drone) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(10, 10, 10, 10) 
        ));

        card.add(new JLabel("Model: " + drone.getModel()));
        card.add(new JLabel("Status: " + drone.getStatus()));
        card.add(new JLabel("Battery: " + drone.getBattery() + "%"));
        card.add(new JLabel("Speed: " + drone.getSpeed() + " km/h"));
        card.add(new JLabel("Top Speed: " + drone.getTopSpeed() + " km/h"));
        card.add(new JLabel("Type: " + drone.getType()));
        card.add(new JLabel("Serial: " + drone.getSerial()));

        return card;

    }
    
}
