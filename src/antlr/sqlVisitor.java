// Generated from /Users/usuario/NetBeansProjects/DBMS/src/antlr/sql.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link sqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface sqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(@NotNull sqlParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#references}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferences(@NotNull sqlParser.ReferencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#first_where_statement_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirst_where_statement_update(@NotNull sqlParser.First_where_statement_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#where_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere_statement(@NotNull sqlParser.Where_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#tables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTables(@NotNull sqlParser.TablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#from_multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_multiple(@NotNull sqlParser.From_multipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#order}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder(@NotNull sqlParser.OrderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionAddColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionAddColumn(@NotNull sqlParser.AccionAddColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull sqlParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#column_terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_terminal(@NotNull sqlParser.Column_terminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_literal(@NotNull sqlParser.Tipo_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#final_where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinal_where(@NotNull sqlParser.Final_whereContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#num_or_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum_or_id(@NotNull sqlParser.Num_or_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRename_table_statement(@NotNull sqlParser.Rename_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull sqlParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#final_where_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinal_where_update(@NotNull sqlParser.Final_where_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_data_statement(@NotNull sqlParser.Sql_data_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_schema_statement(@NotNull sqlParser.Sql_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#foreign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeign(@NotNull sqlParser.ForeignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintForeignKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintForeignKey(@NotNull sqlParser.ConstraintForeignKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintForeignKeyAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintForeignKeyAlter(@NotNull sqlParser.ConstraintForeignKeyAlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull sqlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionDropConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionDropConstraint(@NotNull sqlParser.AccionDropConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#into}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInto(@NotNull sqlParser.IntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#column_or_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_or_constraint(@NotNull sqlParser.Column_or_constraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintCheck}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintCheck(@NotNull sqlParser.ConstraintCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#update_colmn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_colmn(@NotNull sqlParser.Update_colmnContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#list_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_values(@NotNull sqlParser.List_valuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#by}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBy(@NotNull sqlParser.ByContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#float_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat_literal(@NotNull sqlParser.Float_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(@NotNull sqlParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_schema_statement(@NotNull sqlParser.Drop_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#select_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_value(@NotNull sqlParser.Select_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(@NotNull sqlParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(@NotNull sqlParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#insert_column_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_column_names(@NotNull sqlParser.Insert_column_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(@NotNull sqlParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_table_statement(@NotNull sqlParser.Drop_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#first_where_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirst_where_statement(@NotNull sqlParser.First_where_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#float_terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat_terminal(@NotNull sqlParser.Float_terminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintPrimaryKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintPrimaryKey(@NotNull sqlParser.ConstraintPrimaryKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#char_terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_terminal(@NotNull sqlParser.Char_terminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#schema_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema_definition(@NotNull sqlParser.Schema_definitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintPrimaryKeyAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintPrimaryKeyAlter(@NotNull sqlParser.ConstraintPrimaryKeyAlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#identifier_select_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_select_value(@NotNull sqlParser.Identifier_select_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#asc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsc(@NotNull sqlParser.AscContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#rename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRename(@NotNull sqlParser.RenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(@NotNull sqlParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo(@NotNull sqlParser.ToContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(@NotNull sqlParser.LogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#constraint_terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_terminal(@NotNull sqlParser.Constraint_terminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse_schema_statement(@NotNull sqlParser.Use_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#table_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_definition(@NotNull sqlParser.Table_definitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionDropColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionDropColumn(@NotNull sqlParser.AccionDropColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#use}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse(@NotNull sqlParser.UseContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_literal(@NotNull sqlParser.Int_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_schema_manipulation_statement(@NotNull sqlParser.Sql_schema_manipulation_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_table_statement(@NotNull sqlParser.Alter_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_database_statement(@NotNull sqlParser.Alter_database_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#create}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate(@NotNull sqlParser.CreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom(@NotNull sqlParser.FromContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#sql2003Parser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql2003Parser(@NotNull sqlParser.Sql2003ParserContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#delete_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_value(@NotNull sqlParser.Delete_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#constraint_alter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_alter(@NotNull sqlParser.Constraint_alterContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(@NotNull sqlParser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#alter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter(@NotNull sqlParser.AlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull sqlParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#check_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_exp(@NotNull sqlParser.Check_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_executable_statement(@NotNull sqlParser.Sql_executable_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#int_terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_terminal(@NotNull sqlParser.Int_terminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#check}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck(@NotNull sqlParser.CheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#identifier_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_update(@NotNull sqlParser.Identifier_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull sqlParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#where_statement_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere_statement_update(@NotNull sqlParser.Where_statement_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#update_column_multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_column_multiple(@NotNull sqlParser.Update_column_multipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#desc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesc(@NotNull sqlParser.DescContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#drop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop(@NotNull sqlParser.DropContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(@NotNull sqlParser.Id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_column_statement(@NotNull sqlParser.Show_column_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code values}
	 * labeled alternative in {@link sqlParser#accionaccionaccionaccionconstraintTypeconstraintTypeconstraintTypeAlterconstraintTypeAlterconstraintTypeconstraintTypeAlter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(@NotNull sqlParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#show}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow(@NotNull sqlParser.ShowContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_schema_definition_statement(@NotNull sqlParser.Sql_schema_definition_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(@NotNull sqlParser.InsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(@NotNull sqlParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#delete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete(@NotNull sqlParser.DeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_schema_statement(@NotNull sqlParser.Show_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#database_plural}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase_plural(@NotNull sqlParser.Database_pluralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionAddConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionAddConstraint(@NotNull sqlParser.AccionAddConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase(@NotNull sqlParser.DatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull sqlParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#null_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_literal(@NotNull sqlParser.Null_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull sqlParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull sqlParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#date_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_literal(@NotNull sqlParser.Date_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull sqlParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#column_terminal_plural}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_terminal_plural(@NotNull sqlParser.Column_terminal_pluralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintCheckAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintCheckAlter(@NotNull sqlParser.ConstraintCheckAlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#insert_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_value(@NotNull sqlParser.Insert_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#condition_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_update(@NotNull sqlParser.Condition_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#char_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_name(@NotNull sqlParser.Char_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#date_terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_terminal(@NotNull sqlParser.Date_terminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#update_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_value(@NotNull sqlParser.Update_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#select_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_values(@NotNull sqlParser.Select_valuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_table_statement(@NotNull sqlParser.Show_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(@NotNull sqlParser.RelationalContext ctx);
}
