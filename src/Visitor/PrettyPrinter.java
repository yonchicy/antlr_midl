package Visitor;

import SyntaxTree.SyntaxNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrettyPrinter extends VisitorBase{

    int depth;
    SyntaxNode.SpecificationNode root;
    BufferedWriter out ;
    public PrettyPrinter(SyntaxNode.SpecificationNode root,String filename)throws IOException {
        depth=2;
        this.root=root;
        out=new BufferedWriter(new FileWriter(filename));
    }
    public void run() throws IOException{

        root.accept(this);
        out.close();

    }
    private void push(){
        try {
            for (int i = 0; i < depth-1; i++) {
                out.write(" ");

        }
            out.write("-");
        }
        catch (Exception ignored){}
        depth+=2;
    }
    private void pop(){
        depth-=2;
    }
    @Override
    public void visit(SyntaxNode.SpecificationNode node) {
        try{
        out.write("SpecificationNode\n");
        for (int i = 0; i < node.definitions.size(); i++) {
            push();
            node.definitions.get(i).accept(this);
            pop();
        }

        }
        catch(Exception e){}
    }
    @Override
    public void visit(SyntaxNode.DefinitionNode node) {
        try{
        out.write("DefinitionNode\n");
        if(node.type!=null){
            push();
            node.type.accept(this);
            pop();
        }
        else if (node.module!=null){
            push();
            node.module.accept(this);
            pop();
        }
        else {
            System.err.println("error");
        }

        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.ModuleNode node) {
        try{
        out.write("module ("+ node.id+")\n");
        for (int i = 0; i < node.definitions.size(); i++) {
            push();
            node.definitions.get(i).accept(this);
            pop();
        }
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.TypeDeclNode node) {
        try{
        if(node.struct_type!=null){
            push();
            node.struct_type.accept(this);
            pop();
        }
        else if (!node.id.isEmpty()){
            out.write("struct ("+ node.id+")\n");
        }

        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.StructTypeNode node) {
        try{
        out.write("struct_type ("+ node.id+")\n");
        push();
        node.member_list.accept(this);
        pop();
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.MemberListNode node) {
        try{
        out.write("member_list\n");
        for (int i = 0; i < node.type_spec.size(); i++) {
            push();
            node.type_spec.get(i).accept(this);
            pop();
            push();
            node.declarators.get(i).accept(this);
            pop();
        }
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.TypeSpecNode node) {
        try{
        out.write("type_spec\n");
        push();
        if(node.scoped_name!=null){
            node.scoped_name.accept(this);
        }
        else if (node.base_type_spec!=null){
            node.base_type_spec.accept(this);
        }
        else if (node.struct_type!=null){
            node.struct_type.accept(this);
        }
        pop();
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.ScopedNameNode node) {
        try {

        out.write("scoped_name ("+ node.root_id);
        for (int i = 0; i < node.ids.size(); i++) {
            out.write("::"+ node.ids.get(i));
        }
        out.write(")");
        }
        catch (Exception ignored){}
    }

    @Override
    public void visit(SyntaxNode.BaseTypeSpecNode node) {
        try {

        out.write("base_type_spec (");
        if(node.floating_pt_type!=null){
            out.write("float");
        }
        else if (node.integer_type !=null){
            out.write("int");
        }
        else if (node.isChar){
            out.write("char");
        }
        else if (node.isString){
            out.write("string");
        }
        else if (node.isBoolean){
            out.write("boolean");
        }
        out.write(")\n");
        }
        catch (Exception e){}
    }

    @Override
    public void visit(SyntaxNode.FloatingPtTypeNode node) {

    }

    @Override
    public void visit(SyntaxNode.IntegerTypeNode node) {

    }

    @Override
    public void visit(SyntaxNode.SignedIntNode node) {

    }

    @Override
    public void visit(SyntaxNode.UnSignedIntNode node) {

    }

    @Override
    public void visit(SyntaxNode.DeclaratorsNode node) {
        try{
        out.write("declarators\n");
        for (int i = 0; i < node.declarator_list.size(); i++) {
            push();
            node.declarator_list.get(i).accept(this);
            pop();
        }
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.DeclaratorNode node) {
        try{
        out.write("declarator\n");
        push();
        if(node.simple_declarator!=null){
            node.simple_declarator.accept(this);
        }
        else if(node.array_declarator!=null){
            node.array_declarator.accept(this);
        }
        pop();
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.SimpleDeclaratorNode node) {
        try{
        out.write("simple_declarator ("+ node.id+")\n");
        if(node.or_expr !=null){
            push();
            node.or_expr.accept(this);
            pop();
        }

        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.ArrayDeclaratorNode node) {
        try{
        out.write("array_declarators ("+ node.id+")\n");
        push();
        node.or_epxr.accept(this);
        pop();
        if(node.or_expr_list!=null){
            push();
            node.or_expr_list.accept(this);
            pop();
        }

        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.OrExprNode node) {
        try{
        out.write("or_expr_node \n");
        for (int i = 0; i < node.xor_exprs.size(); i++) {
            push();
            node.xor_exprs.get(i).accept(this);
            pop();
        }

        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.OrListExprNode node) {
        try{
        out.write("or_list_node\n");
        for (int i = 0; i < node.or_expr_list.size(); i++) {
            push();
            node.or_expr_list.get(i).accept(this);
            pop();
        }
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.XorExprNode node) {
        try{
        out.write("xor_expr_node\n");
        for (int i = 0; i < node.and_exprs.size(); i++) {
            push();
            node.and_exprs.get(i).accept(this);
            pop();
        }
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.AndExprNode node) {
        try{
        out.write("and_expr_node\n");
        for (int i = 0; i < node.shift_expr.size(); i++) {
            push();
            node.shift_expr.get(i).accept(this);
            pop();
        }
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.ShiftExprNode node) {
        try{
        out.write("shift_expr_node\n");
        push();
        node.add_epxr.accept(this);
        pop();
        for (int i = 0; i < node.add_exprs.size(); i++) {
            push();
            out.write(node.oprts.get(i)+"\n");
            pop();
            push();
            node.add_exprs.get(i).accept(this);
            pop();

        }
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.AddExprNode node) {
        try{
        out.write("add_expr_node\n");
        push();
        node.mult_expr.accept(this);
        pop();
        for (int i = 0; i < node.mult_exprs.size(); i++) {
            push();
            out.write(node.oprts.get(i)+"\n");
            pop();
            push();
            node.mult_exprs.get(i).accept(this);
            pop();
        }
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.MultExprNode node) {
        try{
        out.write("mult_expr_node\n");
        push();
        node.unary_expr.accept(this);
        pop();
        for (int i = 0; i < node.unary_exprs.size(); i++) {
            push();
            out.write(node.oprts.get(i)+"\n");
            pop();
            push();
            node.unary_exprs.get(i).accept(this);
            pop();

        }

        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.UnaryExprNode node) {
        try{
        out.write("unary_expr_node\n");
        if(node.oprt!=null)
        {
            push();
            out.write(node.oprt+"\n");
            pop();
        }
        push();
        node.literal.accept(this);
        pop();
        }
        catch(Exception e){}
    }

    @Override
    public void visit(SyntaxNode.LiteralNode node) {
        try{

        out.write("literal_node\n");
        push();
         if(node.isInt!=null){
             out.write(node.isInt+"\n");
         }
         else if(node.isFloat!=null){
             out.write(node.isFloat+"\n");
         }
         else if(node.isChar!=null){
             out.write(node.isChar+"\n");
         }
         else if(node.isString!=null){
             out.write(node.isString+"\n");
         }
         else if(node.isBoolean!=null){
             out.write(node.isBoolean+"\n");
         }
         }
        catch(Exception e){}
    }
}
