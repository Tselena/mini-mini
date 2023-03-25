package MiniMarket;

import MiniMarket.api.ProductService;
import MiniMarket.dto.Product;
import MiniMarket.utils.RetrofitUtils;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class ModifyProductTest {
    static ProductService productService;
    Product product = new Product(1, "Bread", 100,"Food");
    Faker faker = new Faker();
    int id;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }


    @Test
    void modifyProductTest() throws IOException {
        Response<Product> response = productService.modifyProduct(product)
                .execute();
        assertThat(response.message().concat("doesn't exist"), CoreMatchers.is("doesn't exist"));
    }

}
