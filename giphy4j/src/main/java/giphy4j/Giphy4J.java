package giphy4j;

import java.util.List;

public final class Giphy4J extends Giphy4K {
    public Giphy4J(String apiKey) {
        super(apiKey);
    }

    /**
     * Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored. Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho.
     * @see <a href="https://developers.giphy.com/docs/#operation--gifs-search-get">Getting Started with the GIPHY API - Search Endpoint</a>
     * @param q Search query term or phrase. GIPHY search will automatically look for exact matches to queries + AND match + OR match. Explicit AND + OR boolean clauses in search queries are not supported.
     * @return list of Gifs
     */
    public List<Gif> search(String q) {
        return search(q);
    }

    /**
     * Returns a random GIF, limited by tag. Excluding the tag parameter will return a random GIF from the GIPHY catalog.
     * @see <a href="https://developers.giphy.com/docs/#operation--gifs-random-get">Getting Started with the GIPHY API - Random Endpoint</a>
     * @param tag Filters results by specified tag.
     * @return Gif
     */
    public Gif random(String tag) {
        return random(tag);
    }

}
