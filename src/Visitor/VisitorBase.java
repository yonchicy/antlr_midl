package Visitor;

import SyntaxTree.SyntaxNode.*;


public abstract class VisitorBase {
    public void visit(BaseNode node) {
        node.accept(this);
    }
    public abstract void  visit(SpecificationNode node);
    public abstract void  visit(DefinitionNode node);
    public abstract void  visit(ModuleNode node);
    public abstract void  visit(TypeDeclNode node);
    public abstract void  visit(StructTypeNode node);
    public abstract void  visit(MemberListNode node);
    public abstract void  visit(TypeSpecNode node);
    public abstract void  visit(ScopedNameNode node);
    public abstract void  visit(BaseTypeSpecNode node);
    public abstract void  visit(FloatingPtTypeNode node);
    public abstract void  visit(IntegerTypeNode node);
    public abstract void  visit(SignedIntNode node);
    public abstract void  visit(UnSignedIntNode node);
    public abstract void  visit(DeclaratorsNode node);
    public abstract void  visit(DeclaratorNode node);
    public abstract void  visit(SimpleDeclaratorNode node);
    public abstract void  visit(ArrayDeclaratorNode node);
    public abstract void  visit(OrExprNode node);
    public abstract void  visit(OrListExprNode node);
    public abstract void  visit(XorExprNode node);
    public abstract void  visit(AndExprNode node);
    public abstract void  visit(ShiftExprNode node);
    public abstract void  visit(AddExprNode node);
    public abstract void  visit(MultExprNode node);
    public abstract void  visit(UnaryExprNode node);
    public abstract void  visit(LiteralNode node);

}
