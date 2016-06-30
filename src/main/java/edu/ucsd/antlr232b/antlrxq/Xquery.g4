grammar Xquery;

//root

r : xq ;

// Absolute path

ap
  : ('doc'|'document')'("' fileName '")' '/' rp   	#absolutepath_Slash
  | ('doc'|'document')'("' fileName '")' '//' rp  	#absolutepath_DSlash
  ;

// Relative path
 rp
  :	tagname           								#rpTagName
  | '*'                               				#rpStar
  | '.'                               				#rpDot
  | '..'                              				#rpDotDot
  | 'text()'                          				#rpText
  | '@'tagname                      				#rpAttr
  | '(' rp ')'                        				#rpParenExpr
  | left=rp '/' right=rp            				#rpSlash
  | left=rp '//' right=rp            				#rpDSlash
  | rp '[' f ']'                      				#rpFilter
  | left=rp ',' right=rp              				#rpConcat
  ; 

//Filter

f
  : rp                       						#fRp
  | left=rp ('eq'|'=') right=rp       				#fValEqual
  | left=rp ('is'|'==') right=rp	  				#fIdEqual
  | left=f 'and' right=f         					#fAnd
  | left=f 'or' right=f   							#fOr
  | '(' f ')'                						#fParen
  | 'not ' f                 						#fNot
  ;  

xq : var    										#xVar
   | sconstant    									#xStr
   | ap      										#xAp
   | '(' xq ')'										#xPlain
   | left=xq ',' right=xq      						#xInd
   | xq '/' rp     #xSlash
   | xq '//' rp   #xDSlash
   | '<' lt=tagname'>' '{' xq '}' '</' rt=tagname '>'    	#xNode
   | forClause (letClause)? (whereClause)? returnClause 	#xState
   | letClause xq   								#xLet
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
	: left=cond 'and' right=cond        						#condAnd
	| left=cond 'or'  right=cond         						#condOr
	| NOT cond                        							#condNot 
	| left=xq ('='|'eq')  right=xq             					#condEq
	| left=xq ('=='|'is') right=xq             					#condIs
	| 'empty''(' xq ')'      									#condEmp
	| 'some' var 'in' xq (',' var 'in' xq)* 'satisfies' cond  	#condSome
	| '(' cond ')'           									#condPlain
	;

NOT
	:'not'
	;

returnClause
	:'return' xq
	;

xpath 
	: ap 														#xpathap
    | var ('/'|'//') rp 										#xpathSlash
    ;

tagname	 
	:Id
	;

fileName	 
	:Id ('.' Id)*
	;

attName
	:Id
	;

Dot
	:'.'
	;

string_constant 
	:'"' string_name '"'
	;

string_name
	:Id (',' Id)* ('.')* (Id)*
	;

sconstant
	:Stringconstant
	;

Stringconstant
	:[^"][_A-Za-z0-9-.!, ]*["$]
	;

var 
	: '$' Id
	;

Id
	:[a-zA-Z_] [a-zA-Z_0-9!]*
	;


Ws: [\t\r\n ]+ -> skip;
