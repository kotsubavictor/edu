package koviiv.monads.basics.chapter4;

import static koviiv.monads.basics.model.SampleData.logTask;

import java.util.List;
import java.util.Optional;
import koviiv.monads.basics.model.Artist;
import koviiv.monads.basics.model.SampleData;

public class Task3 {

    private static final ArtistsViaOptional ARTISTS_VIA_OPTIONAL = new ArtistsViaOptional(SampleData.getThreeArtists());

    public static void main(String[] args) {

        logTask(3);
        System.out.println(ARTISTS_VIA_OPTIONAL.getArtistName(0));
        System.out.println(ARTISTS_VIA_OPTIONAL.getArtistName(4));
        System.out.println(ARTISTS_VIA_OPTIONAL.getArtist(0));
        System.out.println(ARTISTS_VIA_OPTIONAL.getArtist(4));
    }
}

class ArtistsViaOptional {

    private List<Artist> artists;

    public ArtistsViaOptional(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {

        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }

        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        return getArtist(index)
                .map(Artist::getName)
                .orElse("unknown");
    }

}

class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Artist getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            indexException(index);
        }
        return artists.get(index);
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index +
                " doesn't correspond to an Artist");
    }

    public String getArtistName(int index) {
        try {
            Artist artist = getArtist(index);
            return artist.getName();
        } catch (IllegalArgumentException e) {
            return "unknown";
        }
    }
}
