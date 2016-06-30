grammar Xquery;
//root
r : xq;

// Absolute path
ap
  :('doc'| 'document')'("' fileName '")' '/' rp	  #absolutepath_Slash
  |('doc'| 'document')'("' fileName '")' '//' rp  #absolutepath_DSlash
  ;
  

// Relative path
 rp
  :tagname         					  #rpTagName
  | '*'                               #rpStar
  | '.'                               #rpDot
  | '..'                              #rpDotDot
  | 'text()'                          #rpText
  | '@'tagname                    	  #rpAttr
  | '(' rp ')'                        #rpParenExpr
  | left=rp '/' right=rp          	  #rpSlash
  | left=rp '//' right=rp          	  #rpDSlash
  | rp '[' f ']'                      #rpFilter
  | left=rp ',' right=rp              #rpConcat
  ; 
//Filter
f
  : rp                     			  #fRp
  | left=rp ('eq'|'=') right=rp       #fValEqual
  | left=rp ('is'|'==') right=rp	  #fIdEqual
  | left=f 'and' right=f       		  #fAnd
  | left=f 'or' right=f 			  #fOr
  | '(' f ')'              			  #fParen
  | 'not ' f               			  #fNot
  ;  
                           


xq : var    																	#xVar
   | String_constant    														#xStr
   | xpath   																	#xPath
   | ap  																	    #xAp
   | '(' xq ')'																	#xPlain
   | left=xq ',' right=xq      													#xInd
   | xq '/' rp     																#xSlash
   | xq '//' rp   																#xDSlash
   | '<' lt=LetterDigit '>' '{' xq '}' '</' rt=LetterDigit '>'    			 	#xNode
   | forClause (letClause)? (whereClause)? returnClause 						#xState
   | letClause xq   															#xLet
   ;                        
         
forClause
	:'for' var 'in' xq (',' var 'in' xq)*
	;         
	
letClause
	:'let' var ':=' xq (',' var ':=' xq)* 
	;
         
whereClause
	:'where' cond 
	;         

cond
	 : left=xq ('='|'eq')  right=xq             				#condEq
	 | left=xq ('=='|'is') right=xq             				#condIs
	 | 'empty''(' xq ')'      									#condEmp
	 | 'some' var 'in' xq (',' var 'in' xq)* 'satisfies' cond  	#condSome
	 | '(' cond ')'           									#condPlain
	 | left=cond 'and' right=cond        						#condAnd
	 | left=cond 'or'  right=cond         						#condOr
	 | 'not' cond                        						#condNot
	 ;

returnClause
	:'return' xq
	;
                  
xpath 
	: ap 				#pathap
    | var ('/'|'//') rp #pathSlash
     ;
tagname								  
	:LetterDigit+
	;

fileName							 
	:LetterDigit+ '/'* LetterDigit+ Dot LetterDigit+
	;
attName
	:LetterDigit+
	;


Dot
:'.'
;
String_constant 
: [^"][_A-Za-z0-9-.!, ]*["$] 
;
var : '$' LetterDigit;

LetterDigit
  :[^_A-Za-z][_A-Za-z0-9-.]* 
  ;
  
Ws: [\t\r\n ]+ -> skip;


   /*                       
oxq
:'for' forC 'where' whereC 'return' returnC #Xq
;

forC
:var 'in' path (',' var 'in' path)*  #forclause 
;
whereC
:
;
returnC
:
;
*
*/
  