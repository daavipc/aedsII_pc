import java.io.*;

public class PrincipalPilha {
    public static String copiarParaString(String path) throws IOException { // Retorna o conteudo original do arquivo
        BufferedReader arq = new BufferedReader(new FileReader(path));

        String conteudo = "";
        String aux;

        while (true) {
            aux = arq.readLine();
            if (aux == null)
                break;
            else {
                conteudo += aux;
                conteudo += '\n';
            }
        }

        arq.close();
        return conteudo;
    }

    public static void substituiParaOriginal(String path, String conteudo) throws IOException { // Exclui todo o
                                                                                                // conteudo do arquivo e
                                                                                                // o transforma na
                                                                                                // string passada por
                                                                                                // parametro
        BufferedWriter arq = new BufferedWriter(new FileWriter(path));

        arq.append(conteudo);

        arq.close();
    }

    public static void inserePilha(String path, String frase, String conteudoExistente) throws IOException {
        BufferedWriter arqF = new BufferedWriter(new FileWriter(path));

        frase += '\n';
        frase += conteudoExistente;

        arqF.append(frase);

        MyIO.println(conteudoArq(path));
        arqF.close();
    }

    public static void deletar(String path) throws IOException { // Método para deleção de elementos - Se descomentar os
                                                                 // elementes da classe BufferedWriter funciona, porém
                                                                 // está com bug
        BufferedReader arq = new BufferedReader(new FileReader(path));
        // BufferedWriter arqW = new BufferedWriter(new FileWriter(path));

        boolean primeiraRep = true;
        String aux;
        String strFinal = "";

        while (true) {
            aux = arq.readLine();
            System.out.println(aux);
            if (aux == null)
                break;
            else {
                if (primeiraRep)
                    primeiraRep = false;
                else {
                    strFinal += aux;
                    strFinal += '\n';
                }
            }
        }
        // arqW.append(strFinal);

        // arqW.close();
        arq.close();
    }

    public static String conteudoArq(String path) throws IOException { // Retorna o conteúdo presente em um arquivo -/-
                                                                       // 2
        BufferedReader Arq = new BufferedReader(new FileReader(path));

        String conteudo = "";
        String aux = "";
        while (aux != null) {
            conteudo += aux;
            aux = Arq.readLine();
            if (aux != null)
                aux += '\n';
        }
        Arq.close();

        return conteudo;
    }

    public static void main(String[] args) throws IOException {
        String path = "pilha.txt";
        String conteudoInicial = copiarParaString(path);

        String aux;
        String frase;
        int opcao;

        do {

            MyIO.println("\nInsira uma opcao\n1. Inserir\n2. Remover\n3. Listar\n4. Sair");
            opcao = MyIO.readInt();
            if (!(opcao < 1 || opcao > 4)) {
                switch (opcao) {
                    case 1:
                        frase = MyIO.readLine();
                        aux = conteudoArq(path);
                        inserePilha(path, frase, aux);
                        break;

                    case 2:
                        // deletar(path); //Bug na função
                        System.out.println("Método indisponível, bug na hora de representar a função, escolha outro!");
                        break;

                    case 3:
                        MyIO.println(conteudoArq(path));
                        break;

                    default:
                        MyIO.println("ERROR, INSIRA OUTRA OPCAO");
                }
            } else
                MyIO.println("\nOpcao invalida, insira outra.\n");

        } while (opcao != 4);
        MyIO.println(conteudoArq(path));
        substituiParaOriginal(path, conteudoInicial);

        // arqW.close();
    }
}