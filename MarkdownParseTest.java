import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void linkTester() throws IOException {

        //MarkdownParse firstTest = new MarkdownParse();
        //assertEquals("Test getLinks file 1", "[https://something.com, some-thing.html]", firstTest.getLinks("test-file.md"));

        //MarkdownParse secondTest = new MarkdownParse();
        Path fileName = Path.of("C:\\Users\\AJCag\\Documents\\GitHub\\markdown-parser\\test-file2.md");
        String content2 = Files.readString(fileName);
        ArrayList<String> links2 = MarkdownParse.getLinks(content2);
        assertEquals(List.of("https://something.com", "some-page.html"), links2);
    }
}