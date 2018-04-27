// Generated from /Users/usuario/NetBeansProjects/DBMS/src/antlr/sql.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link sqlParser}.
 */
public interface sqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(@NotNull sqlParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(@NotNull sqlParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#references}.
	 * @param ctx the parse tree
	 */
	void enterReferences(@NotNull sqlParser.ReferencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#references}.
	 * @param ctx the parse tree
	 */
	void exitReferences(@NotNull sqlParser.ReferencesContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#first_where_statement_update}.
	 * @param ctx the parse tree
	 */
	void enterFirst_where_statement_update(@NotNull sqlParser.First_where_statement_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#first_where_statement_update}.
	 * @param ctx the parse tree
	 */
	void exitFirst_where_statement_update(@NotNull sqlParser.First_where_statement_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#where_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhere_statement(@NotNull sqlParser.Where_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#where_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhere_statement(@NotNull sqlParser.Where_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#tables}.
	 * @param ctx the parse tree
	 */
	void enterTables(@NotNull sqlParser.TablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#tables}.
	 * @param ctx the parse tree
	 */
	void exitTables(@NotNull sqlParser.TablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#from_multiple}.
	 * @param ctx the parse tree
	 */
	void enterFrom_multiple(@NotNull sqlParser.From_multipleContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#from_multiple}.
	 * @param ctx the parse tree
	 */
	void exitFrom_multiple(@NotNull sqlParser.From_multipleContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#order}.
	 * @param ctx the parse tree
	 */
	void enterOrder(@NotNull sqlParser.OrderContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#order}.
	 * @param ctx the parse tree
	 */
	void exitOrder(@NotNull sqlParser.OrderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionAddColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccionAddColumn(@NotNull sqlParser.AccionAddColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionAddColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccionAddColumn(@NotNull sqlParser.AccionAddColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull sqlParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull sqlParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#column_terminal}.
	 * @param ctx the parse tree
	 */
	void enterColumn_terminal(@NotNull sqlParser.Column_terminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#column_terminal}.
	 * @param ctx the parse tree
	 */
	void exitColumn_terminal(@NotNull sqlParser.Column_terminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 */
	void enterTipo_literal(@NotNull sqlParser.Tipo_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 */
	void exitTipo_literal(@NotNull sqlParser.Tipo_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#final_where}.
	 * @param ctx the parse tree
	 */
	void enterFinal_where(@NotNull sqlParser.Final_whereContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#final_where}.
	 * @param ctx the parse tree
	 */
	void exitFinal_where(@NotNull sqlParser.Final_whereContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#num_or_id}.
	 * @param ctx the parse tree
	 */
	void enterNum_or_id(@NotNull sqlParser.Num_or_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#num_or_id}.
	 * @param ctx the parse tree
	 */
	void exitNum_or_id(@NotNull sqlParser.Num_or_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterRename_table_statement(@NotNull sqlParser.Rename_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitRename_table_statement(@NotNull sqlParser.Rename_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull sqlParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull sqlParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#final_where_update}.
	 * @param ctx the parse tree
	 */
	void enterFinal_where_update(@NotNull sqlParser.Final_where_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#final_where_update}.
	 * @param ctx the parse tree
	 */
	void exitFinal_where_update(@NotNull sqlParser.Final_where_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_data_statement(@NotNull sqlParser.Sql_data_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_data_statement(@NotNull sqlParser.Sql_data_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_schema_statement(@NotNull sqlParser.Sql_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_schema_statement(@NotNull sqlParser.Sql_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#foreign}.
	 * @param ctx the parse tree
	 */
	void enterForeign(@NotNull sqlParser.ForeignContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#foreign}.
	 * @param ctx the parse tree
	 */
	void exitForeign(@NotNull sqlParser.ForeignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintForeignKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void enterConstraintForeignKey(@NotNull sqlParser.ConstraintForeignKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintForeignKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void exitConstraintForeignKey(@NotNull sqlParser.ConstraintForeignKeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintForeignKeyAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 */
	void enterConstraintForeignKeyAlter(@NotNull sqlParser.ConstraintForeignKeyAlterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintForeignKeyAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 */
	void exitConstraintForeignKeyAlter(@NotNull sqlParser.ConstraintForeignKeyAlterContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull sqlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull sqlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionDropConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccionDropConstraint(@NotNull sqlParser.AccionDropConstraintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionDropConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccionDropConstraint(@NotNull sqlParser.AccionDropConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#into}.
	 * @param ctx the parse tree
	 */
	void enterInto(@NotNull sqlParser.IntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#into}.
	 * @param ctx the parse tree
	 */
	void exitInto(@NotNull sqlParser.IntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#column_or_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColumn_or_constraint(@NotNull sqlParser.Column_or_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#column_or_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColumn_or_constraint(@NotNull sqlParser.Column_or_constraintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintCheck}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void enterConstraintCheck(@NotNull sqlParser.ConstraintCheckContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintCheck}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void exitConstraintCheck(@NotNull sqlParser.ConstraintCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#update_colmn}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_colmn(@NotNull sqlParser.Update_colmnContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#update_colmn}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_colmn(@NotNull sqlParser.Update_colmnContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#list_values}.
	 * @param ctx the parse tree
	 */
	void enterList_values(@NotNull sqlParser.List_valuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#list_values}.
	 * @param ctx the parse tree
	 */
	void exitList_values(@NotNull sqlParser.List_valuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#by}.
	 * @param ctx the parse tree
	 */
	void enterBy(@NotNull sqlParser.ByContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#by}.
	 * @param ctx the parse tree
	 */
	void exitBy(@NotNull sqlParser.ByContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#float_literal}.
	 * @param ctx the parse tree
	 */
	void enterFloat_literal(@NotNull sqlParser.Float_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#float_literal}.
	 * @param ctx the parse tree
	 */
	void exitFloat_literal(@NotNull sqlParser.Float_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(@NotNull sqlParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(@NotNull sqlParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterDrop_schema_statement(@NotNull sqlParser.Drop_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitDrop_schema_statement(@NotNull sqlParser.Drop_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#select_value}.
	 * @param ctx the parse tree
	 */
	void enterSelect_value(@NotNull sqlParser.Select_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#select_value}.
	 * @param ctx the parse tree
	 */
	void exitSelect_value(@NotNull sqlParser.Select_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(@NotNull sqlParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(@NotNull sqlParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(@NotNull sqlParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(@NotNull sqlParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#insert_column_names}.
	 * @param ctx the parse tree
	 */
	void enterInsert_column_names(@NotNull sqlParser.Insert_column_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#insert_column_names}.
	 * @param ctx the parse tree
	 */
	void exitInsert_column_names(@NotNull sqlParser.Insert_column_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(@NotNull sqlParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(@NotNull sqlParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterDrop_table_statement(@NotNull sqlParser.Drop_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitDrop_table_statement(@NotNull sqlParser.Drop_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#first_where_statement}.
	 * @param ctx the parse tree
	 */
	void enterFirst_where_statement(@NotNull sqlParser.First_where_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#first_where_statement}.
	 * @param ctx the parse tree
	 */
	void exitFirst_where_statement(@NotNull sqlParser.First_where_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#float_terminal}.
	 * @param ctx the parse tree
	 */
	void enterFloat_terminal(@NotNull sqlParser.Float_terminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#float_terminal}.
	 * @param ctx the parse tree
	 */
	void exitFloat_terminal(@NotNull sqlParser.Float_terminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintPrimaryKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void enterConstraintPrimaryKey(@NotNull sqlParser.ConstraintPrimaryKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintPrimaryKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void exitConstraintPrimaryKey(@NotNull sqlParser.ConstraintPrimaryKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#char_terminal}.
	 * @param ctx the parse tree
	 */
	void enterChar_terminal(@NotNull sqlParser.Char_terminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#char_terminal}.
	 * @param ctx the parse tree
	 */
	void exitChar_terminal(@NotNull sqlParser.Char_terminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#schema_definition}.
	 * @param ctx the parse tree
	 */
	void enterSchema_definition(@NotNull sqlParser.Schema_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#schema_definition}.
	 * @param ctx the parse tree
	 */
	void exitSchema_definition(@NotNull sqlParser.Schema_definitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintPrimaryKeyAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 */
	void enterConstraintPrimaryKeyAlter(@NotNull sqlParser.ConstraintPrimaryKeyAlterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintPrimaryKeyAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 */
	void exitConstraintPrimaryKeyAlter(@NotNull sqlParser.ConstraintPrimaryKeyAlterContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#identifier_select_value}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_select_value(@NotNull sqlParser.Identifier_select_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#identifier_select_value}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_select_value(@NotNull sqlParser.Identifier_select_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#asc}.
	 * @param ctx the parse tree
	 */
	void enterAsc(@NotNull sqlParser.AscContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#asc}.
	 * @param ctx the parse tree
	 */
	void exitAsc(@NotNull sqlParser.AscContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#rename}.
	 * @param ctx the parse tree
	 */
	void enterRename(@NotNull sqlParser.RenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#rename}.
	 * @param ctx the parse tree
	 */
	void exitRename(@NotNull sqlParser.RenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(@NotNull sqlParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(@NotNull sqlParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#to}.
	 * @param ctx the parse tree
	 */
	void enterTo(@NotNull sqlParser.ToContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#to}.
	 * @param ctx the parse tree
	 */
	void exitTo(@NotNull sqlParser.ToContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(@NotNull sqlParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(@NotNull sqlParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#constraint_terminal}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_terminal(@NotNull sqlParser.Constraint_terminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#constraint_terminal}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_terminal(@NotNull sqlParser.Constraint_terminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterUse_schema_statement(@NotNull sqlParser.Use_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitUse_schema_statement(@NotNull sqlParser.Use_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#table_definition}.
	 * @param ctx the parse tree
	 */
	void enterTable_definition(@NotNull sqlParser.Table_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#table_definition}.
	 * @param ctx the parse tree
	 */
	void exitTable_definition(@NotNull sqlParser.Table_definitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionDropColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccionDropColumn(@NotNull sqlParser.AccionDropColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionDropColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccionDropColumn(@NotNull sqlParser.AccionDropColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#use}.
	 * @param ctx the parse tree
	 */
	void enterUse(@NotNull sqlParser.UseContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#use}.
	 * @param ctx the parse tree
	 */
	void exitUse(@NotNull sqlParser.UseContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(@NotNull sqlParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(@NotNull sqlParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_schema_manipulation_statement(@NotNull sqlParser.Sql_schema_manipulation_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_schema_manipulation_statement(@NotNull sqlParser.Sql_schema_manipulation_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterAlter_table_statement(@NotNull sqlParser.Alter_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitAlter_table_statement(@NotNull sqlParser.Alter_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 */
	void enterAlter_database_statement(@NotNull sqlParser.Alter_database_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 */
	void exitAlter_database_statement(@NotNull sqlParser.Alter_database_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#create}.
	 * @param ctx the parse tree
	 */
	void enterCreate(@NotNull sqlParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#create}.
	 * @param ctx the parse tree
	 */
	void exitCreate(@NotNull sqlParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#from}.
	 * @param ctx the parse tree
	 */
	void enterFrom(@NotNull sqlParser.FromContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#from}.
	 * @param ctx the parse tree
	 */
	void exitFrom(@NotNull sqlParser.FromContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#sql2003Parser}.
	 * @param ctx the parse tree
	 */
	void enterSql2003Parser(@NotNull sqlParser.Sql2003ParserContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#sql2003Parser}.
	 * @param ctx the parse tree
	 */
	void exitSql2003Parser(@NotNull sqlParser.Sql2003ParserContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#delete_value}.
	 * @param ctx the parse tree
	 */
	void enterDelete_value(@NotNull sqlParser.Delete_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#delete_value}.
	 * @param ctx the parse tree
	 */
	void exitDelete_value(@NotNull sqlParser.Delete_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#constraint_alter}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_alter(@NotNull sqlParser.Constraint_alterContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#constraint_alter}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_alter(@NotNull sqlParser.Constraint_alterContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(@NotNull sqlParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(@NotNull sqlParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#alter}.
	 * @param ctx the parse tree
	 */
	void enterAlter(@NotNull sqlParser.AlterContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#alter}.
	 * @param ctx the parse tree
	 */
	void exitAlter(@NotNull sqlParser.AlterContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(@NotNull sqlParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(@NotNull sqlParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#check_exp}.
	 * @param ctx the parse tree
	 */
	void enterCheck_exp(@NotNull sqlParser.Check_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#check_exp}.
	 * @param ctx the parse tree
	 */
	void exitCheck_exp(@NotNull sqlParser.Check_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_executable_statement(@NotNull sqlParser.Sql_executable_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_executable_statement(@NotNull sqlParser.Sql_executable_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#int_terminal}.
	 * @param ctx the parse tree
	 */
	void enterInt_terminal(@NotNull sqlParser.Int_terminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#int_terminal}.
	 * @param ctx the parse tree
	 */
	void exitInt_terminal(@NotNull sqlParser.Int_terminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#check}.
	 * @param ctx the parse tree
	 */
	void enterCheck(@NotNull sqlParser.CheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#check}.
	 * @param ctx the parse tree
	 */
	void exitCheck(@NotNull sqlParser.CheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#identifier_update}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_update(@NotNull sqlParser.Identifier_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#identifier_update}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_update(@NotNull sqlParser.Identifier_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull sqlParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull sqlParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#where_statement_update}.
	 * @param ctx the parse tree
	 */
	void enterWhere_statement_update(@NotNull sqlParser.Where_statement_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#where_statement_update}.
	 * @param ctx the parse tree
	 */
	void exitWhere_statement_update(@NotNull sqlParser.Where_statement_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#update_column_multiple}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_column_multiple(@NotNull sqlParser.Update_column_multipleContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#update_column_multiple}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_column_multiple(@NotNull sqlParser.Update_column_multipleContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#desc}.
	 * @param ctx the parse tree
	 */
	void enterDesc(@NotNull sqlParser.DescContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#desc}.
	 * @param ctx the parse tree
	 */
	void exitDesc(@NotNull sqlParser.DescContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#drop}.
	 * @param ctx the parse tree
	 */
	void enterDrop(@NotNull sqlParser.DropContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#drop}.
	 * @param ctx the parse tree
	 */
	void exitDrop(@NotNull sqlParser.DropContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(@NotNull sqlParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(@NotNull sqlParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_column_statement(@NotNull sqlParser.Show_column_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_column_statement(@NotNull sqlParser.Show_column_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code values}
	 * labeled alternative in {@link sqlParser#accionaccionaccionaccionconstraintTypeconstraintTypeconstraintTypeAlterconstraintTypeAlterconstraintTypeconstraintTypeAlter}.
	 * @param ctx the parse tree
	 */
	void enterValues(@NotNull sqlParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code values}
	 * labeled alternative in {@link sqlParser#accionaccionaccionaccionconstraintTypeconstraintTypeconstraintTypeAlterconstraintTypeAlterconstraintTypeconstraintTypeAlter}.
	 * @param ctx the parse tree
	 */
	void exitValues(@NotNull sqlParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShow(@NotNull sqlParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShow(@NotNull sqlParser.ShowContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_schema_definition_statement(@NotNull sqlParser.Sql_schema_definition_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_schema_definition_statement(@NotNull sqlParser.Sql_schema_definition_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#insert}.
	 * @param ctx the parse tree
	 */
	void enterInsert(@NotNull sqlParser.InsertContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#insert}.
	 * @param ctx the parse tree
	 */
	void exitInsert(@NotNull sqlParser.InsertContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(@NotNull sqlParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(@NotNull sqlParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#delete}.
	 * @param ctx the parse tree
	 */
	void enterDelete(@NotNull sqlParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#delete}.
	 * @param ctx the parse tree
	 */
	void exitDelete(@NotNull sqlParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_schema_statement(@NotNull sqlParser.Show_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_schema_statement(@NotNull sqlParser.Show_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#database_plural}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_plural(@NotNull sqlParser.Database_pluralContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#database_plural}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_plural(@NotNull sqlParser.Database_pluralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionAddConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccionAddConstraint(@NotNull sqlParser.AccionAddConstraintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionAddConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccionAddConstraint(@NotNull sqlParser.AccionAddConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void enterDatabase(@NotNull sqlParser.DatabaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#database}.
	 * @param ctx the parse tree
	 */
	void exitDatabase(@NotNull sqlParser.DatabaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull sqlParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull sqlParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#null_literal}.
	 * @param ctx the parse tree
	 */
	void enterNull_literal(@NotNull sqlParser.Null_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#null_literal}.
	 * @param ctx the parse tree
	 */
	void exitNull_literal(@NotNull sqlParser.Null_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull sqlParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull sqlParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull sqlParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull sqlParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void enterDate_literal(@NotNull sqlParser.Date_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void exitDate_literal(@NotNull sqlParser.Date_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull sqlParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull sqlParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#column_terminal_plural}.
	 * @param ctx the parse tree
	 */
	void enterColumn_terminal_plural(@NotNull sqlParser.Column_terminal_pluralContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#column_terminal_plural}.
	 * @param ctx the parse tree
	 */
	void exitColumn_terminal_plural(@NotNull sqlParser.Column_terminal_pluralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintCheckAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 */
	void enterConstraintCheckAlter(@NotNull sqlParser.ConstraintCheckAlterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintCheckAlter}
	 * labeled alternative in {@link sqlParser#constraintTypeAlter}.
	 * @param ctx the parse tree
	 */
	void exitConstraintCheckAlter(@NotNull sqlParser.ConstraintCheckAlterContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#insert_value}.
	 * @param ctx the parse tree
	 */
	void enterInsert_value(@NotNull sqlParser.Insert_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#insert_value}.
	 * @param ctx the parse tree
	 */
	void exitInsert_value(@NotNull sqlParser.Insert_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#condition_update}.
	 * @param ctx the parse tree
	 */
	void enterCondition_update(@NotNull sqlParser.Condition_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#condition_update}.
	 * @param ctx the parse tree
	 */
	void exitCondition_update(@NotNull sqlParser.Condition_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#char_name}.
	 * @param ctx the parse tree
	 */
	void enterChar_name(@NotNull sqlParser.Char_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#char_name}.
	 * @param ctx the parse tree
	 */
	void exitChar_name(@NotNull sqlParser.Char_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#date_terminal}.
	 * @param ctx the parse tree
	 */
	void enterDate_terminal(@NotNull sqlParser.Date_terminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#date_terminal}.
	 * @param ctx the parse tree
	 */
	void exitDate_terminal(@NotNull sqlParser.Date_terminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#update_value}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_value(@NotNull sqlParser.Update_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#update_value}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_value(@NotNull sqlParser.Update_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#select_values}.
	 * @param ctx the parse tree
	 */
	void enterSelect_values(@NotNull sqlParser.Select_valuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#select_values}.
	 * @param ctx the parse tree
	 */
	void exitSelect_values(@NotNull sqlParser.Select_valuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_table_statement(@NotNull sqlParser.Show_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_table_statement(@NotNull sqlParser.Show_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(@NotNull sqlParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(@NotNull sqlParser.RelationalContext ctx);
}
