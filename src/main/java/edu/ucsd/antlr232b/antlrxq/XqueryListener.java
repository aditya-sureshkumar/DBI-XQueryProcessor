// Generated from edu/ucsd/antlr232b/antlrxq/Xquery.g4 by ANTLR 4.5.3
package edu.ucsd.antlr232b.antlrxq;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XqueryParser}.
 */
public interface XqueryListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link XqueryParser#r}.
     * @param ctx the parse tree
     */
    void enterR(XqueryParser.RContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#r}.
     * @param ctx the parse tree
     */
    void exitR(XqueryParser.RContext ctx);
    /**
     * Enter a parse tree produced by the {@code absolutepath_Slash}
     * labeled alternative in {@link XqueryParser#ap}.
     * @param ctx the parse tree
     */
    void enterAbsolutepath_Slash(XqueryParser.Absolutepath_SlashContext ctx);
    /**
     * Exit a parse tree produced by the {@code absolutepath_Slash}
     * labeled alternative in {@link XqueryParser#ap}.
     * @param ctx the parse tree
     */
    void exitAbsolutepath_Slash(XqueryParser.Absolutepath_SlashContext ctx);
    /**
     * Enter a parse tree produced by the {@code absolutepath_DSlash}
     * labeled alternative in {@link XqueryParser#ap}.
     * @param ctx the parse tree
     */
    void enterAbsolutepath_DSlash(XqueryParser.Absolutepath_DSlashContext ctx);
    /**
     * Exit a parse tree produced by the {@code absolutepath_DSlash}
     * labeled alternative in {@link XqueryParser#ap}.
     * @param ctx the parse tree
     */
    void exitAbsolutepath_DSlash(XqueryParser.Absolutepath_DSlashContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpDot}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpDot(XqueryParser.RpDotContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpDot}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpDot(XqueryParser.RpDotContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpText}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpText(XqueryParser.RpTextContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpText}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpText(XqueryParser.RpTextContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpDotDot}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpDotDot(XqueryParser.RpDotDotContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpDotDot}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpDotDot(XqueryParser.RpDotDotContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpSlash}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpSlash(XqueryParser.RpSlashContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpSlash}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpSlash(XqueryParser.RpSlashContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpConcat}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpConcat(XqueryParser.RpConcatContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpConcat}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpConcat(XqueryParser.RpConcatContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpTagName}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpTagName(XqueryParser.RpTagNameContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpTagName}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpTagName(XqueryParser.RpTagNameContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpStar}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpStar(XqueryParser.RpStarContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpStar}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpStar(XqueryParser.RpStarContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpDSlash}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpDSlash(XqueryParser.RpDSlashContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpDSlash}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpDSlash(XqueryParser.RpDSlashContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpFilter}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpFilter(XqueryParser.RpFilterContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpFilter}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpFilter(XqueryParser.RpFilterContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpAttr}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpAttr(XqueryParser.RpAttrContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpAttr}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpAttr(XqueryParser.RpAttrContext ctx);
    /**
     * Enter a parse tree produced by the {@code rpParenExpr}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void enterRpParenExpr(XqueryParser.RpParenExprContext ctx);
    /**
     * Exit a parse tree produced by the {@code rpParenExpr}
     * labeled alternative in {@link XqueryParser#rp}.
     * @param ctx the parse tree
     */
    void exitRpParenExpr(XqueryParser.RpParenExprContext ctx);
    /**
     * Enter a parse tree produced by the {@code fNot}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void enterFNot(XqueryParser.FNotContext ctx);
    /**
     * Exit a parse tree produced by the {@code fNot}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void exitFNot(XqueryParser.FNotContext ctx);
    /**
     * Enter a parse tree produced by the {@code fRp}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void enterFRp(XqueryParser.FRpContext ctx);
    /**
     * Exit a parse tree produced by the {@code fRp}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void exitFRp(XqueryParser.FRpContext ctx);
    /**
     * Enter a parse tree produced by the {@code fIdEqual}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void enterFIdEqual(XqueryParser.FIdEqualContext ctx);
    /**
     * Exit a parse tree produced by the {@code fIdEqual}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void exitFIdEqual(XqueryParser.FIdEqualContext ctx);
    /**
     * Enter a parse tree produced by the {@code fParen}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void enterFParen(XqueryParser.FParenContext ctx);
    /**
     * Exit a parse tree produced by the {@code fParen}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void exitFParen(XqueryParser.FParenContext ctx);
    /**
     * Enter a parse tree produced by the {@code fOr}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void enterFOr(XqueryParser.FOrContext ctx);
    /**
     * Exit a parse tree produced by the {@code fOr}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void exitFOr(XqueryParser.FOrContext ctx);
    /**
     * Enter a parse tree produced by the {@code fValEqual}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void enterFValEqual(XqueryParser.FValEqualContext ctx);
    /**
     * Exit a parse tree produced by the {@code fValEqual}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void exitFValEqual(XqueryParser.FValEqualContext ctx);
    /**
     * Enter a parse tree produced by the {@code fAnd}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void enterFAnd(XqueryParser.FAndContext ctx);
    /**
     * Exit a parse tree produced by the {@code fAnd}
     * labeled alternative in {@link XqueryParser#f}.
     * @param ctx the parse tree
     */
    void exitFAnd(XqueryParser.FAndContext ctx);
    /**
     * Enter a parse tree produced by the {@code xInd}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXInd(XqueryParser.XIndContext ctx);
    /**
     * Exit a parse tree produced by the {@code xInd}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXInd(XqueryParser.XIndContext ctx);
    /**
     * Enter a parse tree produced by the {@code xState}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXState(XqueryParser.XStateContext ctx);
    /**
     * Exit a parse tree produced by the {@code xState}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXState(XqueryParser.XStateContext ctx);
    /**
     * Enter a parse tree produced by the {@code xLet}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXLet(XqueryParser.XLetContext ctx);
    /**
     * Exit a parse tree produced by the {@code xLet}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXLet(XqueryParser.XLetContext ctx);
    /**
     * Enter a parse tree produced by the {@code xAp}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXAp(XqueryParser.XApContext ctx);
    /**
     * Exit a parse tree produced by the {@code xAp}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXAp(XqueryParser.XApContext ctx);
    /**
     * Enter a parse tree produced by the {@code xVar}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXVar(XqueryParser.XVarContext ctx);
    /**
     * Exit a parse tree produced by the {@code xVar}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXVar(XqueryParser.XVarContext ctx);
    /**
     * Enter a parse tree produced by the {@code xDSlash}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXDSlash(XqueryParser.XDSlashContext ctx);
    /**
     * Exit a parse tree produced by the {@code xDSlash}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXDSlash(XqueryParser.XDSlashContext ctx);
    /**
     * Enter a parse tree produced by the {@code xNode}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXNode(XqueryParser.XNodeContext ctx);
    /**
     * Exit a parse tree produced by the {@code xNode}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXNode(XqueryParser.XNodeContext ctx);
    /**
     * Enter a parse tree produced by the {@code xJoin}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXJoin(XqueryParser.XJoinContext ctx);
    /**
     * Exit a parse tree produced by the {@code xJoin}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXJoin(XqueryParser.XJoinContext ctx);
    /**
     * Enter a parse tree produced by the {@code xSlash}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXSlash(XqueryParser.XSlashContext ctx);
    /**
     * Exit a parse tree produced by the {@code xSlash}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXSlash(XqueryParser.XSlashContext ctx);
    /**
     * Enter a parse tree produced by the {@code xPlain}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXPlain(XqueryParser.XPlainContext ctx);
    /**
     * Exit a parse tree produced by the {@code xPlain}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXPlain(XqueryParser.XPlainContext ctx);
    /**
     * Enter a parse tree produced by the {@code xStr}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void enterXStr(XqueryParser.XStrContext ctx);
    /**
     * Exit a parse tree produced by the {@code xStr}
     * labeled alternative in {@link XqueryParser#xq}.
     * @param ctx the parse tree
     */
    void exitXStr(XqueryParser.XStrContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#forClause}.
     * @param ctx the parse tree
     */
    void enterForClause(XqueryParser.ForClauseContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#forClause}.
     * @param ctx the parse tree
     */
    void exitForClause(XqueryParser.ForClauseContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#letClause}.
     * @param ctx the parse tree
     */
    void enterLetClause(XqueryParser.LetClauseContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#letClause}.
     * @param ctx the parse tree
     */
    void exitLetClause(XqueryParser.LetClauseContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#whereClause}.
     * @param ctx the parse tree
     */
    void enterWhereClause(XqueryParser.WhereClauseContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#whereClause}.
     * @param ctx the parse tree
     */
    void exitWhereClause(XqueryParser.WhereClauseContext ctx);
    /**
     * Enter a parse tree produced by the {@code condEq}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void enterCondEq(XqueryParser.CondEqContext ctx);
    /**
     * Exit a parse tree produced by the {@code condEq}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void exitCondEq(XqueryParser.CondEqContext ctx);
    /**
     * Enter a parse tree produced by the {@code condIs}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void enterCondIs(XqueryParser.CondIsContext ctx);
    /**
     * Exit a parse tree produced by the {@code condIs}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void exitCondIs(XqueryParser.CondIsContext ctx);
    /**
     * Enter a parse tree produced by the {@code condSome}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void enterCondSome(XqueryParser.CondSomeContext ctx);
    /**
     * Exit a parse tree produced by the {@code condSome}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void exitCondSome(XqueryParser.CondSomeContext ctx);
    /**
     * Enter a parse tree produced by the {@code condEmp}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void enterCondEmp(XqueryParser.CondEmpContext ctx);
    /**
     * Exit a parse tree produced by the {@code condEmp}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void exitCondEmp(XqueryParser.CondEmpContext ctx);
    /**
     * Enter a parse tree produced by the {@code condAnd}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void enterCondAnd(XqueryParser.CondAndContext ctx);
    /**
     * Exit a parse tree produced by the {@code condAnd}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void exitCondAnd(XqueryParser.CondAndContext ctx);
    /**
     * Enter a parse tree produced by the {@code condOr}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void enterCondOr(XqueryParser.CondOrContext ctx);
    /**
     * Exit a parse tree produced by the {@code condOr}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void exitCondOr(XqueryParser.CondOrContext ctx);
    /**
     * Enter a parse tree produced by the {@code condPlain}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void enterCondPlain(XqueryParser.CondPlainContext ctx);
    /**
     * Exit a parse tree produced by the {@code condPlain}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void exitCondPlain(XqueryParser.CondPlainContext ctx);
    /**
     * Enter a parse tree produced by the {@code condNot}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void enterCondNot(XqueryParser.CondNotContext ctx);
    /**
     * Exit a parse tree produced by the {@code condNot}
     * labeled alternative in {@link XqueryParser#cond}.
     * @param ctx the parse tree
     */
    void exitCondNot(XqueryParser.CondNotContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#returnClause}.
     * @param ctx the parse tree
     */
    void enterReturnClause(XqueryParser.ReturnClauseContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#returnClause}.
     * @param ctx the parse tree
     */
    void exitReturnClause(XqueryParser.ReturnClauseContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#tagname}.
     * @param ctx the parse tree
     */
    void enterTagname(XqueryParser.TagnameContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#tagname}.
     * @param ctx the parse tree
     */
    void exitTagname(XqueryParser.TagnameContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#fileName}.
     * @param ctx the parse tree
     */
    void enterFileName(XqueryParser.FileNameContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#fileName}.
     * @param ctx the parse tree
     */
    void exitFileName(XqueryParser.FileNameContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#attName}.
     * @param ctx the parse tree
     */
    void enterAttName(XqueryParser.AttNameContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#attName}.
     * @param ctx the parse tree
     */
    void exitAttName(XqueryParser.AttNameContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#string_constant}.
     * @param ctx the parse tree
     */
    void enterString_constant(XqueryParser.String_constantContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#string_constant}.
     * @param ctx the parse tree
     */
    void exitString_constant(XqueryParser.String_constantContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#string_name}.
     * @param ctx the parse tree
     */
    void enterString_name(XqueryParser.String_nameContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#string_name}.
     * @param ctx the parse tree
     */
    void exitString_name(XqueryParser.String_nameContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#sconstant}.
     * @param ctx the parse tree
     */
    void enterSconstant(XqueryParser.SconstantContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#sconstant}.
     * @param ctx the parse tree
     */
    void exitSconstant(XqueryParser.SconstantContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#var}.
     * @param ctx the parse tree
     */
    void enterVar(XqueryParser.VarContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#var}.
     * @param ctx the parse tree
     */
    void exitVar(XqueryParser.VarContext ctx);
    /**
     * Enter a parse tree produced by {@link XqueryParser#list}.
     * @param ctx the parse tree
     */
    void enterList(XqueryParser.ListContext ctx);
    /**
     * Exit a parse tree produced by {@link XqueryParser#list}.
     * @param ctx the parse tree
     */
    void exitList(XqueryParser.ListContext ctx);
}