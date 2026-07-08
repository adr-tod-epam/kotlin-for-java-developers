class Dna(val dnaString: String) {
    val nucleotideCounts: Map<Char, Int>

    init {
        for (character in dnaString) {
            if (character != 'A' && character != 'C' && character != 'G' && character != 'T') {
                throw IllegalArgumentException("Invalid DNA sequence: contains characters other than A, C, G, T")
            }
        }
        val baseMap = mutableMapOf(
            'A' to 0,
            'C' to 0,
            'G' to 0,
            'T' to 0
        )
        for (nucleotide in dnaString) {
            val currentCount = baseMap[nucleotide] ?: 0
            baseMap[nucleotide] = currentCount + 1
        }
        nucleotideCounts = baseMap
    }
}