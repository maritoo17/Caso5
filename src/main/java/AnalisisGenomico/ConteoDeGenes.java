package AnalisisGenomico;

public class ConteoDeGenes {

    public static void main(String[] args) {
        String dna = "ATGAAATGAAAAATGTAGTAAATGAGAGAGATGTAATAG";
        int count = contarGenes(dna);
        System.out.println("Total de genes encontrados: " + count);
    }

    public static int contarGenes(String dna) {
        return contarGenesAux(dna, 0);
    }

    private static int contarGenesAux(String dna, int index) {
        if (dna.length() - index < 3) {
            return 0;
        }

        int startIndex = dna.indexOf("ATG", index);
        if (startIndex == -1) {
            return 0;
        }

        int endIndex = encontrarFinalGen(dna, startIndex + 3);
        if (endIndex != -1) {
            return 1 + contarGenesAux(dna, endIndex + 3);
        } else {
            return contarGenesAux(dna, startIndex + 3);
        }
    }

    private static int encontrarFinalGen(String dna, int startIndex) {
        for (int i = startIndex; i < dna.length() - 2; i += 3) {
            String codon = dna.substring(i, i + 3);
            if (codon.equals("TAG") || codon.equals("TAA") || codon.equals("TGA")) {
                return i;
            }
        }
        return -1;
    }
}
