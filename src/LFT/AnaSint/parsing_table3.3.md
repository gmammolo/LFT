# Esercizio 3.1

## GRAMMATICA   
&lt;prog> ::= &lt;statlist> EOF  
&lt;stat> ::= ID := &lt;expr> |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; print ( &lt;expr> ) |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  read ( ID ) |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  if ( &lt;bexpr> ) &lt;stat> |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  if ( &lt;bexpr> ) &lt;stat> else &lt;stat> |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  while ( &lt;bexpr> ) &lt;stat> |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  { &lt;statlist> }  
&lt;statlist> ::= &lt;stat> &lt;statlist_p>  
&lt;statlist_p> ::= ;&lt;stat>&lt;statlist_p> | ε    
&lt;bexpr> ::= &lt;expr> RELOP &lt;expr>  
&lt;expr> ::= &lt;term> &lt;exprp>  
&lt;exprp> ::= + &lt;term> &lt;exprp> |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -&lt;term> &lt;exprp> |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ε  
&lt;term> ::= &lt;fact> &lt;termp>  
&lt;termp> ::= \* &lt;fact> &lt;termp> |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; / &lt;fact>&lt;termp> |  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ε  
&lt;fact> ::= ( &lt;expr> ) | NUM | ID



## FIRST

FST(&lt;prog>) ::= FST(&lt;statlist>)  =  ***{ID, printf, read, if, while, { }***   
FST(&lt;stat>) ::= ***{ID, printf, read, if, while, { }***  
FST(&lt;statlist>) ::= FST(&lt;stat>) =  ***{ID, printf, read, if, while, { }***    
FST(&lt;statlist_p>) ::= ***{; ε}***  
FST(&lt;bexpr>) ::= FST(&lt;expr>)= ***{ ( , NUM, ID}***   
FST(&lt;expr>) ::= FST (&lt;term>)=  ***{ ( , NUM, ID}***   
FST(&lt;exprp>) ::= ***{ ε , + , -}***    
FST(&lt;term>) ::= FST(&lt;fact>) = ***{ ( , NUM, ID}***    
FST(&lt;termp>) ::= ***{ ε , **** *** , / }***    
FST(&lt;fact>) ::= ***{ ( , NUM, ID}***   

## FOLLOW

FW(&lt;prog>) ::= ***{$}***
FW(&lt;stat>) ::= {else} + FST(&lt;statlist_p)=***{else ;}***  
FW(&lt;statlist>) ::=  ***{}}***   
FW(&lt;statlist_p>) ::= FW(&lt;statlist>) =  ***{}}***  
FW(&lt;bexpr>) ::= ***{)}***  
FW(&lt;expr>) ::= {RELOP}+FW(&lt;bexpr>) =   ***{ RELOP, ) }***   
FW(&lt;exprp>) ::= FW(&lt;expr>) = ***{ RELOP, ) }***    
FW(&lt;term>) ::= FST(&lt;exprp>)+FW(&lt;expr>) +FW(&lt;exprp>) = ***{ RELOP, ) +, - }***  
FW(&lt;termp>) ::= FW(&lt;term>) = FST(&lt;termp>) +FW(&lt;term>)+FW(&lt;termp>)=  ***{ RELOP, ), +, - }***  
FW(&lt;fact>) ::=  ***{ RELOP, ), +, - , **** *** , / }***  


