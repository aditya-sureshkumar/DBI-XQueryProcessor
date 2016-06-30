package edu.ucsd.antlr232b.antlrxq;

import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.v4.runtime.ParserRuleContext;
import org.w3c.dom.Document;

import edu.ucsd.antlr232b.antlrxq.XqueryParser.VarContext;
import edu.ucsd.antlr232b.antlrxq.XqueryParser.XqContext;

import org.w3c.dom.*;
import java.util.*;
import org.antlr.v4.runtime.tree.*;
import javax.xml.parsers.*;
import java.io.*;
import org.antlr.v4.runtime.*;
import java.lang.*;

public class XqueryBuilder extends XqueryBaseListener
{
    ParseTreeProperty<Object> builder_hashmap = new ParseTreeProperty<Object>();
    Object abs_path_instance = null;
    Object xquery_instance = null;
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     */
    
    public Object get_abspath_instance()
    {
        return abs_path_instance;
    }
    public Object get_xquery_instance()
    {
        return xquery_instance;
    }
    public void enterR(XqueryParser.RContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitR(XqueryParser.RContext ctx) { }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterAbsolutepath_Slash(XqueryParser.Absolutepath_SlashContext ctx)
    {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitAbsolutepath_Slash(XqueryParser.Absolutepath_SlashContext ctx)
    {
        XqueryRelativePath relative_path = (XqueryRelativePath) builder_hashmap.get(ctx.rp());
        String fname = ctx.fileName().getText();
        XqueryAbsolutePath abs_path = new XqueryAbsolutePath(fname,"/",relative_path);
        Object obj_var = abs_path;
        abs_path_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterAbsolutepath_DSlash(XqueryParser.Absolutepath_DSlashContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitAbsolutepath_DSlash(XqueryParser.Absolutepath_DSlashContext ctx)
    {
        XqueryRelativePath relative_path = (XqueryRelativePath) builder_hashmap.get(ctx.rp());
        String fname = ctx.fileName().getText();
        XqueryAbsolutePath abs_path = new XqueryAbsolutePath(fname,"//",relative_path);
        Object obj_var = abs_path;
        abs_path_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpDot(XqueryParser.RpDotContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpDot(XqueryParser.RpDotContext ctx)
    {
        //System.out.println("Inside rpdot");
        String cur_token = ctx.getText();
        XqueryRelativePath relative_path = new XqueryRelativePath(cur_token);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpText(XqueryParser.RpTextContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpText(XqueryParser.RpTextContext ctx)
    {
        //System.out.println("Inside rptext");
        String cur_token = ctx.getText();
        XqueryRelativePath relative_path = new XqueryRelativePath(cur_token);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpDotDot(XqueryParser.RpDotDotContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpDotDot(XqueryParser.RpDotDotContext ctx)
    {
        //System.out.println("Inside rpdotdot");
        String cur_token = ctx.getText();
        XqueryRelativePath relative_path = new XqueryRelativePath(cur_token);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpSlash(XqueryParser.RpSlashContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpSlash(XqueryParser.RpSlashContext ctx)
    {
        //System.out.println("Inside rpslash");
        XqueryRelativePath left=(XqueryRelativePath) builder_hashmap.get(ctx.left);
        XqueryRelativePath right=(XqueryRelativePath) builder_hashmap.get(ctx.right);
        XqueryRelativePath relative_path = new XqueryRelativePath(left,"/",right);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpConcat(XqueryParser.RpConcatContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpConcat(XqueryParser.RpConcatContext ctx)
    {
        //System.out.println("Inside rpconcat");
        XqueryRelativePath left=(XqueryRelativePath) builder_hashmap.get(ctx.left);
        XqueryRelativePath right=(XqueryRelativePath) builder_hashmap.get(ctx.right);
        XqueryRelativePath relative_path = new XqueryRelativePath(left,",",right);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpTagName(XqueryParser.RpTagNameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpTagName(XqueryParser.RpTagNameContext ctx)
    {
        //System.out.println("Inside rptagname");
        String cur_token = ctx.tagname().Id().getText();
        //String cur_token = ctx.tagname().string_name().getText();
        XqueryRelativePath relative_path = new XqueryRelativePath(cur_token);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpStar(XqueryParser.RpStarContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpStar(XqueryParser.RpStarContext ctx)
    {
        //System.out.println("Inside rpstar");
        String cur_token = ctx.getText();
        XqueryRelativePath relative_path = new XqueryRelativePath(cur_token);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpDSlash(XqueryParser.RpDSlashContext ctx)
    {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpDSlash(XqueryParser.RpDSlashContext ctx)
    {
        //System.out.println("Inside rpdslash");
        XqueryRelativePath left=(XqueryRelativePath) builder_hashmap.get(ctx.left);
        XqueryRelativePath right=(XqueryRelativePath) builder_hashmap.get(ctx.right);
        XqueryRelativePath relative_path = new XqueryRelativePath(left,"//",right);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpFilter(XqueryParser.RpFilterContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpFilter(XqueryParser.RpFilterContext ctx)
    {
        //System.out.println("Inside rpfilter");
        XqueryRelativePath left=(XqueryRelativePath) builder_hashmap.get(ctx.rp());
        XqueryFilter filter= (XqueryFilter) builder_hashmap.get(ctx.f());
        XqueryRelativePath relative_path = new XqueryRelativePath(left,filter);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpAttr(XqueryParser.RpAttrContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpAttr(XqueryParser.RpAttrContext ctx)
    {
        //System.out.println("Inside rpattr");
        String cur_token = "@" + ctx.tagname().Id().getText();
        
        //String cur_token = "@" + ctx.tagname().string_name().getText();
        XqueryRelativePath relative_path = new XqueryRelativePath(cur_token);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterRpParenExpr(XqueryParser.RpParenExprContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitRpParenExpr(XqueryParser.RpParenExprContext ctx)
    {
        //System.out.println("Inside rpparen");
        XqueryRelativePath left=(XqueryRelativePath) builder_hashmap.get(ctx.rp());
        XqueryRelativePath relative_path = new XqueryRelativePath("()",left);
        Object obj_var = relative_path;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implemenftation does nothing.</p>
     */
    public void enterFNot(XqueryParser.FNotContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitFNot(XqueryParser.FNotContext ctx)
    {
        XqueryFilter left=(XqueryFilter) builder_hashmap.get(ctx.f());
        XqueryFilter filter= new XqueryFilter(left,"not");
        Object obj_var = filter;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterFRp(XqueryParser.FRpContext ctx)
    {
        
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitFRp(XqueryParser.FRpContext ctx)
    {
        XqueryRelativePath left=(XqueryRelativePath) builder_hashmap.get(ctx.rp());
        XqueryFilter filter = new XqueryFilter(left);
        Object obj_var = filter;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterFIdEqual(XqueryParser.FIdEqualContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitFIdEqual(XqueryParser.FIdEqualContext ctx)
    {
        XqueryRelativePath left=(XqueryRelativePath) builder_hashmap.get(ctx.left);
        XqueryRelativePath right=(XqueryRelativePath) builder_hashmap.get(ctx.right);
        XqueryFilter filter= new XqueryFilter(left,"==",right);
        Object obj_var = filter;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterFParen(XqueryParser.FParenContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitFParen(XqueryParser.FParenContext ctx)
    {
        XqueryFilter left=(XqueryFilter) builder_hashmap.get(ctx.f());
        XqueryFilter filter= new XqueryFilter(left,"()");
        Object obj_var = filter;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterFOr(XqueryParser.FOrContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitFOr(XqueryParser.FOrContext ctx)
    {
        XqueryFilter left=(XqueryFilter) builder_hashmap.get(ctx.left);
        XqueryFilter right=(XqueryFilter) builder_hashmap.get(ctx.right);
        XqueryFilter filter= new XqueryFilter(left,"or",right);
        Object obj_var = filter;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterFValEqual(XqueryParser.FValEqualContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitFValEqual(XqueryParser.FValEqualContext ctx)
    {
        XqueryRelativePath left=(XqueryRelativePath) builder_hashmap.get(ctx.left);
        XqueryRelativePath right=(XqueryRelativePath) builder_hashmap.get(ctx.right);
        XqueryFilter filter= new XqueryFilter(left,"=",right);
        Object obj_var = filter;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterFAnd(XqueryParser.FAndContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitFAnd(XqueryParser.FAndContext ctx)
    {
        XqueryFilter left=(XqueryFilter) builder_hashmap.get(ctx.left);
        XqueryFilter right=(XqueryFilter) builder_hashmap.get(ctx.right);
        XqueryFilter filter= new XqueryFilter(left,"and",right);
        Object obj_var = filter;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXInd(XqueryParser.XIndContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXInd(XqueryParser.XIndContext ctx)
    {
        XqueryMain xquery_left =  (XqueryMain) builder_hashmap.get(ctx.left);
        XqueryMain xquery_right =  (XqueryMain) builder_hashmap.get(ctx.right);
        XqueryMain xquery = new XqueryMain(xquery_left,",",xquery_right);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXState(XqueryParser.XStateContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXState(XqueryParser.XStateContext ctx)
    {
        XqueryForClause for_clause = (XqueryForClause) builder_hashmap.get(ctx.forClause());
        XqueryLetClause let_clause = (XqueryLetClause) builder_hashmap.get(ctx.letClause());
        XqueryWhereClause where_clause = (XqueryWhereClause) builder_hashmap.get(ctx.whereClause());
        XqueryReturn return_clause  = (XqueryReturn) builder_hashmap.get(ctx.returnClause());
        XqueryMain xquery = null;
        if(let_clause == null && where_clause == null)
            xquery = new XqueryMain(for_clause,return_clause);
        else if(let_clause != null && where_clause == null)
            xquery = new XqueryMain(for_clause,let_clause,return_clause);
        else if(let_clause == null && where_clause != null)
            xquery = new XqueryMain(for_clause,where_clause,return_clause);
        else if(let_clause != null && where_clause != null)
            xquery = new XqueryMain(for_clause,let_clause,where_clause,return_clause);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXLet(XqueryParser.XLetContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXLet(XqueryParser.XLetContext ctx)
    {
        XqueryLetClause let_clause = (XqueryLetClause) builder_hashmap.get(ctx.letClause());
        XqueryMain left = (XqueryMain) builder_hashmap.get(ctx.xq());
        XqueryMain xquery = new XqueryMain(let_clause,left);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXAp(XqueryParser.XApContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXAp(XqueryParser.XApContext ctx)
    {
        XqueryAbsolutePath abs_path =  (XqueryAbsolutePath) builder_hashmap.get(ctx.ap());
        XqueryMain xquery = new XqueryMain(abs_path);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXVar(XqueryParser.XVarContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXVar(XqueryParser.XVarContext ctx)
    {
        XqueryVariable variable = new XqueryVariable(ctx.getText().toString());
        XqueryMain xquery = new XqueryMain("$",variable);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXDSlash(XqueryParser.XDSlashContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXDSlash(XqueryParser.XDSlashContext ctx)
    {
        XqueryMain xquery_left =  (XqueryMain) builder_hashmap.get(ctx.xq());
        XqueryRelativePath relative_path = (XqueryRelativePath) builder_hashmap.get(ctx.rp());
        XqueryMain xquery = new XqueryMain(xquery_left,"//",relative_path);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXNode(XqueryParser.XNodeContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXNode(XqueryParser.XNodeContext ctx)
    {
        String left_string = ctx.lt.Id().getText();
        String right_string = ctx.rt.Id().getText();
        //String left_string = ctx.lt.string_name().Id().toString();
        //String right_string = ctx.rt.string_name().getText();
        
        XqueryMain xquery_left =  (XqueryMain) builder_hashmap.get(ctx.xq());
        XqueryMain xquery = new XqueryMain("<>{}</>",left_string,right_string,xquery_left);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    /*
     public void enterXabsolutep(XqueryParser.XabsolutepContext ctx) { }
     /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    /*
     public void exitXabsolutep(XqueryParser.XabsolutepContext ctx)
     {
     XqueryXpath xpath =  (XqueryXpath) builder_hashmap.get(ctx.xpath());
     XqueryMain xquery = new XqueryMain(xpath);
     Object obj_var = xquery;
     xquery_instance = obj_var;
     builder_hashmap.put(ctx,obj_var);
     }
     */
    /**f
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXSlash(XqueryParser.XSlashContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXSlash(XqueryParser.XSlashContext ctx)
    {
        XqueryMain xquery_left =  (XqueryMain) builder_hashmap.get(ctx.xq());
        XqueryRelativePath relative_path = (XqueryRelativePath) builder_hashmap.get(ctx.rp());
        XqueryMain xquery = new XqueryMain(xquery_left,"/",relative_path);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXPlain(XqueryParser.XPlainContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXPlain(XqueryParser.XPlainContext ctx)
    {
        XqueryMain xquery_left =  (XqueryMain) builder_hashmap.get(ctx.xq());
        XqueryMain xquery = new XqueryMain("()",xquery_left);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterXStr(XqueryParser.XStrContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXStr(XqueryParser.XStrContext ctx)
    {
        String temp=ctx.sconstant().getText().toString();
        //System.out.println("LOLOL: "+temp);
        //temp=temp.replace(" ", "");
        //System.out.println("LOLOL: "+temp);
        XqueryStringConstant string_constant = new XqueryStringConstant(temp);
        XqueryMain xquery = new XqueryMain(string_constant);
        Object obj_var = xquery;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterForClause(XqueryParser.ForClauseContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitForClause(XqueryParser.ForClauseContext ctx)
    {
        List<VarContext> variable_ctx_list = ctx.var();
        List<XqueryVariable> variable_list = new ArrayList<XqueryVariable>();
        for(int i=0;i<variable_ctx_list.size();i++)
        {
            XqueryVariable var = new XqueryVariable(variable_ctx_list.get(i).getText().toString());
            variable_list.add(var);
        }
        List<XqContext> xquery_ctx_list = ctx.xq();
        List<XqueryMain> xquery_list = new ArrayList<XqueryMain>();
        for(int i=0;i<xquery_ctx_list.size();i++)
        {
            xquery_list.add((XqueryMain) builder_hashmap.get(xquery_ctx_list.get(i)));
        }
        XqueryForClause condition = new XqueryForClause(variable_list,xquery_list);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterLetClause(XqueryParser.LetClauseContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitLetClause(XqueryParser.LetClauseContext ctx)
    {
        List<VarContext> variable_ctx_list = ctx.var();
        List<XqueryVariable> variable_list = new ArrayList<XqueryVariable>();
        for(int i=0;i<variable_ctx_list.size();i++)
        {
            XqueryVariable var = new XqueryVariable(variable_ctx_list.get(i).getText().toString());
            variable_list.add(var);
        }
        List<XqContext> xquery_ctx_list = ctx.xq();
        List<XqueryMain> xquery_list = new ArrayList<XqueryMain>();
        for(int i=0;i<xquery_ctx_list.size();i++)
        {
            xquery_list.add((XqueryMain) builder_hashmap.get(xquery_ctx_list.get(i)));
        }
        XqueryLetClause condition = new XqueryLetClause(variable_list,xquery_list);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /*
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterWhereClause(XqueryParser.WhereClauseContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitWhereClause(XqueryParser.WhereClauseContext ctx)
    {
        XqueryCondition condition = (XqueryCondition) builder_hashmap.get(ctx.cond());
        XqueryWhereClause where_clause = new XqueryWhereClause(condition);
        Object obj_var = where_clause;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterCondEq(XqueryParser.CondEqContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitCondEq(XqueryParser.CondEqContext ctx)
    {
        XqueryMain xquery_left = (XqueryMain) builder_hashmap.get(ctx.left);
        XqueryMain xquery_right = (XqueryMain) builder_hashmap.get(ctx.right);
        XqueryCondition condition = new XqueryCondition(xquery_left,"=",xquery_right);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterCondIs(XqueryParser.CondIsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitCondIs(XqueryParser.CondIsContext ctx)
    {
        XqueryMain xquery_left = (XqueryMain) builder_hashmap.get(ctx.left);
        XqueryMain xquery_right = (XqueryMain) builder_hashmap.get(ctx.right);
        XqueryCondition condition = new XqueryCondition(xquery_left,"==",xquery_right);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterCondSome(XqueryParser.CondSomeContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitCondSome(XqueryParser.CondSomeContext ctx)
    {
        List<VarContext> variable_ctx_list = ctx.var();
        List<XqueryVariable> variable_list = new ArrayList<XqueryVariable>();
        for(int i=0;i<variable_ctx_list.size();i++)
        {
            XqueryVariable var = new XqueryVariable(variable_ctx_list.get(i).getText().toString());
            variable_list.add(var);
        }
        List<XqContext> xquery_ctx_list = ctx.xq();
        List<XqueryMain> xquery_list = new ArrayList<XqueryMain>();
        for(int i=0;i<xquery_ctx_list.size();i++)
        {
            xquery_list.add((XqueryMain) builder_hashmap.get(xquery_ctx_list.get(i)));
        }
        //System.out.println("BUILDERVarlist:	"+variable_list);
        //System.out.println("BUILDERXQlist:	"+xquery_list);
        XqueryCondition input_condition = (XqueryCondition) builder_hashmap.get(ctx.cond());
        XqueryCondition condition = new XqueryCondition("some",variable_list,xquery_list,input_condition);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterCondEmp(XqueryParser.CondEmpContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitCondEmp(XqueryParser.CondEmpContext ctx)
    {
        XqueryMain xquery = (XqueryMain) builder_hashmap.get(ctx.xq());
        XqueryCondition condition = new XqueryCondition("()",xquery);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterCondAnd(XqueryParser.CondAndContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitCondAnd(XqueryParser.CondAndContext ctx)
    {
        XqueryCondition condition_left = (XqueryCondition) builder_hashmap.get(ctx.left);
        XqueryCondition condition_right = (XqueryCondition) builder_hashmap.get(ctx.right);
        XqueryCondition condition = new XqueryCondition(condition_left,"and",condition_right);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterCondOr(XqueryParser.CondOrContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitCondOr(XqueryParser.CondOrContext ctx)
    {
        XqueryCondition condition_left = (XqueryCondition) builder_hashmap.get(ctx.left);
        XqueryCondition condition_right = (XqueryCondition) builder_hashmap.get(ctx.right);
        XqueryCondition condition = new XqueryCondition(condition_left,"or",condition_right);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterCondPlain(XqueryParser.CondPlainContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitCondPlain(XqueryParser.CondPlainContext ctx)
    {
        //System.out.println("Inside builder bracket");
        XqueryCondition condition_left = (XqueryCondition) builder_hashmap.get(ctx.cond());
        XqueryCondition condition = new XqueryCondition("()",condition_left);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterCondNot(XqueryParser.CondNotContext ctx)
    {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitCondNot(XqueryParser.CondNotContext ctx)
    {
        XqueryCondition condition_left = (XqueryCondition) builder_hashmap.get(ctx.cond());
        XqueryCondition condition = new XqueryCondition("not",condition_left);
        Object obj_var = condition;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterReturnClause(XqueryParser.ReturnClauseContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitReturnClause(XqueryParser.ReturnClauseContext ctx)
    {
        XqueryMain xquery = (XqueryMain) builder_hashmap.get(ctx.xq());
        XqueryReturn return_clause = new XqueryReturn(xquery);
        Object obj_var = return_clause;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterTagname(XqueryParser.TagnameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitTagname(XqueryParser.TagnameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterFileName(XqueryParser.FileNameContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitFileName(XqueryParser.FileNameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterAttName(XqueryParser.AttNameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitAttName(XqueryParser.AttNameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterVar(XqueryParser.VarContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitVar(XqueryParser.VarContext ctx) {}
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void enterEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void visitErrorNode(ErrorNode node) { }
    
    
    public void enterXJoin(XqueryParser.XJoinContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitXJoin(XqueryParser.XJoinContext ctx) 
    {
        XqueryMain xquery_left =  (XqueryMain) builder_hashmap.get(ctx.left);
        XqueryMain xquery_right =  (XqueryMain) builder_hashmap.get(ctx.right);
        ArrayList<String> left_l = (ArrayList<String>) builder_hashmap.get(ctx.leftlist);
        ArrayList<String> right_l = (ArrayList<String>) builder_hashmap.get(ctx.rightlist);
        
        XqueryJoin xqj = new XqueryJoin(xquery_left,xquery_right,left_l,right_l);
        XqueryMain obj_m = new XqueryMain(xqj);
        
        Object obj_var = obj_m;
        xquery_instance = obj_var;
        builder_hashmap.put(ctx,obj_var);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    
    public void enterList(XqueryParser.ListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    public void exitList(XqueryParser.ListContext ctx) 
    {
        ArrayList<String> idlist=new ArrayList<String>();
        List<TerminalNode> xyz = ctx.Id();
        for(int i=0;i<xyz.size();i++)
        {
            idlist.add(xyz.get(i).getText());
        }
        Object obj_list=idlist;
        
        builder_hashmap.put(ctx,obj_list);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    
}
