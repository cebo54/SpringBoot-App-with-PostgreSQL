package kodlamaio.icardi.api.controllers;

import kodlamaio.icardi.business.abstracts.ProductService;
import kodlamaio.icardi.core.utilities.results.DataResult;
import kodlamaio.icardi.core.utilities.results.Result;
import kodlamaio.icardi.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService){

        this.productService=productService;
    }
    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){

        return this.productService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){

        return (Result)productService.add(product);
    }
    @GetMapping("/getByProductName")
    public DataResult<Product>getByProductName(@RequestParam String productName){
        return productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategory")
    public DataResult<Product>getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }
    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(String productName){
        return productService.getByProductNameContains(productName);
    }
    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(@RequestParam int pageNo,@RequestParam() int pageSize){
        return productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllAsc")
    public DataResult<List<Product>> getAllSorted(){

        return productService.getAllSorted();
    }
}
