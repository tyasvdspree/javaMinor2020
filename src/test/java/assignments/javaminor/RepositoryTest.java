package assignments.javaminor;

import assignments.javaminor.service.DefaultStringService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CrudRepository.class, DefaultStringService.class})
public class RepositoryTest {

    @InjectMocks
    CrudRepository crudRepositoryMock;

    @Test
    void emptyRepository(){
        assertEquals (true, crudRepositoryMock._knownText.isEmpty());
    }

    @Test
    void notEmptyRepository(){
        String text = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc consequat turpis sit amet purus 
varius tincidunt. Nunc interdum lorem leo, vel eleifend est vestibulum a. Nam sed maximus velit. Nulla eleifend elit
vitae nisi ornare, eu tristique augue tristique. Nulla sollicitudin consectetur neque, vestibulum molestie libero
consequat vitae. Nulla in placerat ipsum. Fusce at dui sed metus consectetur ullamcorper. Curabitur mollis pharetra ex,
in eleifend massa congue ut. Etiam in rhoncus ex.
""";
        int wordCount = 68;

        crudRepositoryMock.save(text, wordCount);

        assertEquals(false, crudRepositoryMock._knownText.isEmpty());
    }
}
