package Visitor;
import SyntaxTree.SyntaxNode.*;


public class VisitorBase {
    public  void visit(BaseNode node){
        node.accept(this);
    }
}
