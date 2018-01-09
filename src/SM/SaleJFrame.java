package SM;

import javax.swing.JFrame;

import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class SaleJFrame extends JPanel implements ActionListener{
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
    JLabel discount = new JLabel("Discount");
    JTextField discount_txt = new JTextField();
    JLabel grandTotal = new JLabel("Grand Total");
    JTextField grandTotal_txt = new JTextField();
    
    Map strategies = new HashMap<String, String>();
    
    String[] PricingStrategy  = {"Senior Discount", "Eid Discout 100 Tk. Over 1000 Tk", "Best for Customer", "Best for Store"};
    JComboBox DDPricingStrategy = new JComboBox(PricingStrategy);
    JButton calculateDiscount = new JButton("Calculate Discount");
    
    int flag = 0;
    JTable table;
    DefaultTableModel model;
    
    ProcessSaleContraller psc = new ProcessSaleContraller();
    
    
    public SaleJFrame(){
        model = new DefaultTableModel();
        model.addColumn("SL#");
        model.addColumn("Item Name");
        model.addColumn("Unit Price");
        model.addColumn("Quantity");
        model.addColumn("Sub Total");
        
        table = new JTable(model) {
            @Override
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);
                int id = (int) getValueAt(rowIndex, 0);
                tip = "Manufacturer Name: "
                       + psc.getProductSpecification(id).getManufacturerName()
                       + ", Address: " 
                       + psc.getProductSpecification(id).getManufacturerAddress()
                       ;                 
                return tip;
            }          
        };  
        
    }
    
    public void gui(){
        DDPricingStrategy.setSelectedIndex(3);
        
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
        discount.setBounds(425, 430, 100, 25);
        discount_txt.setBounds(500, 430, 100, 25);
        grandTotal.setBounds(425, 460, 100, 25);
        grandTotal_txt.setBounds(500, 460, 100, 25);
        DDPricingStrategy.setBounds(100, 370, 150, 25);
        calculateDiscount.setBounds(100, 460, 150, 25);
        
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
        window.add(discount);
        window.add(discount_txt);
        window.add(grandTotal);
        window.add(grandTotal_txt);
        window.add(DDPricingStrategy);
        window.add(calculateDiscount);
               
        NewSale.addActionListener(this);
        AddItem.addActionListener(this);
        DDPricingStrategy.addActionListener(this);
        calculateDiscount.addActionListener(this);
        window.setLayout(null);
        window.setSize(800,600);
        window.setLocation(250,100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == NewSale){
            ItemId_txt.setText("");
            Quantity_txt.setText("");
            total_txt.setText("");
            vat_txt.setText("");
            discount_txt.setText("");
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
            
            if(psc.sale.sli.get(flag).getValidId() == false){
                psc.sale.sli.remove(flag);
                JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            else{ 
                total_txt.setText(Integer.toString(psc.sale.getPreDiscountTotal()));            
                
                model.addRow(new Object[]{
                    psc.getProductSpecification(iId).getId(), 
                    psc.getProductSpecification(iId).getName(), 
                    psc.getProductSpecification(iId).getPrice(), 
                    q, 
                    psc.sale.sli.get(flag).getSubTotal()
                });
                flag++;
            }
        }
        if(e.getSource() == calculateDiscount){            
            String strategy = (String)DDPricingStrategy.getSelectedItem();
            strategies.put("Senior Discount", "PercentageDiscountPricingStrategy");
            strategies.put("Eid Discout 100 Tk. Over 1000 Tk", "AbsoluteDiscountOverThresholdPricingStrategy");
            strategies.put("Best for Customer", "CompositeBestForCustomerPricingStrategy");
            strategies.put("Best for Store", "CompositeBestForStorePricingStrategy");
            psc.setPricingStrategy((String) strategies.get(strategy));
            vat_txt.setText(Integer.toString(psc.getVAT()));
            discount_txt.setText(Integer.toString(psc.getDiscount()));
            grandTotal_txt.setText(Integer.toString(psc.getTotalPrice()));
            new SaleFrame1().initialize(psc.sale);
            psc.setSaleTotal();
        }
    }
    public static void main(String[] args){
        SaleJFrame sjf = new SaleJFrame();
        sjf.gui();
    }
}
