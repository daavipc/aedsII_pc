public class introJava {
public static float media(int[] vetor){
float mediaE = 0;
for(int i=0; i<vetor.length; i++)
mediaE+=vetor[i];

return mediaE/vetor.length;
}   

public static void main(String[] args){
int n = MyIO.readInt();
int[] vetor = new int[n];

for(int i=0; i<n; i++)
vetor[i] = MyIO.readInt();

float mediaElementos = media(vetor);

for(int i=0; i<n; i++){
if(vetor[i] > mediaElementos)
MyIO.println(vetor[i]);
}
}
}
