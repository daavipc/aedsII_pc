import java.util.Scanner;

class pais{
private String nome;
private int ouro;
private int prata;
private int bronze;
private int totmedalha;

pais(String nome, int ouro, int prata, int bronze) {
this.nome = nome;
this.ouro = ouro;
this.prata = prata;
this.bronze = bronze;
this.totmedalha = ouro + prata + bronze;
}
public String gNome() {
return nome;
}
public int gOuro() {
return ouro;
}
public int gPrata() {
return prata;
}
public int gBronze() {
return bronze;
}
public int totalmedalhas() {
return totmedalha;
}
public void setouro(int ouro) {
this.ouro = ouro;
}
public void setprata(int prata) {
this.prata = prata;
}
public void setbronze(int bronze) {
this.bronze = bronze;
}
public void sTtMedalha(int totmedalha) {
this.totmedalha = totmedalha;
}
}

public class questao2{
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
pais[] paises = new pais[500];
int num = 0;

num = Integer.parseInt(sc.nextLine());
for (int i = 0; i < num; i++) {
String pais[] = new String[4];
pais = sc.nextLine().split(" ");
paises[i] = new pais(pais[0], Integer.parseInt(pais[1]), Integer.parseInt(pais[2]), Integer.parseInt(pais[3]));
}

for (int i = 0; i < num; i++) {
for (int j = 0; j < num; j++) {
if (paises[i].totalmedalhas() > paises[j].totalmedalhas()) {
pais aux = paises[i];
paises[i] = paises[j];
paises[j] = aux;
}
if (paises[i].gOuro() > paises[j].gOuro()) {
pais aux = paises[i];
paises[i] = paises[j];
paises[j] = aux;
} else if (paises[i].gOuro() == paises[j].gOuro()) {
if (paises[i].gPrata() > paises[j].gPrata()) {
pais aux = paises[i];
paises[i] = paises[j];
paises[j] = aux;
} else if (paises[i].gPrata() == paises[j].gPrata()) {
if (paises[i].gBronze() > paises[j].gBronze()) {
pais aux = paises[i];
paises[i] = paises[j];
paises[j] = aux;
}
}
}
}
}

for (int i = 0; i < num; i++) {
System.out.println(paises[i].gNome() + " " + paises[i].gOuro() + " " + paises[i].gPrata() + " "
+ paises[i].gBronze());
}
}
}
