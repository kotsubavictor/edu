package koviiv.monads.basics.chapter9;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import koviiv.monads.basics.model.Artist;

public class CompletableFutureArtistAnalyser implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CompletableFutureArtistAnalyser(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        getNumberOfMembers(artistName)
                .thenCombine(getNumberOfMembers(otherArtistName), (leftMembers, rightMembers) -> leftMembers > rightMembers)
                .thenAccept(handler);
    }

    private CompletableFuture<Long> getNumberOfMembers(String artistName) {
        return CompletableFuture
                .supplyAsync(() -> artistLookupService.apply(artistName))
                .thenApply(Artist::getMembers)
                .thenApply(Stream::count);
    }

}
