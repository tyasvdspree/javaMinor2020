package assignments.javaminor;

import assignments.javaminor.service.DefaultStringService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CrudRepository.class, DefaultStringService.class})
class StringReversControllerTest {

    @Mock
    CrudRepository crudRepositoryMock;

    @InjectMocks
    DefaultStringService _stringService;

    @Test
    void reverse() {
        String expectedString = "legermeetsysteemregel";
        String inputString = "legermeetsysteemregel";

        String result = _stringService.reverse(inputString);

        assertEquals (expectedString, result);
    }

    @Test
    void failReverse(){
        String expectedString = "regen";
        String inputString = "regen";

        String result = _stringService.reverse(inputString);

        assertNotEquals (expectedString, result);
    }

    @Test
    void count() {

        when(crudRepositoryMock.find(ArgumentMatchers.anyString())).thenReturn(-1);

        String text = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc consequat turpis sit amet purus 
varius tincidunt. Nunc interdum lorem leo, vel eleifend est vestibulum a. Nam sed maximus velit. Nulla eleifend elit
vitae nisi ornare, eu tristique augue tristique. Nulla sollicitudin consectetur neque, vestibulum molestie libero
consequat vitae. Nulla in placerat ipsum. Fusce at dui sed metus consectetur ullamcorper. Curabitur mollis pharetra ex,
in eleifend massa congue ut. Etiam in rhoncus ex.
""";
        int expectedWordCount = 68;

        int wordCount = _stringService.count(text);

        assertEquals(expectedWordCount,wordCount);
    }
}