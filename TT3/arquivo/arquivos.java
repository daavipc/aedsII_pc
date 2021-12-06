import java.io.*;

public class arquivos {
public static void charFy(char[] stringVetor, String word){
for(int i=0; i<word.length(); i++){
stringVetor[i] = word.charAt(i);
}
}
public static String stringFy(char[] stringVetor){
String frase = "";
for(int i=0; i<stringVetor.length; i++)
frase += stringVetor[i];
frase += '\n';

return frase;
}

public static String conteudoArq(String path) throws IOException {                                                          //Retorna o conteúdo presente em um arquivo -/- 1
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
public static void copiaArquivo(String pathOriginal, String pathCopia) throws IOException{                                  //Passa o conteúdo presente em um arquivo para outro -/- 1 
BufferedWriter Arq = new BufferedWriter(new FileWriter(pathCopia));

Arq.append(conteudoArq(pathOriginal));
Arq.close();
}
public static void escreverEmArquivo(String frase, String path) throws IOException{                                         //Escreve em um texto X em um arquivo Y -/- 2
BufferedWriter arq = new BufferedWriter(new FileWriter(path));
arq.append(frase);

arq.close();
}
public static void lerConteudoArq(String path) throws IOException{                                                          //Lê e imprime na tela o conteúdo do arquivo -/- 2
BufferedReader arq = new BufferedReader(new FileReader(path));
String aux = "";
while(true){
aux = arq.readLine();
if(aux == null)
break;
else
MyIO.println(aux);
}

arq.close();
}
public static void conversaoMaiuscula(String path) throws IOException{                                                      // -/- '2' -/- Lê o conteudo do arquivo, armazena numa variavel, converte para maiusculas todas as letras minusculas e depois as imprime
BufferedReader arq = new BufferedReader(new FileReader(path));
String aux = "";
char[] vectText;

while(true){
aux = arq.readLine();
if(aux == null)
break;
else{
vectText = new char[aux.length()];

charFy(vectText, aux);
aux = "";
for(int i=0; i<vectText.length; i++){
if(vectText[i]>=97 && vectText[i]<=122)
vectText[i]-=32;
aux += vectText[i];
}

MyIO.println(aux);
}
}

arq.close();
}
public static void cArqMaiuscula(String pathInicial, String pathFinal) throws IOException{                                  // -/- '2' -/- Lê o conteudo do arquivo, transforma as letras minusculas em maiuscula e cola no arquivo 2
BufferedReader arqInicial = new BufferedReader(new FileReader(pathInicial));
BufferedWriter arqFinal = new BufferedWriter(new FileWriter(pathFinal));

String aux = "";
char[] vectText;

while(true){
aux = arqInicial.readLine();
if(aux == null)
break;
else{
vectText = new char[aux.length()];

charFy(vectText, aux);
aux = "";
for(int i=0; i<vectText.length; i++){
if(vectText[i]>=97 && vectText[i]<=122)
vectText[i]-=32;
aux += vectText[i];
}

aux += '\n';
arqFinal.append(aux);
}
}

arqInicial.close();
arqFinal.close();
}
public static void copiarInvertido(String pathIncial, String pathFinal) throws IOException{                                 // -/- '2' -/- Lê o conteudo do arquivo 1 e cola invertido no arquivo 2
BufferedReader arqInicial = new BufferedReader(new FileReader(pathIncial));
BufferedWriter arqFinal = new BufferedWriter(new FileWriter(pathFinal));

String aux = "";
char[] vectText;
int tamanhoInvertido;

while(true){
aux = arqInicial.readLine();
if(aux == null)
break;
else{
vectText = new char[aux.length()];
tamanhoInvertido = aux.length()-1;

charFy(vectText, aux);
aux = "";
for(int i=tamanhoInvertido; i>=0; i--)
arqFinal.append(vectText[i]);

arqFinal.append('\n');
}
}

arqInicial.close();
arqFinal.close();
}
public static void cifraC(String path, int key) throws IOException{                                                         // -/- '2' -/- Lê o conteudo do arquivo e o imprime adicionando o valor da chave ao valor do caractere na tabela ASCII
BufferedReader arq = new BufferedReader(new FileReader(path));

String aux = "";
char[] stringVetor;

while(true){
aux = arq.readLine();
if(aux == null)
break;
else{
stringVetor = new char[aux.length()];
charFy(stringVetor, aux);

for(int i=0; i<aux.length(); i++){
stringVetor[i] += key;
MyIO.print(stringVetor[i]);
}
MyIO.print('\n');
}
}
arq.close();
}
public static void uncifraC(String path, int key) throws IOException{                                                       // -/- '2' -/- Lê o conteudo do arquivo e o imprime descriptografando-o de acordo com o valor da chave
BufferedReader arq = new BufferedReader(new FileReader(path));

String aux = "";
char[] stringVetor;

while(true){
aux = arq.readLine();
if(aux == null)
break;
else{
stringVetor = new char[aux.length()];
charFy(stringVetor, aux);

for(int i=0; i<aux.length(); i++){
stringVetor[i] -= key;
MyIO.print(stringVetor[i]);
}
MyIO.print('\n');
}
}
arq.close();
}

public static void main(String[] args) throws IOException{}

}
