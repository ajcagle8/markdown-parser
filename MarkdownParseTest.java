import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void linkTester() {

        //MarkdownParse firstTest = new MarkdownParse();
        //assertEquals("Test getLinks file 1", "[https://something.com, some-thing.html]", firstTest.getLinks("test-file.md"));

        MarkdownParse secondTest = new MarkdownParse();

        assertEquals(List.of("https://github.com/ajcagle8/cse15l-lab-reports", "https://google.com", "tinyurl.com/lab3group4"), secondTest.getLinks("test-file2.md"));
    }
}