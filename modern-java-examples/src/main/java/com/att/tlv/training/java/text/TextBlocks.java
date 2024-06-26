package com.att.tlv.training.java.text;

public class TextBlocks {
    // Regular strings:
    String html = "<html>\n" +
                  "    <body>\n" +
                  "        <p>Hello, world</p>\n" +
                  "    </body>\n" +
                  "</html>\n";

    // Text block
    String htmlTextBlock = """
            <html>
                <body>
                    <p>Hello, world</p>
                </body>
            </html>
            """;

    // Regular strings:
    String query = "SELECT \"EMP_ID\", \"LAST_NAME\" " +
                   "FROM \"EMPLOYEE_TB\"\n" +
                   "WHERE \"CITY\" = 'INDIANAPOLIS'\n" +
                   "ORDER BY \"EMP_ID\", \"LAST_NAME\";\n";

    // Text block
    String queryWithTextBlock = """
            SELECT "EMP_ID", "LAST_NAME"
            FROM "EMPLOYEE_TB"
            WHERE "CITY" = 'INDIANAPOLIS'
            ORDER BY "EMP_ID", "LAST_NAME";
            """;

    // A text block is a multi-line string literal that avoids the need for most escape sequences automatically
    // formats the string in a predictable way gives the developer control over the format when desired.
    // A text block is a new kind of literal in the Java language. It may be used to denote a string anywhere that a string literal could appear, but offers greater expressiveness and less accidental complexity.
    // A text block consists of zero or more content characters, enclosed by opening and closing delimiters.
    // The opening delimiter is a sequence of three double quote characters (""") followed by zero or more white spaces
    // followed by a line terminator. The content begins at the first character after the line terminator of the opening delimiter.
    // The closing delimiter is a sequence of three double quote characters.
    // The content ends at the last character before the first double quote of the closing delimiter.
    // Fat delimiters (""") were chosen so that " characters could appear unescaped, and also to visually distinguish
    // a text block from a string literal.

    // == "line 1\nline 2\nline 3\n"
    String textBlock = """
            line 1
            line 2
            line 3
            """;

    // == "line 1\nline 2\nline 3"
    String textBlockWithNoTrailingNewlineV1 = """
            line 1
            line 2
            line 3""";

    // == "line 1\nline 2\nline 3"
    String textBlockWithNoTrailingNewlineV2 = """
            line 1
            line 2
            line 3\
            """;

    // The closing triple quotes determine the margin.
    // Moving them to the left adds a margin, while moving it to the right makes no difference.
    // Trailing spaces are removed.
    String htmlTextBlockWithMargins = """
            <html>
                <body>
                    <p>Hello, world</p>
                </body>
            </html>
            """;

    // Sometimes we wish to break a long single line string for readability:
    String singleLineString = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                              "elit, sed do eiusmod tempor incididunt ut labore " +
                              "et dolore magna aliqua.";

    // The \<line-terminator> escape sequence explicitly suppresses the insertion of a newline character.
    // It's applicable in text blocks only
    String singleLineTextBlock = """
            Lorem ipsum dolor sit amet, consectetur adipiscing \
            elit, sed do eiusmod tempor incididunt ut labore \
            et dolore magna aliqua.\
            """;

    // The new \s escape sequence simply translates to a single space (\u0020).
    // Escape sequences aren't translated until after incidental space stripping, so \s can act as fence
    // to prevent the stripping of trailing white space. Using \s at the end of each line in this example
    // guarantees that each line is exactly six characters long
    // The \s escape sequence can be used in text blocks, traditional string literals, and character literals.
    String colors = """
            red  \s
            green\s
            blue \s
            """;
}
