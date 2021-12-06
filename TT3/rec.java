import java.lang.Math;

public class recursivo {
public static void charFy(char[] stringVetor, String word) {
for (int i = 0; i < word.length(); i++) {
stringVetor[i] = word.charAt(i);
}
}

public static boolean isVogal(char caracter) {
if ((caracter == 'a' || caracter == 'A') || (caracter == 'e' || caracter == 'E')
|| (caracter == 'i' || caracter == 'I') || (caracter == 'o' || caracter == 'O')
|| (caracter == 'u' || caracter == 'U'))
return true;

return false;
}

public static boolean isMinuscula(char caracter) {
if (caracter >= 97 && caracter <= 122)
return true;

return false;
}

public static int maiorElemento(int[] vetor, int tamanho, int maior) {
if (tamanho == 0)
return maior;

else {
if (vetor[tamanho] > maior)
maior = vetor[tamanho];
return maiorElemento(vetor, --tamanho, maior);
}
}

public static boolean isPalindromo(char[] vect, int pInicial, boolean boo) {
if (pInicial >= vect.length / 2)
return boo;
else {
if (vect[pInicial] == vect[(vect.length - 1) - pInicial])
return isPalindromo(vect, ++pInicial, boo);
else
return isPalindromo(vect, vect.length - 1, false);
}
}

public static int quantidadeVogais(char[] frase, int tamanho, int vogais) {
if (isVogal(frase[tamanho]))
++vogais;

if (tamanho == 0)
return vogais;
else
return quantidadeVogais(frase, --tamanho, vogais);
}

public static int quantidadeMinusculas(char[] frase, int tamanho, int qtd) {
if (isMinuscula(frase[tamanho]))
++qtd;

if (tamanho == 0)
return qtd;
else
return quantidadeMinusculas(frase, --tamanho, qtd);
}

public static int ordenacao(int[] array, int pos) {
int menor = array[pos];
int aux = pos;

for (int i = pos + 1; i < array.length; i++) {
if (array[i] < menor) {
menor = array[i];
aux = i;
}
}
array[aux] = array[pos];
array[pos] = menor;

if (pos == array.length - 1)
return 0;
else
return ordenacao(array, ++pos);
}

public static int e1(int n) {
if (n == 0)
return 1;
else if (n == 1)
return 2;
else {
return e1(n - 1) * e1(n - 2) - e1(n - 1);
}
}

public static int e2(int n) {
if (n == 0)
return 1;
else
return (int) Math.pow((n - 1), 2);
}

public static void main(String[] args) {
int n = MyIO.readInt();
MyIO.println(e2(n));
}
}
