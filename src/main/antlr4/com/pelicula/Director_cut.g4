grammar Director_cut;

program: PREMIERE '{' statement* '}' EOF;

block: '{' statement* '}';

type: Type_TICKET | RATING | SCRIPT | SPOILER;

statement:
	CAST ROLE '=' (expr | condExpr) ';'
	| STAR ROLE '=' (expr | condExpr) ';'
	| type ROLE '=' (expr | condExpr) ';'
	| ROLE '=' (expr | condExpr) ';'
	| printStmt
	| ifStmt
	| forStmt
	| expr ';';

printStmt: SUBTITLE '(' valorImprimible ')' ';';

valorImprimible: expr | condExpr | DIALOGUE;

ifStmt:
	PLOT_TWIST '(' condExpr ')' block (
		SPIN_OFF '(' condExpr ')' block
	)* (ALTERNATE_ENDING block)?;

forStmt:
	REPLAY '(' (ROLE '=' expr)? ';' condExpr ';' (ROLE '=' expr)? ')' block;

condExpr:
	expr (BOX_OFFICE_LEADER | CRITIC_AGREEMENT | FLOP_MATCH) expr;

expr: term ( (CROSSOVER | CUT) term)*;

term: factor ( (FRANCHISE | SPLIT_SCREEN) factor)*;

factor:
	'(' expr ')'
	| ROLE // Identificador de variable
	| FRAME // Número entero
	| DURATION // Número decimal
	| DIALOGUE // Cadena de texto
	| HIT // true
	| FLOP ; // false

// Estructura y Variables
PREMIERE: 'premiere';
CAST: 'cast';
STAR: 'star';

// Tipos de Datos
Type_TICKET: 'ticket';
RATING: 'rating';
SCRIPT: 'script';
SPOILER: 'spoiler';

// Valores Booleanos
HIT: 'hit';
FLOP: 'flop';

// Input / Output
SUBTITLE: 'subtitle';
AUDITION: 'audition';

// Control de Flujo
PLOT_TWIST: 'plot_twist'; // if
SPIN_OFF: 'spin_off'; // else if
ALTERNATE_ENDING: 'alternate_ending'; // else
REPLAY: 'replay'; // for

// Operadores Matemáticos y Lógicos
CROSSOVER: '+';
CUT: '-';
FRANCHISE: '*';
SPLIT_SCREEN: '/';
BOX_OFFICE_LEADER: '>';
FLOP_MATCH: '<';
CRITIC_AGREEMENT: '==';

// Identificadores y Literales con temática
ROLE: [a-zA-Z_][a-zA-Z0-9_]*;
FRAME: [0-9]+;
DURATION: [0-9]+ '.' [0-9]+;
DIALOGUE: '"' .*? '"';

// Ignorar espacios, saltos de línea y comentarios
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
MULTILINE_COMMENT: '/*' .*? '*/' -> skip;