#include <stdio.h> 
#define boolean short
#define true 1
#define false 0

boolean numero(char c){
boolean numeros=false;
if(c>='0'&&c<='9')
numeros=true;
return numeros;
}

boolean ponto(char c){
boolean ponto=false;
if(c=='.')
ponto=true;
return ponto;
}


int main(){
int n;
scanf("%d",&n);

FILE *arq=fopen("arq.dat", "wb");

for(int i=0;i<n;i++)
{
double numero;
scanf("%lf", &numero);
fwrite(&numero, sizeof(double), 1, arq);
}

fclose (arq);

arq=fopen("arq.dat", "rb");

for(int i=0;i<n;i++)
{
double numero;
fseek(arq,  (n-1-i)*8, SEEK_SET);
fread(&numero, sizeof(double), 1, arq);
int nInt;
nInt=numero;
if(numero-nInt!=0)
{
printf("%g\n", numero);
}
else
{
printf("%d\n", nInt);
}

}

fclose(arq);
}