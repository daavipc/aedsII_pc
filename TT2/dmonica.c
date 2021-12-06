#include <stdio.h>

int main(void){

int id1, id2, idmae;
int soma, id3;
scanf("%d", &idmae);

scanf("%d", &id1);

scanf("%d", &id2);

soma = id1 + id2; 
id3 = idmae - soma ;
if (id1 > id2 && id1 > id3)
{
printf("%d", id1);
}
else if (id2 > id1 && id2 > id3)
{
printf("%d", id2);
}
else
{
printf("%d", id3);
}
return 0;
}