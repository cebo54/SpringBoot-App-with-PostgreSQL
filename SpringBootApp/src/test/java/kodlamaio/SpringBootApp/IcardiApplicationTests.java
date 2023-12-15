package kodlamaio.SpringBootApp;




import kodlamaio.SpringBootApp.business.concretes.ProductManager;
import kodlamaio.SpringBootApp.core.utilities.results.SuccessResult;
import kodlamaio.SpringBootApp.dataAccess.abstracts.ProductDao;
import kodlamaio.SpringBootApp.entities.concretes.Category;
import kodlamaio.SpringBootApp.entities.concretes.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class IcardiApplicationTests {
	@InjectMocks
	private ProductManager productManager;
	@Mock
	private ProductDao productDao;
	@Mock
	private SuccessResult res;

	@Test
	public void AddTest() {
		Category category =new Category();
		Product product =new Product();
		product.setProductName("test-name");
		product.setUnitPrice(5);
		product.setUnitsInStock((short) 5);
		product.setQuantityPerUnit("test-quantity");
		category.setCategoryId(1);
		Product productMock = Mockito.mock(Product.class);

		Mockito.when(productMock.getId()).thenReturn(1);
		Mockito.when(productDao.save(ArgumentMatchers.any(Product.class))).thenReturn(productMock);
		SuccessResult result = (SuccessResult) productManager.add(product);

		Assertions.assertEquals("test-name",product.getProductName());
		Assertions.assertEquals(1,product.getId());



	}

}
