package Visitor;
import SyntaxTree.SyntaxNode.*;


public abstract class VisitorBase {
    public  void visit(BaseNode node){
        node.accept(this);
    }
    public abstract  void visit(SpecificationNode node);
    public abstract void visit(DefinitionNode node);
    public abstract void visit(ModuleNode node);
    public abstract void visit(TypeDeclNode node);

}
