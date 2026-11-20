package lista1.exercicio03;

// Lista 1 - Exercício 3: Classe NumeroComplexo
// Obs.: as operações retornam um NOVO número complexo (não alteram os operandos).
public class NumeroComplexo {

    private double real;
    private double imaginaria;

    public NumeroComplexo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginaria() {
        return imaginaria;
    }

    public void setImaginaria(double imaginaria) {
        this.imaginaria = imaginaria;
    }

    // (a+bi)+(c+di) = (a+c)+(b+d)i
    public NumeroComplexo somar(NumeroComplexo o) {
        return new NumeroComplexo(real + o.real, imaginaria + o.imaginaria);
    }

    // (a+bi)-(c+di) = (a-c)+(b-d)i
    public NumeroComplexo subtrair(NumeroComplexo o) {
        return new NumeroComplexo(real - o.real, imaginaria - o.imaginaria);
    }

    // (a+bi)*(c+di) = (ac-bd)+(ad+bc)i
    public NumeroComplexo multiplicar(NumeroComplexo o) {
        double a = real, b = imaginaria, c = o.real, d = o.imaginaria;
        return new NumeroComplexo(a * c - b * d, a * d + b * c);
    }

    // (a+bi)/(c+di) = (ac+bd)/(c²+d²) + (bc-ad)/(c²+d²)i
    public NumeroComplexo dividir(NumeroComplexo o) {
        double a = real, b = imaginaria, c = o.real, d = o.imaginaria;
        double denominador = c * c + d * d;
        if (denominador == 0) {
            throw new ArithmeticException("Divisão por número complexo zero");
        }
        return new NumeroComplexo((a * c + b * d) / denominador, (b * c - a * d) / denominador);
    }

    // g) Comparação semântica
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NumeroComplexo)) return false;
        NumeroComplexo o = (NumeroComplexo) obj;
        return Double.compare(real, o.real) == 0 && Double.compare(imaginaria, o.imaginaria) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(real) + Double.hashCode(imaginaria);
    }

    // h) Representação "a + bi"
    @Override
    public String toString() {
        if (imaginaria < 0) {
            return real + " - " + (-imaginaria) + "i";
        }
        return real + " + " + imaginaria + "i";
    }

    // i) Módulo: raiz de (a² + b²)
    public double modulo() {
        return Math.sqrt(real * real + imaginaria * imaginaria);
    }
}
