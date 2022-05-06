package SyntaxTree;
import  Visitor.*;

import java.util.ArrayList;
import java.util.List;

public class SyntaxNode {
    public static class BaseNode{
        public  void accept(VisitorBase visitor){
            visitor.visit(this);
        }
    }
    public static class SpecificationNode extends BaseNode{
        public ArrayList<DefinitionNode> definitions;
    };
    public static class DefinitionNode extends BaseNode{
        public TypeDeclNode type;
        public ModuleNode  module;
    };
    public static class ModuleNode extends BaseNode{};
    public static class TypeDeclNode extends BaseNode{
        public String id;
    };


}

