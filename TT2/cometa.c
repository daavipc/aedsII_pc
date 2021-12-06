#include <stdio.h>

int  main (void) {
int ano, vzs;

scanf( "%d", &ano);

vzs = (ano - 10 ) / 76 ;
vzs++;
printf( "%d", vzs * 76 + 10 );

return  0 ;
}