package SM;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SaleFrame1 extends JFrame implements PropertyListener{
    public SaleFrame1(){
        
    }
    @Override
    public void onPropertyEvent(Sale source, String name, int value) {
        if(name.equals("sale.total")){
            setTitle("Sale Total");
            setVisible(true);
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sale Total " + value, "", JOptionPane.PLAIN_MESSAGE);
            //saleTextField.setText(value.toString());
        }
            
    }
    public void initialize(Sale sale){
        sale.addPropertyListener(this);
    }
    
}
