package TestLab3;

import Lab3.Repository;
import Lab3.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ServiceNormTest {

    @Test
    void getStuffWithLengthLessThanFive() {
        Repository repository = new Repository();
        Service service = new Service(repository);

        List<String> stuff = service.getStuffWithLengthLessThanFive();

        // Validate the response
        Assertions.assertNotNull(stuff);
        Assertions.assertEquals(2, stuff.size());
    }




}