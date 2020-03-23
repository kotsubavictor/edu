package koviiv.monads.basics.chapter9;

import java.util.function.Consumer;
import java.util.function.Function;
import koviiv.monads.basics.model.Artist;

public class CallbackArtistAnalyser implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CallbackArtistAnalyser(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
//        TODO
    }

    private long getNumberOfMembers(String artistName) {
        //        TODO
        return 0;
    }

}
