package Visitor;

import SyntaxTree.SyntaxNode.*;
import Driver.*;

import java.util.ArrayList;

public class SyntaxTreeBuilder extends MIDLBaseVisitor<BaseNode>{


    private ArrayList<String> strings;

    @Override
    public BaseNode visitSpecification(MIDLParser.SpecificationContext ctx) {
        SpecificationNode root= new SpecificationNode();
        root.definitions=new ArrayList<>();
        for (int i = 0; i < ctx.definition().size(); i++) {
                root.definitions.add( (DefinitionNode) visit(ctx.definition(i)));
        }
        return root;
    }

    @Override
    public BaseNode visitDefineType(MIDLParser.DefineTypeContext ctx) {
        DefinitionNode define = new DefinitionNode();
        define.type= (TypeDeclNode) visit(ctx.type_decl());
        return define;
    }
    @Override
    public BaseNode visitDefineModule(MIDLParser.DefineModuleContext ctx) {
        DefinitionNode define = new DefinitionNode();
        define.module= (ModuleNode) visit(ctx.module());
        return define;

    }
    @Override
    public BaseNode visitModule(MIDLParser.ModuleContext ctx) {
        ModuleNode module = new ModuleNode();
        module.id=ctx.ID().getText();
        module.definitions=new ArrayList<>();
        for (int i = 0; i < ctx.definition().size(); i++) {
            module.definitions.add((DefinitionNode) visit(ctx.definition(i)));
        }
        return module;
    }

    @Override
    public BaseNode visitStructDefine(MIDLParser.StructDefineContext ctx) {
        TypeDeclNode temp=new TypeDeclNode();
        temp.struct_type= (StructTypeNode) visit(ctx.struct_type());
        return temp;
    }

    @Override
    public BaseNode visitStructDecl(MIDLParser.StructDeclContext ctx) {
        TypeDeclNode type_decl = new TypeDeclNode();
        type_decl.id=ctx.ID().getText();
        return type_decl;
    }

    @Override
    public BaseNode visitStruct_type(MIDLParser.Struct_typeContext ctx) {
        StructTypeNode temp=new StructTypeNode();
        temp.id=ctx.ID().getText();
        temp.member_list= (MemberListNode) visit(ctx.member_list());
        return temp;
    }

    @Override
    public BaseNode visitMember_list(MIDLParser.Member_listContext ctx) {
        MemberListNode temp=new MemberListNode();
        temp.declarators=new ArrayList<>();
        temp.type_spec=new ArrayList<>();
        for (int i = 0; i < ctx.declarators().size(); i++) {
            temp.type_spec.add((TypeSpecNode) visit(ctx.type_spec(i)));
            temp.declarators.add((DeclaratorsNode) visit(ctx.declarators(i)));
        }
        return temp;
    }

    @Override
    public BaseNode visitTypeScopeName(MIDLParser.TypeScopeNameContext ctx) {
        TypeSpecNode temp=new TypeSpecNode();
        temp.scoped_name= (ScopedNameNode) visit(ctx.scoped_name());
        return temp;
    }

    @Override
    public BaseNode visitTypeBaseTypeSpec(MIDLParser.TypeBaseTypeSpecContext ctx) {
        TypeSpecNode temp=new TypeSpecNode();
        temp.base_type_spec= (BaseTypeSpecNode) visit(ctx.base_type_spec());
        return temp;
    }

    @Override
    public BaseNode visitTypeStructType(MIDLParser.TypeStructTypeContext ctx) {
        TypeSpecNode temp=new TypeSpecNode();
        temp.struct_type= (StructTypeNode) visit(ctx.struct_type());
        return temp;

    }

    @Override
    public BaseNode visitScoped_name(MIDLParser.Scoped_nameContext ctx) {
        ScopedNameNode temp = new ScopedNameNode();
        temp.root_id=ctx.ID(0).getText();
        temp.ids=new ArrayList<>();
        for (int i = 1; i < ctx.ID().size(); i++) {
            temp.ids.add(ctx.ID(i).getText());
        }
        return temp;
    }

    @Override
    public BaseNode visitTypeFloat(MIDLParser.TypeFloatContext ctx) {
        BaseTypeSpecNode temp=new BaseTypeSpecNode();
        temp.floating_pt_type= (FloatingPtTypeNode) visit(ctx.floating_pt_type());
        temp.isBoolean=false;
        temp.isChar=false;
        temp.isString=false;
        return temp;
    }

