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

    @Test
    public void labReportSnippet1() throws IOException {

        Path fileName = Path.of("C:\\Users\\AJCag\\Documents\\GitHub\\markdown-parser\\test-file-LR1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("url.com", "`google.com", "google.com", "ucsd.edu"), links);
    }

    @Test
    public void labReportSnippet2() throws IOException {

        Path fileName = Path.of("C:\\Users\\AJCag\\Documents\\GitHub\\markdown-parser\\test-file-LR2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("a.com((", "example.com"), links);
    }

    @Test
    public void labReportSnippet3() throws IOException {

        Path fileName = Path.of("C:\\Users\\AJCag\\Documents\\GitHub\\markdown-parser\\test-file-LR3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule"), links);
    }
}