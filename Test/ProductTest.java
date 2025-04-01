import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("Example Product", "This is a description", "123", 29.99);
    }

    @Test
    void testGetCost() {
        assertEquals(29.99, product.getCost());
    }

    @Test
    void testSetCost() {
        product.setCost(39.99);
        assertEquals(39.99, product.getCost());
    }

    @Test
    void testGetID() {
        assertEquals("123", product.getID());
    }

    @Test
    void testSetID() {
        product.setID("456");
        assertEquals("456", product.getID());
    }

    @Test
    void testGetDescription() {
        assertEquals("This is a description", product.getDescription());
    }

    @Test
    void testSetDescription() {
        product.setDescription("New description");
        assertEquals("New description", product.getDescription());
    }

    @Test
    void testGetName() {
        assertEquals("Example Product", product.getName());
    }

    @Test
    void testSetName() {
        product.setName("New Product");
        assertEquals("New Product", product.getName());
    }

    @Test
    void testToString() {
        String expectedString = "Product{name='Example Product', description='This is a description', ID='123', cost=29.99}";
        assertEquals(expectedString, product.toString());
    }

    @Test
    void testEquals() {
        Product sameProduct = new Product("Example Product", "This is a description", "123", 29.99);
        Product differentProduct = new Product("Different Product", "Different description", "456", 39.99);

        assertEquals(product, sameProduct);
        assertNotEquals(product, differentProduct);
    }

    @Test
    void testHashCode() {
        Product sameProduct = new Product("Example Product", "This is a description", "123", 29.99);
        Product differentProduct = new Product("Different Product", "Different description", "456", 39.99);

        assertEquals(product.hashCode(), sameProduct.hashCode());
        assertNotEquals(product.hashCode(), differentProduct.hashCode());
    }
}