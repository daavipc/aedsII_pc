import java.io.*;
import java.io.FileReader;
import java.io.File;  
import java.io.IOException;
import java.util.Scanner;

class CCelula {
public Object itm;
public Object mnValor;
public CCelula prox;    	

public CCelula(Object valorIt, CCelula proxCe, Object menor)
{
itm = valorIt;
prox = proxCe;
mnValor = menor;
}    			
public CCelula(Object valorIt)
{
itm = valorIt;
prox = null;
}    			        	
public CCelula()
{
itm = null;
prox = null;
}    			        	
}

class CPilha {
private CCelula topo = null;
private int menor = 900000;
private int valorInt = 0;


public void empilha(Object valorIt) {
valorInt = (int) valorIt;
if (valorInt < menor)
menor = valorInt;

topo = new CCelula(valorIt, topo, menor);
}

public Object desempilha() {
Object itm = null;
if (topo != null) {
if (topo.prox != null)
menor = (int) topo.prox.mnValor;
else 
menor = (int) topo.mnValor;
itm = topo.itm;
topo = topo.prox;
}
return itm;
}


public Object peek() {
return (topo != null) ? topo.itm : null;
}

public Object getMenor(){
return menor;
}

public boolean verificaVazia() {
return topo == null;
}

}

public class Questao01 {

public static boolean isFim(String s){
boolean result;

result = (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');

return result;
}

public static void main(String[] args){
Scanner leitor = new Scanner(System.in);
String[] in = new String[1000];
int numEntrada = 0;
CPilha pilha = new CPilha();
String auxValor;
int valor = 0;

while(true){
in [numEntrada] = leitor.nextLine();
if(isFim(in[numEntrada]) == true){
numEntrada++;
break;
}

if(in[numEntrada].charAt(0)== 'I'){
auxValor = in[numEntrada].substring(2);
valor = Integer.parseInt(auxValor);
pilha.empilha(valor);
}

else if(in[numEntrada].charAt(0)== 'D'){
System.out.println(pilha.desempilha());
}

else if(in[numEntrada].charAt(0)== 'T'){
System.out.println(pilha.peek());
}

else if(in[numEntrada].charAt(0)== 'M'){
System.out.println(pilha.getMenor());
}

numEntrada ++;
}

while(true){
if(pilha.verificaVazia() == false){
int saida = (int)pilha.desempilha();

System.out.println(saida);
}
else	
break;
}

leitor.close();
}

}
