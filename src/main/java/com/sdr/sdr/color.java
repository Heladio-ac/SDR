/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdr.sdr;




import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;

public class color extends DefaultTableCellRenderer {

    private final int columna_patron;

    public color(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        Font font = new Font("Courier", Font.BOLD, 16);
        switch (table.getValueAt(row, columna_patron).toString()) {
            
            case "Reponer":
                setBackground(Color.RED);
                setForeground(Color.WHITE);
                
                break;
            case "Suficiente":
                setBackground(Color.green);
                setForeground(Color.black);
                break;
            case "Sin Informacion":
            setBackground(Color.ORANGE);
            setForeground(Color.black);
                break;
            default:
                break;
        }
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;
    }

}

