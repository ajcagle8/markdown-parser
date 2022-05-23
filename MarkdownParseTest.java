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
        assertEquals(List.of("[a link](url.com)", "another link`", 
                            "cod[e", "code]"), links);
    }

    @Test
    public void labReportSnippet2() throws IOException {

        Path fileName = Path.of("C:\\Users\\AJCag\\Documents\\GitHub\\markdown-parser\\test-file-LR2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("[a nested link](b.com)", 
                            "a nested parenthesized url",
                            "some escaped [ brackets ]"), links);
    }

    @Test
    public void labReportSnippet3() throws IOException {

        Path fileName = Path.of("C:\\Users\\AJCag\\Documents\\GitHub\\markdown-parser\\test-file-LR3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("[this title text is really long and takes up more than one line",
                            "'\n'and has some line breaks]( https://www.twitter.com )",
                            "'\n'this title text is really long and takes up more than one line",
                            "'\n'[this link doesn't have a closing parenthesis](github.com",
                            "'\n'And there's still some more text after that.",
                            "'\n'[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/",
                            "'\n')",
                            "'\n'And then there's more text"), 
                            links);
    }
}