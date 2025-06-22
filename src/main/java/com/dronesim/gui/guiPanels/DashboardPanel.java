package com.dronesim.gui.guiPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.dronesim.api.model.Drone;
import com.dronesim.api.model.DroneDynamics;
import com.dronesim.api.model.DroneOverview;
import com.dronesim.api.model.DroneType;

public class DashboardPanel extends JPanel {
    private JTextField searchField;
    private JPanel droneGridPanel;
    private JPanel chartPanel;

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

    public void updateDashboard(List<DroneOverview> drones) {
        droneGridPanel.removeAll();

        for (DroneOverview d : drones) {
            JPanel card = createDroneCard(d);
            droneGridPanel.add(card);
        }

        droneGridPanel.revalidate();
        droneGridPanel.repaint();
    }

    private JPanel createDroneCard(DroneOverview d) {
        Drone base = d.getDrone();
        DroneType type = d.getType();
        DroneDynamics dyn = d.getDynamics();


        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(10, 10, 10, 10) 
        ));

        card.add(new JLabel("Model: " + base.getDronetype()));
        //card.add(new JLabel("Status: " + drone.getStatus()));
        card.add(new JLabel("Battery: " + type.getBattery_capacity() + "%"));
        card.add(new JLabel("Speed: " + dyn.getSpeed() + " km/h"));
        card.add(new JLabel("Top Speed: " + type.getMax_speed() + " km/h"));
        card.add(new JLabel("Type: " + base.getCarriage_type()));
        card.add(new JLabel("Serial: " + base.getSerialNumber()));

        return card;

    }
    
}
