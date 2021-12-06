public class dmonica{
public static void main(String[] args){

int id1;
int id2;
int idmae;
int soma;
int id3;

idmae = MyIO.readInt();
id1 = MyIO.readInt();
id2 = MyIO.readInt();
soma = id1 + id2;

id3 = idmae - soma;

if (id1 > id2 && id1 > id3){
MyIO.println( +id1);
}else if (id2 > id1 && id2 > id3){
MyIO.println( +id2);
}
else if (id3 > id1 && id3 > id2){
MyIO.println( +id3);
}

}
}