package src;

public class Fracao {

    /**
     * Construtor.
     * O sinal da fração é passado no parâmetro específico.
     *
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param positiva se true, a fração será positiva; caso contrário, será negativa
     */

    private int numerador;
    private int denominador;
    private boolean positiva;
    private double sinal;
    private boolean nula;


    public Fracao(int numerador, int denominador, boolean positiva) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.positiva = positiva;
        if(positiva)
            sinal = 1.0;
        else
            sinal = -1.0;

        nula = numerador == 0;

        if (nula)
            this.positiva = false;
    }

    /**
     * @return um double com o valor numérico desta fração
     */
    public double getValorNumerico() {
        return sinal*this.numerador/this.denominador;
    }

    /**
     * Retorna uma fração que é equivalente a esta fração (this),
     * e que é irredutível (numerador e denominador primos entre si).
     * Em outras palavras, retorna a fração geratriz desta fração.
     *
     * @return uma fração irredutível equivalente a esta;
     *         no caso desta fração JÁ SER ela própria irredutível, retorna this
     */

    private int Euclides(){
        int resto;
        int a = numerador;
        int b = denominador;
        while(b!=0){
            resto = a%b;
            a = b;
            b = resto;
        }
        return a;
    }
    public Fracao getFracaoGeratriz() {
        int mdc = Euclides();
        int numeradorGeratriz = numerador/mdc;
        int denominadorGeratriz = denominador/mdc;
        Fracao geratriz = new Fracao(numeradorGeratriz, denominadorGeratriz, this.isPositiva());
        if(numeradorGeratriz == numerador && denominadorGeratriz == denominador)
            return this;
        else
            return geratriz;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public boolean isPositiva() {
        return this.positiva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Fracao fracao = (Fracao) o;

        if(nula  && fracao.nula)
            return true;

        return this.getFracaoGeratriz().getNumerador() == fracao.getFracaoGeratriz().getNumerador() &&
                this.getFracaoGeratriz().getDenominador() == fracao.getFracaoGeratriz().getDenominador() &&
                this.getFracaoGeratriz().isPositiva() == fracao.getFracaoGeratriz().isPositiva();
    }


}
