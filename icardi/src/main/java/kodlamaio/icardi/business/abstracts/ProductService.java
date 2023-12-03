package kodlamaio.icardi.business.abstracts;


import kodlamaio.icardi.core.utilities.results.DataResult;
import kodlamaio.icardi.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;


import javax.xml.transform.Result;
import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo,int pageSize);
    DataResult<List<Product>> getAllSorted();

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);


}
