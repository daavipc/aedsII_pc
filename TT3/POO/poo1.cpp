#include <stdio.h>
#include <cstdlib>
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include "formas.h"
using namespace std;

retangulo::retangulo(double base, double altura){
this->base = base;
this->altura = altura;
}
double retangulo::getArea(){
double area = this->altura * this->base;
return area;
}
double retangulo::getPerimetro(){
double perimetro = (this->altura*2) + (this->base*2);
return perimetro;
}
double retangulo::getDiagonal(){
double diagonal = sqrt(pow(this->altura, 2) + pow(this->base, 2));
return diagonal;
}

int main(){
retangulo *r1 = new retangulo(10, 2);
retangulo *r2 = new retangulo(20, 4);

cout<<"\n"<<r2->getArea();
cout<<"\n"<<r1->getArea();

cout<<"\n"<<r2->getPerimetro();
cout<<"\n"<<r1->getPerimetro();

cout<<"\n"<<r2->getDiagonal();
cout<<"\n"<<r1->getDiagonal();

return 0;
}