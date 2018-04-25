// Generated from /Users/usuario/NetBeansProjects/DBMS/src/antlr/sql.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__94=1, T__93=2, T__92=3, T__91=4, T__90=5, T__89=6, T__88=7, T__87=8, 
		T__86=9, T__85=10, T__84=11, T__83=12, T__82=13, T__81=14, T__80=15, T__79=16, 
		T__78=17, T__77=18, T__76=19, T__75=20, T__74=21, T__73=22, T__72=23, 
		T__71=24, T__70=25, T__69=26, T__68=27, T__67=28, T__66=29, T__65=30, 
		T__64=31, T__63=32, T__62=33, T__61=34, T__60=35, T__59=36, T__58=37, 
		T__57=38, T__56=39, T__55=40, T__54=41, T__53=42, T__52=43, T__51=44, 
		T__50=45, T__49=46, T__48=47, T__47=48, T__46=49, T__45=50, T__44=51, 
		T__43=52, T__42=53, T__41=54, T__40=55, T__39=56, T__38=57, T__37=58, 
		T__36=59, T__35=60, T__34=61, T__33=62, T__32=63, T__31=64, T__30=65, 
		T__29=66, T__28=67, T__27=68, T__26=69, T__25=70, T__24=71, T__23=72, 
		T__22=73, T__21=74, T__20=75, T__19=76, T__18=77, T__17=78, T__16=79, 
		T__15=80, T__14=81, T__13=82, T__12=83, T__11=84, T__10=85, T__9=86, T__8=87, 
		T__7=88, T__6=89, T__5=90, T__4=91, T__3=92, T__2=93, T__1=94, T__0=95, 
		BOOLEAN=96, DATETIME=97, ID=98, NUM=99, FLOAT=100, DATE=101, CHAR=102, 
		WS=103, COMMENT=104;
	public static final String[] tokenNames = {
		"<INVALID>", "'FOREIGN'", "'CONSTRAINT'", "'FROM'", "'use'", "'char'", 
		"'alter'", "'set'", "'!='", "'float'", "'REFERENCES'", "'order'", "'insert'", 
		"'='", "'delete'", "'check'", "'database'", "'int'", "'null'", "'('", 
		"'tables'", "'column'", "','", "'primary'", "'COLUMNS'", "'PRIMARY'", 
		"'VALUES'", "'ASC'", "'CHECK'", "'UPDATE'", "'DELETE'", "'columns'", "'>='", 
		"'<'", "'TABLES'", "'desc'", "'date'", "'<>'", "'rename'", "'INSERT'", 
		"'NULL'", "'SHOW'", "'CREATE'", "'COLUMN'", "'TABLE'", "'DATABASES'", 
		"'BY'", "'foreign'", "'by'", "'WHERE'", "'create'", "'databases'", "'INTO'", 
		"';'", "'AND'", "'NOT'", "'asc'", "'<='", "'ADD'", "'from'", "'constraint'", 
		"'KEY'", "'values'", "'ORDER'", "'*'", "'SELECT'", "'update'", "'.'", 
		"'DROP'", "'add'", "'key'", "'DATE'", "'INT'", "'TO'", "'RENAME'", "'to'", 
		"'CHAR'", "'drop'", "'select'", "'show'", "'>'", "'OR'", "'or'", "'ALTER'", 
		"'where'", "'USE'", "'table'", "'into'", "'FLOAT'", "')'", "'and'", "'DESC'", 
		"'DATABASE'", "'not'", "'SET'", "'references'", "'boolean'", "'datetime'", 
		"ID", "NUM", "FLOAT", "DATE", "CHAR", "WS", "COMMENT"
	};
	public static final int
		RULE_create = 0, RULE_database = 1, RULE_database_plural = 2, RULE_table = 3, 
		RULE_drop = 4, RULE_alter = 5, RULE_rename = 6, RULE_to = 7, RULE_show = 8, 
		RULE_use = 9, RULE_int_terminal = 10, RULE_float_terminal = 11, RULE_char_name = 12, 
		RULE_char_terminal = 13, RULE_date_terminal = 14, RULE_constraint_terminal = 15, 
		RULE_primary = 16, RULE_key = 17, RULE_foreign = 18, RULE_references = 19, 
		RULE_check = 20, RULE_insert = 21, RULE_update = 22, RULE_delete = 23, 
		RULE_select = 24, RULE_set = 25, RULE_where = 26, RULE_order = 27, RULE_by = 28, 
		RULE_asc = 29, RULE_desc = 30, RULE_into = 31, RULE_values = 32, RULE_tables = 33, 
		RULE_from = 34, RULE_add = 35, RULE_column_terminal = 36, RULE_column_terminal_plural = 37, 
		RULE_and = 38, RULE_or = 39, RULE_not = 40, RULE_sql2003Parser = 41, RULE_sql_executable_statement = 42, 
		RULE_sql_schema_statement = 43, RULE_sql_schema_definition_statement = 44, 
		RULE_sql_schema_manipulation_statement = 45, RULE_sql_data_statement = 46, 
		RULE_schema_definition = 47, RULE_table_definition = 48, RULE_column_or_constraint = 49, 
		RULE_drop_schema_statement = 50, RULE_alter_table_statement = 51, RULE_drop_table_statement = 52, 
		RULE_alter_database_statement = 53, RULE_show_schema_statement = 54, RULE_use_schema_statement = 55, 
		RULE_column = 56, RULE_tipo_literal = 57, RULE_constraint = 58, RULE_constraintType = 59, 
		RULE_num_or_id = 60, RULE_id_list = 61, RULE_check_exp = 62, RULE_rename_table_statement = 63, 
		RULE_accion = 64, RULE_constraint_alter = 65, RULE_constraintTypeAlter = 66, 
		RULE_show_table_statement = 67, RULE_show_column_statement = 68, RULE_insert_value = 69, 
		RULE_insert_column_names = 70, RULE_logic = 71, RULE_relational = 72, 
		RULE_update_value = 73, RULE_update_column_multiple = 74, RULE_update_colmn = 75, 
		RULE_delete_value = 76, RULE_select_value = 77, RULE_final_where = 78, 
		RULE_final_where_update = 79, RULE_from_multiple = 80, RULE_select_values = 81, 
		RULE_first_where_statement = 82, RULE_first_where_statement_update = 83, 
		RULE_where_statement_update = 84, RULE_where_statement = 85, RULE_condition = 86, 
		RULE_condition_update = 87, RULE_identifier = 88, RULE_identifier_select_value = 89, 
		RULE_identifier_update = 90, RULE_list_values = 91, RULE_value = 92, RULE_tipo = 93, 
		RULE_literal = 94, RULE_int_literal = 95, RULE_float_literal = 96, RULE_date_literal = 97, 
		RULE_char_literal = 98, RULE_null_literal = 99;
	public static final String[] ruleNames = {
		"create", "database", "database_plural", "table", "drop", "alter", "rename", 
		"to", "show", "use", "int_terminal", "float_terminal", "char_name", "char_terminal", 
		"date_terminal", "constraint_terminal", "primary", "key", "foreign", "references", 
		"check", "insert", "update", "delete", "select", "set", "where", "order", 
		"by", "asc", "desc", "into", "values", "tables", "from", "add", "column_terminal", 
		"column_terminal_plural", "and", "or", "not", "sql2003Parser", "sql_executable_statement", 
		"sql_schema_statement", "sql_schema_definition_statement", "sql_schema_manipulation_statement", 
		"sql_data_statement", "schema_definition", "table_definition", "column_or_constraint", 
		"drop_schema_statement", "alter_table_statement", "drop_table_statement", 
		"alter_database_statement", "show_schema_statement", "use_schema_statement", 
		"column", "tipo_literal", "constraint", "constraintType", "num_or_id", 
		"id_list", "check_exp", "rename_table_statement", "accion", "constraint_alter", 
		"constraintTypeAlter", "show_table_statement", "show_column_statement", 
		"insert_value", "insert_column_names", "logic", "relational", "update_value", 
		"update_column_multiple", "update_colmn", "delete_value", "select_value", 
		"final_where", "final_where_update", "from_multiple", "select_values", 
		"first_where_statement", "first_where_statement_update", "where_statement_update", 
		"where_statement", "condition", "condition_update", "identifier", "identifier_select_value", 
		"identifier_update", "list_values", "value", "tipo", "literal", "int_literal", 
		"float_literal", "date_literal", "char_literal", "null_literal"
	};

	@Override
	public String getGrammarFileName() { return "sql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public sqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CreateContext extends ParserRuleContext {
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCreate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_create);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_la = _input.LA(1);
			if ( !(_la==T__53 || _la==T__45) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatabaseContext extends ParserRuleContext {
		public DatabaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDatabase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDatabase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDatabase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatabaseContext database() throws RecognitionException {
		DatabaseContext _localctx = new DatabaseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_database);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !(_la==T__79 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Database_pluralContext extends ParserRuleContext {
		public Database_pluralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_plural; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDatabase_plural(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDatabase_plural(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDatabase_plural(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Database_pluralContext database_plural() throws RecognitionException {
		Database_pluralContext _localctx = new Database_pluralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_database_plural);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_la = _input.LA(1);
			if ( !(_la==T__50 || _la==T__44) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableContext extends ParserRuleContext {
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !(_la==T__51 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropContext extends ParserRuleContext {
		public DropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDrop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDrop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDrop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropContext drop() throws RecognitionException {
		DropContext _localctx = new DropContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_drop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlterContext extends ParserRuleContext {
		public AlterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterContext alter() throws RecognitionException {
		AlterContext _localctx = new AlterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_alter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !(_la==T__89 || _la==T__12) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RenameContext extends ParserRuleContext {
		public RenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenameContext rename() throws RecognitionException {
		RenameContext _localctx = new RenameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !(_la==T__57 || _la==T__21) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToContext extends ParserRuleContext {
		public ToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToContext to() throws RecognitionException {
		ToContext _localctx = new ToContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_to);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_la = _input.LA(1);
			if ( !(_la==T__22 || _la==T__20) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowContext extends ParserRuleContext {
		public ShowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowContext show() throws RecognitionException {
		ShowContext _localctx = new ShowContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_show);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !(_la==T__54 || _la==T__16) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UseContext extends ParserRuleContext {
		public UseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UseContext use() throws RecognitionException {
		UseContext _localctx = new UseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_use);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_la = _input.LA(1);
			if ( !(_la==T__91 || _la==T__10) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_terminalContext extends ParserRuleContext {
		public Int_terminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInt_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInt_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInt_terminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_terminalContext int_terminal() throws RecognitionException {
		Int_terminalContext _localctx = new Int_terminalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_int_terminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !(_la==T__78 || _la==T__23) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Float_terminalContext extends ParserRuleContext {
		public Float_terminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_float_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFloat_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFloat_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFloat_terminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Float_terminalContext float_terminal() throws RecognitionException {
		Float_terminalContext _localctx = new Float_terminalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_float_terminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_la = _input.LA(1);
			if ( !(_la==T__86 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_nameContext extends ParserRuleContext {
		public Char_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterChar_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitChar_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitChar_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_nameContext char_name() throws RecognitionException {
		Char_nameContext _localctx = new Char_nameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_char_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_la = _input.LA(1);
			if ( !(_la==T__90 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_terminalContext extends ParserRuleContext {
		public Char_nameContext char_name() {
			return getRuleContext(Char_nameContext.class,0);
		}
		public TerminalNode NUM() { return getToken(sqlParser.NUM, 0); }
		public Char_terminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterChar_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitChar_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitChar_terminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_terminalContext char_terminal() throws RecognitionException {
		Char_terminalContext _localctx = new Char_terminalContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_char_terminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); char_name();
			setState(227); match(T__76);
			setState(228); match(NUM);
			setState(229); match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_terminalContext extends ParserRuleContext {
		public Date_terminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDate_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDate_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDate_terminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_terminalContext date_terminal() throws RecognitionException {
		Date_terminalContext _localctx = new Date_terminalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_date_terminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_la = _input.LA(1);
			if ( !(_la==T__59 || _la==T__24) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constraint_terminalContext extends ParserRuleContext {
		public Constraint_terminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraint_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraint_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraint_terminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_terminalContext constraint_terminal() throws RecognitionException {
		Constraint_terminalContext _localctx = new Constraint_terminalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constraint_terminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_la = _input.LA(1);
			if ( !(_la==T__93 || _la==T__35) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_la = _input.LA(1);
			if ( !(_la==T__72 || _la==T__70) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyContext extends ParserRuleContext {
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__25) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForeignContext extends ParserRuleContext {
		public ForeignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterForeign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitForeign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitForeign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeignContext foreign() throws RecognitionException {
		ForeignContext _localctx = new ForeignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_foreign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !(_la==T__94 || _la==T__48) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferencesContext extends ParserRuleContext {
		public ReferencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_references; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterReferences(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitReferences(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitReferences(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferencesContext references() throws RecognitionException {
		ReferencesContext _localctx = new ReferencesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_references);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==T__85 || _la==T__0) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckContext extends ParserRuleContext {
		public CheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckContext check() throws RecognitionException {
		CheckContext _localctx = new CheckContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_check);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !(_la==T__80 || _la==T__67) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertContext extends ParserRuleContext {
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInsert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInsert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_insert);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !(_la==T__83 || _la==T__56) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateContext extends ParserRuleContext {
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_update);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_la = _input.LA(1);
			if ( !(_la==T__66 || _la==T__29) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteContext extends ParserRuleContext {
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDelete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDelete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_delete);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !(_la==T__81 || _la==T__65) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectContext extends ParserRuleContext {
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_select);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !(_la==T__30 || _la==T__17) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_la = _input.LA(1);
			if ( !(_la==T__88 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereContext extends ParserRuleContext {
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitWhere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitWhere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !(_la==T__46 || _la==T__11) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderContext extends ParserRuleContext {
		public OrderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitOrder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitOrder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderContext order() throws RecognitionException {
		OrderContext _localctx = new OrderContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_order);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !(_la==T__84 || _la==T__32) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ByContext extends ParserRuleContext {
		public ByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_by; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitBy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitBy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ByContext by() throws RecognitionException {
		ByContext _localctx = new ByContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_by);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !(_la==T__49 || _la==T__47) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AscContext extends ParserRuleContext {
		public AscContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAsc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAsc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAsc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AscContext asc() throws RecognitionException {
		AscContext _localctx = new AscContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_asc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_la = _input.LA(1);
			if ( !(_la==T__68 || _la==T__39) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescContext extends ParserRuleContext {
		public DescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDesc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescContext desc() throws RecognitionException {
		DescContext _localctx = new DescContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_desc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !(_la==T__60 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntoContext extends ParserRuleContext {
		public IntoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_into; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntoContext into() throws RecognitionException {
		IntoContext _localctx = new IntoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_into);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_la = _input.LA(1);
			if ( !(_la==T__43 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesContext extends ParserRuleContext {
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_la = _input.LA(1);
			if ( !(_la==T__69 || _la==T__33) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablesContext extends ParserRuleContext {
		public TablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablesContext tables() throws RecognitionException {
		TablesContext _localctx = new TablesContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_tables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_la = _input.LA(1);
			if ( !(_la==T__75 || _la==T__61) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromContext extends ParserRuleContext {
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_from);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if ( !(_la==T__92 || _la==T__36) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_la = _input.LA(1);
			if ( !(_la==T__37 || _la==T__26) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_terminalContext extends ParserRuleContext {
		public Column_terminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumn_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumn_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumn_terminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_terminalContext column_terminal() throws RecognitionException {
		Column_terminalContext _localctx = new Column_terminalContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_column_terminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !(_la==T__74 || _la==T__52) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_terminal_pluralContext extends ParserRuleContext {
		public Column_terminal_pluralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_terminal_plural; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumn_terminal_plural(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumn_terminal_plural(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumn_terminal_plural(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_terminal_pluralContext column_terminal_plural() throws RecognitionException {
		Column_terminal_pluralContext _localctx = new Column_terminal_pluralContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_column_terminal_plural);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !(_la==T__71 || _la==T__64) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !(_la==T__41 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__13) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContext extends ParserRuleContext {
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_not);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_la = _input.LA(1);
			if ( !(_la==T__40 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql2003ParserContext extends ParserRuleContext {
		public List<Sql_executable_statementContext> sql_executable_statement() {
			return getRuleContexts(Sql_executable_statementContext.class);
		}
		public Sql_executable_statementContext sql_executable_statement(int i) {
			return getRuleContext(Sql_executable_statementContext.class,i);
		}
		public Sql2003ParserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql2003Parser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql2003Parser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql2003Parser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql2003Parser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql2003ParserContext sql2003Parser() throws RecognitionException {
		Sql2003ParserContext _localctx = new Sql2003ParserContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_sql2003Parser);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(285); sql_executable_statement();
				}
				}
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__91) | (1L << T__89) | (1L << T__83) | (1L << T__81) | (1L << T__66) | (1L << T__65) | (1L << T__56) | (1L << T__54) | (1L << T__53) | (1L << T__45))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__30 - 65)) | (1L << (T__29 - 65)) | (1L << (T__27 - 65)) | (1L << (T__18 - 65)) | (1L << (T__17 - 65)) | (1L << (T__16 - 65)) | (1L << (T__12 - 65)) | (1L << (T__10 - 65)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_executable_statementContext extends ParserRuleContext {
		public Sql_schema_statementContext sql_schema_statement() {
			return getRuleContext(Sql_schema_statementContext.class,0);
		}
		public Sql_data_statementContext sql_data_statement() {
			return getRuleContext(Sql_data_statementContext.class,0);
		}
		public Sql_executable_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_executable_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_executable_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_executable_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_executable_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_executable_statementContext sql_executable_statement() throws RecognitionException {
		Sql_executable_statementContext _localctx = new Sql_executable_statementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_sql_executable_statement);
		try {
			setState(292);
			switch (_input.LA(1)) {
			case T__91:
			case T__89:
			case T__54:
			case T__53:
			case T__45:
			case T__27:
			case T__18:
			case T__16:
			case T__12:
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(290); sql_schema_statement();
				}
				break;
			case T__83:
			case T__81:
			case T__66:
			case T__65:
			case T__56:
			case T__30:
			case T__29:
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(291); sql_data_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_statementContext extends ParserRuleContext {
		public Sql_schema_manipulation_statementContext sql_schema_manipulation_statement() {
			return getRuleContext(Sql_schema_manipulation_statementContext.class,0);
		}
		public Sql_schema_definition_statementContext sql_schema_definition_statement() {
			return getRuleContext(Sql_schema_definition_statementContext.class,0);
		}
		public Sql_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_statementContext sql_schema_statement() throws RecognitionException {
		Sql_schema_statementContext _localctx = new Sql_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_sql_schema_statement);
		try {
			setState(296);
			switch (_input.LA(1)) {
			case T__53:
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(294); sql_schema_definition_statement();
				}
				break;
			case T__91:
			case T__89:
			case T__54:
			case T__27:
			case T__18:
			case T__16:
			case T__12:
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(295); sql_schema_manipulation_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_definition_statementContext extends ParserRuleContext {
		public Table_definitionContext table_definition() {
			return getRuleContext(Table_definitionContext.class,0);
		}
		public Schema_definitionContext schema_definition() {
			return getRuleContext(Schema_definitionContext.class,0);
		}
		public Sql_schema_definition_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_definition_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_schema_definition_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_schema_definition_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_schema_definition_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_definition_statementContext sql_schema_definition_statement() throws RecognitionException {
		Sql_schema_definition_statementContext _localctx = new Sql_schema_definition_statementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_sql_schema_definition_statement);
		try {
			setState(300);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(298); schema_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299); table_definition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_manipulation_statementContext extends ParserRuleContext {
		public Drop_table_statementContext drop_table_statement() {
			return getRuleContext(Drop_table_statementContext.class,0);
		}
		public Drop_schema_statementContext drop_schema_statement() {
			return getRuleContext(Drop_schema_statementContext.class,0);
		}
		public Show_schema_statementContext show_schema_statement() {
			return getRuleContext(Show_schema_statementContext.class,0);
		}
		public Alter_table_statementContext alter_table_statement() {
			return getRuleContext(Alter_table_statementContext.class,0);
		}
		public Alter_database_statementContext alter_database_statement() {
			return getRuleContext(Alter_database_statementContext.class,0);
		}
		public Rename_table_statementContext rename_table_statement() {
			return getRuleContext(Rename_table_statementContext.class,0);
		}
		public Show_table_statementContext show_table_statement() {
			return getRuleContext(Show_table_statementContext.class,0);
		}
		public Use_schema_statementContext use_schema_statement() {
			return getRuleContext(Use_schema_statementContext.class,0);
		}
		public Show_column_statementContext show_column_statement() {
			return getRuleContext(Show_column_statementContext.class,0);
		}
		public Sql_schema_manipulation_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_manipulation_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_schema_manipulation_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_schema_manipulation_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_schema_manipulation_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_manipulation_statementContext sql_schema_manipulation_statement() throws RecognitionException {
		Sql_schema_manipulation_statementContext _localctx = new Sql_schema_manipulation_statementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_sql_schema_manipulation_statement);
		try {
			setState(311);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(302); drop_schema_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303); alter_table_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(304); drop_table_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(305); alter_database_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(306); use_schema_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(307); show_schema_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(308); rename_table_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(309); show_table_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(310); show_column_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_data_statementContext extends ParserRuleContext {
		public Delete_valueContext delete_value() {
			return getRuleContext(Delete_valueContext.class,0);
		}
		public Insert_valueContext insert_value() {
			return getRuleContext(Insert_valueContext.class,0);
		}
		public Update_valueContext update_value() {
			return getRuleContext(Update_valueContext.class,0);
		}
		public Select_valueContext select_value() {
			return getRuleContext(Select_valueContext.class,0);
		}
		public Sql_data_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_data_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_data_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_data_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_data_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_data_statementContext sql_data_statement() throws RecognitionException {
		Sql_data_statementContext _localctx = new Sql_data_statementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_sql_data_statement);
		try {
			setState(317);
			switch (_input.LA(1)) {
			case T__30:
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(313); select_value();
				}
				break;
			case T__83:
			case T__56:
				enterOuterAlt(_localctx, 2);
				{
				setState(314); insert_value();
				}
				break;
			case T__66:
			case T__29:
				enterOuterAlt(_localctx, 3);
				{
				setState(315); update_value();
				}
				break;
			case T__81:
			case T__65:
				enterOuterAlt(_localctx, 4);
				{
				setState(316); delete_value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_definitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public DatabaseContext database() {
			return getRuleContext(DatabaseContext.class,0);
		}
		public Schema_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSchema_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSchema_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSchema_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Schema_definitionContext schema_definition() throws RecognitionException {
		Schema_definitionContext _localctx = new Schema_definitionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_schema_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); create();
			setState(320); database();
			setState(321); match(ID);
			setState(322); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_definitionContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public Column_or_constraintContext column_or_constraint() {
			return getRuleContext(Column_or_constraintContext.class,0);
		}
		public Table_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTable_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTable_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTable_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_definitionContext table_definition() throws RecognitionException {
		Table_definitionContext _localctx = new Table_definitionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_table_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); create();
			setState(325); table();
			setState(326); match(ID);
			setState(327); match(T__76);
			{
			setState(328); column_or_constraint();
			}
			setState(329); match(T__6);
			setState(330); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_or_constraintContext extends ParserRuleContext {
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public Column_or_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_or_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumn_or_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumn_or_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumn_or_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_or_constraintContext column_or_constraint() throws RecognitionException {
		Column_or_constraintContext _localctx = new Column_or_constraintContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_column_or_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(334);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(332); column();
					}
					break;
				case T__93:
				case T__35:
					{
					setState(333); constraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(336); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__93 || _la==T__35 || _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_schema_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public DatabaseContext database() {
			return getRuleContext(DatabaseContext.class,0);
		}
		public DropContext drop() {
			return getRuleContext(DropContext.class,0);
		}
		public Drop_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDrop_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDrop_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDrop_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_schema_statementContext drop_schema_statement() throws RecognitionException {
		Drop_schema_statementContext _localctx = new Drop_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_drop_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338); drop();
			setState(339); database();
			setState(340); match(ID);
			setState(341); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_statementContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public AccionContext accion() {
			return getRuleContext(AccionContext.class,0);
		}
		public AlterContext alter() {
			return getRuleContext(AlterContext.class,0);
		}
		public Alter_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlter_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlter_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlter_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_table_statementContext alter_table_statement() throws RecognitionException {
		Alter_table_statementContext _localctx = new Alter_table_statementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_alter_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343); alter();
			setState(344); table();
			setState(345); match(ID);
			setState(346); accion();
			setState(347); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_table_statementContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public DropContext drop() {
			return getRuleContext(DropContext.class,0);
		}
		public Drop_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDrop_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDrop_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDrop_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_table_statementContext drop_table_statement() throws RecognitionException {
		Drop_table_statementContext _localctx = new Drop_table_statementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); drop();
			setState(350); table();
			setState(351); match(ID);
			setState(352); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_database_statementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public DatabaseContext database() {
			return getRuleContext(DatabaseContext.class,0);
		}
		public AlterContext alter() {
			return getRuleContext(AlterContext.class,0);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public RenameContext rename() {
			return getRuleContext(RenameContext.class,0);
		}
		public Alter_database_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_database_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlter_database_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlter_database_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlter_database_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_database_statementContext alter_database_statement() throws RecognitionException {
		Alter_database_statementContext _localctx = new Alter_database_statementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_alter_database_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354); alter();
			setState(355); database();
			setState(356); match(ID);
			setState(357); rename();
			setState(358); to();
			setState(359); match(ID);
			setState(360); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_schema_statementContext extends ParserRuleContext {
		public Database_pluralContext database_plural() {
			return getRuleContext(Database_pluralContext.class,0);
		}
		public ShowContext show() {
			return getRuleContext(ShowContext.class,0);
		}
		public Show_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShow_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShow_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShow_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_schema_statementContext show_schema_statement() throws RecognitionException {
		Show_schema_statementContext _localctx = new Show_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_show_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362); show();
			setState(363); database_plural();
			setState(364); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Use_schema_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public UseContext use() {
			return getRuleContext(UseContext.class,0);
		}
		public DatabaseContext database() {
			return getRuleContext(DatabaseContext.class,0);
		}
		public Use_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUse_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUse_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUse_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Use_schema_statementContext use_schema_statement() throws RecognitionException {
		Use_schema_statementContext _localctx = new Use_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_use_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); use();
			setState(367); database();
			setState(368); match(ID);
			setState(369); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Tipo_literalContext tipo_literal() {
			return getRuleContext(Tipo_literalContext.class,0);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(371); match(ID);
			setState(372); tipo_literal();
			}
			setState(375);
			_la = _input.LA(1);
			if (_la==T__73) {
				{
				setState(374); match(T__73);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_literalContext extends ParserRuleContext {
		public Float_terminalContext float_terminal() {
			return getRuleContext(Float_terminalContext.class,0);
		}
		public Char_terminalContext char_terminal() {
			return getRuleContext(Char_terminalContext.class,0);
		}
		public Int_terminalContext int_terminal() {
			return getRuleContext(Int_terminalContext.class,0);
		}
		public Date_terminalContext date_terminal() {
			return getRuleContext(Date_terminalContext.class,0);
		}
		public Tipo_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTipo_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTipo_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTipo_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_literalContext tipo_literal() throws RecognitionException {
		Tipo_literalContext _localctx = new Tipo_literalContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_tipo_literal);
		try {
			setState(381);
			switch (_input.LA(1)) {
			case T__78:
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(377); int_terminal();
				}
				break;
			case T__86:
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(378); float_terminal();
				}
				break;
			case T__90:
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(379); char_terminal();
				}
				break;
			case T__59:
			case T__24:
				enterOuterAlt(_localctx, 4);
				{
				setState(380); date_terminal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public Constraint_terminalContext constraint_terminal() {
			return getRuleContext(Constraint_terminalContext.class,0);
		}
		public ConstraintTypeContext constraintType() {
			return getRuleContext(ConstraintTypeContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383); constraint_terminal();
			setState(384); constraintType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTypeContext extends ParserRuleContext {
		public ConstraintTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintType; }
	 
		public ConstraintTypeContext() { }
		public void copyFrom(ConstraintTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstraintCheckContext extends ConstraintTypeContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public List<Check_expContext> check_exp() {
			return getRuleContexts(Check_expContext.class);
		}
		public List<LogicContext> logic() {
			return getRuleContexts(LogicContext.class);
		}
		public LogicContext logic(int i) {
			return getRuleContext(LogicContext.class,i);
		}
		public CheckContext check() {
			return getRuleContext(CheckContext.class,0);
		}
		public Check_expContext check_exp(int i) {
			return getRuleContext(Check_expContext.class,i);
		}
		public ConstraintCheckContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintCheck(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstraintPrimaryKeyContext extends ConstraintTypeContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ConstraintPrimaryKeyContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintPrimaryKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintPrimaryKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintPrimaryKey(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstraintForeignKeyContext extends ConstraintTypeContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public List<Id_listContext> id_list() {
			return getRuleContexts(Id_listContext.class);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ReferencesContext references() {
			return getRuleContext(ReferencesContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public ForeignContext foreign() {
			return getRuleContext(ForeignContext.class,0);
		}
		public Id_listContext id_list(int i) {
			return getRuleContext(Id_listContext.class,i);
		}
		public ConstraintForeignKeyContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintForeignKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintForeignKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintForeignKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintTypeContext constraintType() throws RecognitionException {
		ConstraintTypeContext _localctx = new ConstraintTypeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_constraintType);
		int _la;
		try {
			setState(425);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ConstraintPrimaryKeyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(386); match(ID);
				setState(387); primary();
				setState(388); key();
				setState(389); match(T__76);
				setState(390); id_list();
				setState(391); match(T__6);
				setState(393);
				_la = _input.LA(1);
				if (_la==T__73) {
					{
					setState(392); match(T__73);
					}
				}

				}
				break;
			case 2:
				_localctx = new ConstraintForeignKeyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(395); match(ID);
				setState(396); foreign();
				setState(397); key();
				setState(398); match(T__76);
				setState(399); id_list();
				setState(400); match(T__6);
				setState(401); references();
				setState(402); match(ID);
				setState(403); match(T__76);
				setState(404); id_list();
				setState(405); match(T__6);
				setState(407);
				_la = _input.LA(1);
				if (_la==T__73) {
					{
					setState(406); match(T__73);
					}
				}

				}
				break;
			case 3:
				_localctx = new ConstraintCheckContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(409); match(ID);
				setState(410); check();
				setState(411); match(T__76);
				setState(412); check_exp();
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & ((1L << (T__41 - 54)) | (1L << (T__40 - 54)) | (1L << (T__14 - 54)) | (1L << (T__13 - 54)) | (1L << (T__5 - 54)) | (1L << (T__2 - 54)))) != 0)) {
					{
					{
					setState(413); logic();
					setState(414); check_exp();
					}
					}
					setState(420);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(421); match(T__6);
				setState(423);
				_la = _input.LA(1);
				if (_la==T__73) {
					{
					setState(422); match(T__73);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Num_or_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode NUM() { return getToken(sqlParser.NUM, 0); }
		public Num_or_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num_or_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterNum_or_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitNum_or_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitNum_or_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Num_or_idContext num_or_id() throws RecognitionException {
		Num_or_idContext _localctx = new Num_or_idContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_num_or_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUM) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitId_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitId_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429); match(ID);
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__73) {
				{
				{
				setState(430); match(T__73);
				setState(431); match(ID);
				}
				}
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Check_expContext extends ParserRuleContext {
		public Num_or_idContext num_or_id() {
			return getRuleContext(Num_or_idContext.class,0);
		}
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public Check_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCheck_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCheck_exp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCheck_exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Check_expContext check_exp() throws RecognitionException {
		Check_expContext _localctx = new Check_expContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_check_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437); match(ID);
			setState(438); relational();
			{
			setState(439); num_or_id();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rename_table_statementContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public AlterContext alter() {
			return getRuleContext(AlterContext.class,0);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public RenameContext rename() {
			return getRuleContext(RenameContext.class,0);
		}
		public Rename_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rename_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRename_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRename_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRename_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rename_table_statementContext rename_table_statement() throws RecognitionException {
		Rename_table_statementContext _localctx = new Rename_table_statementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_rename_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441); alter();
			setState(442); table();
			setState(443); match(ID);
			setState(444); rename();
			setState(445); to();
			setState(446); match(ID);
			setState(447); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccionContext extends ParserRuleContext {
		public AccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accion; }
	 
		public AccionContext() { }
		public void copyFrom(AccionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AccionDropConstraintContext extends AccionContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Constraint_terminalContext constraint_terminal() {
			return getRuleContext(Constraint_terminalContext.class,0);
		}
		public DropContext drop() {
			return getRuleContext(DropContext.class,0);
		}
		public AccionDropConstraintContext(AccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAccionDropConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAccionDropConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAccionDropConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccionAddColumnContext extends AccionContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Column_terminalContext column_terminal() {
			return getRuleContext(Column_terminalContext.class,0);
		}
		public Constraint_alterContext constraint_alter() {
			return getRuleContext(Constraint_alterContext.class,0);
		}
		public Tipo_literalContext tipo_literal() {
			return getRuleContext(Tipo_literalContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public AccionAddColumnContext(AccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAccionAddColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAccionAddColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAccionAddColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccionAddConstraintContext extends AccionContext {
		public Constraint_alterContext constraint_alter() {
			return getRuleContext(Constraint_alterContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public AccionAddConstraintContext(AccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAccionAddConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAccionAddConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAccionAddConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccionDropColumnContext extends AccionContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Column_terminalContext column_terminal() {
			return getRuleContext(Column_terminalContext.class,0);
		}
		public DropContext drop() {
			return getRuleContext(DropContext.class,0);
		}
		public AccionDropColumnContext(AccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAccionDropColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAccionDropColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAccionDropColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccionContext accion() throws RecognitionException {
		AccionContext _localctx = new AccionContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_accion);
		int _la;
		try {
			setState(467);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new AccionAddColumnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(449); add();
				setState(450); column_terminal();
				setState(451); match(ID);
				setState(452); tipo_literal();
				setState(454);
				_la = _input.LA(1);
				if (_la==T__93 || _la==T__35) {
					{
					setState(453); constraint_alter();
					}
				}

				}
				break;
			case 2:
				_localctx = new AccionAddConstraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(456); add();
				setState(457); constraint_alter();
				}
				break;
			case 3:
				_localctx = new AccionDropColumnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(459); drop();
				setState(460); column_terminal();
				setState(461); match(ID);
				}
				break;
			case 4:
				_localctx = new AccionDropConstraintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(463); drop();
				setState(464); constraint_terminal();
				setState(465); match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constraint_alterContext extends ParserRuleContext {
		public Constraint_terminalContext constraint_terminal() {
			return getRuleContext(Constraint_terminalContext.class,0);
		}
		public ConstraintTypeAlterContext constraintTypeAlter() {
			return getRuleContext(ConstraintTypeAlterContext.class,0);
		}
		public Constraint_alterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_alter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraint_alter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraint_alter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraint_alter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_alterContext constraint_alter() throws RecognitionException {
		Constraint_alterContext _localctx = new Constraint_alterContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_constraint_alter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469); constraint_terminal();
			setState(470); constraintTypeAlter();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTypeAlterContext extends ParserRuleContext {
		public ConstraintTypeAlterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintTypeAlter; }
	 
		public ConstraintTypeAlterContext() { }
		public void copyFrom(ConstraintTypeAlterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstraintCheckAlterContext extends ConstraintTypeAlterContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public List<Check_expContext> check_exp() {
			return getRuleContexts(Check_expContext.class);
		}
		public List<LogicContext> logic() {
			return getRuleContexts(LogicContext.class);
		}
		public LogicContext logic(int i) {
			return getRuleContext(LogicContext.class,i);
		}
		public CheckContext check() {
			return getRuleContext(CheckContext.class,0);
		}
		public Check_expContext check_exp(int i) {
			return getRuleContext(Check_expContext.class,i);
		}
		public ConstraintCheckAlterContext(ConstraintTypeAlterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintCheckAlter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintCheckAlter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintCheckAlter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstraintPrimaryKeyAlterContext extends ConstraintTypeAlterContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ConstraintPrimaryKeyAlterContext(ConstraintTypeAlterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintPrimaryKeyAlter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintPrimaryKeyAlter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintPrimaryKeyAlter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstraintForeignKeyAlterContext extends ConstraintTypeAlterContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public List<Id_listContext> id_list() {
			return getRuleContexts(Id_listContext.class);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ReferencesContext references() {
			return getRuleContext(ReferencesContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public ForeignContext foreign() {
			return getRuleContext(ForeignContext.class,0);
		}
		public Id_listContext id_list(int i) {
			return getRuleContext(Id_listContext.class,i);
		}
		public ConstraintForeignKeyAlterContext(ConstraintTypeAlterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintForeignKeyAlter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintForeignKeyAlter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintForeignKeyAlter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintTypeAlterContext constraintTypeAlter() throws RecognitionException {
		ConstraintTypeAlterContext _localctx = new ConstraintTypeAlterContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_constraintTypeAlter);
		int _la;
		try {
			setState(511);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new ConstraintPrimaryKeyAlterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(472); match(ID);
				setState(473); primary();
				setState(474); key();
				setState(475); match(T__76);
				setState(476); id_list();
				setState(477); match(T__6);
				setState(479);
				_la = _input.LA(1);
				if (_la==T__73) {
					{
					setState(478); match(T__73);
					}
				}

				}
				break;
			case 2:
				_localctx = new ConstraintForeignKeyAlterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(481); match(ID);
				setState(482); foreign();
				setState(483); key();
				setState(484); match(T__76);
				setState(485); id_list();
				setState(486); match(T__6);
				setState(487); references();
				setState(488); match(ID);
				setState(489); match(T__76);
				setState(490); id_list();
				setState(491); match(T__6);
				setState(493);
				_la = _input.LA(1);
				if (_la==T__73) {
					{
					setState(492); match(T__73);
					}
				}

				}
				break;
			case 3:
				_localctx = new ConstraintCheckAlterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(495); match(ID);
				setState(496); check();
				setState(497); match(T__76);
				setState(498); check_exp();
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & ((1L << (T__41 - 54)) | (1L << (T__40 - 54)) | (1L << (T__14 - 54)) | (1L << (T__13 - 54)) | (1L << (T__5 - 54)) | (1L << (T__2 - 54)))) != 0)) {
					{
					{
					setState(499); logic();
					setState(500); check_exp();
					}
					}
					setState(506);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(507); match(T__6);
				setState(509);
				_la = _input.LA(1);
				if (_la==T__73) {
					{
					setState(508); match(T__73);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_table_statementContext extends ParserRuleContext {
		public ShowContext show() {
			return getRuleContext(ShowContext.class,0);
		}
		public TablesContext tables() {
			return getRuleContext(TablesContext.class,0);
		}
		public Show_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShow_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShow_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShow_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_table_statementContext show_table_statement() throws RecognitionException {
		Show_table_statementContext _localctx = new Show_table_statementContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_show_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513); show();
			setState(514); tables();
			setState(515); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_column_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public ShowContext show() {
			return getRuleContext(ShowContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public Column_terminal_pluralContext column_terminal_plural() {
			return getRuleContext(Column_terminal_pluralContext.class,0);
		}
		public Show_column_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_column_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShow_column_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShow_column_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShow_column_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_column_statementContext show_column_statement() throws RecognitionException {
		Show_column_statementContext _localctx = new Show_column_statementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_show_column_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517); show();
			setState(518); column_terminal_plural();
			setState(519); from();
			setState(520); match(ID);
			setState(521); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public List_valuesContext list_values() {
			return getRuleContext(List_valuesContext.class,0);
		}
		public IntoContext into() {
			return getRuleContext(IntoContext.class,0);
		}
		public Insert_column_namesContext insert_column_names() {
			return getRuleContext(Insert_column_namesContext.class,0);
		}
		public Insert_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInsert_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInsert_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInsert_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_valueContext insert_value() throws RecognitionException {
		Insert_valueContext _localctx = new Insert_valueContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_insert_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523); insert();
			setState(524); into();
			setState(525); match(ID);
			setState(527);
			_la = _input.LA(1);
			if (_la==T__76) {
				{
				setState(526); insert_column_names();
				}
			}

			setState(529); values();
			setState(530); match(T__76);
			setState(531); list_values();
			setState(532); match(T__6);
			setState(533); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_column_namesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public Insert_column_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_column_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInsert_column_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInsert_column_names(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInsert_column_names(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_column_namesContext insert_column_names() throws RecognitionException {
		Insert_column_namesContext _localctx = new Insert_column_namesContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_insert_column_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535); match(T__76);
			setState(536); match(ID);
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__73) {
				{
				{
				setState(537); match(T__73);
				setState(538); match(ID);
				}
				}
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(544); match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicContext extends ParserRuleContext {
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_logic);
		try {
			setState(549);
			switch (_input.LA(1)) {
			case T__41:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(546); and();
				}
				break;
			case T__14:
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(547); or();
				}
				break;
			case T__40:
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(548); not();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalContext extends ParserRuleContext {
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_relational);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__87) | (1L << T__82) | (1L << T__63) | (1L << T__62) | (1L << T__58) | (1L << T__38))) != 0) || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Final_where_updateContext final_where_update() {
			return getRuleContext(Final_where_updateContext.class,0);
		}
		public UpdateContext update() {
			return getRuleContext(UpdateContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public Update_column_multipleContext update_column_multiple() {
			return getRuleContext(Update_column_multipleContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public Update_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUpdate_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUpdate_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUpdate_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_valueContext update_value() throws RecognitionException {
		Update_valueContext _localctx = new Update_valueContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_update_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553); update();
			setState(554); match(ID);
			setState(555); set();
			setState(556); update_column_multiple();
			setState(560);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__11) {
				{
				setState(557); where();
				setState(558); final_where_update();
				}
			}

			setState(562); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_column_multipleContext extends ParserRuleContext {
		public Update_colmnContext update_colmn(int i) {
			return getRuleContext(Update_colmnContext.class,i);
		}
		public List<Update_colmnContext> update_colmn() {
			return getRuleContexts(Update_colmnContext.class);
		}
		public Update_column_multipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_column_multiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUpdate_column_multiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUpdate_column_multiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUpdate_column_multiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_column_multipleContext update_column_multiple() throws RecognitionException {
		Update_column_multipleContext _localctx = new Update_column_multipleContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_update_column_multiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(564); update_colmn();
				}
				}
				setState(567); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_colmnContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Update_colmnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_colmn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUpdate_colmn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUpdate_colmn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUpdate_colmn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_colmnContext update_colmn() throws RecognitionException {
		Update_colmnContext _localctx = new Update_colmnContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_update_colmn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569); match(ID);
			setState(570); match(T__82);
			setState(571); value();
			setState(573);
			_la = _input.LA(1);
			if (_la==T__73) {
				{
				setState(572); match(T__73);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Final_where_updateContext final_where_update() {
			return getRuleContext(Final_where_updateContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public Delete_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDelete_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDelete_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDelete_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_valueContext delete_value() throws RecognitionException {
		Delete_valueContext _localctx = new Delete_valueContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_delete_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575); delete();
			setState(576); from();
			setState(577); match(ID);
			setState(581);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__11) {
				{
				setState(578); where();
				setState(579); final_where_update();
				}
			}

			setState(583); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_valueContext extends ParserRuleContext {
		public AscContext asc() {
			return getRuleContext(AscContext.class,0);
		}
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public DescContext desc() {
			return getRuleContext(DescContext.class,0);
		}
		public ByContext by() {
			return getRuleContext(ByContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public OrderContext order() {
			return getRuleContext(OrderContext.class,0);
		}
		public From_multipleContext from_multiple() {
			return getRuleContext(From_multipleContext.class,0);
		}
		public Select_valuesContext select_values() {
			return getRuleContext(Select_valuesContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public Final_whereContext final_where() {
			return getRuleContext(Final_whereContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public Select_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSelect_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSelect_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSelect_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_valueContext select_value() throws RecognitionException {
		Select_valueContext _localctx = new Select_valueContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_select_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585); select();
			setState(586); select_values();
			setState(587); from();
			setState(588); from_multiple();
			setState(592);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__11) {
				{
				setState(589); where();
				setState(590); final_where();
				}
			}

			setState(601);
			_la = _input.LA(1);
			if (_la==T__84 || _la==T__32) {
				{
				setState(594); order();
				setState(595); by();
				setState(596); match(ID);
				setState(599);
				switch (_input.LA(1)) {
				case T__68:
				case T__39:
					{
					setState(597); asc();
					}
					break;
				case T__60:
				case T__4:
					{
					setState(598); desc();
					}
					break;
				case T__42:
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(603); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Final_whereContext extends ParserRuleContext {
		public First_where_statementContext first_where_statement() {
			return getRuleContext(First_where_statementContext.class,0);
		}
		public List<Where_statementContext> where_statement() {
			return getRuleContexts(Where_statementContext.class);
		}
		public Where_statementContext where_statement(int i) {
			return getRuleContext(Where_statementContext.class,i);
		}
		public Final_whereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFinal_where(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFinal_where(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFinal_where(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Final_whereContext final_where() throws RecognitionException {
		Final_whereContext _localctx = new Final_whereContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_final_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605); first_where_statement();
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & ((1L << (T__41 - 54)) | (1L << (T__40 - 54)) | (1L << (T__14 - 54)) | (1L << (T__13 - 54)) | (1L << (T__5 - 54)) | (1L << (T__2 - 54)))) != 0)) {
				{
				{
				setState(606); where_statement();
				}
				}
				setState(611);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Final_where_updateContext extends ParserRuleContext {
		public Where_statement_updateContext where_statement_update(int i) {
			return getRuleContext(Where_statement_updateContext.class,i);
		}
		public List<Where_statement_updateContext> where_statement_update() {
			return getRuleContexts(Where_statement_updateContext.class);
		}
		public First_where_statement_updateContext first_where_statement_update() {
			return getRuleContext(First_where_statement_updateContext.class,0);
		}
		public Final_where_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_where_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFinal_where_update(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFinal_where_update(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFinal_where_update(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Final_where_updateContext final_where_update() throws RecognitionException {
		Final_where_updateContext _localctx = new Final_where_updateContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_final_where_update);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612); first_where_statement_update();
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & ((1L << (T__41 - 54)) | (1L << (T__40 - 54)) | (1L << (T__14 - 54)) | (1L << (T__13 - 54)) | (1L << (T__5 - 54)) | (1L << (T__2 - 54)))) != 0)) {
				{
				{
				setState(613); where_statement_update();
				}
				}
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class From_multipleContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public From_multipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_multiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFrom_multiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFrom_multiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFrom_multiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final From_multipleContext from_multiple() throws RecognitionException {
		From_multipleContext _localctx = new From_multipleContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_from_multiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619); match(ID);
			setState(624);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__73) {
				{
				{
				setState(620); match(T__73);
				setState(621); match(ID);
				}
				}
				setState(626);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_valuesContext extends ParserRuleContext {
		public Identifier_select_valueContext identifier_select_value(int i) {
			return getRuleContext(Identifier_select_valueContext.class,i);
		}
		public List<Identifier_select_valueContext> identifier_select_value() {
			return getRuleContexts(Identifier_select_valueContext.class);
		}
		public Select_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSelect_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSelect_values(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSelect_values(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_valuesContext select_values() throws RecognitionException {
		Select_valuesContext _localctx = new Select_valuesContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_select_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			switch (_input.LA(1)) {
			case T__31:
				{
				setState(627); match(T__31);
				}
				break;
			case ID:
				{
				setState(628); identifier_select_value();
				setState(633);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__73) {
					{
					{
					setState(629); match(T__73);
					setState(630); identifier_select_value();
					}
					}
					setState(635);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class First_where_statementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public First_where_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_first_where_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFirst_where_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFirst_where_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFirst_where_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final First_where_statementContext first_where_statement() throws RecognitionException {
		First_where_statementContext _localctx = new First_where_statementContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_first_where_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638); condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class First_where_statement_updateContext extends ParserRuleContext {
		public Condition_updateContext condition_update() {
			return getRuleContext(Condition_updateContext.class,0);
		}
		public First_where_statement_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_first_where_statement_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFirst_where_statement_update(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFirst_where_statement_update(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFirst_where_statement_update(this);
			else return visitor.visitChildren(this);
		}
	}

	public final First_where_statement_updateContext first_where_statement_update() throws RecognitionException {
		First_where_statement_updateContext _localctx = new First_where_statement_updateContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_first_where_statement_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640); condition_update();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_statement_updateContext extends ParserRuleContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public Condition_updateContext condition_update() {
			return getRuleContext(Condition_updateContext.class,0);
		}
		public Where_statement_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_statement_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterWhere_statement_update(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitWhere_statement_update(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitWhere_statement_update(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Where_statement_updateContext where_statement_update() throws RecognitionException {
		Where_statement_updateContext _localctx = new Where_statement_updateContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_where_statement_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642); logic();
			setState(643); condition_update();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_statementContext extends ParserRuleContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Where_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterWhere_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitWhere_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitWhere_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Where_statementContext where_statement() throws RecognitionException {
		Where_statementContext _localctx = new Where_statementContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_where_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645); logic();
			setState(646); condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648); identifier();
			setState(649); relational();
			setState(650); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Condition_updateContext extends ParserRuleContext {
		public List<Identifier_updateContext> identifier_update() {
			return getRuleContexts(Identifier_updateContext.class);
		}
		public Identifier_updateContext identifier_update(int i) {
			return getRuleContext(Identifier_updateContext.class,i);
		}
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public Condition_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCondition_update(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCondition_update(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCondition_update(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_updateContext condition_update() throws RecognitionException {
		Condition_updateContext _localctx = new Condition_updateContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_condition_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652); identifier_update();
			setState(653); relational();
			setState(654); identifier_update();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(656); match(ID);
				}
				break;
			case T__77:
			case T__55:
			case NUM:
			case FLOAT:
			case DATE:
			case CHAR:
				{
				setState(657); value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(662);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(660); match(T__28);
				setState(661); match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Identifier_select_valueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public Identifier_select_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_select_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterIdentifier_select_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitIdentifier_select_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitIdentifier_select_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Identifier_select_valueContext identifier_select_value() throws RecognitionException {
		Identifier_select_valueContext _localctx = new Identifier_select_valueContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_identifier_select_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(664); match(ID);
			}
			setState(667);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(665); match(T__28);
				setState(666); match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Identifier_updateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Identifier_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterIdentifier_update(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitIdentifier_update(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitIdentifier_update(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Identifier_updateContext identifier_update() throws RecognitionException {
		Identifier_updateContext _localctx = new Identifier_updateContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_identifier_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(669); match(ID);
				}
				break;
			case T__77:
			case T__55:
			case NUM:
			case FLOAT:
			case DATE:
			case CHAR:
				{
				setState(670); value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_valuesContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterList_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitList_values(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitList_values(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_valuesContext list_values() throws RecognitionException {
		List_valuesContext _localctx = new List_valuesContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_list_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(673); value();
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__73) {
				{
				{
				setState(674); match(T__73);
				{
				setState(675); value();
				}
				}
				}
				setState(680);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681); tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683); literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public Date_literalContext date_literal() {
			return getRuleContext(Date_literalContext.class,0);
		}
		public Float_literalContext float_literal() {
			return getRuleContext(Float_literalContext.class,0);
		}
		public Null_literalContext null_literal() {
			return getRuleContext(Null_literalContext.class,0);
		}
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_literal);
		try {
			setState(690);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(685); int_literal();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(686); float_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(687); date_literal();
				}
				break;
			case T__77:
			case T__55:
				enterOuterAlt(_localctx, 4);
				{
				setState(688); null_literal();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(689); char_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literalContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(sqlParser.NUM, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInt_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInt_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInt_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_int_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Float_literalContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(sqlParser.FLOAT, 0); }
		public Float_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_float_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFloat_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFloat_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFloat_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Float_literalContext float_literal() throws RecognitionException {
		Float_literalContext _localctx = new Float_literalContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_float_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694); match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_literalContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(sqlParser.DATE, 0); }
		public Date_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDate_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDate_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDate_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_literalContext date_literal() throws RecognitionException {
		Date_literalContext _localctx = new Date_literalContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696); match(DATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(sqlParser.CHAR, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterChar_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitChar_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitChar_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698); match(CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Null_literalContext extends ParserRuleContext {
		public Null_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterNull_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitNull_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitNull_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Null_literalContext null_literal() throws RecognitionException {
		Null_literalContext _localctx = new Null_literalContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_null_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			_la = _input.LA(1);
			if ( !(_la==T__77 || _la==T__55) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3j\u02c1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\6+\u0121\n+\r+\16"+
		"+\u0122\3,\3,\5,\u0127\n,\3-\3-\5-\u012b\n-\3.\3.\5.\u012f\n.\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\5/\u013a\n/\3\60\3\60\3\60\3\60\5\60\u0140\n\60\3"+
		"\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3"+
		"\63\6\63\u0151\n\63\r\63\16\63\u0152\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\38\38\38\38\39\39\39\39\39\3:\3:\3:\3:\5:\u017a\n:\3;"+
		"\3;\3;\3;\5;\u0180\n;\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\5=\u018c\n=\3=\3="+
		"\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u019a\n=\3=\3=\3=\3=\3=\3=\3=\7=\u01a3"+
		"\n=\f=\16=\u01a6\13=\3=\3=\5=\u01aa\n=\5=\u01ac\n=\3>\3>\3?\3?\3?\7?\u01b3"+
		"\n?\f?\16?\u01b6\13?\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3"+
		"B\5B\u01c9\nB\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\5B\u01d6\nB\3C\3C\3C\3"+
		"D\3D\3D\3D\3D\3D\3D\5D\u01e2\nD\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\5"+
		"D\u01f0\nD\3D\3D\3D\3D\3D\3D\3D\7D\u01f9\nD\fD\16D\u01fc\13D\3D\3D\5D"+
		"\u0200\nD\5D\u0202\nD\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G\5G\u0212"+
		"\nG\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\7H\u021e\nH\fH\16H\u0221\13H\3H\3H\3"+
		"I\3I\3I\5I\u0228\nI\3J\3J\3K\3K\3K\3K\3K\3K\3K\5K\u0233\nK\3K\3K\3L\6"+
		"L\u0238\nL\rL\16L\u0239\3M\3M\3M\3M\5M\u0240\nM\3N\3N\3N\3N\3N\3N\5N\u0248"+
		"\nN\3N\3N\3O\3O\3O\3O\3O\3O\3O\5O\u0253\nO\3O\3O\3O\3O\3O\5O\u025a\nO"+
		"\5O\u025c\nO\3O\3O\3P\3P\7P\u0262\nP\fP\16P\u0265\13P\3Q\3Q\7Q\u0269\n"+
		"Q\fQ\16Q\u026c\13Q\3R\3R\3R\7R\u0271\nR\fR\16R\u0274\13R\3S\3S\3S\3S\7"+
		"S\u027a\nS\fS\16S\u027d\13S\5S\u027f\nS\3T\3T\3U\3U\3V\3V\3V\3W\3W\3W"+
		"\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Z\3Z\5Z\u0295\nZ\3Z\3Z\5Z\u0299\nZ\3[\3[\3["+
		"\5[\u029e\n[\3\\\3\\\5\\\u02a2\n\\\3]\3]\3]\7]\u02a7\n]\f]\16]\u02aa\13"+
		"]\3^\3^\3_\3_\3`\3`\3`\3`\3`\5`\u02b5\n`\3a\3a\3b\3b\3c\3c\3d\3d\3e\3"+
		"e\3e\2\2f\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2"+
		"\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba"+
		"\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\2-\4\2,,\64\64\4\2\22\22^^"+
		"\4\2//\65\65\4\2..XX\4\2FFOO\4\2\b\bUU\4\2((LL\4\2KKMM\4\2++QQ\4\2\6\6"+
		"WW\4\2\23\23JJ\4\2\13\13ZZ\4\2\7\7NN\4\2&&II\4\2\4\4>>\4\2\31\31\33\33"+
		"\4\2??HH\4\2\3\3\61\61\4\2\f\faa\4\2\21\21\36\36\4\2\16\16))\4\2\37\37"+
		"DD\4\2\20\20  \4\2CCPP\4\2\t\t``\4\2\63\63VV\4\2\r\rAA\4\2\60\60\62\62"+
		"\4\2\35\35::\4\2%%]]\4\2\66\66YY\4\2\34\34@@\4\2\26\26$$\4\2\5\5==\4\2"+
		"<<GG\4\2\27\27--\4\2\32\32!!\4\288\\\\\3\2ST\4\299__\3\2de\b\2\n\n\17"+
		"\17\"#\'\';;RR\4\2\24\24**\u029c\2\u00ca\3\2\2\2\4\u00cc\3\2\2\2\6\u00ce"+
		"\3\2\2\2\b\u00d0\3\2\2\2\n\u00d2\3\2\2\2\f\u00d4\3\2\2\2\16\u00d6\3\2"+
		"\2\2\20\u00d8\3\2\2\2\22\u00da\3\2\2\2\24\u00dc\3\2\2\2\26\u00de\3\2\2"+
		"\2\30\u00e0\3\2\2\2\32\u00e2\3\2\2\2\34\u00e4\3\2\2\2\36\u00e9\3\2\2\2"+
		" \u00eb\3\2\2\2\"\u00ed\3\2\2\2$\u00ef\3\2\2\2&\u00f1\3\2\2\2(\u00f3\3"+
		"\2\2\2*\u00f5\3\2\2\2,\u00f7\3\2\2\2.\u00f9\3\2\2\2\60\u00fb\3\2\2\2\62"+
		"\u00fd\3\2\2\2\64\u00ff\3\2\2\2\66\u0101\3\2\2\28\u0103\3\2\2\2:\u0105"+
		"\3\2\2\2<\u0107\3\2\2\2>\u0109\3\2\2\2@\u010b\3\2\2\2B\u010d\3\2\2\2D"+
		"\u010f\3\2\2\2F\u0111\3\2\2\2H\u0113\3\2\2\2J\u0115\3\2\2\2L\u0117\3\2"+
		"\2\2N\u0119\3\2\2\2P\u011b\3\2\2\2R\u011d\3\2\2\2T\u0120\3\2\2\2V\u0126"+
		"\3\2\2\2X\u012a\3\2\2\2Z\u012e\3\2\2\2\\\u0139\3\2\2\2^\u013f\3\2\2\2"+
		"`\u0141\3\2\2\2b\u0146\3\2\2\2d\u0150\3\2\2\2f\u0154\3\2\2\2h\u0159\3"+
		"\2\2\2j\u015f\3\2\2\2l\u0164\3\2\2\2n\u016c\3\2\2\2p\u0170\3\2\2\2r\u0175"+
		"\3\2\2\2t\u017f\3\2\2\2v\u0181\3\2\2\2x\u01ab\3\2\2\2z\u01ad\3\2\2\2|"+
		"\u01af\3\2\2\2~\u01b7\3\2\2\2\u0080\u01bb\3\2\2\2\u0082\u01d5\3\2\2\2"+
		"\u0084\u01d7\3\2\2\2\u0086\u0201\3\2\2\2\u0088\u0203\3\2\2\2\u008a\u0207"+
		"\3\2\2\2\u008c\u020d\3\2\2\2\u008e\u0219\3\2\2\2\u0090\u0227\3\2\2\2\u0092"+
		"\u0229\3\2\2\2\u0094\u022b\3\2\2\2\u0096\u0237\3\2\2\2\u0098\u023b\3\2"+
		"\2\2\u009a\u0241\3\2\2\2\u009c\u024b\3\2\2\2\u009e\u025f\3\2\2\2\u00a0"+
		"\u0266\3\2\2\2\u00a2\u026d\3\2\2\2\u00a4\u027e\3\2\2\2\u00a6\u0280\3\2"+
		"\2\2\u00a8\u0282\3\2\2\2\u00aa\u0284\3\2\2\2\u00ac\u0287\3\2\2\2\u00ae"+
		"\u028a\3\2\2\2\u00b0\u028e\3\2\2\2\u00b2\u0294\3\2\2\2\u00b4\u029a\3\2"+
		"\2\2\u00b6\u02a1\3\2\2\2\u00b8\u02a3\3\2\2\2\u00ba\u02ab\3\2\2\2\u00bc"+
		"\u02ad\3\2\2\2\u00be\u02b4\3\2\2\2\u00c0\u02b6\3\2\2\2\u00c2\u02b8\3\2"+
		"\2\2\u00c4\u02ba\3\2\2\2\u00c6\u02bc\3\2\2\2\u00c8\u02be\3\2\2\2\u00ca"+
		"\u00cb\t\2\2\2\u00cb\3\3\2\2\2\u00cc\u00cd\t\3\2\2\u00cd\5\3\2\2\2\u00ce"+
		"\u00cf\t\4\2\2\u00cf\7\3\2\2\2\u00d0\u00d1\t\5\2\2\u00d1\t\3\2\2\2\u00d2"+
		"\u00d3\t\6\2\2\u00d3\13\3\2\2\2\u00d4\u00d5\t\7\2\2\u00d5\r\3\2\2\2\u00d6"+
		"\u00d7\t\b\2\2\u00d7\17\3\2\2\2\u00d8\u00d9\t\t\2\2\u00d9\21\3\2\2\2\u00da"+
		"\u00db\t\n\2\2\u00db\23\3\2\2\2\u00dc\u00dd\t\13\2\2\u00dd\25\3\2\2\2"+
		"\u00de\u00df\t\f\2\2\u00df\27\3\2\2\2\u00e0\u00e1\t\r\2\2\u00e1\31\3\2"+
		"\2\2\u00e2\u00e3\t\16\2\2\u00e3\33\3\2\2\2\u00e4\u00e5\5\32\16\2\u00e5"+
		"\u00e6\7\25\2\2\u00e6\u00e7\7e\2\2\u00e7\u00e8\7[\2\2\u00e8\35\3\2\2\2"+
		"\u00e9\u00ea\t\17\2\2\u00ea\37\3\2\2\2\u00eb\u00ec\t\20\2\2\u00ec!\3\2"+
		"\2\2\u00ed\u00ee\t\21\2\2\u00ee#\3\2\2\2\u00ef\u00f0\t\22\2\2\u00f0%\3"+
		"\2\2\2\u00f1\u00f2\t\23\2\2\u00f2\'\3\2\2\2\u00f3\u00f4\t\24\2\2\u00f4"+
		")\3\2\2\2\u00f5\u00f6\t\25\2\2\u00f6+\3\2\2\2\u00f7\u00f8\t\26\2\2\u00f8"+
		"-\3\2\2\2\u00f9\u00fa\t\27\2\2\u00fa/\3\2\2\2\u00fb\u00fc\t\30\2\2\u00fc"+
		"\61\3\2\2\2\u00fd\u00fe\t\31\2\2\u00fe\63\3\2\2\2\u00ff\u0100\t\32\2\2"+
		"\u0100\65\3\2\2\2\u0101\u0102\t\33\2\2\u0102\67\3\2\2\2\u0103\u0104\t"+
		"\34\2\2\u01049\3\2\2\2\u0105\u0106\t\35\2\2\u0106;\3\2\2\2\u0107\u0108"+
		"\t\36\2\2\u0108=\3\2\2\2\u0109\u010a\t\37\2\2\u010a?\3\2\2\2\u010b\u010c"+
		"\t \2\2\u010cA\3\2\2\2\u010d\u010e\t!\2\2\u010eC\3\2\2\2\u010f\u0110\t"+
		"\"\2\2\u0110E\3\2\2\2\u0111\u0112\t#\2\2\u0112G\3\2\2\2\u0113\u0114\t"+
		"$\2\2\u0114I\3\2\2\2\u0115\u0116\t%\2\2\u0116K\3\2\2\2\u0117\u0118\t&"+
		"\2\2\u0118M\3\2\2\2\u0119\u011a\t\'\2\2\u011aO\3\2\2\2\u011b\u011c\t("+
		"\2\2\u011cQ\3\2\2\2\u011d\u011e\t)\2\2\u011eS\3\2\2\2\u011f\u0121\5V,"+
		"\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123U\3\2\2\2\u0124\u0127\5X-\2\u0125\u0127\5^\60\2\u0126\u0124"+
		"\3\2\2\2\u0126\u0125\3\2\2\2\u0127W\3\2\2\2\u0128\u012b\5Z.\2\u0129\u012b"+
		"\5\\/\2\u012a\u0128\3\2\2\2\u012a\u0129\3\2\2\2\u012bY\3\2\2\2\u012c\u012f"+
		"\5`\61\2\u012d\u012f\5b\62\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"[\3\2\2\2\u0130\u013a\5f\64\2\u0131\u013a\5h\65\2\u0132\u013a\5j\66\2"+
		"\u0133\u013a\5l\67\2\u0134\u013a\5p9\2\u0135\u013a\5n8\2\u0136\u013a\5"+
		"\u0080A\2\u0137\u013a\5\u0088E\2\u0138\u013a\5\u008aF\2\u0139\u0130\3"+
		"\2\2\2\u0139\u0131\3\2\2\2\u0139\u0132\3\2\2\2\u0139\u0133\3\2\2\2\u0139"+
		"\u0134\3\2\2\2\u0139\u0135\3\2\2\2\u0139\u0136\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u0139\u0138\3\2\2\2\u013a]\3\2\2\2\u013b\u0140\5\u009cO\2\u013c\u0140"+
		"\5\u008cG\2\u013d\u0140\5\u0094K\2\u013e\u0140\5\u009aN\2\u013f\u013b"+
		"\3\2\2\2\u013f\u013c\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140"+
		"_\3\2\2\2\u0141\u0142\5\2\2\2\u0142\u0143\5\4\3\2\u0143\u0144\7d\2\2\u0144"+
		"\u0145\7\67\2\2\u0145a\3\2\2\2\u0146\u0147\5\2\2\2\u0147\u0148\5\b\5\2"+
		"\u0148\u0149\7d\2\2\u0149\u014a\7\25\2\2\u014a\u014b\5d\63\2\u014b\u014c"+
		"\7[\2\2\u014c\u014d\7\67\2\2\u014dc\3\2\2\2\u014e\u0151\5r:\2\u014f\u0151"+
		"\5v<\2\u0150\u014e\3\2\2\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153e\3\2\2\2\u0154\u0155\5\n\6\2"+
		"\u0155\u0156\5\4\3\2\u0156\u0157\7d\2\2\u0157\u0158\7\67\2\2\u0158g\3"+
		"\2\2\2\u0159\u015a\5\f\7\2\u015a\u015b\5\b\5\2\u015b\u015c\7d\2\2\u015c"+
		"\u015d\5\u0082B\2\u015d\u015e\7\67\2\2\u015ei\3\2\2\2\u015f\u0160\5\n"+
		"\6\2\u0160\u0161\5\b\5\2\u0161\u0162\7d\2\2\u0162\u0163\7\67\2\2\u0163"+
		"k\3\2\2\2\u0164\u0165\5\f\7\2\u0165\u0166\5\4\3\2\u0166\u0167\7d\2\2\u0167"+
		"\u0168\5\16\b\2\u0168\u0169\5\20\t\2\u0169\u016a\7d\2\2\u016a\u016b\7"+
		"\67\2\2\u016bm\3\2\2\2\u016c\u016d\5\22\n\2\u016d\u016e\5\6\4\2\u016e"+
		"\u016f\7\67\2\2\u016fo\3\2\2\2\u0170\u0171\5\24\13\2\u0171\u0172\5\4\3"+
		"\2\u0172\u0173\7d\2\2\u0173\u0174\7\67\2\2\u0174q\3\2\2\2\u0175\u0176"+
		"\7d\2\2\u0176\u0177\5t;\2\u0177\u0179\3\2\2\2\u0178\u017a\7\30\2\2\u0179"+
		"\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017as\3\2\2\2\u017b\u0180\5\26\f\2"+
		"\u017c\u0180\5\30\r\2\u017d\u0180\5\34\17\2\u017e\u0180\5\36\20\2\u017f"+
		"\u017b\3\2\2\2\u017f\u017c\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u017e\3\2"+
		"\2\2\u0180u\3\2\2\2\u0181\u0182\5 \21\2\u0182\u0183\5x=\2\u0183w\3\2\2"+
		"\2\u0184\u0185\7d\2\2\u0185\u0186\5\"\22\2\u0186\u0187\5$\23\2\u0187\u0188"+
		"\7\25\2\2\u0188\u0189\5|?\2\u0189\u018b\7[\2\2\u018a\u018c\7\30\2\2\u018b"+
		"\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u01ac\3\2\2\2\u018d\u018e\7d"+
		"\2\2\u018e\u018f\5&\24\2\u018f\u0190\5$\23\2\u0190\u0191\7\25\2\2\u0191"+
		"\u0192\5|?\2\u0192\u0193\7[\2\2\u0193\u0194\5(\25\2\u0194\u0195\7d\2\2"+
		"\u0195\u0196\7\25\2\2\u0196\u0197\5|?\2\u0197\u0199\7[\2\2\u0198\u019a"+
		"\7\30\2\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u01ac\3\2\2\2"+
		"\u019b\u019c\7d\2\2\u019c\u019d\5*\26\2\u019d\u019e\7\25\2\2\u019e\u01a4"+
		"\5~@\2\u019f\u01a0\5\u0090I\2\u01a0\u01a1\5~@\2\u01a1\u01a3\3\2\2\2\u01a2"+
		"\u019f\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2"+
		"\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7\u01a9\7[\2\2\u01a8"+
		"\u01aa\7\30\2\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3"+
		"\2\2\2\u01ab\u0184\3\2\2\2\u01ab\u018d\3\2\2\2\u01ab\u019b\3\2\2\2\u01ac"+
		"y\3\2\2\2\u01ad\u01ae\t*\2\2\u01ae{\3\2\2\2\u01af\u01b4\7d\2\2\u01b0\u01b1"+
		"\7\30\2\2\u01b1\u01b3\7d\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4"+
		"\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5}\3\2\2\2\u01b6\u01b4\3\2\2\2"+
		"\u01b7\u01b8\7d\2\2\u01b8\u01b9\5\u0092J\2\u01b9\u01ba\5z>\2\u01ba\177"+
		"\3\2\2\2\u01bb\u01bc\5\f\7\2\u01bc\u01bd\5\b\5\2\u01bd\u01be\7d\2\2\u01be"+
		"\u01bf\5\16\b\2\u01bf\u01c0\5\20\t\2\u01c0\u01c1\7d\2\2\u01c1\u01c2\7"+
		"\67\2\2\u01c2\u0081\3\2\2\2\u01c3\u01c4\5H%\2\u01c4\u01c5\5J&\2\u01c5"+
		"\u01c6\7d\2\2\u01c6\u01c8\5t;\2\u01c7\u01c9\5\u0084C\2\u01c8\u01c7\3\2"+
		"\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01d6\3\2\2\2\u01ca\u01cb\5H%\2\u01cb\u01cc"+
		"\5\u0084C\2\u01cc\u01d6\3\2\2\2\u01cd\u01ce\5\n\6\2\u01ce\u01cf\5J&\2"+
		"\u01cf\u01d0\7d\2\2\u01d0\u01d6\3\2\2\2\u01d1\u01d2\5\n\6\2\u01d2\u01d3"+
		"\5 \21\2\u01d3\u01d4\7d\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01c3\3\2\2\2\u01d5"+
		"\u01ca\3\2\2\2\u01d5\u01cd\3\2\2\2\u01d5\u01d1\3\2\2\2\u01d6\u0083\3\2"+
		"\2\2\u01d7\u01d8\5 \21\2\u01d8\u01d9\5\u0086D\2\u01d9\u0085\3\2\2\2\u01da"+
		"\u01db\7d\2\2\u01db\u01dc\5\"\22\2\u01dc\u01dd\5$\23\2\u01dd\u01de\7\25"+
		"\2\2\u01de\u01df\5|?\2\u01df\u01e1\7[\2\2\u01e0\u01e2\7\30\2\2\u01e1\u01e0"+
		"\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u0202\3\2\2\2\u01e3\u01e4\7d\2\2\u01e4"+
		"\u01e5\5&\24\2\u01e5\u01e6\5$\23\2\u01e6\u01e7\7\25\2\2\u01e7\u01e8\5"+
		"|?\2\u01e8\u01e9\7[\2\2\u01e9\u01ea\5(\25\2\u01ea\u01eb\7d\2\2\u01eb\u01ec"+
		"\7\25\2\2\u01ec\u01ed\5|?\2\u01ed\u01ef\7[\2\2\u01ee\u01f0\7\30\2\2\u01ef"+
		"\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u0202\3\2\2\2\u01f1\u01f2\7d"+
		"\2\2\u01f2\u01f3\5*\26\2\u01f3\u01f4\7\25\2\2\u01f4\u01fa\5~@\2\u01f5"+
		"\u01f6\5\u0090I\2\u01f6\u01f7\5~@\2\u01f7\u01f9\3\2\2\2\u01f8\u01f5\3"+
		"\2\2\2\u01f9\u01fc\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb"+
		"\u01fd\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fd\u01ff\7[\2\2\u01fe\u0200\7\30"+
		"\2\2\u01ff\u01fe\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0202\3\2\2\2\u0201"+
		"\u01da\3\2\2\2\u0201\u01e3\3\2\2\2\u0201\u01f1\3\2\2\2\u0202\u0087\3\2"+
		"\2\2\u0203\u0204\5\22\n\2\u0204\u0205\5D#\2\u0205\u0206\7\67\2\2\u0206"+
		"\u0089\3\2\2\2\u0207\u0208\5\22\n\2\u0208\u0209\5L\'\2\u0209\u020a\5F"+
		"$\2\u020a\u020b\7d\2\2\u020b\u020c\7\67\2\2\u020c\u008b\3\2\2\2\u020d"+
		"\u020e\5,\27\2\u020e\u020f\5@!\2\u020f\u0211\7d\2\2\u0210\u0212\5\u008e"+
		"H\2\u0211\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213"+
		"\u0214\5B\"\2\u0214\u0215\7\25\2\2\u0215\u0216\5\u00b8]\2\u0216\u0217"+
		"\7[\2\2\u0217\u0218\7\67\2\2\u0218\u008d\3\2\2\2\u0219\u021a\7\25\2\2"+
		"\u021a\u021f\7d\2\2\u021b\u021c\7\30\2\2\u021c\u021e\7d\2\2\u021d\u021b"+
		"\3\2\2\2\u021e\u0221\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220"+
		"\u0222\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0223\7[\2\2\u0223\u008f\3\2"+
		"\2\2\u0224\u0228\5N(\2\u0225\u0228\5P)\2\u0226\u0228\5R*\2\u0227\u0224"+
		"\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0226\3\2\2\2\u0228\u0091\3\2\2\2\u0229"+
		"\u022a\t+\2\2\u022a\u0093\3\2\2\2\u022b\u022c\5.\30\2\u022c\u022d\7d\2"+
		"\2\u022d\u022e\5\64\33\2\u022e\u0232\5\u0096L\2\u022f\u0230\5\66\34\2"+
		"\u0230\u0231\5\u00a0Q\2\u0231\u0233\3\2\2\2\u0232\u022f\3\2\2\2\u0232"+
		"\u0233\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0235\7\67\2\2\u0235\u0095\3"+
		"\2\2\2\u0236\u0238\5\u0098M\2\u0237\u0236\3\2\2\2\u0238\u0239\3\2\2\2"+
		"\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u0097\3\2\2\2\u023b\u023c"+
		"\7d\2\2\u023c\u023d\7\17\2\2\u023d\u023f\5\u00ba^\2\u023e\u0240\7\30\2"+
		"\2\u023f\u023e\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0099\3\2\2\2\u0241\u0242"+
		"\5\60\31\2\u0242\u0243\5F$\2\u0243\u0247\7d\2\2\u0244\u0245\5\66\34\2"+
		"\u0245\u0246\5\u00a0Q\2\u0246\u0248\3\2\2\2\u0247\u0244\3\2\2\2\u0247"+
		"\u0248\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\7\67\2\2\u024a\u009b\3"+
		"\2\2\2\u024b\u024c\5\62\32\2\u024c\u024d\5\u00a4S\2\u024d\u024e\5F$\2"+
		"\u024e\u0252\5\u00a2R\2\u024f\u0250\5\66\34\2\u0250\u0251\5\u009eP\2\u0251"+
		"\u0253\3\2\2\2\u0252\u024f\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u025b\3\2"+
		"\2\2\u0254\u0255\58\35\2\u0255\u0256\5:\36\2\u0256\u0259\7d\2\2\u0257"+
		"\u025a\5<\37\2\u0258\u025a\5> \2\u0259\u0257\3\2\2\2\u0259\u0258\3\2\2"+
		"\2\u0259\u025a\3\2\2\2\u025a\u025c\3\2\2\2\u025b\u0254\3\2\2\2\u025b\u025c"+
		"\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025e\7\67\2\2\u025e\u009d\3\2\2\2"+
		"\u025f\u0263\5\u00a6T\2\u0260\u0262\5\u00acW\2\u0261\u0260\3\2\2\2\u0262"+
		"\u0265\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u009f\3\2"+
		"\2\2\u0265\u0263\3\2\2\2\u0266\u026a\5\u00a8U\2\u0267\u0269\5\u00aaV\2"+
		"\u0268\u0267\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u0268\3\2\2\2\u026a\u026b"+
		"\3\2\2\2\u026b\u00a1\3\2\2\2\u026c\u026a\3\2\2\2\u026d\u0272\7d\2\2\u026e"+
		"\u026f\7\30\2\2\u026f\u0271\7d\2\2\u0270\u026e\3\2\2\2\u0271\u0274\3\2"+
		"\2\2\u0272\u0270\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u00a3\3\2\2\2\u0274"+
		"\u0272\3\2\2\2\u0275\u027f\7B\2\2\u0276\u027b\5\u00b4[\2\u0277\u0278\7"+
		"\30\2\2\u0278\u027a\5\u00b4[\2\u0279\u0277\3\2\2\2\u027a\u027d\3\2\2\2"+
		"\u027b\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027f\3\2\2\2\u027d\u027b"+
		"\3\2\2\2\u027e\u0275\3\2\2\2\u027e\u0276\3\2\2\2\u027f\u00a5\3\2\2\2\u0280"+
		"\u0281\5\u00aeX\2\u0281\u00a7\3\2\2\2\u0282\u0283\5\u00b0Y\2\u0283\u00a9"+
		"\3\2\2\2\u0284\u0285\5\u0090I\2\u0285\u0286\5\u00b0Y\2\u0286\u00ab\3\2"+
		"\2\2\u0287\u0288\5\u0090I\2\u0288\u0289\5\u00aeX\2\u0289\u00ad\3\2\2\2"+
		"\u028a\u028b\5\u00b2Z\2\u028b\u028c\5\u0092J\2\u028c\u028d\5\u00b2Z\2"+
		"\u028d\u00af\3\2\2\2\u028e\u028f\5\u00b6\\\2\u028f\u0290\5\u0092J\2\u0290"+
		"\u0291\5\u00b6\\\2\u0291\u00b1\3\2\2\2\u0292\u0295\7d\2\2\u0293\u0295"+
		"\5\u00ba^\2\u0294\u0292\3\2\2\2\u0294\u0293\3\2\2\2\u0295\u0298\3\2\2"+
		"\2\u0296\u0297\7E\2\2\u0297\u0299\7d\2\2\u0298\u0296\3\2\2\2\u0298\u0299"+
		"\3\2\2\2\u0299\u00b3\3\2\2\2\u029a\u029d\7d\2\2\u029b\u029c\7E\2\2\u029c"+
		"\u029e\7d\2\2\u029d\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u00b5\3\2"+
		"\2\2\u029f\u02a2\7d\2\2\u02a0\u02a2\5\u00ba^\2\u02a1\u029f\3\2\2\2\u02a1"+
		"\u02a0\3\2\2\2\u02a2\u00b7\3\2\2\2\u02a3\u02a8\5\u00ba^\2\u02a4\u02a5"+
		"\7\30\2\2\u02a5\u02a7\5\u00ba^\2\u02a6\u02a4\3\2\2\2\u02a7\u02aa\3\2\2"+
		"\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u00b9\3\2\2\2\u02aa\u02a8"+
		"\3\2\2\2\u02ab\u02ac\5\u00bc_\2\u02ac\u00bb\3\2\2\2\u02ad\u02ae\5\u00be"+
		"`\2\u02ae\u00bd\3\2\2\2\u02af\u02b5\5\u00c0a\2\u02b0\u02b5\5\u00c2b\2"+
		"\u02b1\u02b5\5\u00c4c\2\u02b2\u02b5\5\u00c8e\2\u02b3\u02b5\5\u00c6d\2"+
		"\u02b4\u02af\3\2\2\2\u02b4\u02b0\3\2\2\2\u02b4\u02b1\3\2\2\2\u02b4\u02b2"+
		"\3\2\2\2\u02b4\u02b3\3\2\2\2\u02b5\u00bf\3\2\2\2\u02b6\u02b7\7e\2\2\u02b7"+
		"\u00c1\3\2\2\2\u02b8\u02b9\7f\2\2\u02b9\u00c3\3\2\2\2\u02ba\u02bb\7g\2"+
		"\2\u02bb\u00c5\3\2\2\2\u02bc\u02bd\7h\2\2\u02bd\u00c7\3\2\2\2\u02be\u02bf"+
		"\t,\2\2\u02bf\u00c9\3\2\2\2.\u0122\u0126\u012a\u012e\u0139\u013f\u0150"+
		"\u0152\u0179\u017f\u018b\u0199\u01a4\u01a9\u01ab\u01b4\u01c8\u01d5\u01e1"+
		"\u01ef\u01fa\u01ff\u0201\u0211\u021f\u0227\u0232\u0239\u023f\u0247\u0252"+
		"\u0259\u025b\u0263\u026a\u0272\u027b\u027e\u0294\u0298\u029d\u02a1\u02a8"+
		"\u02b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
