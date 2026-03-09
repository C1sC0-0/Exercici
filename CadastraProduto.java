import java.util.Scanner;

public class CadastraProduto {
    private static int buscarIndicePorNome(String[] produtos, int qtd, String nomeBusca) {
        for (int i = 0; i < qtd; i++) {
            if (produtos[i].equalsIgnoreCase(nomeBusca)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] produtos = new String[5];
        int[] qtdprodutos = new int[5];

        int qtd = 0; // controla quantos cadastros existem
        int opcao;

        while (true) {
            System.out.println("\n=== CADASTRO DE PRODUTO ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Pesquisar (por nome)");
            System.out.println("4 - Alterar (por nome)");
            System.out.println("5 - Remover (por nome)");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1: // CADASTRAR
                    if (qtd == produtos.length) { // VERIFICA SE A LISTA ESTA CHEIA
                        System.out.println("Lista cheia! Nao e possivel cadastrar.");
                        break;
                    }

                    System.out.println("Digite um produto: ");
                    String novoProduto = sc.nextLine();
                    if (buscarIndicePorNome(produtos, qtd, novoProduto) != -1) {
                        System.out.println("Produto ja cadastrado.");
                        break;
                    }
                    produtos[qtd] = novoProduto;

                    System.out.println("Digite a quantidade de produtos");
                    qtdprodutos[qtd] = sc.nextInt();
                    sc.nextLine();

                    qtd++;
                    System.out.println("Cadastrado com sucesso!");
                    break;
                case 2: // listar
                    if (qtd == 0) {
                        System.out.println("Nenhum cadastro.");
                        break;
                    }

                    System.out.println("\nProdutos cadastrados");
                    for (int i = 0; i < qtd; i++) {
                        System.out.println(i+1 + "- " + produtos[i] + " - " + qtdprodutos[i]);
                    }
                    break;
                case 3: // pesquisar
                    if (qtd == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    }

                    System.out.print("Digite o nome do produto para pesquisar: ");
                    String nomePesquisa = sc.nextLine();
                    int indicePesquisa = buscarIndicePorNome(produtos, qtd, nomePesquisa);

                    if (indicePesquisa == -1) {
                        System.out.println("Produto nao encontrado.");
                    } else {
                        System.out.println("Produto encontrado:");
                        System.out.println("Indice: " + indicePesquisa);
                        System.out.println("Nome: " + produtos[indicePesquisa]);
                        System.out.println("Quantidade: " + qtdprodutos[indicePesquisa]);
                    }
                    break;
                case 4: // alterar
                    if (qtd == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    }

                    System.out.print("Digite o nome do produto para alterar: ");
                    String nomeAlteracao = sc.nextLine();
                    int indiceAlteracao = buscarIndicePorNome(produtos, qtd, nomeAlteracao);

                    if (indiceAlteracao == -1) {
                        System.out.println("Produto nao encontrado.");
                        break;
                    }

                    System.out.print("Deseja alterar nome e quantidade? (s/n): ");
                    String alterarNome = sc.nextLine();

                    if (alterarNome.equalsIgnoreCase("s")) {
                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();

                        int indiceNomeExistente = buscarIndicePorNome(produtos, qtd, novoNome);
                        if (indiceNomeExistente != -1 && indiceNomeExistente != indiceAlteracao) {
                            System.out.println("Ja existe outro produto com esse nome.");
                            break;
                        }

                        produtos[indiceAlteracao] = novoNome;
                    }

                    System.out.print("Nova quantidade: ");
                    qtdprodutos[indiceAlteracao] = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Produto alterado com sucesso.");
                    break;
                case 5: // remover
                    if (qtd == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    }

                    System.out.print("Digite o nome do produto para remover: ");
                    String nomeRemocao = sc.nextLine();
                    int indiceRemocao = buscarIndicePorNome(produtos, qtd, nomeRemocao);

                    if (indiceRemocao == -1) {
                        System.out.println("Produto nao encontrado.");
                        break;
                    }

                    for (int i = indiceRemocao; i < qtd - 1; i++) {
                        produtos[i] = produtos[i + 1];
                        qtdprodutos[i] = qtdprodutos[i + 1];
                    }

                    produtos[qtd - 1] = null;
                    qtdprodutos[qtd - 1] = 0;
                    qtd--;
                    System.out.println("Produto removido com sucesso.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }

        sc.close();
    }
}
