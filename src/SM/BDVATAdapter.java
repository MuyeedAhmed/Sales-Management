package SM;

public class BDVATAdapter implements IVATCalculator{
    BDVATCalculator bdv = new BDVATCalculator();
    @Override
    public int getVATAmount(int saleTotal){
        return (int) Math.round(bdv.calculateVATAmount(saleTotal));
    }
}
