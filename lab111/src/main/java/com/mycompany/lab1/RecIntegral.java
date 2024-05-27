/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;

import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Василий
 */
public class RecIntegral {
    private static LinkedList list = new LinkedList(); 
    
    private static int countRow = 0;
    
    // Считывание записи из таблицы
    public static void WritingRecordFromATable(DefaultTableModel table) throws MyException 
    {
        countRow = 0;

        for (int i = 0; i < table.getRowCount(); i++)
        {     
            double num = 0;
            
            if (Double.parseDouble(table.getValueAt(i, 3).toString()) > 1000000 ||
                Double.parseDouble(table.getValueAt(i, 3).toString()) < 0.000001)
                throw new MyException("Out of range..."); 
            //if (Double.parseDouble(table.getValueAt(i,3).toString())> Double.parseDouble(table.getValueAt(i, 3).toString())))
             //   throw new MyException("FirstStep is higher than FinalStep");
            
            if (table.getValueAt(i, 3) == null)
                num = 0;
            else
                num = Double.parseDouble(table.getValueAt(i, 3).toString());
                
            list.add(new Object[] {table.getValueAt(i, 0),
                                  table.getValueAt(i, 1),
                                  table.getValueAt(i, 2),
                                  num});      
        }
        
        //table.setRowCount(0);
    }
    
    // Запись данных в таблицу
    public static int PrintDataInTable(DefaultTableModel table, int countElemInTable)
    {   
        for (Object item : list)
        {
            table.insertRow(countElemInTable, (Object[]) item);
            countElemInTable++;
        }   
        
        return countElemInTable;
    }
}
