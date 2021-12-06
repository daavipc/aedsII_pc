import java.util.Random;
public class e1{
public static boolean busca(int[] array, int elemento){
for(int i=0; i<array.length; i++){
if(array[i] == elemento)
return true;
}
return false;
}
public static boolean buscaBinaria(int[] array, int elemento){
int meio;
int limiteS = array.length-1;
int limiteI = 0;

while(limiteI <= limiteS){
meio = (limiteS+limiteI)/2;
if(elemento == array[meio])
return true;
if(elemento < array[meio])
limiteS = meio - 1;
else
limiteI = meio + 1;
}
return false;
}
public static void maiorMenor(int[] array){
int menor = array[0];
int maior = menor;

for(int i=0; i<array.length; i++){
if(array[i] > maior)
maior = array[i];
if(array[i] < menor)
menor = array[i];
}
MyIO.println("Maior: " + maior);
MyIO.println("Menor: " + menor);
}

public static int multiplicacao(int a, int b){
int soma = 0;
if(b>0)
soma = a + multiplicacao(a, b-1);

return soma;
}
public static String conteudoArq(String path) throws IOException {
BufferedReader Arq = new BufferedReader(new FileReader(path));

String conteudo = "";
String aux = "";
while (aux != null) {
conteudo += aux;
aux = Arq.readLine();
if(aux!=null)
aux+='\n';
}
Arq.close();

return conteudo;
}

public static void copiaArquivo(String pathOriginal, String pathCopia) throws IOException{
BufferedWriter Arq = new BufferedWriter(new FileWriter(pathCopia));

Arq.append(conteudoArq(pathOriginal));
Arq.close();
}

public static void main(String [] args) throws IOException{
String caminhoOriginal = MyIO.readString();
String caminhoCopia = MyIO.readString();

copiaArquivo(caminhoOriginal, caminhoCopia);

BufferedReader arq = new BufferedReader(new FileReader(caminhoCopia));
while(true){
if(arq.readLine() == null)
break;
else
System.out.println(arq.readLine());
}
arq.close();



}

}