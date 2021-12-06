import java.util.Scanner;

class Questao02 {
public static boolean fim(String str) {
return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
}

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
String op = "";
int count1 = 0, count2 = 0;

while(true){
count1 = 0; count2 = 0; 
op = sc.nextLine();

if(fim(op) == true) {
break; 
}

for(int i = 0; i < op.length(); i++) {

if(op.charAt(i) == '(') {
count1++;
}

if(op.charAt(0) == ')' || op.charAt(op.length() - 1) == '(') {
count1++;
break;
}

else if (op.charAt(i) == ')') {
count2++;
}

}

if (count1 == count2){
System.out.println("correto");
}
else{
System.out.println("incorreto");
}

}

sc.close();
}
}

