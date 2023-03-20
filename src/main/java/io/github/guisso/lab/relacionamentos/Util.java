package io.github.guisso.lab.relacionamentos;

/**
 *
 * @author Caixa
 */
public class Util {

    public static long obterNumeroCpf(String cpf) {
        long numeroCpf = 0;
        int unidade = 0;
        int potencia = 0;
        for (int i = cpf.length() - 1; i >= 0; i--) {
            char c = cpf.charAt(i);
//            Character.isLetter(c);
            if (Character.isDigit(c)) {
                unidade = Character.getNumericValue(c);
                numeroCpf = numeroCpf + (long) Math.pow(10.0, (double) potencia) * (long) unidade;
                potencia++;
            }

        }
        return numeroCpf;
    }

    public static boolean cpfValido(String cpf) {
        long numeroCpf = Util.obterNumeroCpf(cpf);
        int dv = 0;
        int dvCalculado = 0;

        for (byte i = 0; i < 2; i++) {
            dv = (int) numeroCpf % 10;
            numeroCpf = numeroCpf / 10;
            int ref = 2;
            long soma = 0;
            while (numeroCpf > 0) {
                soma = soma + (numeroCpf % 10) * ref;
                numeroCpf = numeroCpf / 10;
                ref++;
            }
            dvCalculado = (int) (soma % 11);
            dvCalculado = 11 - dvCalculado;
            if (dvCalculado == 10 || dvCalculado==11) {
                dvCalculado = 0;
            }
            if (!(dv == dvCalculado)) {
                System.out.println(dvCalculado);
                return false;
            }
        }
        return true;
    }

}
