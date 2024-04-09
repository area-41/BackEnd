package br.com.americanas.polotech.ProOri_02.News;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Boolean key = Boolean.TRUE;
    public static Map<String, String> map = new HashMap();

    public static void main(String[] args) {
        while (key) {
            letreiro();
            mensageria();
        }
    }
    public static void mensageria() {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> listaPessoas = new ArrayList<>();
        System.out.println("Quantas pessoas? (digite 0 para sair)");
        int qtd = scanner.nextInt();
        if (qtd == 0) {
            key = Boolean.FALSE;
        } else {
            for (int i = 0; i < qtd; i++) {
                scanner = new Scanner(System.in);
                Pessoa pessoa = new Pessoa();
                System.out.printf("Digite o nome da %s pessoa:\n\t", i + 1);
                pessoa.setNome(scanner.nextLine());
                listaPessoas.add(pessoa);
            }
            System.out.println("Qual a mensagem que gostaria de enviar?");
            scanner = new Scanner(System.in);
            String mensagem = scanner.nextLine();

            System.out.printf("\nA lista de pessoas: %s\n", listaPessoas.stream().map(Pessoa::getNome).collect(Collectors.toList()));

            Map<String, String> map = new HashMap();
            System.out.println("\nColocar pessoas no hashmap:");
            for (int i = 0; i < listaPessoas.size(); i++) {
                System.out.println(listaPessoas.get(i).nome);
                map.put(String.valueOf(listaPessoas.get(i).nome), "received a message: -> " + mensagem);
            }

            System.out.println("\nProcurar mensagem para 'Joao' >");
            System.out.println(map.get("Joao"));
            System.out.println("\nRemover Maria:");
            map.remove("Maria");

            System.out.printf("\nValores do Hash map:\n", map.values());
            for (String i : map.values()) {
                System.out.println(i);
            }

            System.out.println("\nMensageria para enviar:");
            for (String i : map.keySet()) {
                System.out.println("Chave: " + i + "|| Valor: " + map.get(i));
            }
            System.out.println(map);


            map.clear();
            System.out.printf("\nHash map vazio:\n\n", map.values());
            for (String i : map.values()) {
                System.out.println(i);
            }

            System.out.println(map);
        }
    }

    public static void letreiro() {
        System.out.println(":::::::::::: Mensageria ADA :::::::::::::::");
    }
}