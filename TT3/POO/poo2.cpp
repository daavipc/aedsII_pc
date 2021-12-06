#include <math.h>

class ponto{
private:
double x;
double y;
int id;
int static nextID = 0;

public:
ponto();
ponto(double x, double y);
void alterarId();
int getId();
static void alterarNextID();
int getNextId();
void setX(double valor);
double getX();
void setY(double valor);
double getY();
double dist(double ponto2);
double dist(ponto ponto);
int isTriangulo(ponto ponto1, ponto ponto2, ponto ponto3);
double getAreaRetangulo(ponto ponto);
};

ponto::ponto(){
this->x = 0;
this->y = 0;
}
ponto::ponto(double x, double y){
this->x = x;
this->y = y;
}
void ponto::alterarId(){
this->id = this->nextID;
ponto::alterarNextID();
}
int ponto::getId(){
return this->id;
}
void ponto::alterarNextID(){
nextID++;
}
int ponto::getNextId(){
return this->nextID;
}
double ponto::dist(double ponto2){
return this->x - ponto2;
}
double ponto::dist(ponto ponto){
return this->x - ponto.getX();
}
int ponto::isTriangulo(ponto ponto1, ponto ponto2, ponto ponto3){
if(ponto1.getX() > abs(ponto2.getX() - ponto3.getX()) && ponto1.getX() < ponto2.getX() + ponto3.getX()){
if (ponto2.getX() > abs(ponto1.getX() - ponto3.getX()) && ponto2.getX() < ponto1.getX() + ponto3.getX()){
if(ponto3.getX() > abs(ponto1.getX() - ponto2.getX()) && ponto3.getX() < ponto1.getX() + ponto2.getX())
return 1;
else
return 0;
}
else
return 0;
}
else
return 0; 
}
double ponto::getAreaRetangulo(ponto ponto){
return ponto.getX()*ponto.getY();
}
