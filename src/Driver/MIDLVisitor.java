package Driver;// Generated from MIDL.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MIDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MIDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MIDLParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecification(MIDLParser.SpecificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefineType}
	 * labeled alternative in {@link MIDLParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineType(MIDLParser.DefineTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefineModule}
	 * labeled alternative in {@link MIDLParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineModule(MIDLParser.DefineModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(MIDLParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructDefine}
	 * labeled alternative in {@link MIDLParser#type_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDefine(MIDLParser.StructDefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructDecl}
	 * labeled alternative in {@link MIDLParser#type_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDecl(MIDLParser.StructDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#struct_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_type(MIDLParser.Struct_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#member_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_list(MIDLParser.Member_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeScopeName}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeScopeName(MIDLParser.TypeScopeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBaseTypeSpec}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBaseTypeSpec(MIDLParser.TypeBaseTypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeStructType}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStructType(MIDLParser.TypeStructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#scoped_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScoped_name(MIDLParser.Scoped_nameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeFloat}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFloat(MIDLParser.TypeFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(MIDLParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeChar}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeChar(MIDLParser.TypeCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeString(MIDLParser.TypeStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(MIDLParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloating_pt_type(MIDLParser.Floating_pt_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#integer_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_type(MIDLParser.Integer_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned_int(MIDLParser.Signed_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsigned_int(MIDLParser.Unsigned_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#declarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarators(MIDLParser.DeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(MIDLParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#simple_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_declarator(MIDLParser.Simple_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#array_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_declarator(MIDLParser.Array_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#exp_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_list(MIDLParser.Exp_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expr(MIDLParser.Or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#xor_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor_expr(MIDLParser.Xor_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(MIDLParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expr(MIDLParser.Shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#add_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_expr(MIDLParser.Add_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#mult_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult_expr(MIDLParser.Mult_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#unary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(MIDLParser.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MIDLParser.LiteralContext ctx);
}