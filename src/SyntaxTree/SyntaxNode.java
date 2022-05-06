package SyntaxTree;
import  Visitor.*;

import java.util.ArrayList;

public class SyntaxNode {
    public static class BaseNode{
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
    }
    public static class SpecificationNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }

        public ArrayList<DefinitionNode> definitions;
    };
    public static class DefinitionNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public TypeDeclNode type;
        public ModuleNode  module;
    };
    public static class ModuleNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public String id;
        public ArrayList<DefinitionNode> definitions;
    };
    public static class TypeDeclNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public String id;
        public StructTypeNode struct_type;
    };

    public static class StructTypeNode extends BaseNode {
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public String id;
        public MemberListNode member_list;
    }
    public static class MemberListNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public ArrayList<TypeSpecNode> type_spec;
        public ArrayList<DeclaratorsNode> declarators;
    }
    public static class TypeSpecNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public ScopedNameNode scoped_name;
        public BaseTypeSpecNode base_type_spec;
        public StructTypeNode struct_type;
    }
    public static class ScopedNameNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public String root_id;
        public ArrayList<String> ids;
    }
    public static class BaseTypeSpecNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public FloatingPtTypeNode floating_pt_type;
        public IntegerTypeNode integer_type;
        public boolean isChar;
        public boolean isString;
        public boolean isBoolean;
    }
    public static class FloatingPtTypeNode extends  BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public boolean isFloat;
        public boolean isDouble;
        public boolean isLongDouble;
    }
    public static class IntegerTypeNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public SignedIntNode signed_int;
        public UnSignedIntNode unsigned_int;
    }
    public static class   SignedIntNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public boolean isShort;
        public boolean isLong;
        public boolean isLongLong;
        public boolean isChar;

    }
    public static class   UnSignedIntNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public boolean isShort;
        public boolean isLong;
        public boolean isLongLong;
        public boolean isChar;
    }

    public static class DeclaratorsNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public ArrayList<DeclaratorNode> declarator_list;
    }
    public static class DeclaratorNode extends BaseNode {
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public SimpleDeclaratorNode simple_declarator;
        public ArrayDeclaratorNode array_declarator;
    }

    public static class SimpleDeclaratorNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
       public  String id;
        public OrExprNode or_expr;
    }
    public static class ArrayDeclaratorNode  extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public  String id;
        public OrExprNode or_epxr;
        public expListNode or_expr_list;
    }
    public  static  class expListNode extends  BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public ArrayList<OrExprNode> or_exprs;
    }
    public static class OrExprNode  extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public ArrayList<XorExprNode> xor_exprs;
    }
    public static class OrListExprNode  extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public ArrayList<OrExprNode> or_expr_list;
    }
    public static class XorExprNode  extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public ArrayList<AndExprNode> and_exprs;
    }
    public static class AndExprNode  extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public ArrayList<ShiftExprNode> shift_expr;
    }
    public static class ShiftExprNode  extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public AddExprNode add_epxr;
        public ArrayList<AddExprNode> add_exprs;
        public ArrayList<String> oprts;
    }
    public static class AddExprNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public MultExprNode mult_expr;
        public ArrayList<MultExprNode> mult_exprs;
        public ArrayList<String> oprts;
    }
    public static class MultExprNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public UnaryExprNode unary_expr;
        public ArrayList<UnaryExprNode> unary_exprs;
        public ArrayList<String> oprts;
    }
    public static class UnaryExprNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public String oprt;
        public LiteralNode literal;
    }
    public static class LiteralNode extends BaseNode{
        @Override
        public void accept(VisitorBase visitor){
            visitor.visit(this);
        }
        public String isInt;
        public String isFloat;
        public String isChar;
        public String isString;
        public String isBoolean;
    }

}

