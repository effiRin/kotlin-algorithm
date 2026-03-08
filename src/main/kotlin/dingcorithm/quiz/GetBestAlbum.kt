package dingcorithm.quiz

import dingcorithm.util.UtilFunction.printList

fun main() {
    val bestAlbum = GetBestAlbum()

    // 정답 = [4, 1, 3, 0]
    printList(
        bestAlbum.getBestAlbum(
            arrayOf("classic", "pop", "classic", "classic", "pop"),
            intArrayOf(500, 600, 150, 800, 2500)
        )
    )

    // 정답 = [0, 6, 5, 2, 4, 1]
    printList(
        bestAlbum.getBestAlbum(
            arrayOf("hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop"),
            intArrayOf(2000, 500, 600, 150, 800, 2500, 2000)
        )
    )
}

class GetBestAlbum {

    fun getBestAlbum(genres: Array<String>, plays: IntArray): MutableList<Int> {
        val genreTotalPlay = hashMapOf<String, Int>() // 장르별 총 재생 수
        val genreSongsMap = mutableMapOf<String, MutableList<IntArray>>() // 장르별 노래

        for(i in genres.indices) {
            val genre = genres[i]
            val playCount = plays[i]

            genreTotalPlay[genre] = playCount + (genreTotalPlay[genre] ?: 0)
            genreSongsMap.getOrPut(genre) { mutableListOf() } // getOrPut -> 가져오거나 디폴트값 mutableListOf()를 넣거나
                .add(intArrayOf(i, playCount))
        }

        /***
        / map은 key로 값을 찾는 자료구조라서, sort를 할 수 없다.
        / 따라서 맵의 key-value 쌍들을 꺼내는 entries를 이용해서 정렬을 한다.
        / entries를 쓰면 Set<Map.Entry<String, Int>> 가 된다. (ex : ("classic", 1450), ("pop", 3100) ... )
        / 즉, 각 원소가 entry.key / entry.value를 가진 객체들의 모음이 되는 것
        */
        val sortedGenres = genreTotalPlay.entries.sortedByDescending { it.value }

        val result = mutableListOf<Int>()

        for((genre, _) in sortedGenres) { // playCount이지만 안쓰면 _로 표시
            val songs = genreSongsMap[genre]!! // 그 장르의 노래들을 가져와서
                .sortedWith (compareByDescending<IntArray> { it[1] }.thenBy { it[0] }) // play 수 -> index 순으로 정렬한다
            result.addAll(songs.take(2).map { it[0] })
        }

        return result
    }
}

/***
 * 1. sortedBy
 * 하나의 기준으로 오름차순 정렬할 때.
 *
 * val numbers = listOf(30, 10, 20)
 * val result = numbers.sortedBy { it }
 * println(result) // [10, 20, 30]
 *
 * 2.sortedWith
 * 비교 규칙 자체를 직접 넣는 방식. 더 복잡한 정렬이 필요할 때 써.
 *
 * 예를 들어:
 * val result = musicInfos.sortedWith(
 *     compareByDescending<MusicInfo> { it.playCount }
 *         .thenBy { it.id }
 * )
 *
 * 또는 comparator를 직접 써도 돼:
 *
 * val result = musicInfos.sortedWith { a, b ->
 *     when {
 *         a.playCount != b.playCount -> b.playCount - a.playCount
 *         else -> a.id - b.id
 *     }
 * }
 *
 */