import Driver.MIDLLexer;
import Driver.MIDLParser;
import SyntaxTree.SyntaxNode;
import Visitor.SyntaxTreeBuilder;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "/home/yonchicy/IdeaProjects/antlr_test/src/test.txt";
        CharStream input = CharStreams.fromFileName(filename);

        MIDLLexer lexer = new MIDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MIDLParser parser = new MIDLParser(tokens);
        ParseTree tree = parser.specification(); // calc is the starting rule

        SyntaxTreeBuilder builder = new SyntaxTreeBuilder();
        SyntaxNode.BaseNode root = builder.visit(tree);


    }
}

