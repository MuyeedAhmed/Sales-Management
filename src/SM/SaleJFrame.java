package SM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class SaleJFrame implements ActionListener{
    JFrame window = new JFrame("Sale Management");

    JButton NewSale = new JButton("New Sale");
    JLabel ItemId = new JLabel("Item ID");
    JTextField ItemId_txt = new JTextField();
    JLabel Quantity = new JLabel("Quantity");
    JTextField Quantity_txt = new JTextField();
    JButton AddItem = new JButton("Add Item");
    JLabel total = new JLabel("Total");
    JTextField total_txt = new JTextField();
    JLabel vat = new JLabel("VAT");
    JTextField vat_txt = new JTextField();
    JLabel grandTotal = new JLabel("Grand Total");
    JTextField grandTotal_txt = new JTextField();
    
    int flag = 0;
    JTable table;
    DefaultTableModel model;
    
    ProcessSaleContraller psc = new ProcessSaleContraller();
    Vector <SalesLineItem> sli = new Vector <SalesLineItem>(10);
    
    public SaleJFrame(){
        model = new DefaultTableModel();
        model.addColumn("SL#");
        model.addColumn("Item Name");
        model.addColumn("Unit Price");
        model.addColumn("Quantity");
        model.addColumn("Sub Total");
        table = new JTable(model);
                
    }
    public void gui(){
        NewSale.setBounds(100, 25, 100, 25);
        ItemId.setBounds(25, 75, 100, 25);
        ItemId_txt.setBounds(100, 75, 200, 25);
        Quantity.setBounds(25, 125, 100, 25);
        Quantity_txt.setBounds(100, 125, 200, 25);
        AddItem.setBounds(100, 175, 100, 25);
        table.getTableHeader().setBounds(100, 225, 500, 25);
        table.setBounds(100, 250, 500, 115);
        total.setBounds(425, 370, 100, 25);
        total_txt.setBounds(500, 370, 100, 25);
        vat.setBounds(425, 400, 100, 25);
        vat_txt.setBounds(500, 400, 100, 25);
        grandTotal.setBounds(425, 430, 100, 25);
        grandTotal_txt.setBounds(500, 430, 100, 25);
        
        
        window.add(NewSale);
        window.add(ItemId);
        window.add(ItemId_txt);
        window.add(Quantity);
        window.add(Quantity_txt);
        window.add(AddItem);
   
        table.setPreferredScrollableViewportSize(new Dimension(500, 115));
        table.setFillsViewportHeight(true);
        window.add(table.getTableHeader());
        window.add(table);
        window.add(total);
        window.add(total_txt);
        window.add(vat);
        window.add(vat_txt);
        window.add(grandTotal);
        window.add(grandTotal_txt);
        
        
        NewSale.addActionListener(this);
        AddItem.addActionListener(this);
        
        window.setLayout(null);
        window.setSize(800,600);
        window.setLocation(250,100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == NewSale){
            ItemId_txt.setText("");
            Quantity_txt.setText("");
            total_txt.setText("");
            vat_txt.setText("");
            grandTotal_txt.setText("");
            psc.makeNewSale();
            for(int i = 0; i<flag; i++)
                model.removeRow(0);
            flag = 0;   
        }
        if(e.getSource() == AddItem){
            
            int iId = Integer.parseInt(ItemId_txt.getText());
            int q = Integer.parseInt(Quantity_txt.getText());
            ItemId_txt.setText("");
            Quantity_txt.setText("");
            psc.addItem(iId, q);
            
            sli = psc.getSalesLineItemList();
            if(sli.get(flag).getValidId() == false){
                sli.remove(flag);
                JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.PLAIN_MESSAGE);
                
            }
            else{
                try {
                    ProductSpecification ps = new ProductSpecification();
                    
                    ps = psc.getProductSpecification(iId);
                    total_txt.setText(Integer.toString(psc.getTotalPrice()));
                    
                    vat_txt.setText(Integer.toString(psc.sale.getVATAmount()));
                    
                    grandTotal_txt.setText(Integer.toString(psc.sale.getGrandTotal()));
                    
                    model.addRow(new Object[]{ps.getId(), ps.getName(), ps.getPrice(), q, sli.get(flag).getSubTotal()});
                    flag++;
                } catch (Exception ex) {
                    Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }           
    }	
}

