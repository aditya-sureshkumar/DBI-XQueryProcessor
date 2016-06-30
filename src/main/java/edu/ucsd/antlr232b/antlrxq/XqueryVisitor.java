// Generated from edu/ucsd/antlr232b/antlrxq/Xquery.g4 by ANTLR 4.5.3
package edu.ucsd.antlr232b.antlrxq;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XqueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XqueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XqueryParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(XqueryParser.RContext ctx);
	/**
	 * Visit a parse tree produced by the {@code absolutepath_Slash}
	 * labeled alternative in {@link XqueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutepath_Slash(XqueryParser.Absolutepath_SlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code absolutepath_DSlash}
	 * labeled alternative in {@link XqueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutepath_DSlash(XqueryParser.Absolutepath_DSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpDot}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpDot(XqueryParser.RpDotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpText(XqueryParser.RpTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpDotDot}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpDotDot(XqueryParser.RpDotDotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpSlash(XqueryParser.RpSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpConcat}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpConcat(XqueryParser.RpConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpTagName(XqueryParser.RpTagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpStar}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpStar(XqueryParser.RpStarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpDSlash}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpDSlash(XqueryParser.RpDSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XqueryParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAttr(XqueryParser.RpAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpParenExpr}
	 * labeled alternative in {@link XqueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpParenExpr(XqueryParser.RpParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fNot}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFNot(XqueryParser.FNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fRp}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFRp(XqueryParser.FRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fIdEqual}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFIdEqual(XqueryParser.FIdEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fParen}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFParen(XqueryParser.FParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fOr}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFOr(XqueryParser.FOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fValEqual}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFValEqual(XqueryParser.FValEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fAnd}
	 * labeled alternative in {@link XqueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFAnd(XqueryParser.FAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xInd}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXInd(XqueryParser.XIndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xState}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXState(XqueryParser.XStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xLet}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXLet(XqueryParser.XLetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xAp}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXAp(XqueryParser.XApContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xVar}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXVar(XqueryParser.XVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xDSlash}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXDSlash(XqueryParser.XDSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xNode}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXNode(XqueryParser.XNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xSlash}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXSlash(XqueryParser.XSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xPlain}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXPlain(XqueryParser.XPlainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xStr}
	 * labeled alternative in {@link XqueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXStr(XqueryParser.XStrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XqueryParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XqueryParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XqueryParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condEq}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondEq(XqueryParser.CondEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condIs}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondIs(XqueryParser.CondIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condSome}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondSome(XqueryParser.CondSomeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condEmp}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondEmp(XqueryParser.CondEmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondAnd(XqueryParser.CondAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondOr(XqueryParser.CondOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condPlain}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondPlain(XqueryParser.CondPlainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XqueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondNot(XqueryParser.CondNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XqueryParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xpathap}
	 * labeled alternative in {@link XqueryParser#xpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpathap(XqueryParser.XpathapContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xpathSlash}
	 * labeled alternative in {@link XqueryParser#xpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpathSlash(XqueryParser.XpathSlashContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#tagname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagname(XqueryParser.TagnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XqueryParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XqueryParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#string_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_constant(XqueryParser.String_constantContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#string_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_name(XqueryParser.String_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#sconstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSconstant(XqueryParser.SconstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link XqueryParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XqueryParser.VarContext ctx);
}