    @Override
    public BaseNode visitTypeInt(MIDLParser.TypeIntContext ctx) {
        BaseTypeSpecNode temp=new BaseTypeSpecNode();
        temp.integer_type= (IntegerTypeNode) visit(ctx.integer_type());
        temp.isBoolean=false;
        temp.isChar=false;
        temp.isString=false;
        return temp;
    }

    @Override
    public BaseNode visitTypeChar(MIDLParser.TypeCharContext ctx) {
        BaseTypeSpecNode temp=new BaseTypeSpecNode();
        temp.isBoolean=false;
        temp.isChar=true;
        temp.isString=false;
        return temp;
    }

    @Override
    public BaseNode visitTypeString(MIDLParser.TypeStringContext ctx) {
        BaseTypeSpecNode temp=new BaseTypeSpecNode();
        temp.isBoolean=false;
        temp.isChar= false;
        temp.isString=true;
        return temp;
    }

    @Override
    public BaseNode visitTypeBool(MIDLParser.TypeBoolContext ctx) {
        BaseTypeSpecNode temp=new BaseTypeSpecNode();
        temp.isBoolean=true;
        temp.isChar= false;
        temp.isString=false;
        return temp;
    }

    @Override
    public BaseNode visitFloating_pt_type(MIDLParser.Floating_pt_typeContext ctx) {
        FloatingPtTypeNode temp=new FloatingPtTypeNode();
        temp.isFloat = ctx.getText().equals("float");
        temp.isDouble = ctx.getText().equals("double");
        temp.isLongDouble = ctx.getText().equals("long double");
        return temp;
    }


    @Override
    public BaseNode visitInteger_type(MIDLParser.Integer_typeContext ctx) {
        IntegerTypeNode temp=new IntegerTypeNode();
        if(!ctx.signed_int().isEmpty()){
            temp.signed_int= (SignedIntNode) visit(ctx.signed_int());
        }
        else if (!ctx.unsigned_int().isEmpty()){
            temp.unsigned_int= (UnSignedIntNode) visit(ctx.unsigned_int());
        }
        return temp;
    }
    @Override
    public BaseNode visitSigned_int(MIDLParser.Signed_intContext ctx) {
        SignedIntNode temp = new SignedIntNode();
        // FIXME: error here
        temp.isChar = ctx.getText().equals("int8");
        temp.isShort=ctx.getText().equals("short")|ctx.getText().equals("int16");
        temp.isLong = ctx.getText().equals("long")|ctx.getText().equals("int32");
        temp.isLongLong = ctx.getText().equals("long")|ctx.getText().equals("int64");
        return  temp;
    }


    @Override
    public BaseNode visitUnsigned_int(MIDLParser.Unsigned_intContext ctx) {
        // FIXME: error here
        UnSignedIntNode temp = new UnSignedIntNode();
        temp.isChar = ctx.getText().equals("uint8");
        temp.isShort=ctx.getText().equals("short")|ctx.getText().equals("uint16");
        temp.isLong = ctx.getText().equals("long")|ctx.getText().equals("uint32");
        temp.isLongLong = ctx.getText().equals("long")|ctx.getText().equals("uint64");
        return temp;
    }

    @Override
    public BaseNode visitDeclarators(MIDLParser.DeclaratorsContext ctx) {
        DeclaratorsNode temp = new DeclaratorsNode();
        temp.declarator_list = new ArrayList<>();
        for (int i = 0; i < ctx.declarator().size(); i++) {
            temp.declarator_list.add((DeclaratorNode) visit(ctx.declarator(i)));
        }
        return temp;
    }

    @Override
    public BaseNode visitDeclarator(MIDLParser.DeclaratorContext ctx) {
        DeclaratorNode temp = new DeclaratorNode();
        if(ctx.simple_declarator()!=null){
            temp.simple_declarator= (SimpleDeclaratorNode) visit(ctx.simple_declarator());
        }
        if(ctx.array_declarator()!=null){
            temp.array_declarator= (ArrayDeclaratorNode) visit(ctx.array_declarator());
        }
        return temp;
    }

    @Override
    public BaseNode visitSimple_declarator(MIDLParser.Simple_declaratorContext ctx) {
        SimpleDeclaratorNode temp = new SimpleDeclaratorNode();
        temp.id = ctx.ID().getText();
        if(!ctx.or_expr().isEmpty()){
            temp.or_expr = (OrExprNode) visit(ctx.or_expr());
        }
        return temp;
    }

