
package midpractice23;


public class CartItem {
   private  String productName;
    private int unitPrice,  vatRate, quantity;
   private  float vatAmount, totalAmount;

    @Override
    public String toString() {
        return "CartItem{" + "productName=" + productName + ", unitPrice=" + unitPrice + ", vatRate=" + vatRate + ", quantity=" + quantity + ", vatAmount=" + vatAmount + ", totalAmount=" + totalAmount + '}';
    }

    public CartItem() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(float vatAmount) {
        this.vatAmount = vatAmount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public CartItem(String productName, int unitPrice, int vatRate, int quantity, float vatAmount, float totalAmount) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.vatRate = vatRate;
        this.quantity = quantity;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
    }
}
