// Generated from Xquery.g4 by ANTLR 4.4
package edu.ucsd.antlr232b.antlrxq;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XqueryParser}.
 */
public interface XqueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XqueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(@NotNull XqueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(@NotNull XqueryParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XqueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(@NotNull XqueryParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(@NotNull XqueryParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pathSlash}
	 * labeled alternative in {@link XqueryParser#xpath}.
	 * @param ctx the parse tree
	 */
	void enterPathSlash(@NotNull XqueryParser.PathSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathSlash}
	 * labeled alternative in {@link XqueryParser#xpath}.
	 * @param ctx the parse tree
	 */
	void exitPathSlash(@NotNull XqueryParser.PathSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condPlain}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondPlain(@NotNull XqueryParser.CondPlainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condPlain}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondPlain(@NotNull XqueryParser.CondPlainContext ctx);
	/**
	 * Enter a parse tree produced by {@link XqueryParser#tagname}.
	 * @param ctx the parse tree
	 */
	void enterTagname(@NotNull XqueryParser.TagnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#tagname}.
	 * @param ctx the parse tree
	 */
	void exitTagname(@NotNull XqueryParser.TagnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XqueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(@NotNull XqueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(@NotNull XqueryParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fIdEqual}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFIdEqual(@NotNull XqueryParser.FIdEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fIdEqual}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFIdEqual(@NotNull XqueryParser.FIdEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpDSlash}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpDSlash(@NotNull XqueryParser.RpDSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpDSlash}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpDSlash(@NotNull XqueryParser.RpDSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondOr(@NotNull XqueryParser.CondOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondOr(@NotNull XqueryParser.CondOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAttr(@NotNull XqueryParser.RpAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAttr(@NotNull XqueryParser.RpAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fNot}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFNot(@NotNull XqueryParser.FNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fNot}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFNot(@NotNull XqueryParser.FNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link XqueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull XqueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull XqueryParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xDSlash}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXDSlash(@NotNull XqueryParser.XDSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xDSlash}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXDSlash(@NotNull XqueryParser.XDSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xStr}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXStr(@NotNull XqueryParser.XStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xStr}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXStr(@NotNull XqueryParser.XStrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XqueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(@NotNull XqueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(@NotNull XqueryParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xLet}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXLet(@NotNull XqueryParser.XLetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xLet}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXLet(@NotNull XqueryParser.XLetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpSlash(@NotNull XqueryParser.RpSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpSlash(@NotNull XqueryParser.RpSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xVar}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXVar(@NotNull XqueryParser.XVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xVar}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXVar(@NotNull XqueryParser.XVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(@NotNull XqueryParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(@NotNull XqueryParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpParenExpr}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpParenExpr(@NotNull XqueryParser.RpParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpParenExpr}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpParenExpr(@NotNull XqueryParser.RpParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fAnd}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFAnd(@NotNull XqueryParser.FAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fAnd}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFAnd(@NotNull XqueryParser.FAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pathap}
	 * labeled alternative in {@link XqueryParser#xpath}.
	 * @param ctx the parse tree
	 */
	void enterPathap(@NotNull XqueryParser.PathapContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathap}
	 * labeled alternative in {@link XqueryParser#xpath}.
	 * @param ctx the parse tree
	 */
	void exitPathap(@NotNull XqueryParser.PathapContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpDotDot}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpDotDot(@NotNull XqueryParser.RpDotDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpDotDot}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpDotDot(@NotNull XqueryParser.RpDotDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fRp}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFRp(@NotNull XqueryParser.FRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fRp}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFRp(@NotNull XqueryParser.FRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xAp}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXAp(@NotNull XqueryParser.XApContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xAp}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXAp(@NotNull XqueryParser.XApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpDot}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpDot(@NotNull XqueryParser.RpDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpDot}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpDot(@NotNull XqueryParser.RpDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpText(@NotNull XqueryParser.RpTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpText(@NotNull XqueryParser.RpTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condEq}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEq(@NotNull XqueryParser.CondEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condEq}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEq(@NotNull XqueryParser.CondEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condIs}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondIs(@NotNull XqueryParser.CondIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condIs}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondIs(@NotNull XqueryParser.CondIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpConcat}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpConcat(@NotNull XqueryParser.RpConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpConcat}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpConcat(@NotNull XqueryParser.RpConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xNode}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXNode(@NotNull XqueryParser.XNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xNode}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXNode(@NotNull XqueryParser.XNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code absolutepath_Slash}
	 * labeled alternative in {@link XqueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutepath_Slash(@NotNull XqueryParser.Absolutepath_SlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absolutepath_Slash}
	 * labeled alternative in {@link XqueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutepath_Slash(@NotNull XqueryParser.Absolutepath_SlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fParen}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFParen(@NotNull XqueryParser.FParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fParen}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFParen(@NotNull XqueryParser.FParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fOr}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFOr(@NotNull XqueryParser.FOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fOr}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFOr(@NotNull XqueryParser.FOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code absolutepath_DSlash}
	 * labeled alternative in {@link XqueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutepath_DSlash(@NotNull XqueryParser.Absolutepath_DSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absolutepath_DSlash}
	 * labeled alternative in {@link XqueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutepath_DSlash(@NotNull XqueryParser.Absolutepath_DSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condEmp}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEmp(@NotNull XqueryParser.CondEmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condEmp}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEmp(@NotNull XqueryParser.CondEmpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpStar}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpStar(@NotNull XqueryParser.RpStarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpStar}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpStar(@NotNull XqueryParser.RpStarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fValEqual}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFValEqual(@NotNull XqueryParser.FValEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fValEqual}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFValEqual(@NotNull XqueryParser.FValEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xSlash}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXSlash(@NotNull XqueryParser.XSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xSlash}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXSlash(@NotNull XqueryParser.XSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xPlain}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXPlain(@NotNull XqueryParser.XPlainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xPlain}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXPlain(@NotNull XqueryParser.XPlainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xInd}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXInd(@NotNull XqueryParser.XIndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xInd}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXInd(@NotNull XqueryParser.XIndContext ctx);
	/**
	 * Enter a parse tree produced by {@link XqueryParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull XqueryParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull XqueryParser.RContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condSome}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondSome(@NotNull XqueryParser.CondSomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condSome}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondSome(@NotNull XqueryParser.CondSomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xState}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXState(@NotNull XqueryParser.XStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xState}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXState(@NotNull XqueryParser.XStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpTagName(@NotNull XqueryParser.RpTagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpTagName(@NotNull XqueryParser.RpTagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XqueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(@NotNull XqueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(@NotNull XqueryParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondAnd(@NotNull XqueryParser.CondAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondAnd(@NotNull XqueryParser.CondAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link XqueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(@NotNull XqueryParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XqueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(@NotNull XqueryParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xPath}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXPath(@NotNull XqueryParser.XPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xPath}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXPath(@NotNull XqueryParser.XPathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondNot(@NotNull XqueryParser.CondNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondNot(@NotNull XqueryParser.CondNotContext ctx);
}