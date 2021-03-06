// Define a grammar
grammar MIDL;

specification : definition (definition)* ;
definition : type_decl ';' # DefineType
           | module ';' # DefineModule
           ;
module : 'module' ID '{' definition (definition)* '}' ;
type_decl : struct_type # StructDefine
          | 'struct' ID # StructDecl
          ;
struct_type : 'struct' ID '{' member_list '}' ;
member_list : ( type_spec declarators ';' )* ;
type_spec : scoped_name # TypeScopeName
          | base_type_spec # TypeBaseTypeSpec
          | struct_type # TypeStructType
          ;
scoped_name : '::'? ID ( '::' ID )* ;
base_type_spec : floating_pt_type #TypeFloat
               | integer_type #TypeInt
               | 'char' #TypeChar
               | 'string'#TypeString
               | 'boolean'#TypeBool
               ;
floating_pt_type : 'float'
                 | 'double'
                 | 'long double'
                 ;
integer_type : signed_int
             | unsigned_int
             ;
signed_int : ('short'|'int16')
           | ('long'|'int32')
           | ('long' 'long'|'int64')
           | 'int8'
           ;
unsigned_int : ('unsigned''short'| 'uint16')
             | ('unsigned''long'| 'uint32')
             | ('unsigned' 'long' 'long' | 'uint64')
             | 'uint8'
             ;
declarators : declarator (',' declarator )* ;
declarator : simple_declarator
           | array_declarator
           ;
simple_declarator : ID ('=' or_expr)? ;
array_declarator : ID '[' or_expr ']' ('=' exp_list)? ;
exp_list : '[' or_expr ( ','or_expr )* ']' ;
or_expr : xor_expr ('|' xor_expr)* ;
xor_expr : and_expr ('^' and_expr)* ;
and_expr : shift_expr ('&'shift_expr)* ;
shift_expr : add_expr ( op=('>>' | '<<') add_expr )* ;
add_expr : mult_expr ( op=('+' | '-') mult_expr )* ;
mult_expr : unary_expr ( op=('*' |'/'|'%') unary_expr )* ;
unary_expr : op=('-'| '+' | '~')? literal ;
literal : INTEGER
        | FLOATING_PT
        | CHAR
        | STRING
        | BOOLEAN
        ;


fragment LETTER : [a-z]|[A-Z] ;

fragment DIGIT : [0-9] ;

fragment UNDERLINE: '_' ;

ID :  LETTER (UNDERLINE?( LETTER | DIGIT))* ;

INTEGER_TYPE_SUFFIX :   'l' | 'L' ;

INTEGER : ('0' | [1-9] [0-9]*) INTEGER_TYPE_SUFFIX? ;

EXPONENT : ( 'e' | 'E') ( '+' | '-' )? [0-9]+ ;

FLOAT_TYPE_SUFFIX :  'f' | 'F' | 'd' | 'D' ;

FLOATING_PT :  [0-9]+ '.' [0-9]*  EXPONENT?  FLOAT_TYPE_SUFFIX?
   				|  '.' [0-9]+  EXPONENT?  FLOAT_TYPE_SUFFIX?
   				|  [0-9]+  EXPONENT  FLOAT_TYPE_SUFFIX?
   				|  [0-9]+  EXPONENT?  FLOAT_TYPE_SUFFIX
                ;

ESCAPE_SEQUENCE :  '\\' ['"\btnfr];

CHAR : '\''(ESCAPE_SEQUENCE |  (~'\\' | ~'\'') ) '\'' ;
STRING : '"' (ESCAPE_SEQUENCE |  (~'\\' | ~'"') )* '"' ;

BOOLEAN :  'TRUE' | 'true' | 'FALSE' | 'false' ;
WS : [ \t\r\n]+ -> skip;    // ???????????????Tab???????????????\r ???Windows???