    @Override
    public BaseNode visitArray_declarator(MIDLParser.Array_declaratorContext ctx) {
        ArrayDeclaratorNode temp = new ArrayDeclaratorNode();
        temp.id=ctx.ID().getText();
        temp.or_epxr = (OrExprNode) visit(ctx.or_expr());
        if(!ctx.exp_list().isEmpty()){
            temp.or_expr_list= (expListNode) visit(ctx.exp_list());
        }
        return  temp;
    }

    @Override
    public BaseNode visitExp_list(MIDLParser.Exp_listContext ctx) {
        expListNode temp = new expListNode();
        temp.or_exprs=new ArrayList<>();
        for (int i = 0; i < ctx.or_expr().size(); i++) {
            temp.or_exprs.add((OrExprNode) visit(ctx.or_expr(i)));
        }
        return temp;
    }

    @Override
    public BaseNode visitOr_expr(MIDLParser.Or_exprContext ctx) {
        OrExprNode temp = new OrExprNode() ;
        temp.xor_exprs=new ArrayList<>();
        for (int i = 0; i < ctx.xor_expr().size(); i++) {
            temp.xor_exprs.add((XorExprNode) visit(ctx.xor_expr(i)));
        }
        return temp;
        
    }

    @Override
    public BaseNode visitXor_expr(MIDLParser.Xor_exprContext ctx) {
        XorExprNode temp = new XorExprNode();
        temp.and_exprs=new ArrayList<>();
        for (int i = 0; i < ctx.and_expr().size(); i++) {
            temp.and_exprs.add((AndExprNode) visit(ctx.and_expr(i)));
        }
        return temp;
    }

    @Override
    public BaseNode visitShift_expr(MIDLParser.Shift_exprContext ctx) {
        ShiftExprNode temp = new ShiftExprNode();
        temp.add_exprs=new ArrayList<>();
        temp.oprts=new ArrayList<>();
        temp.add_epxr= (AddExprNode) visit(ctx.add_expr(0));
        for (int i = 1; i < ctx.add_expr().size(); i++) {
            temp.oprts.add(ctx.op.getText());
            temp.add_exprs.add((AddExprNode) visit(ctx.add_expr(i)));
        }

        return temp;
    }

    @Override
    public BaseNode visitAdd_expr(MIDLParser.Add_exprContext ctx) {
        AddExprNode temp = new AddExprNode();
        temp.mult_exprs=new ArrayList<>();
        temp.oprts=new ArrayList<>();
        temp.mult_expr= (MultExprNode) visit(ctx.mult_expr(0));
        for (int i = 1; i < ctx.mult_expr().size(); i++) {
            temp.oprts.add(ctx.op.getText());
            temp.mult_exprs.add((MultExprNode) visit(ctx.mult_expr(i)));
        }
       return temp;
    }

    @Override
    public BaseNode visitAnd_expr(MIDLParser.And_exprContext ctx) {
        AndExprNode temp = new AndExprNode();
        temp.shift_expr=new ArrayList<>();
        for (int i = 0; i < ctx.shift_expr().size(); i++) {
            temp.shift_expr.add((ShiftExprNode) visit(ctx.shift_expr(i)));

        }
        return temp;

    }

    @Override
    public BaseNode visitMult_expr(MIDLParser.Mult_exprContext ctx) {
        MultExprNode temp = new MultExprNode();
        temp.unary_exprs=new ArrayList<>();
        temp.oprts=new ArrayList<>();
        temp.unary_expr= (UnaryExprNode) visit(ctx.unary_expr(0));
        for (int i = 1; i < ctx.unary_expr().size(); i++) {
            temp.oprts.add(ctx.op.getText());
            temp.unary_exprs.add((UnaryExprNode) visit(ctx.unary_expr(i)));
        }
        return temp;
    }

    @Override
    public BaseNode visitUnary_expr(MIDLParser.Unary_exprContext ctx) {
        UnaryExprNode temp = new UnaryExprNode();
        temp.oprt=ctx.op.getText();
        temp.literal= (LiteralNode) visit(ctx.literal());
        return temp;
    }

    @Override
    public BaseNode visitLiteral(MIDLParser.LiteralContext ctx) {
        LiteralNode temp = new LiteralNode();
        temp.isInt=ctx.INTEGER().getText();
        return temp;
    }
}
