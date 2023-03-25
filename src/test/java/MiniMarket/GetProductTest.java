package MiniMarket;

import MiniMarket.api.ProductService;
import MiniMarket.dto.Product;
import MiniMarket.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductTest {
    static ProductService productService;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void getProductsTest() {
        Response<Product> response = productService.getProductById(1).execute();

        assertThat(response.message().concat("Unable to find product with id"), CoreMatchers.is("Unable to find product with id"));
    }
}
