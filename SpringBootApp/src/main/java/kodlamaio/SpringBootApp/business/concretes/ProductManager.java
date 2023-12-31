package kodlamaio.SpringBootApp.business.concretes;

import kodlamaio.SpringBootApp.business.abstracts.ProductService;
import kodlamaio.SpringBootApp.core.utilities.results.DataResult;
import kodlamaio.SpringBootApp.core.utilities.results.SuccessDataResult;
import kodlamaio.SpringBootApp.core.utilities.results.SuccessResult;
import kodlamaio.SpringBootApp.dataAccess.abstracts.ProductDao;
import kodlamaio.SpringBootApp.entities.concretes.Product;
import kodlamaio.SpringBootApp.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;
    @Autowired
    public ProductManager(ProductDao productDao){

        this.productDao=productDao;
    }
    @Override
    public DataResult<List<Product>> getAll() {

        return new SuccessDataResult<List<Product>>
                ( this.productDao.findAll(),"Data listelendi");

    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort=Sort.by(Sort.Direction.ASC,"productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort));
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return (Result) new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                ( this.productDao.getByProductName(productName),"Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                ( this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByCategoryIn(categories),"Data listelendi");
    }



    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameContains(productName),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getProductWithCategoryDetails(),"Data Listelendi");
    }
}
