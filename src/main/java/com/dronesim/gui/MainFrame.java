package com.dronesim.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.dronesim.gui.guiPanels.CatalogPanel;
import com.dronesim.gui.guiPanels.ConnectionPanel;
import com.dronesim.gui.guiPanels.DashboardPanel;
import com.dronesim.gui.guiPanels.DynamicsPanel;

public class MainFrame extends JFrame{
    private final JTabbedPane tabbedPane;
    private final CatalogPanel catalogP;
    private final DashboardPanel dashboardP;
    private final DynamicsPanel dynamicsP;

    public MainFrame() {
        this.setTitle("Drone");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        catalogP = new CatalogPanel();
        dashboardP = new DashboardPanel();
        dynamicsP = new DynamicsPanel();
        
        ConnectionPanel connectionP = new ConnectionPanel(this::onConnected);

        tabbedPane.addTab("Connection", connectionP);
        tabbedPane.addTab("Drone catalog", catalogP);
        tabbedPane.addTab("Dashboard", dashboardP);
        tabbedPane.addTab("Flight dynamics", dynamicsP);

        tabbedPane.setEnabledAt(1, false);
        tabbedPane.setEnabledAt(2, false);
        tabbedPane.setEnabledAt(3, false);

        this.add(tabbedPane);
        this.setVisible(true);
    }

    private void onConnected() {
        tabbedPane.setEnabledAt(1, true);
        tabbedPane.setEnabledAt(2, true);
        tabbedPane.setEnabledAt(3, true);
        tabbedPane.setSelectedIndex(2);
    }
}
