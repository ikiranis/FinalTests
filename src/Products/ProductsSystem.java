// Άσκηση 2, Επαναληπτικές 2020

package Products;

import java.util.ArrayList;

class Product {
    private double unitPrice;
    private int discountRate;

    public Product(double unitPrice, int discountRate) throws Exception {
        if (discountRate < 0 || discountRate > 100) {
            throw new Exception("Discount out of limit");
        }

        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public double getTotalPrice() {
        return unitPrice - ((unitPrice  * discountRate) / 100);
    }

    @Override
    public String toString() {
        return "Product{" +
                "unitPrice=" + unitPrice +
                ", discountRate=" + discountRate +
                '}';
    }
}

class ProductList {
    private ArrayList<Product> products;

    public ProductList() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double total() {
        double sum = 0.0;

        for (Product product : products) {
            System.out.println(product.getTotalPrice());
            sum += product.getTotalPrice();
        }

        return sum;
    }
}

public class ProductsSystem {
    public static void main(String[] args) {
        try {
            Product p1 = new Product(239.50, 101);
            Product p2 = new Product(160.40, 5);

            ProductList productList = new ProductList();
            productList.addProduct(p1);
            productList.addProduct(p2);

            System.out.println(p1);
            System.out.println(p2);
            System.out.println("Η συνολική αξία είναι: " + productList.total());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
