package io.github.guisso.lab.relacionamentos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Guisso &lt;luis.guisso at ifnmg.edu.br&gt;
 */
public class RelacionamentoTests {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();

        try {
            pessoa1.setNome("Luis");
        } catch (Exception ex) {
            Logger.getLogger(RelacionamentoTests.class.getName()).log(Level.SEVERE, null, ex);
        }

        pessoa1.setNascimento(LocalDate.of(1910, 1, 1));

        Credencial cred1 = new Credencial();
        cred1.setEmail("luis@mail.com");
        cred1.setSenha("asdf123");

        Telefone t1 = new Telefone();
        t1.setDdd((byte) 38);
        t1.setNumero(21044141);
        
        Telefone t2 = new Telefone();
        t2.setDdd((byte) 99);
        t2.setNumero(78784545);
        
        Endereco e1 = new Endereco();
        e1.setLogradouro("Rua Dois");
        e1.setBairro("Village do Lago I");
        e1.setNumero(300);
        
        Endereco e2 = new Endereco();
        e2.setLogradouro("Rua Três");
        e2.setBairro("Village do Lago II");
        e2.setNumero(400);

//        pessoa1.getTelefones()[0] = t1;
        pessoa1.adicionarTelefonePrimario(t1);
        pessoa1.adicionarTelefoneSecundario(t2);
        
//        pessoa1.getEnderecos().add(e1);
        pessoa1.adicionarEndereco(e1);
        pessoa1.adicionarEndereco(e2);
        
        pessoa1.setCredencial(cred1);
        
//        t1.setPessoa(pessoa1); // <-----
//        t2.setPessoa(pessoa1); // <-----
//        e1.setPessoa(pessoa1); // <-----
//        e2.setPessoa(pessoa1); // <-----
//        cred1.setPessoa(pessoa1); // <-----
        
        
        System.out.println(">> " + pessoa1);
        
        System.out.println(Util.cpfValido("\n3~35.140.906-10"));

//        // Qual é o email da credencial do guisso?
//        System.out.println("> "
//                + guisso
//                        .getCredencial()
//                        .getEmail());
    }
}
