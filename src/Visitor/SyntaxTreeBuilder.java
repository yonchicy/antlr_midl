package Visitor;

import SyntaxTree.SyntaxNode.*;
import Driver.*;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class SyntaxTreeBuilder extends MIDLBaseVisitor<BaseNode>{


    @Override
    public BaseNode visitSpecification(MIDLParser.SpecificationContext ctx) {
        SpecificationNode root= new SpecificationNode();
        root.definitions=new ArrayList<>();
        System.out.println("add define");
        for (int i = 0; i < ctx.definition().size(); i++) {
                root.definitions.add( (DefinitionNode) visit(ctx.definition(i)));
        }
        return root;
    }

    @Override
    public BaseNode visitDefineType(MIDLParser.DefineTypeContext ctx) {
        System.out.println("add define type");
        DefinitionNode define = new DefinitionNode();
        define.type= (TypeDeclNode) visit(ctx.type_decl());
        return define;
    }
    @Override
    public BaseNode visitDefineModule(MIDLParser.DefineModuleContext ctx) {
        return super.visitDefineModule(ctx);
    }
    @Override
    public BaseNode visitModule(MIDLParser.ModuleContext ctx) {
        return super.visitModule(ctx);
    }

    @Override
    public BaseNode visitStructDefine(MIDLParser.StructDefineContext ctx) {
        return super.visitStructDefine(ctx);
    }

    @Override
    public BaseNode visitStructDecl(MIDLParser.StructDeclContext ctx) {
        System.out.println("add struct declare");
        TypeDeclNode type_decl = new TypeDeclNode();
        type_decl.id=ctx.ID().getText();
        return type_decl;
    }

}
