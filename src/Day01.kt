fun main() {
    fun part1(input: List<Int>): Int = input.windowed(2).count { (a, b) -> a < b }

    fun part2(input: List<Int>): Int {
        val triples: List<Int> = input.windowed(3).map { it.sum() }

        return part1(triples)
    }

    val input = readInput("Day01")
    val inputOfInts = input.map { it.toInt() }

    println(part1(inputOfInts))
    println(part2(inputOfInts))
}
