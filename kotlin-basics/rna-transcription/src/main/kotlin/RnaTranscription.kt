fun transcribeToRna(dna: String): String {
    var rna = ""
    for (nucleotide in dna) {
        rna += when (nucleotide) {
            'G' -> 'C'
            'C' -> 'G'
            'T' -> 'A'
            'A' -> 'U'
            else -> throw IllegalArgumentException("Invalid nucleotide: $nucleotide")
        }
    }
    return rna
}