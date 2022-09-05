public class Repository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;

    }

    public void add(Product product) {
        Product[] newProduct = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            newProduct[i] = products[i];
        }
        newProduct[newProduct.length - 1] = product;
        products = newProduct;

    }


    public void remove(int id) {
        Product[] removeProduct = new Product[products.length - 1];
        int removeId = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                removeProduct[removeId] = product;
                removeId++;
            }
        }
        products = removeProduct;

    }
}

