public class cometa {
public static void main(String[] args){
int ano, vzs;

ano = MyIO.readInt();

vzs = (ano - 10 ) / 76 ;
vzs++;

MyIO.println( +vzs * 76 + 10);
}
}