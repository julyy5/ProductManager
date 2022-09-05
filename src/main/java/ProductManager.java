public class ProductManager {
    // добавьте необходимые поля, конструкторы и методы
    private Repository repository;

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.add(product);
    }

    public Product[] remove(int id) {
        repository.remove(id);
        return findAll();
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp; // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }// метод определения соответствия товара product запросу search


}