## Tabella di Parsing &
|              | printf                                            | read                                              | if                                                                 | else | while                                             | {                                                 | }                                                    | ;                                  | RELOP               | ID                                                               | NUM                                                              | +                        | -                                          | *                        | /                                          | (                                                                | )                    | $ |
|--------------|---------------------------------------------------|---------------------------------------------------|--------------------------------------------------------------------|------|---------------------------------------------------|---------------------------------------------------|------------------------------------------------------|------------------------------------|---------------------|------------------------------------------------------------------|------------------------------------------------------------------|--------------------------|--------------------------------------------|--------------------------|--------------------------------------------|------------------------------------------------------------------|----------------------|---|
| &lt;prog>       | &lt;prog>::=&lt;statlist>EOF                | &lt;prog>::=&lt;statlist>EOF                | &lt;prog>::=&lt;statlist>EOF                                 |      | &lt;prog>::=&lt;statlist>EOF                |                                                   |                                                      |                                    |                     | &lt;prog>::=&lt;statlist>EOF                                           |                                                                  |                          |                                            |                          |                                            |                                                                  |                      |   |
| &lt;stat>       | &lt;stat> ::= printf( &lt;expr>)                        | &lt;stat>::=read(ID)                                 | &lt;stat>::=if(&lt;bexpr>)&lt;stat> \  &lt;stat>::=if(&lt;bexpr>)&lt;stat>else&lt;stat> |      | &lt;stat>::=while(&lt;bexpr>)&lt;stat>                     | &lt;stat>::={&lt;statelist>}                            |                                                      |                                    |                     | &lt;stat>::=ID:=&lt;expr>                                              |                                                                  |                          |                                            |                          |                                            |                                                                  |                      |   |
| &lt;statlist>   | &lt;statlist>::=&lt;stat>&lt;statlist_p> | &lt;statlist>::=&lt;stat>&lt;statlist_p> | &lt;statlist>::=&lt;stat>&lt;statlist_p>                  |      | &lt;statlist>::=&lt;stat>&lt;statlist_p> | &lt;statlist>::=&lt;stat>&lt;statlist_p> |                                                      |                                    |                     | &lt;statlist>::=&lt;stat>&lt;statlist_p>                                  |                                                                  |                          |                                            |                          |                                            |                                                                  |                      |   |
| &lt;statlist_p> |                                                   |                                                   |                                                                    |      |                                                   |                                                   | &lt;statlist_p>::=;&lt;stat>&lt;statlist_p> | &lt;statlist_p>::=;&lt;stat>&lt;statlist_p> |                     |                                                                  |                                                                  |                          |                                            |                          |                                            |                                                                  |                      |   |
| &lt;bexpr>      |                                                   |                                                   |                                                                    |      |                                                   |                                                   |                                                      |                                    |                     | &lt;bexpr>::=&lt;expr>RELOP&lt;expr>                    | &lt;bexpr>::=&lt;expr>RELOP&lt;expr>                                      |                          |                                            |                          |                                            | &lt;bexpr>::=&lt;expr>RELOP&lt;expr>                    |                      |   |
| &lt;expr>       |                                                   |                                                   |                                                                    |      |                                                   |                                                   |                                                      |                                    |                     | &lt;expr>::=&lt;term>&lt;exprp>                                           | &lt;expr>::=&lt;term>&lt;exprp>                         |                          |                                            |                          |                                            | &lt;expr>::=&lt;term>&lt;exprp>                         |                      |   |
| &lt;exprp>      |                                                   |                                                   |                                                                    |      |                                                   |                                                   |                                                      |                                    | &lt;exprp>:=ε |                                                                  |                                                                  | &lt;exprp>::=+&lt;term>&lt;exprp> | &lt;exprp>::=-&lt;term>&lt;exprp> |                          |                                            |                                                                  | &lt;exprp>:=ε  |   |
| &lt;term>       |                                                   |                                                   |                                                                    |      |                                                   |                                                   |                                                      |                                    |                     | &lt;term>;::=&lt;fact>;&lt;termp>; | &lt;term>;::=&lt;fact>;&lt;termp>; |                          |                                            |                          |                                            | &lt;term>;::=&lt;fact>;&lt;termp>; |                      |   |
| &lt;termp>      |                                                   |                                                   |                                                                    |      |                                                   |                                                   |                                                      |                                    | &lt;termp>::=ε      |                                                                  |                                                                  | &lt;termp>::=ε     | &lt;termp>::=ε                       | &lt;termp>::=*&lt;fact>&lt;termp> | &lt;termp>::=/&lt;fact>&lt;termp> |                                                                  | &lt;termp>::=ε |   |
| &lt;fact>       |                                                   |                                                   |                                                                    |      |                                                   |                                                   |                                                      |                                    |                     | &lt;fact>::=ID                                                      | &lt;fact>::=NUM                                                     |                          |                                            |                          |                                            | &lt;fact>::=(&lt;expr>)                                                |                      |   | |
### Note:
Tabella generata su http://www.tablesgenerator.com/markdown_tables.  
Per comodità sarà inserito anche un salvataggio del file per modificarla nella stessa directory.
