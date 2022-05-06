package SyntaxTree;
import  Visitor.*;

import java.util.List;

public class SyntaxNode {
    public static class BaseNode{
        public  void accept(VisitorBase visitor){
            visitor.visit(this);
        }
    }
    public static class SpecificationNode extends BaseNode{
        List<DefinitionNode> definitions;
    };
    public static class DefinitionNode extends BaseNode{
        TypeDeclNode type;
        ModuleNode  module;
    };
    public static class ModuleNode extends BaseNode{};
    public static class TypeDeclNode extends BaseNode{
        StructIDTypeNode stuct_id;
    };
    public static class StructIDTypeNode extends  BaseNode{
        String id;
    };


}

