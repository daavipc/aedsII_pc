#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define N 2000

int testaPalindromo(char palavra[]);
int TesteFim(char palavra[]);

int main(){
char palavra[N];

do{
scanf("%[^\n]", palavra);
scanf("%*[^\n]");
scanf("%*c");

if (testaPalindromo(palavra) == 1)
printf("Sim \n");
else
printf("Não \n");
}

while (TesteFim(palavra) != 1);
return 0;
}

int testaPalindromo(char palavra[]){
int i;
int Nreal;

Nreal = strlen(palavra);

for (int i = 0; i < Nreal; i++){

if (palavra[i] != palavra[Nreal - 1 - i]){
return 0;
}
}

return 1;
}

int TesteFim(char palavra[]){
int result = 0;
if (strcmp(palavra, "-x-") == 0)
result = 1;
return result;
}